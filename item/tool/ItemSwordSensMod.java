package deepcraft.item.tool;

import cpw.mods.fml.common.FMLCommonHandler;
import deepcraft.core.CommonProxy;
import deepcraft.core.Core;
import deepcraft.world.xirk.WorldProviderXirk;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.common.DimensionManager;

public class ItemSwordSensMod extends ItemSword{
	
	@Override
	public String getTextureFile(){
		return CommonProxy.ITEMS_PNG;
	}

	EnumToolMaterial material;
	int weaponDamage;
	EnumRarity rarity;
	boolean glow;
	public ItemSwordSensMod(int par1, EnumToolMaterial par2EnumToolMaterial, EnumRarity rarity, boolean glow) {
		super(par1, par2EnumToolMaterial);
		this.weaponDamage = 4 + (2*par2EnumToolMaterial.getDamageVsEntity());
		this.rarity = rarity;
		this.glow = glow;
		this.material = par2EnumToolMaterial;
	}
	
    public int getDamageVsEntity(Entity par1Entity)
    {
        return this.weaponDamage;
    }
    public EnumRarity getRarity(ItemStack par1ItemStack) {
		return this.rarity;
    }
    
    public boolean hasEffect(ItemStack par1ItemStack){
    	return this.glow;
    }
    
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
    	if (this.material == Core.SCINITE) {
    		entity.setFire(10);
    	} else if (this.material == Core.GODUMACTIVE) {
    		entity.setDead();
    	}
        return false;
    }
    
    @Override
    public boolean itemInteractionForEntity(ItemStack item, EntityLiving ent)
    {
    	Integer entID = EntityList.getEntityID(ent);
    	if (entID != null) {
			this.spawn(ent.worldObj, ent.posX, ent.posY, ent.posZ, entID);
			return true;
    	}
        return false;
    }
    
    private void spawn(World world, double intX, double intY, double intZ, int entID) { 	
		float var6 = 0.7F;
		double dX = (double)(world.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
		double dY = (double)(world.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
		double dZ = (double)(world.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
		EntityItem spawnEnt = new EntityItem(world, intX + dX, intY + dY, intZ + dZ,  new ItemStack(383, 1, entID));
		spawnEnt.delayBeforeCanPickup = 60;
		world.spawnEntityInWorld(spawnEnt);
    }


}
