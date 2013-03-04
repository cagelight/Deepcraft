package sensory.world.xirk;

import java.util.List;
import java.util.Random;

import sensory.world.feature.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.*;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.*;
import net.minecraftforge.common.*;
import net.minecraftforge.event.Event.*;
import net.minecraftforge.event.terraingen.*;

public class ChunkProviderXirk implements IChunkProvider
{
	/** RNG. */
	private Random rand;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen1;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen2;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen3;

	/** A NoiseGeneratorOctaves used in generating terrain */
	private NoiseGeneratorOctaves noiseGen4;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen5;

	/** A NoiseGeneratorOctaves used in generating terrain */
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	
	private NoiseGeneratorPerlin perly;

	/** Reference to the World object. */
	private World worldObj;

	/** are map structures going to be generated (e.g. strongholds) */
	private final boolean mapFeaturesEnabled;

	/** Holds the overall noise array used in chunk generation */
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new CavesXirk();

	/** The biomes that are used to generate the chunk */
	private BiomeGenBase[] biomesForGeneration;

	/** A double array that hold terrain noise from noiseGen3 */
	double[] noise3;

	/** A double array that hold terrain noise */
	double[] noise1;

	/** A double array that hold terrain noise from noiseGen2 */
	double[] noise2;

	/** A double array that hold terrain noise from noiseGen5 */
	double[] noise5;

	/** A double array that holds terrain noise from noiseGen6 */
	double[] noise6;

