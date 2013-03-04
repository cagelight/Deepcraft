package sensory.block;

import sensory.core.CommonProxy;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockTormentedSoulSand extends BlockSoulSand{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockTormentedSoulSand(int par1, int par2) {
		super(par1, par2);
	}
	
	@Override
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionX *= 0.2D;
        par5Entity.motionZ *= 0.2D;
    }

}
