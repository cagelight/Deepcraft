package deepcraft.item.tool;

import deepcraft.core.CommonProxy;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemHoeSensMod extends ItemHoe{
	
	@Override
	public String getTextureFile(){
		return CommonProxy.ITEMS_PNG;
	}

	EnumRarity rarity;
	boolean glow;
	public ItemHoeSensMod(int par1, EnumToolMaterial par2EnumToolMaterial, EnumRarity rarity, boolean glow) {
		super(par1, par2EnumToolMaterial);
		this.rarity = rarity;
		this.glow = glow;
	}
    public EnumRarity getRarity(ItemStack par1ItemStack) {
		return this.rarity;
    }
    
    public boolean hasEffect(ItemStack par1ItemStack){
    	return this.glow;
    }

}