	/**
	 * Used to store the 5x5 parabolic field that is used during terrain generation.
	 */
	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];

	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
	}

	public ChunkProviderXirk(World par1World, long par2, boolean par4)
	{
		this.worldObj = par1World;
		this.mapFeaturesEnabled = par4;
		this.rand = new Random(par2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
		this.perly = new NoiseGeneratorPerlin(this.rand);

		NoiseGeneratorOctaves[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise};
		noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
		this.noiseGen1 = noiseGens[0];
		this.noiseGen2 = noiseGens[1];
		this.noiseGen3 = noiseGens[2];
		this.noiseGen4 = noiseGens[3];
		this.noiseGen5 = noiseGens[4];
		this.noiseGen6 = noiseGens[5];
		this.mobSpawnerNoise = noiseGens[6];
	}

	/**
	 * Generates the shape of the terrain for the chunk though its all stone though the water is frozen if the
	 * temperature is low enough
	 */
	
	public void generateTerrain(int chunkX, int chunkZ, byte[] chunkBlocks) {
		
		//this.noiseArray = this.initializeNoiseField(this.noiseArray, chunkX * 16, 0, chunkZ * 16, 16, 1, 16);
		int[] heightmap = createHeightmap(chunkX*16, chunkZ*16, 48);
		
		for (int z = 0; z < 16; z++) {
			for (int x = 0; x < 16; x++) {
				int mapMod = heightmap[x+(z*16)];
				for (int y = 0; y < 128; y++) {
					if ((y >= 31+mapMod) && (y <= 95+mapMod)) {
						chunkBlocks[cC(x,y,z)] = 0;
					} else {
						chunkBlocks[cC(x,y,z)] = (byte)Block.sandStone.blockID;
					}
				}
			}
		}
	}
	
	public int cC(int x, int y, int z) {
		return y+(x*128)+(z*2048);
	}
	
/*	public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte)
	{
		byte var4 = 4;
		byte var5 = 16;
		byte var6 = 63;
		int var7 = var4 + 1;
		byte var8 = 17;
		int var9 = var4 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, var7 + 5, var9 + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, par1 * var4, 0, par2 * var4, var7, var8, var9);

		for (int var10 = 0; var10 < var4; ++var10)
		{
			for (int var11 = 0; var11 < var4; ++var11)
			{
				for (int var12 = 0; var12 < var5; ++var12)
				{
					double var13 = 0.125D;
					double var15 = this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
					double var17 = this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
					double var19 = this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
					double var21 = this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
					double var23 = (this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
					double var25 = (this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
					double var27 = (this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
					double var29 = (this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

					for (int i = 0; i < 8; ++i)
					{
						double var32 = 0.25D;
						double var34 = var15;
						double var36 = var17;
						double var38 = (var19 - var15) * var32;
						double var40 = (var21 - var17) * var32;

						for (int j = 0; j < 4; ++j)
						{
							int var43 = j + var10 * 4 << 11 | 0 + var11 * 4 << 7 | var12 * 8 + i;
							short var44 = 128;
							var43 -= var44;
							double var45 = 0.25D;
							double var49 = (var36 - var34) * var45;
							double var47 = var34 - var49;

							for (int k = 0; k < 4; ++k)
							{
								if ((var47 += var49) > 0.0D)
								{
									par3ArrayOfByte[var43 += var44] = (byte)Block.sandStone.blockID;
								}
								else if (var12 * 8 + i < var6)
								{
									par3ArrayOfByte[var43 += var44] = (byte)Block.sand.blockID;
								}
								else
								{
									par3ArrayOfByte[var43 += var44] = 0;
								}
							}

							var34 += var38;
							var36 += var40;
						}

						var15 += var23;
						var17 += var25;
						var19 += var27;
						var21 += var29;
					}
				}
			}
		}
	} */

	/**
	 * Replaces the stone that was placed in with blocks that match the biome
	 */
	public void replaceBlocksForBiome(int chunkX, int chunkZ, byte[] chunkBlocks, BiomeGenBase[] par4ArrayOfBiomeGenBase)
	{
		ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, chunkX, chunkZ, chunkBlocks, par4ArrayOfBiomeGenBase);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return;

		byte floorGeneral = 31;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, chunkX * 16, chunkZ * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

		for (int x = 0; x < 16; ++x)
		{
			for (int z = 0; z < 16; ++z)
			{
				BiomeGenBase var10 = par4ArrayOfBiomeGenBase[z + x * 16];
				float var11 = var10.getFloatTemperature();
				int var12 = (int)(this.stoneNoise[x + z * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var13 = -1;
				byte var14 = var10.topBlock;
				byte var15 = var10.fillerBlock;

				for (int y = 127; y >= 0; --y)
				{
					int var17 = (z * 16 + x) * 128 + y;

					if (y <= 0 + this.rand.nextInt(5))
					{
						chunkBlocks[var17] = (byte)Block.bedrock.blockID;
					}
					if (y >= 122 + this.rand.nextInt(5))
					{
						chunkBlocks[var17] = (byte)Block.bedrock.blockID;
					}
					else
					{
						byte var18 = chunkBlocks[var17];

						if (var18 == 0)
						{
							var13 = -1;
						}
						else if (var18 == Block.sandStone.blockID)
						{
							if (var13 == -1)
							{
								if (var12 <= 0)
								{
									var14 = 0;
									var15 = (byte)Block.sandStone.blockID;
								}
								else if (y >= floorGeneral - 4 && y <= floorGeneral + 1)
								{
									var14 = var10.topBlock;
									var15 = var10.fillerBlock;
								}

								if (y < floorGeneral && var14 == 0)
								{
									if (var11 < 0.15F)
									{
										var14 = (byte)Block.ice.blockID;
									}
									else
									{
										var14 = (byte)Block.waterStill.blockID;
									}
								}

								var13 = var12;

								if (y >= floorGeneral - 1)
								{
									chunkBlocks[var17] = var14;
								}
								else
								{
									chunkBlocks[var17] = var15;
								}
							}
							else if (var13 > 0)
							{
								--var13;
								chunkBlocks[var17] = var15;

								if (var13 == 0 && var15 == Block.sand.blockID)
								{
									var13 = this.rand.nextInt(4);
									var15 = (byte)Block.sandStone.blockID;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	public Chunk loadChunk(int par1, int par2)
	{
		return this.provideChunk(par1, par2);
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
	 * specified chunk from the map seed and chunk seed
	 */
	public Chunk provideChunk(int par1, int par2)
	{
		this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
		byte[] chunkBlocks = new byte[32768];
		this.generateTerrain(par1, par2, chunkBlocks);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, chunkBlocks, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, par1, par2, chunkBlocks);


		Chunk var4 = new Chunk(this.worldObj, chunkBlocks, par1, par2);
		byte[] var5 = var4.getBiomeArray();

		for (int var6 = 0; var6 < var5.length; ++var6)
		{
			var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
		}

		var4.generateSkylightMap();
		return var4;
	}

	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the [empty] noise array, the position, and the
	 * size.
	 */
	private int[] createHeightmap(int chunkX, int chunkZ, int maxValue) {
		double scale = 0.0125D;
		int[] noiseArray = new int[256];
		double[] tempField=new double[256];this.perly.populateNoiseArray(tempField, chunkX*scale, 0, chunkZ*scale, 16, 1, 16, scale, scale, scale, 1);
		for(int i=0;i<256;i++){noiseArray[i]=(int)(tempField[i]*maxValue);}
		return noiseArray;
	}
 	
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7)
	{
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY) return event.noisefield;

		if (par1ArrayOfDouble == null)
		{
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}

		if (this.parabolicField == null)
		{
			this.parabolicField = new float[25];

			for (int var8 = -2; var8 <= 2; ++var8)
			{
				for (int var9 = -2; var9 <= 2; ++var9)
				{
					float var10 = 10.0F / MathHelper.sqrt_float((float)(var8 * var8 + var9 * var9) + 0.2F);
					this.parabolicField[var8 + 2 + (var9 + 2) * 5] = var10;
				}
			}
		}

		double var44 = 684.412D;
		double var45 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		boolean var43 = false;
		boolean var42 = false;
		int var12 = 0;
		int var13 = 0;

		for (int var14 = 0; var14 < par5; ++var14)
		{
			for (int var15 = 0; var15 < par7; ++var15)
			{
				float var16 = 0.0F;
				float var17 = 0.0F;
				float var18 = 0.0F;
				byte var19 = 2;
				//BiomeGenBase var20 = this.biomesForGeneration[var14 + 2 + (var15 + 2) * (par5 + 5)];
				
				int minheight = 4;

				for (int var21 = -var19; var21 <= var19; ++var21)
				{
					for (int var22 = -var19; var22 <= var19; ++var22)
					{
						//BiomeGenBase var23 = this.biomesForGeneration[var14 + var21 + 2 + (var15 + var22 + 2) * (par5 + 5)];
						float var24 = this.parabolicField[var21 + 2 + (var22 + 2) * 5] / (minheight + 2.0F);

						if (minheight > minheight)
						{
							var24 /= 2.0F;
						}

						var16 += 127 * var24;
						var17 += minheight * var24;
						var18 += var24;
					}
				}

				var16 /= var18;
				var17 /= var18;
				var16 = var16 * 0.9F + 0.1F;
				var17 = (var17 * 4.0F - 1.0F) / 8.0F;
				double var47 = this.noise6[var13] / 8000.0D;

				if (var47 < 0.0D)
				{
					var47 = -var47 * 0.3D;
				}

				var47 = var47 * 3.0D - 2.0D;

				if (var47 < 0.0D)
				{
					var47 /= 2.0D;

					if (var47 < -1.0D)
					{
						var47 = -1.0D;
					}

					var47 /= 1.4D;
					var47 /= 2.0D;
				}
				else
				{
					if (var47 > 1.0D)
					{
						var47 = 1.0D;
					}

					var47 /= 8.0D;
				}

				++var13;

				for (int var46 = 0; var46 < par6; ++var46)
				{
					double var48 = (double)var17;
					double var26 = (double)var16;
					var48 += var47 * 0.2D;
					var48 = var48 * (double)par6 / 16.0D;
					double var28 = (double)par6 / 2.0D + var48 * 4.0D;
					double var30 = 0.0D;
					double var32 = ((double)var46 - var28) * 12.0D * 128.0D / 128.0D / var26;

					if (var32 < 0.0D)
					{
						var32 *= 4.0D;
					}

					double var34 = this.noise1[var12] / 512.0D;
					double var36 = this.noise2[var12] / 512.0D;
					double var38 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;

					if (var38 < 0.0D)
					{
						var30 = var34;
					}
					else if (var38 > 1.0D)
					{
						var30 = var36;
					}
					else
					{
						var30 = var34 + (var36 - var34) * var38;
					}

					var30 -= var32;

					if (var46 > par6 - 4)
					{
						double var40 = (double)((float)(var46 - (par6 - 4)) / 3.0F);
						var30 = var30 * (1.0D - var40) + -10.0D * var40;
					}

					par1ArrayOfDouble[var12] = var30;
					++var12;
				}
			}
		}

		return par1ArrayOfDouble;
	}

	/**
	 * Checks to see if a chunk exists at x, y
	 */
	public boolean chunkExists(int par1, int par2)
	{
		return true;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3)
	{
		BlockSand.fallInstantly = true;
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * var7 + (long)par3 * var9 ^ this.worldObj.getSeed());
		boolean var11 = false;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, var11));

		int var12;
		int var13;
		int var14;
		
		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, var11, DUNGEON)) {
			for (int i = 0; i < 5; i++) {
				var12 = var4 + this.rand.nextInt(16) + 8;
				var13 = this.rand.nextInt(63);
				var14 = var5 + this.rand.nextInt(16) + 8;
				(new XirciumSpikes(false)).generate(this.worldObj, this.rand, var12, var13, var14);
			}
		}
		
		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, var11, DUNGEON)) {
			for (int i = 0; i < 5; i++) {
				var12 = var4 + this.rand.nextInt(16) + 8;
				var13 = this.rand.nextInt(63)+63;
				var14 = var5 + this.rand.nextInt(16) + 8;
				(new XirciumSpikes(true)).generate(this.worldObj, this.rand, var12, var13, var14);
			}
		}
		
		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, var11, DUNGEON) && rand.nextInt(128) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = this.rand.nextInt(8) + 28;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new XirciumSuperSpike(false)).generate(this.worldObj, this.rand, var12, var13, var14);
		}
		
		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, var11, DUNGEON) && rand.nextInt(128) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = this.rand.nextInt(8) + 92;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new XirciumSuperSpike(true)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, var11, DUNGEON);

		var6.decorate(this.worldObj, this.rand, var4, var5);
		SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
		var4 += 8;
		var5 += 8;

		doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, var11, ICE);
		for (var12 = 0; doGen && var12 < 16; ++var12)
		{
			for (var13 = 0; var13 < 16; ++var13)
			{
				var14 = this.worldObj.getPrecipitationHeight(var4 + var12, var5 + var13);

				if (this.worldObj.isBlockFreezable(var12 + var4, var14 - 1, var13 + var5))
				{
					this.worldObj.setBlockWithNotify(var12 + var4, var14 - 1, var13 + var5, Block.ice.blockID);
				}

				if (this.worldObj.canSnowAt(var12 + var4, var14, var13 + var5))
				{
					this.worldObj.setBlockWithNotify(var12 + var4, var14, var13 + var5, Block.snow.blockID);
				}
			}
		}

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, var11));

		BlockSand.fallInstantly = false;
	}

	/**
	 * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
	 * Return true if all chunks have been saved.
	 */
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate)
	{
		return true;
	}

	/**
	 * Unloads the 100 oldest chunks from memory, due to a bug with chunkSet.add() never being called it thinks the list
	 * is always empty and will not remove any chunks.
	 */
	public boolean unload100OldestChunks()
	{
		return false;
	}

	/**
	 * Returns if the IChunkProvider supports saving.
	 */
	public boolean canSave()
	{
		return true;
	}

	/**
	 * Converts the instance data to a readable string.
	 */
	public String makeString()
	{
		return "RandomLevelSource";
	}

	/**
	 * Returns a list of creatures of the specified type that can spawn at the given location.
	 */
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4)
	{
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(par2, par4);
		return var5 == null ? null : var5.getSpawnableList(par1EnumCreatureType);
	}

	/**
	 * Returns the location of the closest structure of the specified type. If not found returns null.
	 */
	public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5)
	{
		return null;
	}

	public int getLoadedChunkCount()
	{
		return 0;
	}

	public void recreateStructures(int par1, int par2)
	{
	}
}
