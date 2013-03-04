package deepcraft.core;

import java.util.EnumSet;

import cpw.mods.fml.common.ICraftingHandler;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class SensModWatcher implements IScheduledTickHandler, ICraftingHandler{

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {

		EntityPlayer plr = (EntityPlayer) tickData[0];

		ItemStack gaHelm = plr.getCurrentArmor(3); boolean wearingGAHelm = false; try {wearingGAHelm = (gaHelm.itemID == SArmors.helmetGodumActive.itemID);} catch (NullPointerException e){wearingGAHelm = false;} finally {}
		ItemStack gaChst = plr.getCurrentArmor(2); boolean wearingGAChst = false; try {wearingGAChst = (gaChst.itemID == SArmors.plateGodumActive.itemID);} catch (NullPointerException e){wearingGAChst = false;} finally {}
		ItemStack gaLegs = plr.getCurrentArmor(1); boolean wearingGALegs = false; try {wearingGALegs = (gaLegs.itemID == SArmors.legsGodumActive.itemID);} catch (NullPointerException e){wearingGALegs = false;} finally {}
		ItemStack gaBoot = plr.getCurrentArmor(0); boolean wearingGABoot = false; try {wearingGABoot = (gaBoot.itemID == SArmors.bootsGodumActive.itemID);} catch (NullPointerException e){wearingGABoot = false;} finally {}
		boolean wearingGAAll = (wearingGAHelm && wearingGAChst && wearingGALegs && wearingGABoot);

		if (wearingGAAll) {
			if (!plr.isEntityInvulnerable()) {
				NBTTagCompound derp = new NBTTagCompound();
				plr.writeToNBT(derp);
				derp.setBoolean("Invulnerable", true);
				plr.readFromNBT(derp);
			}
		} else {
			if (plr.isEntityInvulnerable()) {
				NBTTagCompound derp = new NBTTagCompound();
				plr.writeToNBT(derp);
				derp.setBoolean("Invulnerable", false);
				plr.readFromNBT(derp);
			}
		}

		if (wearingGAHelm) {
			plr.setAir(300);
			blankEnchantRoutine(gaHelm);
			gaHelm.setItemDamage(0);
		}
		
		if (wearingGAChst) {
			if (plr.isBurning()) {
				plr.extinguish();
			}
			blankEnchantRoutine(gaChst);
			gaChst.setItemDamage(0);
		}

		if (wearingGALegs) {
			blankEnchantRoutine(gaLegs);
			gaLegs.setItemDamage(0);
		}

		if (wearingGABoot) {
			plr.fallDistance = 0.0F;
			blankEnchantRoutine(gaBoot);
			gaBoot.setItemDamage(0);
		}
		
		if (!wearingGAAll) {
			ItemStack scHelm = plr.getCurrentArmor(3); boolean wearingSCHelm = false; try {wearingSCHelm = (gaHelm.itemID == SArmors.helmetScinite.itemID);} catch (NullPointerException e){wearingSCHelm = false;} finally {}
			ItemStack scChst = plr.getCurrentArmor(2); boolean wearingSCChst = false; try {wearingSCChst = (gaChst.itemID == SArmors.plateScinite.itemID);} catch (NullPointerException e){wearingSCChst = false;} finally {}
			ItemStack scLegs = plr.getCurrentArmor(1); boolean wearingSCLegs = false; try {wearingSCLegs = (gaLegs.itemID == SArmors.legsScinite.itemID);} catch (NullPointerException e){wearingSCLegs = false;} finally {}
			ItemStack scBoot = plr.getCurrentArmor(0); boolean wearingSCBoot = false; try {wearingSCBoot = (gaBoot.itemID == SArmors.bootsScinite.itemID);} catch (NullPointerException e){wearingSCBoot = false;} finally {}
			boolean wearingSCAll = (wearingSCHelm && wearingSCChst && wearingSCLegs && wearingSCBoot);
			
			if (wearingSCHelm) {
				blankEnchantRoutine(scHelm);
			}
			if (wearingSCChst) {
				if (plr.isBurning()) {
					plr.extinguish();
				}
				blankEnchantRoutine(scChst);
			}
			if (wearingSCLegs) {
				blankEnchantRoutine(scLegs);
			}
			if (wearingSCBoot) {
				plr.fallDistance = 0.0F;
				blankEnchantRoutine(scBoot);
			}
			
			if (!wearingSCAll) {
				ItemStack vaHelm = plr.getCurrentArmor(3); boolean wearingVAHelm = false; try {wearingVAHelm = (gaHelm.itemID == SArmors.helmetValarium.itemID);} catch (NullPointerException e){wearingVAHelm = false;} finally {}
				ItemStack vaChst = plr.getCurrentArmor(2); boolean wearingVAChst = false; try {wearingVAChst = (gaChst.itemID == SArmors.plateValarium.itemID);} catch (NullPointerException e){wearingVAChst = false;} finally {}
				ItemStack vaLegs = plr.getCurrentArmor(1); boolean wearingVALegs = false; try {wearingVALegs = (gaLegs.itemID == SArmors.legsValarium.itemID);} catch (NullPointerException e){wearingVALegs = false;} finally {}
				ItemStack vaBoot = plr.getCurrentArmor(0); boolean wearingVABoot = false; try {wearingVABoot = (gaBoot.itemID == SArmors.bootsValarium.itemID);} catch (NullPointerException e){wearingVABoot = false;} finally {}
				boolean wearingVAAll = (wearingVAHelm && wearingVAChst && wearingVALegs && wearingVABoot);
				
				if (wearingVAHelm) {
					blankEnchantRoutine(vaHelm);
				}
				if (wearingVAChst) {
					blankEnchantRoutine(vaChst);
				}
				if (wearingVALegs) {
					blankEnchantRoutine(vaLegs);
				}
				if (wearingVABoot) {
					blankEnchantRoutine(vaBoot);
				}
			}
		}
	}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "Sensory's Mod Watcher";
	}

	@Override
	public int nextTickSpacing() {
		return 10;
	}

	@Override
	public void onCrafting(EntityPlayer player, ItemStack item, IInventory craftMatrix) {
		
/*		boolean pickaxeSciP = (item.itemID == STools.pickaxeScinite.itemID || item.itemID == STools.pickaxeGodum.itemID || item.itemID == STools.pickaxeGodumActive.itemID);
		boolean swordSciP = (item.itemID == STools.swordScinite.itemID || item.itemID == STools.swordGodum.itemID || item.itemID == STools.swordGodumActive.itemID);
		boolean spaxelSciP = (item.itemID == STools.spaxelScinite.itemID || item.itemID == STools.spaxelGodum.itemID || item.itemID == STools.spaxelGodumActive.itemID);
		
		if (swordSciP || spaxelSciP) {
			item.addEnchantment(Enchantment.fireAspect, 10);
			item.addEnchantment(Enchantment.knockback, 10);
			item.
		}
		if (pickaxeSciP || spaxelSciP) {
			item.addEnchantment(Enchantment.fortune, 10);
		}
		if (item.itemID == STools.spaxelScinite.itemID || item.itemID == STools.pickaxeScinite.itemID) {
			item.addEnchantment(Enchantment.silkTouch, 10);
		} */
	}

	@Override
	public void onSmelting(EntityPlayer player, ItemStack item) {
		
	}
	
	private void blankEnchantRoutine (ItemStack item) {
        if (item.stackTagCompound == null)
        {
        	item.setTagCompound(new NBTTagCompound());
        }

        if (!item.stackTagCompound.hasKey("ench"))
        {
        	item.stackTagCompound.setTag("ench", new NBTTagList("ench"));
        }
	}
}
