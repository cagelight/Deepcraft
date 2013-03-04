package deepcraft.world.feature;

import java.math.MathContext;
import java.util.Random;

import deepcraft.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class XirciumSpikes extends WorldGenerator
{
	public boolean isInverted = false;
	
	public XirciumSpikes(boolean inverted) {
		this.isInverted = inverted;
	}
	
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
    	boolean blockTest = false;
    	if (world.getBlockId(x, y, z) == Block.sandStone.blockID && world.isAirBlock(x, y+8, z) && !this.isInverted) {blockTest=true;} else if (world.getBlockId(x, y, z) == Block.sandStone.blockID && world.isAirBlock(x, y-8, z)) {blockTest=true;}
    	if (blockTest) {
			int size = rand.nextInt(16)+8;
			int lengths = rand.nextInt(16)+8;
			int resolution = 2;
			float horizMod = size;
			float horizDivider = ((float)horizMod)/2;
			
			for (int j = 0; j < lengths; j++) {
				float offx = (rand.nextFloat()*horizMod)-horizDivider;
				float curx = 0.0F;
				float offy = size/((rand.nextFloat()*2) + 1.0F); if (this.isInverted){offy = -offy;}
				float cury = 0.0F;
				float offz = (rand.nextFloat()*horizMod)-horizDivider;
				float curz = 0.0F;
				
				int iterations = size*resolution;
				
				for (int i = 0; i < iterations; i++) {
					world.setBlockWithNotify(x+(int)curx, y+(int)cury, z+(int)curz, SBlocks.blockXircium.blockID);
					curx = offx*((float)i/(float)iterations);
					cury = offy*((float)i/(float)iterations);
					curz = offz*((float)i/(float)iterations);
				}
			}
			return true;
		}
        return false;
    }
}
