package sensory.item.tool;

import java.util.ArrayList;
import java.util.List;

import sensory.core.CommonProxy;
import sensory.core.Core;
import sensory.core.STools;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.entity.player.UseHoeEvent;

public class ItemPickaxeSensMod extends ItemPickaxe{

	@Override
	public String getTextureFile(){
		return CommonProxy.ITEMS_PNG;
	}

	EnumToolMaterial material;
	EnumRarity rarity;
	boolean glow;
	public ItemPickaxeSensMod(int par1, EnumToolMaterial par2EnumToolMaterial, EnumRarity rarity, boolean glow) {
		super(par1, par2EnumToolMaterial);
		this.rarity = rarity;
		this.glow = glow;
		this.material = par2EnumToolMaterial;
	}
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return this.rarity;
	}

	public boolean hasEffect(ItemStack par1ItemStack){
		return this.glow;
	}

	private int owedBlocks = 0;
	private int owedID = 0;

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int intX, int intY, int intZ, int derp, float floatX, float floatY, float floatZ)
	{
		if (this.material == Core.GODUMACTIVE) {
			if (!player.canPlayerEdit(intX, intY, intZ, derp, item))
			{
				return false;
			}
			else
			{
				UseHoeEvent event = new UseHoeEvent(player, item, world, intX, intY, intZ);
				if (MinecraftForge.EVENT_BUS.post(event))
				{
					return false;
				}

				if (event.getResult() == Result.ALLOW)
				{
					return true;
				}

				else
				{					
					this.owedID = world.getBlockId(intX, intY, intZ);
					if (this.owedID == Block.bedrock.blockID) {
						return false;
					}

					Block var13 = Block.stone;
					world.playSoundEffect((double)((float)intX + 0.5F), (double)((float)intY + 0.5F), (double)((float)intZ + 0.5F), var13.stepSound.getStepSound(), (var13.stepSound.getVolume() + 1.0F) / 2.0F, var13.stepSound.getPitch() * 0.8F);

					if (world.isRemote)
					{
						return true;
					}
					else
					{	
						int collectLimit = 8192;
						int testID = 0;
						List Jobs = new ArrayList();
						Jobs.add(new int[]{intX, intY, intZ});

						while (Jobs.size() > 0 && collectLimit > 0) {
							int[] thisBlock=(int[])Jobs.get(0);Jobs.remove(0);
							if (world.getBlockId(thisBlock[0], thisBlock[1], thisBlock[2]) != 0) {
								collectLimit--; this.owedBlocks++;
								this.destroy(thisBlock[0], thisBlock[1], thisBlock[2], world);

								testID = world.getBlockId(thisBlock[0] + 1, thisBlock[1], thisBlock[2]);
								if (testID == owedID) {
									Jobs.add(new int[]{thisBlock[0] + 1, thisBlock[1], thisBlock[2]});
								}
								testID = world.getBlockId(thisBlock[0] - 1, thisBlock[1], thisBlock[2]);
								if (testID == owedID) {
									Jobs.add(new int[]{thisBlock[0] - 1, thisBlock[1], thisBlock[2]});
								}
								testID = world.getBlockId(thisBlock[0], thisBlock[1] + 1, thisBlock[2]);
								if (testID == owedID) {
									Jobs.add(new int[]{thisBlock[0], thisBlock[1] + 1, thisBlock[2]});
								}
								testID = world.getBlockId(thisBlock[0], thisBlock[1] - 1, thisBlock[2]);
								if (testID == owedID) {
									Jobs.add(new int[]{thisBlock[0], thisBlock[1] - 1, thisBlock[2]});
								}
								testID = world.getBlockId(thisBlock[0], thisBlock[1], thisBlock[2] + 1);
								if (testID == owedID) {
									Jobs.add(new int[]{thisBlock[0], thisBlock[1], thisBlock[2] + 1});
								}
								testID = world.getBlockId(thisBlock[0], thisBlock[1], thisBlock[2] - 1);
								if (testID == owedID) {
									Jobs.add(new int[]{thisBlock[0], thisBlock[1], thisBlock[2] - 1});
								}
							}
						}

						this.releaseOwed(world, intX, intY, intZ);

						return true;
					}
				}
			}
		} else { return false; }
	}

	private void destroy (int intX, int intY, int intZ, World world) {
		world.setBlockWithNotify(intX, intY, intZ, 0);
	}

	private void releaseOwed(World world, int intX, int intY, int intZ) {
		while (this.owedBlocks > 0) {
			if (this.owedBlocks > 64) {
				this.spawn(world, intX, intY, intZ, this.owedID, 64);
				this.owedBlocks -= 64;
			} else {
				this.spawn(world, intX, intY, intZ, this.owedID, this.owedBlocks);
				this.owedBlocks = 0;
			}
		}
	}

	private void spawn (World world, int intX, int intY, int intZ, int spawnID, int stackSize) {
		float var6 = 0.7F;
		double dX = (double)(world.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
		double dY = (double)(world.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
		double dZ = (double)(world.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
		EntityItem spawnEnt = new EntityItem(world, (double)intX + dX, (double)intY + dY, (double)intZ + dZ, new ItemStack(spawnID, stackSize, 0));
		spawnEnt.delayBeforeCanPickup = 60;
		world.spawnEntityInWorld(spawnEnt);
	}
}