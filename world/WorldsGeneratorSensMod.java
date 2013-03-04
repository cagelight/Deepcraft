package deepcraft.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import deepcraft.core.Core;

public class WorldsGeneratorSensMod implements IWorldGenerator{
	
	private List<int[]> StandardSurfGenerationSets = new ArrayList();
	private List<int[]> HellGenerationSets = new ArrayList();
	private List<int[]> EnduraiGenerationSets = new ArrayList();
	private List<int[]> XirkGenerationSets = new ArrayList();

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		BiomeGenBase biomeProvider = world.getBiomeGenForCoords(chunkX, chunkZ);
		if(biomeProvider.biomeName == "Hell") {
			generateHell(random,chunkX*16,chunkZ*16,world);
		} else if (biomeProvider.biomeName == "Endurai") {
			generateEndurai(random,chunkX*16,chunkZ*16,world);
		} else if (biomeProvider.biomeName == "Xirk") {
			generateXirk(random,chunkX*16,chunkZ*16,world);
		} else {
			generateSurface(random,chunkX*16,chunkZ*16,world);
		}
	}

	public void SetupStandardSurfOre(int blockID, int perChunk, int Min, int Max, int HeightMax){
		StandardSurfGenerationSets.add(new int[]{blockID, perChunk, Min, Max, HeightMax});
	}
	public void SetupHellOre(int blockID, int perChunk, int Min, int Max, int HeightMax){
		HellGenerationSets.add(new int[]{blockID, perChunk, Min, Max, HeightMax});
	}
	public void SetupEnduraiOre(int blockID, int perChunk, int Min, int Max, int HeightMax){
		EnduraiGenerationSets.add(new int[]{blockID, perChunk, Min, Max, HeightMax});
	}
	public void SetupXirkOre(int blockID, int perChunk, int Min, int Max, int HeightMax){
		XirkGenerationSets.add(new int[]{blockID, perChunk, Min, Max, HeightMax});
	}

	public void generateSurface(Random random, int x, int z, World w){
		for(int i=0;i<StandardSurfGenerationSets.size();i++){
			for(int ii=0;ii<StandardSurfGenerationSets.get(i)[1];ii++){ //This makes it gen multiple times in each chunk
				int posX = x + random.nextInt(16); //X coordinate to gen at
				int posY = random.nextInt(StandardSurfGenerationSets.get(i)[4]); //Y coordinate less than 40 to gen at
				int posZ = z + random.nextInt(16); //Z coordinate to gen at
				new WorldGenMinableSensMod(StandardSurfGenerationSets.get(i)[0],random.nextInt(StandardSurfGenerationSets.get(i)[3]-StandardSurfGenerationSets.get(i)[2]+1) + StandardSurfGenerationSets.get(i)[2]).generate(w, random, posX, posY, posZ); //The gen call
			}
		}
	}
	
	public void generateHell(Random random, int x, int z, World w){
		for(int i=0;i<HellGenerationSets.size();i++){
			for(int ii=0;ii<HellGenerationSets.get(i)[1];ii++){ //This makes it gen multiple times in each chunk
				int posX = x + random.nextInt(16); //X coordinate to gen at
				int posY = random.nextInt(HellGenerationSets.get(i)[4]); //Y coordinate less than 40 to gen at
				int posZ = z + random.nextInt(16); //Z coordinate to gen at
				new WorldGenMinableSensMod(HellGenerationSets.get(i)[0],random.nextInt(HellGenerationSets.get(i)[3]-HellGenerationSets.get(i)[2]+1) + HellGenerationSets.get(i)[2]).generate(w, random, posX, posY, posZ); //The gen call
			}
		}
	}
	
	public void generateEndurai(Random random, int x, int z, World w){
		for(int i=0;i<EnduraiGenerationSets.size();i++){
			for(int ii=0;ii<EnduraiGenerationSets.get(i)[1];ii++){ //This makes it gen multiple times in each chunk
				int posX = x + random.nextInt(16); //X coordinate to gen at
				int posY = random.nextInt(EnduraiGenerationSets.get(i)[4]); //Y coordinate less than 40 to gen at
				int posZ = z + random.nextInt(16); //Z coordinate to gen at
				new WorldGenMinableSensMod(EnduraiGenerationSets.get(i)[0],random.nextInt(EnduraiGenerationSets.get(i)[3]-EnduraiGenerationSets.get(i)[2]+1) + EnduraiGenerationSets.get(i)[2]).generate(w, random, posX, posY, posZ); //The gen call
			}
		}
	}

	public void generateXirk(Random random, int x, int z, World w){
		for(int i=0;i<XirkGenerationSets.size();i++){
			for(int ii=0;ii<XirkGenerationSets.get(i)[1];ii++){ //This makes it gen multiple times in each chunk
				int posX = x + random.nextInt(16); //X coordinate to gen at
				int posY = random.nextInt(XirkGenerationSets.get(i)[4]); //Y coordinate less than 40 to gen at
				int posZ = z + random.nextInt(16); //Z coordinate to gen at
				new WorldGenMinableSensMod(XirkGenerationSets.get(i)[0],random.nextInt(XirkGenerationSets.get(i)[3]-XirkGenerationSets.get(i)[2]+1) + XirkGenerationSets.get(i)[2], new int[] {Block.sandStone.blockID, Block.stone.blockID}).generate(w, random, posX, posY, posZ); //The gen call
			}
		}
	}

}
