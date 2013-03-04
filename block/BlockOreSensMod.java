package deepcraft.block;

import java.util.Random;

import deepcraft.core.CommonProxy;
import deepcraft.core.Core;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.block.material.Material;

public class BlockOreSensMod extends BlockOre {
	public BlockOreSensMod(int id, int texture) {
		super(id, texture);

		setHardness(4.0F); // 33% harder than diamond
		setStepSound(Block.soundStoneFootstep);
		setBlockName("genericOre");
		setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public String getTextureFile () {
		return CommonProxy.BLOCK_PNG;
	}

	public int idDropped(int par1, Random random, int par2) {
		return this.blockID;
	}
}