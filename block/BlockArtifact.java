package sensory.block;

import java.util.Random;

import sensory.core.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockArtifact extends Block {
	
	public int dropID;
	
	@Override
	public String getTextureFile () {
		return CommonProxy.ITEMS_PNG;
	}

	public BlockArtifact(int id, int texture, Material material, int dropID) {
		super(id, texture, material);
		this.setCreativeTab(CreativeTabs.tabDecorations);
		this.dropID = dropID;
	}
	
	@Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.dropID;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }


    @Override
    public int getRenderType()
    {
        return 1;
    }

}
