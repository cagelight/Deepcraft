package sensory.block;

import sensory.core.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockStairsSensMod extends BlockStairs{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockStairsSensMod(int par1, Block par2Block, int par3) {
		super(par1, par2Block, par3);
	}

}
