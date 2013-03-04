package deepcraft.block;

import java.util.Random;

import deepcraft.core.CommonProxy;
import deepcraft.core.Core;
import deepcraft.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;

public class BlockCrystalOreSensMod extends BlockOre {
	public int dropID;
	public int dropDamage;
	public int dropQuant;
	public int dropExtra;
	public BlockCrystalOreSensMod(int id, int texture, int dropID, int dropDamage, int dropQuant, int dropExtra) {
		super(id, texture);

		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setBlockName("genericOre");
		setCreativeTab(CreativeTabs.tabBlock);
		this.dropID = dropID;
		this.dropDamage = dropDamage;
		this.dropQuant = dropQuant;
		this.dropExtra = dropExtra + 1;
	}

	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public int idDropped(int par1, Random random, int par2) {
		return dropID;
	}
    public int quantityDropped(Random par1Random)
    {
        return dropQuant + par1Random.nextInt(dropExtra);
    }
    public int damageDropped(int par1)
    {
        return this.dropDamage;
    }
    
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int var8 = 0;

            if (this.blockID == SBlocks.oreCoalNether.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 2);
            }
            else if (this.blockID == SBlocks.oreDiamondNether.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == SBlocks.oreEmeraldNether.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 3, 7);
            }
            else if (this.blockID == SBlocks.oreLapisNether.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 2, 5);
            }
            else if (this.blockID == SBlocks.oreXirciumNether.blockID || this.blockID == SBlocks.oreXircium.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 5, 10);
            }
            else if (this.blockID == SBlocks.oreNetheriteNether.blockID || this.blockID == SBlocks.oreNetherite.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 6, 12);
            }
            else if (this.blockID == SBlocks.oreSciniteNether.blockID || this.blockID == SBlocks.oreScinite.blockID)
            {
                var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 192, 256);
            }

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }
}