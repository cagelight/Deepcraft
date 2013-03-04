package sensory.item;

import sensory.core.SBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemEnduraiArtifact extends ItemSensMod{

	public ItemEnduraiArtifact(int par1, EnumRarity rarity, boolean glow) {
		super(par1, rarity, glow);
	}
	
	@Override
    public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int intX, int intY, int intZ, int intQ, float par8, float par9, float par10)
    {
        if (world.getBlockId(intX, intY, intZ) == SBlocks.blockEndurum.blockID) {
        	SBlocks.portalEndurai.tryToCreatePortal(world, intX, intY + 1, intZ);
        	return true;
        }
        return false;  
    }

}
