package sensory.world.feature;

import java.util.Random;

import sensory.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class XirciumSuperSpike extends WorldGenerator
{	
	public boolean isInverted = false;
	
	public XirciumSuperSpike(boolean inverted) {
		this.isInverted = inverted;
	}
	
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
    	boolean blockTest = false;
    	if (world.getBlockId(x, y, z) == Block.sandStone.blockID && world.isAirBlock(x, y+8, z) && !this.isInverted) {blockTest=true;} else if (world.getBlockId(x, y, z) == Block.sandStone.blockID && world.isAirBlock(x, y-8, z)) {blockTest=true;}
    	if (blockTest) {
			int size = 64;
			int lengths = 24;
			int resolution = 1;
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
					for (int nx = -1; nx < 2; nx++) {
						for (int ny = -1; ny < 2; ny++) {
							for (int nz = -1; nz < 2; nz++) {
								world.setBlockWithNotify(nx+x+(int)curx, ny+y+(int)cury, nz+z+(int)curz, SBlocks.blockXircium.blockID);
							}
						}
					}
					curx = offx*((float)(i+1)/(float)iterations);
					cury = offy*((float)(i+1)/(float)iterations);
					curz = offz*((float)(i+1)/(float)iterations);
				}
				world.setBlockWithNotify(x+(int)(offx*0.9F), y+(int)(offy*0.9F), z+(int)(offz*0.9F), SBlocks.artifactXirkBlock.blockID);
			}
			if (!this.isInverted) {
				world.setBlockWithNotify(x, y+3, z, SBlocks.artifactDeepNetherBlock.blockID);
			} else {
				world.setBlockWithNotify(x, y-3, z, SBlocks.artifactDeepNetherBlock.blockID);
			}
			return true;
		}
        return false;
    }
}
