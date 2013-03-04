package sensory.block;

import sensory.core.CommonProxy;
import sensory.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.liquids.IBlockLiquid;

public class BlockBlueLavaFlowing extends BlockFlowing{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockBlueLavaFlowing(int par1, Material par2Material) {
		super(par1, par2Material);
		this.enableStats = false;
		//this.blockIndexInTexture = 30;
	}
	
}
