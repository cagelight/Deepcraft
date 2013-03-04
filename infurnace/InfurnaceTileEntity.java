package deepcraft.infurnace;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import deepcraft.block.BlockInfurnace;
import deepcraft.core.Core;
import deepcraft.core.SBlocks;
import deepcraft.core.SItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;
import net.minecraft.block.Block;

public class InfurnaceTileEntity extends TileEntity implements IInventory, ISidedInventory {
	/**
	 * The ItemStacks that hold the items currently being used in the furnace
	 */
	private ItemStack[] infurnaceItemStacks = new ItemStack[6];

	/** The number of ticks that the furnace will keep burning */
	public int infurnaceBurnTime = 0;

	/**
	 * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
	 */
	public int currentItemBurnTime = 0;

	/** The number of ticks that the current item has been cooking for */
	public int furnaceCookTime = 0;
	
	public int infurnaceRate;
	public int burnRate = 20;
	
	public int getRate() {
		return this.infurnaceRate;
	}
	
	public InfurnaceTileEntity() {
		this.infurnaceRate = 32000;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory()
	{
		return this.infurnaceItemStacks.length;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int par1)
	{
		return this.infurnaceItemStacks[par1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
	 * new stack.
	 */
	public ItemStack decrStackSize(int par1, int par2)
	{
		if (this.infurnaceItemStacks[par1] != null)
		{
			ItemStack var3;

			if (this.infurnaceItemStacks[par1].stackSize <= par2)
			{
				var3 = this.infurnaceItemStacks[par1];
				this.infurnaceItemStacks[par1] = null;
				return var3;
			}
			else
			{
				var3 = this.infurnaceItemStacks[par1].splitStack(par2);

				if (this.infurnaceItemStacks[par1].stackSize == 0)
				{
					this.infurnaceItemStacks[par1] = null;
				}

				return var3;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int par1)
	{
		if (this.infurnaceItemStacks[par1] != null)
		{
			ItemStack var2 = this.infurnaceItemStacks[par1];
			this.infurnaceItemStacks[par1] = null;
			return var2;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	 */
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
	{
		this.infurnaceItemStacks[par1] = par2ItemStack;

		if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
		{
			par2ItemStack.stackSize = this.getInventoryStackLimit();
		}
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName()
	{
		return "container.furnace";
	}

	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
		this.infurnaceItemStacks = new ItemStack[this.getSizeInventory()];

		for (int var3 = 0; var3 < var2.tagCount(); ++var3)
		{
			NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
			byte var5 = var4.getByte("Slot");

			if (var5 >= 0 && var5 < this.infurnaceItemStacks.length)
			{
				this.infurnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
			}
		}

		this.infurnaceBurnTime = par1NBTTagCompound.getShort("BurnTime");
		this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
		this.currentItemBurnTime = getItemBurnTime(this.infurnaceItemStacks[1])+getItemBurnTime(this.infurnaceItemStacks[5])+getItemBurnTime(this.infurnaceItemStacks[3])+getItemBurnTime(this.infurnaceItemStacks[4]);
	}

	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setShort("BurnTime", (short)this.infurnaceBurnTime);
		par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
		NBTTagList var2 = new NBTTagList();

		for (int var3 = 0; var3 < this.infurnaceItemStacks.length; ++var3)
		{
			if (this.infurnaceItemStacks[var3] != null)
			{
				NBTTagCompound var4 = new NBTTagCompound();
				var4.setByte("Slot", (byte)var3);
				this.infurnaceItemStacks[var3].writeToNBT(var4);
				var2.appendTag(var4);
			}
		}

		par1NBTTagCompound.setTag("Items", var2);
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
	 * this more of a set than a get?*
	 */
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1)
	{
		return (this.furnaceCookTime * par1) / getRate();
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1)
	{
		if (this.currentItemBurnTime <= 0)
		{
			this.currentItemBurnTime = getRate();
		}

		return this.infurnaceBurnTime * par1 / this.currentItemBurnTime;
	}

	/**
	 * Returns true if the furnace is currently burning
	 */
	public boolean isBurning()
	{
		return this.infurnaceBurnTime > 0;
	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
	 * ticks and creates a new spawn inside its implementation.
	 */
	public void updateEntity()
	{
		boolean var1 = this.infurnaceBurnTime > 0;
		boolean var2 = false;
		
		if (this.infurnaceBurnTime > 0)
		{
			this.infurnaceBurnTime -= this.burnRate;
		}

		if (!this.worldObj.isRemote)
		{
			if (this.infurnaceBurnTime <= 0 && this.canSmelt())
			{
				short itemdel = 1;
				this.infurnaceBurnTime = getItemBurnTime(this.infurnaceItemStacks[1]);
				if (this.infurnaceBurnTime == 0) {this.infurnaceBurnTime = getItemBurnTime(this.infurnaceItemStacks[5]); itemdel = 5;}
				if (this.infurnaceBurnTime == 0) {this.infurnaceBurnTime = getItemBurnTime(this.infurnaceItemStacks[3]); itemdel = 3;}
				if (this.infurnaceBurnTime == 0) {this.infurnaceBurnTime = getItemBurnTime(this.infurnaceItemStacks[4]); itemdel = 4;}

				this.currentItemBurnTime = this.infurnaceBurnTime;


				if (this.infurnaceBurnTime > 0)
				{
					var2 = true;

					if (this.infurnaceItemStacks[itemdel] != null)
					{
						--this.infurnaceItemStacks[itemdel].stackSize;

						if (this.infurnaceItemStacks[itemdel].stackSize == 0)
						{
							this.infurnaceItemStacks[itemdel] = this.infurnaceItemStacks[itemdel].getItem().getContainerItemStack(infurnaceItemStacks[itemdel]);
						}
					}
				}
			}

			if (this.isBurning() && this.canSmelt())
			{
				this.furnaceCookTime += this.burnRate;

				if (this.furnaceCookTime >= this.infurnaceRate)
				{
					this.furnaceCookTime = 0;
					this.smeltItem();
					var2 = true;
				}
			}
			else
			{
				this.furnaceCookTime = 0;
			}

			if (var1 != this.infurnaceBurnTime > 0)
			{
				var2 = true;
				BlockInfurnace.updateFurnaceBlockState(this.infurnaceBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}

		if (var2)
		{
			this.onInventoryChanged();
		}
	}

	/**
	 * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
	 */
	private boolean canSmelt()
	{
		if (this.infurnaceItemStacks[0] == null)
		{
			return false;
		}
		else
		{
			if (this.infurnaceItemStacks[0].getItem().itemID == SBlocks.oreValarium.blockID
					|| this.infurnaceItemStacks[0].getItem().itemID == SBlocks.oreValariumNether.blockID
					|| this.infurnaceItemStacks[0].getItem().itemID == SBlocks.oreScinite.blockID
					|| this.infurnaceItemStacks[0].getItem().itemID == SBlocks.oreSciniteNether.blockID) {
				this.infurnaceRate = 32000;
			} else if (this.infurnaceItemStacks[0].getItem().itemID == SBlocks.oreGodum.blockID || this.infurnaceItemStacks[0].getItem().itemID == SBlocks.oreGodum.blockID) {
				this.infurnaceRate = 64000;
			} else if (this.infurnaceItemStacks[0].getItem().itemID == SItems.crystalGodum.itemID) {
				this.infurnaceRate = 256000;
			} else {
				this.infurnaceRate = 200;
			}

			ItemStack var1 = InfurnaceRecipes.smelting().getSmeltingResult(this.infurnaceItemStacks[0]);
			if (var1 == null) return false;
			if (this.infurnaceItemStacks[2] == null) return true;
			if (!this.infurnaceItemStacks[2].isItemEqual(var1)) return false;
			int result = infurnaceItemStacks[2].stackSize + var1.stackSize;
			return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
		}
	}

	/**
	 * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
	 */
	public void smeltItem()
	{
		if (this.canSmelt())
		{
			ItemStack var1 = InfurnaceRecipes.smelting().getSmeltingResult(this.infurnaceItemStacks[0]);

			if (this.infurnaceItemStacks[2] == null)
			{
				this.infurnaceItemStacks[2] = var1.copy();
			}
			else if (this.infurnaceItemStacks[2].isItemEqual(var1))
			{
				infurnaceItemStacks[2].stackSize += var1.stackSize;
			}

			--this.infurnaceItemStacks[0].stackSize;

			if (this.infurnaceItemStacks[0].stackSize <= 0)
			{
				this.infurnaceItemStacks[0] = null;
			}
		}
	}

	/**
	 * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
	 * fuel
	 */
	public static int getItemBurnTime(ItemStack par0ItemStack)
	{
		if (par0ItemStack == null)
		{
			return 0;
		}
		else
		{
            int var1 = par0ItemStack.getItem().itemID;
            Item var2 = par0ItemStack.getItem();

            if (par0ItemStack.getItem() instanceof ItemBlock && Block.blocksList[var1] != null)
            {
                Block var3 = Block.blocksList[var1];

                if (var3 == Block.woodSingleSlab)
                {
                    return 150;
                }

                if (var3.blockMaterial == Material.wood)
                {
                    return 300;
                }
            }

            if (var2 instanceof ItemTool && ((ItemTool) var2).getToolMaterialName().equals("WOOD")) return 200;
            if (var2 instanceof ItemSword && ((ItemSword) var2).getToolMaterialName().equals("WOOD")) return 200;
            if (var2 instanceof ItemHoe && ((ItemHoe) var2).func_77842_f().equals("WOOD")) return 200;
            if (var1 == Block.netherrack.blockID) return 20;
            if (var1 == Item.stick.itemID) return 100;
            if (var1 == Item.coal.itemID) return 1600;
            if (var1 == Item.bucketLava.itemID) return 32000;
            if (var1 == Block.sapling.blockID) return 100;
            if (var1 == Item.blazeRod.itemID) return 3200;
			if (var1 == SItems.crystalXircium.itemID) return 128000;
			if (var1 == SItems.itemValarFuel.itemID) return 512000;
			if (var1 == SItems.crystalScinite.itemID) return 2048000;
            return GameRegistry.getFuelValue(par0ItemStack);
		}
	}

	/**
	 * Return true if item is a fuel source (getItemBurnTime() > 0).
	 */
	public static boolean isItemFuel(ItemStack par0ItemStack)
	{
		return getItemBurnTime(par0ItemStack) > 0;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
	{
		return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	public void openChest() {}

	public void closeChest() {}

	@Override
	public int getStartInventorySide(ForgeDirection side)
	{
		if (side == ForgeDirection.DOWN) return 1;
		if (side == ForgeDirection.UP) return 0;
		return 2;
	}

	@Override
	public int getSizeInventorySide(ForgeDirection side)
	{
		return 1;
	}
}
