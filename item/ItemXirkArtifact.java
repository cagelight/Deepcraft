package deepcraft.item;

import deepcraft.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemXirkArtifact extends ItemSensMod{

	public ItemXirkArtifact(int id, EnumRarity rarity, boolean glow) {
		super(id, rarity, glow);
	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int intX, int intY, int intZ, int intQ, float par8, float par9, float par10)
	{
		if (world.getBlockId(intX, intY, intZ) == SBlocks.blockEndurum.blockID) {
			SBlocks.portalEndurai.tryToCreatePortal(world, intX, intY + 1, intZ);
			return true;
		} else if (world.getBlockId(intX, intY, intZ) == SBlocks.blockXircium.blockID) {
			SBlocks.portalXirk.tryToCreatePortal(world, intX, intY + 1, intZ);
			return true;
		} else {
			if (intQ == 0){
				--intY;
			}
			if (intQ == 1){
				++intY;
			}
			if (intQ == 2){
				--intZ;
			}
			if (intQ == 3){
				++intZ;
			}
			if (intQ == 4){
				--intX;
			}
			if (intQ == 5){
				++intX;
			}
			if (!player.canPlayerEdit(intX, intY, intZ, intQ, item)){
				return false;
			}
			else{
				int var11 = world.getBlockId(intX, intY, intZ);
				if (var11 == 0)
				{
					world.playSoundEffect((double)intX + 0.5D, (double)intY + 0.5D, (double)intZ + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					world.setBlockWithNotify(intX, intY, intZ, Block.fire.blockID);
				}
				return true;
			}
		}
	}

}
