package sensory.block;

import java.util.Random;

import sensory.core.CommonProxy;
import sensory.core.SItems;
import net.minecraft.block.BlockSandStone;

public class BlockOreXirciumSandstone extends BlockSandStone{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockOreXirciumSandstone(int par1) {
		super(par1);
	}
	
	public int idDropped(int par1, Random random, int par2) {
		return SItems.crystalXircium.itemID;
	}

}
