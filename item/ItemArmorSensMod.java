package deepcraft.item;

import deepcraft.core.CommonProxy;
import deepcraft.core.SArmors;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.IArmorTextureProvider;
import net.minecraftforge.common.ISpecialArmor;

public class ItemArmorSensMod extends ItemArmor implements IArmorTextureProvider{

	EnumRarity rarity;
	boolean glow;
	EnumArmorMaterial material;
	public ItemArmorSensMod(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, EnumRarity rarity, boolean glow) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.rarity = rarity;
		this.glow = glow;
		this.material = par2EnumArmorMaterial;
		
		this.setHasSubtypes(false);
	}

	public String getArmorTextureFile(ItemStack itemstack)
	{
		if(itemstack.itemID == SArmors.helmetEndurum.itemID || itemstack.itemID == SArmors.plateEndurum.itemID || itemstack.itemID == SArmors.bootsEndurum.itemID) {
			return CommonProxy.ARMOR_ENDURUM_PNG[0];
		} else if(itemstack.itemID == SArmors.legsEndurum.itemID) {
			return CommonProxy.ARMOR_ENDURUM_PNG[1];
		} else if(itemstack.itemID == SArmors.helmetXircium.itemID || itemstack.itemID == SArmors.plateXircium.itemID || itemstack.itemID == SArmors.bootsXircium.itemID) {
			return CommonProxy.ARMOR_XIRCIUM_PNG[0];
		} else if(itemstack.itemID == SArmors.legsXircium.itemID) {
			return CommonProxy.ARMOR_XIRCIUM_PNG[1];
		} else if(itemstack.itemID == SArmors.helmetNetherite.itemID || itemstack.itemID == SArmors.plateNetherite.itemID || itemstack.itemID == SArmors.bootsNetherite.itemID) {
			return CommonProxy.ARMOR_NETHERITE_PNG[0];
		} else if(itemstack.itemID == SArmors.legsNetherite.itemID) {
			return CommonProxy.ARMOR_NETHERITE_PNG[1];
		} else if(itemstack.itemID == SArmors.helmetValarium.itemID || itemstack.itemID == SArmors.plateValarium.itemID || itemstack.itemID == SArmors.bootsValarium.itemID) {
			return CommonProxy.ARMOR_VALARIUM_PNG[0];
		} else if(itemstack.itemID == SArmors.legsValarium.itemID) {
			return CommonProxy.ARMOR_VALARIUM_PNG[1];
		} else if(itemstack.itemID == SArmors.helmetScinite.itemID || itemstack.itemID == SArmors.plateScinite.itemID || itemstack.itemID == SArmors.bootsScinite.itemID) {
			return CommonProxy.ARMOR_SCINITE_PNG[0];
		} else if(itemstack.itemID == SArmors.legsScinite.itemID) {
			return CommonProxy.ARMOR_SCINITE_PNG[1];
		} else if(itemstack.itemID == SArmors.helmetGodum.itemID || itemstack.itemID == SArmors.plateGodum.itemID || itemstack.itemID == SArmors.bootsGodum.itemID) {
			return CommonProxy.ARMOR_GODUM_PNG[0];
		} else if(itemstack.itemID == SArmors.legsGodum.itemID) {
			return CommonProxy.ARMOR_GODUM_PNG[1];
		} else if(itemstack.itemID == SArmors.helmetGodumActive.itemID || itemstack.itemID == SArmors.plateGodumActive.itemID || itemstack.itemID == SArmors.bootsGodumActive.itemID) {
			return CommonProxy.ARMOR_GODUM_PNG[0];
		} else if(itemstack.itemID == SArmors.legsGodumActive.itemID) {
			return CommonProxy.ARMOR_GODUM_PNG[1];
		}
		return CommonProxy.ARMOR_ENDURUM_PNG[0];
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return this.rarity;
	}

	public boolean hasEffect(ItemStack par1ItemStack){
		return this.glow;
	}

	@Override
	public String getTextureFile() {
		return CommonProxy.ITEMS_PNG;
	}

}
