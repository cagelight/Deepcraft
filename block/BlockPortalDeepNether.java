package sensory.block;

import java.util.Random;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import sensory.core.CommonProxy;
import sensory.core.Core;
import sensory.core.SBlocks;
import sensory.core.SWorlds;
import sensory.fx.EntityPortalEnduraiFX;
import sensory.fx.EntityPortalDeepNetherFX;
import sensory.world.TeleporterSensMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPortal;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.world.World;

public class BlockPortalDeepNether extends BlockPortal{
	
	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public BlockPortalDeepNether(int par1, int par2) {
		super(par1, par2);

		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.provider.isSurfaceWorld() && par5Random.nextInt(2000) < par1World.difficultySetting)
		{
			int var6;

			for (var6 = par3; !par1World.doesBlockHaveSolidTopSurface(par2, var6, par4) && var6 > 0; --var6)
			{
				;
			}

			if (var6 > 0 && !par1World.isBlockNormalCube(par2, var6 + 1, par4))
			{
				Entity var7 = ItemMonsterPlacer.spawnCreature(par1World, 57, (double)par2 + 0.5D, (double)var6 + 1.1D, (double)par4 + 0.5D);

				if (var7 != null)
				{
					var7.timeUntilPortal = var7.getPortalCooldown();
				}
			}
		}
	}

	@Override
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
	{
		if (par5Entity.ridingEntity == null && par5Entity.riddenByEntity == null)
		{
			if(par5Entity instanceof EntityPlayerMP) {
				EntityPlayerMP player = (EntityPlayerMP)par5Entity;
				if (player.timeUntilPortal == 0) {
					if (player.dimension != SWorlds.deepNetherID) {
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, SWorlds.deepNetherID, new TeleporterSensMod(player.mcServer.worldServerForDimension(SWorlds.deepNetherID), SBlocks.portalDeepNether, SBlocks.blockNetherite));
						player.timeUntilPortal = 60;
					} else {
						player.mcServer.getConfigurationManager().transferPlayerToDimension(player, 0, new TeleporterSensMod(player.mcServer.worldServerForDimension(0), SBlocks.portalDeepNether, SBlocks.blockNetherite));
						player.timeUntilPortal = 60;
					}
				}
			}
		}
	}

	@Override
	public boolean tryToCreatePortal(World par1World, int par2, int par3, int par4)
	{
		byte var5 = 0;
		byte var6 = 0;

		if (par1World.getBlockId(par2 - 1, par3, par4) == SBlocks.blockNetherite.blockID || par1World.getBlockId(par2 + 1, par3, par4) == SBlocks.blockNetherite.blockID)
		{
			var5 = 1;
		}

		if (par1World.getBlockId(par2, par3, par4 - 1) == SBlocks.blockNetherite.blockID || par1World.getBlockId(par2, par3, par4 + 1) == SBlocks.blockNetherite.blockID)
		{
			var6 = 1;
		}

		if (var5 == var6)
		{
			return false;
		}
		else
		{
			if (par1World.getBlockId(par2 - var5, par3, par4 - var6) == 0)
			{
				par2 -= var5;
				par4 -= var6;
			}

			int var7;
			int var8;

			for (var7 = -1; var7 <= 2; ++var7)
			{
				for (var8 = -1; var8 <= 3; ++var8)
				{
					boolean var9 = var7 == -1 || var7 == 2 || var8 == -1 || var8 == 3;

					if (var7 != -1 && var7 != 2 || var8 != -1 && var8 != 3)
					{
						int var10 = par1World.getBlockId(par2 + var5 * var7, par3 + var8, par4 + var6 * var7);

						if (var9)
						{
							if (var10 != SBlocks.blockNetherite.blockID)
							{
								return false;
							}
						}
						else if (var10 != 0 && var10 != Block.fire.blockID)
						{
							return false;
						}
					}
				}
			}

			par1World.editingBlocks = true;

			for (var7 = 0; var7 < 2; ++var7)
			{
				for (var8 = 0; var8 < 3; ++var8)
				{
					par1World.setBlockWithNotify(par2 + var5 * var7, par3 + var8, par4 + var6 * var7, SBlocks.portalDeepNether.blockID);
				}
			}

			par1World.editingBlocks = false;
			return true;
		}
	}

	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
	{
		byte var6 = 0;
		byte var7 = 1;

		if (par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID)
		{
			var6 = 1;
			var7 = 0;
		}

		int var8;

		for (var8 = par3; par1World.getBlockId(par2, var8 - 1, par4) == this.blockID; --var8)
		{
			;
		}

		if (par1World.getBlockId(par2, var8 - 1, par4) != SBlocks.blockNetherite.blockID)
		{
			par1World.setBlockWithNotify(par2, par3, par4, 0);
		}
		else
		{
			int var9;

			for (var9 = 1; var9 < 4 && par1World.getBlockId(par2, var8 + var9, par4) == this.blockID; ++var9)
			{
				;
			}

			if (var9 == 3 && par1World.getBlockId(par2, var8 + var9, par4) == SBlocks.blockNetherite.blockID)
			{
				boolean var10 = par1World.getBlockId(par2 - 1, par3, par4) == this.blockID || par1World.getBlockId(par2 + 1, par3, par4) == this.blockID;
				boolean var11 = par1World.getBlockId(par2, par3, par4 - 1) == this.blockID || par1World.getBlockId(par2, par3, par4 + 1) == this.blockID;

				if (var10 && var11)
				{
					par1World.setBlockWithNotify(par2, par3, par4, 0);
				}
				else
				{
					if ((par1World.getBlockId(par2 + var6, par3, par4 + var7) != SBlocks.blockNetherite.blockID || par1World.getBlockId(par2 - var6, par3, par4 - var7) != this.blockID) && (par1World.getBlockId(par2 - var6, par3, par4 - var7) != SBlocks.blockNetherite.blockID || par1World.getBlockId(par2 + var6, par3, par4 + var7) != this.blockID))
					{
						par1World.setBlockWithNotify(par2, par3, par4, 0);
					}
				}
			}
			else
			{
				par1World.setBlockWithNotify(par2, par3, par4, 0);
			}
		}
	}
	
	@Override
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par5Random.nextInt(100) == 0)
        {
            par1World.playSound((double)par2 + 0.5D, (double)par3 + 0.5D, (double)par4 + 0.5D, "portal.portal", 0.5F, par5Random.nextFloat() * 0.4F + 0.8F, false);
        }
        
        for (int var6 = 0; var6 < 4; ++var6)
        {
            double var7 = (double)((float)par2 + par5Random.nextFloat());
            double var9 = (double)((float)par3 + par5Random.nextFloat());
            double var11 = (double)((float)par4 + par5Random.nextFloat());
            double var13 = 0.0D;
            double var15 = 0.0D;
            double var17 = 0.0D;
            int var19 = par5Random.nextInt(2) * 2 - 1;
            var13 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            var15 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;
            var17 = ((double)par5Random.nextFloat() - 0.5D) * 0.5D;

            if (par1World.getBlockId(par2 - 1, par3, par4) != this.blockID && par1World.getBlockId(par2 + 1, par3, par4) != this.blockID)
            {
                var7 = (double)par2 + 0.5D + 0.25D * (double)var19;
                var13 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
            }
            else
            {
                var11 = (double)par4 + 0.5D + 0.25D * (double)var19;
                var17 = (double)(par5Random.nextFloat() * 2.0F * (float)var19);
            }

            //par1World.spawnParticle("portal", var7, var9, var11, var13, var15, var17);
            FMLClientHandler.instance().getClient().effectRenderer.addEffect((EntityFX)new EntityPortalDeepNetherFX(par1World, var7, var9, var11, var13, var15, var17), null);
        }
    }

}
