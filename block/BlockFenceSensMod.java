package deepcraft.block;

import deepcraft.core.CommonProxy;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockFenceSensMod extends BlockFence{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockFenceSensMod(int par1, int par2) {
		super(par1, par2);
	}
    public BlockFenceSensMod(int par1, int par2, Material par3Material)
    {
        super(par1, par2, par3Material);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

}
