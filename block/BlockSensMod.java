package sensory.block;

import java.util.Random;

import sensory.core.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSensMod extends Block {

	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockSensMod (int id, int texture, Material material) {
		super(id, texture, material);

		setCreativeTab(CreativeTabs.tabBlock);
		setStepSound(Block.soundStoneFootstep);
	}
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

}
