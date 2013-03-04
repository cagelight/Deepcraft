package sensory.item;

import sensory.core.CommonProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

public class ItemSensMod extends Item{

	EnumRarity rarity;
	boolean glow;
    public ItemSensMod(int id, EnumRarity rarity, boolean glow) {
            super(id);
            
            // Constructor Configuration
            maxStackSize = 64;
            setCreativeTab(CreativeTabs.tabMisc);
            setIconIndex(0);
            setItemName("genericItem");
            this.rarity = rarity;
            this.glow = glow;
    }
    
    public String getTextureFile() {
            return CommonProxy.ITEMS_PNG;
    }
    
    @Override
    public EnumRarity getRarity(ItemStack par1ItemStack) {
		return this.rarity;
    }
    
    public boolean hasEffect(ItemStack par1ItemStack){
    	return this.glow;
    }
    
    
}