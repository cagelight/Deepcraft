package sensory.world.feature;

import java.util.Random;

import sensory.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeepNetherReplacer extends WorldGenerator
{
    public boolean generate(World world, Random rand, int bX, int bY, int bZ)
    {
    	for (int x=0;x<16;x++) {
    		for (int z=0;z<16;z++) {
    			for (int y=0;y<128;y++) {
    				int blockID = world.getBlockId(x+bX, y, z+bZ);
		    		if (blockID == Block.netherrack.blockID) {
		    			world.setBlock(x+bX, y, z+bZ, SBlocks.netherrackDeep.blockID);
		    		} else if (blockID == Block.gravel.blockID || blockID == Block.slowSand.blockID) {
		    			world.setBlock(x+bX, y, z+bZ, SBlocks.slowSandDeep.blockID);
		    		}
    			}
    		}
    	}
        return true;
    }
}
