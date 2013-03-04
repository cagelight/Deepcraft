package sensory.block;

import java.util.Random;

import sensory.core.CommonProxy;
import sensory.core.Core;
import sensory.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockRedstoneOreNether extends BlockRedstoneOre {
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockRedstoneOreNether(int par1, int par2, boolean par3) {
		super(par1, par2, par3);
	}
	
    private void glow(World par1World, int par2, int par3, int par4)
    {
        this.sparkle(par1World, par2, par3, par4);

        if (this.blockID == SBlocks.oreRedstoneNether.blockID)
        {
            par1World.setBlockWithNotify(par2, par3, par4, SBlocks.oreRedstoneNetherGlowing.blockID);
        }
    }
    
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (this.blockID == SBlocks.oreRedstoneNetherGlowing.blockID)
        {
            par1World.setBlockWithNotify(par2, par3, par4, SBlocks.oreRedstoneNether.blockID);
        }
    }
    
    private void sparkle(World par1World, int par2, int par3, int par4)
    {
        Random var5 = par1World.rand;
        double var6 = 0.0625D;

        for (int var8 = 0; var8 < 6; ++var8)
        {
            double var9 = (double)((float)par2 + var5.nextFloat());
            double var11 = (double)((float)par3 + var5.nextFloat());
            double var13 = (double)((float)par4 + var5.nextFloat());

            if (var8 == 0 && !par1World.isBlockOpaqueCube(par2, par3 + 1, par4))
            {
                var11 = (double)(par3 + 1) + var6;
            }

            if (var8 == 1 && !par1World.isBlockOpaqueCube(par2, par3 - 1, par4))
            {
                var11 = (double)(par3 + 0) - var6;
            }

            if (var8 == 2 && !par1World.isBlockOpaqueCube(par2, par3, par4 + 1))
            {
                var13 = (double)(par4 + 1) + var6;
            }

            if (var8 == 3 && !par1World.isBlockOpaqueCube(par2, par3, par4 - 1))
            {
                var13 = (double)(par4 + 0) - var6;
            }

            if (var8 == 4 && !par1World.isBlockOpaqueCube(par2 + 1, par3, par4))
            {
                var9 = (double)(par2 + 1) + var6;
            }

            if (var8 == 5 && !par1World.isBlockOpaqueCube(par2 - 1, par3, par4))
            {
                var9 = (double)(par2 + 0) - var6;
            }

            if (var9 < (double)par2 || var9 > (double)(par2 + 1) || var11 < 0.0D || var11 > (double)(par3 + 1) || var13 < (double)par4 || var13 > (double)(par4 + 1))
            {
                par1World.spawnParticle("reddust", var9, var11, var13, 0.0D, 0.0D, 0.0D);
            }
        }
    }
    
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(SBlocks.oreRedstoneNether);
    }

}
