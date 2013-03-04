package sensory.world.feature;

import java.util.Random;

import sensory.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class EndurumCubes extends WorldGenerator
{
    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
    	int cubesize = (par2Random.nextInt(5)+1)*2;
    	int negam = -(cubesize/2);
    	int posam = (-negam)+1;
    	for (int x = negam; x < posam; x++) {
    		for (int y = negam; y < posam; y++) {
    			for (int z = negam; z < posam; z++) {
    				par1World.setBlockWithNotify(par3+x, par4+y, par5+z, SBlocks.blockEndurum.blockID);
    			}
    		}
    	}
    	
    	if (cubesize == 10) {
    		par1World.setBlockWithNotify(par3, par4, par5, SBlocks.artifactXirkBlock.blockID);
    	} else {
    		par1World.setBlockWithNotify(par3, par4, par5, SBlocks.artifactEnduraiBlock.blockID);
    	}
        return true;
    }
}
