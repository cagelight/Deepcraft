package deepcraft.block;

import java.util.Random;

import deepcraft.core.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.liquids.IBlockLiquid;

public class BlockBlueLavaStationary extends BlockStationary{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockBlueLavaStationary(int par1, Material par2Material) {
		super(par1, par2Material);
		this.enableStats = false;
		//this.blockIndexInTexture = 30;
	}
	
	@Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        int var6 = par5Random.nextInt(3);
        int var7;
        int var8;

        for (var7 = 0; var7 < var6; ++var7)
        {
            par2 += par5Random.nextInt(3) - 1;
            ++par3;
            par4 += par5Random.nextInt(3) - 1;
            var8 = par1World.getBlockId(par2, par3, par4);

            if (var8 == 0)
            {
                if (par1World.getBlockMaterial(par2 - 1, par3, par4).getCanBurn() || par1World.getBlockMaterial(par2 + 1, par3, par4).getCanBurn() || par1World.getBlockMaterial(par2, par3, par4 - 1).getCanBurn() || par1World.getBlockMaterial(par2, par3, par4 + 1).getCanBurn() || par1World.getBlockMaterial(par2, par3 - 1, par4).getCanBurn() || par1World.getBlockMaterial(par2, par3 + 1, par4).getCanBurn())
                {
                    par1World.setBlockWithNotify(par2, par3, par4, Block.fire.blockID);
                    return;
                }
            }
            else if (Block.blocksList[var8].blockMaterial.blocksMovement())
            {
                return;
            }
        }

        if (var6 == 0)
        {
            var7 = par2;
            var8 = par4;

            for (int var9 = 0; var9 < 3; ++var9)
            {
                par2 = var7 + par5Random.nextInt(3) - 1;
                par4 = var8 + par5Random.nextInt(3) - 1;

                if (par1World.isAirBlock(par2, par3 + 1, par4) && par1World.getBlockMaterial(par2 + 1, par3, par4).getCanBurn())
                {
                    par1World.setBlockWithNotify(par2, par3 + 1, par4, Block.fire.blockID);
                }
            }
        }
    }
}
