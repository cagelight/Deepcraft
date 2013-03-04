package deepcraft.block;

import deepcraft.core.CommonProxy;
import net.minecraft.block.BlockNetherrack;

public class BlockDeepNetherrack extends BlockNetherrack {
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockDeepNetherrack(int par1, int par2) {
		super(par1, par2);
	}

}
