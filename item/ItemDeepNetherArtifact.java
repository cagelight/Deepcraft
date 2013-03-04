package deepcraft.item;

import deepcraft.core.SBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemDeepNetherArtifact extends ItemSensMod{

	public ItemDeepNetherArtifact(int id, EnumRarity rarity, boolean glow) {
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
        } else if (world.getBlockId(intX, intY, intZ) == SBlocks.blockNetherite.blockID) {
        	SBlocks.portalDeepNether.tryToCreatePortal(world, intX, intY + 1, intZ);
        	return true;
        }
        
        return false;
    }

}
