package deepcraft.core;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import deepcraft.item.tool.ItemAxeSensMod;
import deepcraft.item.tool.ItemHoeSensMod;
import deepcraft.item.tool.ItemPickaxeSensMod;
import deepcraft.item.tool.ItemSpadeSensMod;
import deepcraft.item.tool.ItemSpaxelSensMod;
import deepcraft.item.tool.ItemSwordSensMod;
import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;

public class STools {
	
	public static final Item swordEndurum = (new ItemSwordSensMod(1100, Core.ENDURUM, EnumRarity.uncommon, false)).setIconCoord(0, 4).setItemName("swordEndurum");
	public static final Item swordXircium = (new ItemSwordSensMod(1200, Core.XIRCIUM, EnumRarity.uncommon, false)).setIconCoord(1, 4).setItemName("swordXircium");
	public static final Item swordNetherite = (new ItemSwordSensMod(1300, Core.NETHERITE, EnumRarity.uncommon, false)).setIconCoord(2, 4).setItemName("swordNetherite");
	public static final Item swordValarium = (new ItemSwordSensMod(1400, Core.VALARIUM, EnumRarity.rare, true)).setIconCoord(3, 4).setItemName("swordValarium");
	public static final Item swordScinite = (new ItemSwordSensMod(1500, Core.SCINITE, EnumRarity.rare, true)).setIconCoord(4, 4).setItemName("swordScinite");
	public static final Item swordGodum = (new ItemSwordSensMod(1600, Core.GODUM, EnumRarity.epic, false)).setIconCoord(5, 4).setItemName("swordGodum");
	public static final Item swordGodumActive = (new ItemSwordSensMod(1700, Core.GODUMACTIVE, Core.endgame, true)).setIconCoord(5, 4).setItemName("swordGodumActive");

	public static final Item spadeEndurum = (new ItemSpadeSensMod(1101, Core.ENDURUM, EnumRarity.uncommon, false)).setIconCoord(0, 5).setItemName("spadeEndurum");
	public static final Item spadeXircium = (new ItemSpadeSensMod(1201, Core.XIRCIUM, EnumRarity.uncommon, false)).setIconCoord(1, 5).setItemName("spadeXircium");
	public static final Item spadeNetherite = (new ItemSpadeSensMod(1301, Core.NETHERITE, EnumRarity.uncommon, false)).setIconCoord(2, 5).setItemName("spadeNetherite");
	public static final Item spadeValarium = (new ItemSpadeSensMod(1401, Core.VALARIUM, EnumRarity.rare, true)).setIconCoord(3, 5).setItemName("spadeValarium");
	public static final Item spadeScinite = (new ItemSpadeSensMod(1501, Core.SCINITE, EnumRarity.rare, true)).setIconCoord(4, 5).setItemName("spadeScinite");
	public static final Item spadeGodum = (new ItemSpadeSensMod(1601, Core.GODUM, EnumRarity.epic, false)).setIconCoord(5, 5).setItemName("spadeGodum");
	public static final Item spadeGodumActive = (new ItemSpadeSensMod(1701, Core.GODUMACTIVE, Core.endgame, true)).setIconCoord(5, 5).setItemName("spadeGodumActive");

	public static final Item pickaxeEndurum = (new ItemPickaxeSensMod(1102, Core.ENDURUM, EnumRarity.uncommon, false)).setIconCoord(0, 6).setItemName("pickaxeEndurum");
	public static final Item pickaxeXircium = (new ItemPickaxeSensMod(1202, Core.XIRCIUM, EnumRarity.uncommon, false)).setIconCoord(1, 6).setItemName("pickaxeXircium");
	public static final Item pickaxeNetherite = (new ItemPickaxeSensMod(1302, Core.NETHERITE, EnumRarity.uncommon, false)).setIconCoord(2, 6).setItemName("pickaxeNetherite");
	public static final Item pickaxeValarium = (new ItemPickaxeSensMod(1402, Core.VALARIUM, EnumRarity.rare, true)).setIconCoord(3, 6).setItemName("pickaxeValarium");
	public static final Item pickaxeScinite = (new ItemPickaxeSensMod(1502, Core.SCINITE, EnumRarity.rare, true)).setIconCoord(4, 6).setItemName("pickaxeScinite");
	public static final Item pickaxeGodum = (new ItemPickaxeSensMod(1602, Core.GODUM, EnumRarity.epic, false)).setIconCoord(5, 6).setItemName("pickaxeGodum");
	public static final Item pickaxeGodumActive = (new ItemPickaxeSensMod(1702, Core.GODUMACTIVE, Core.endgame, true)).setIconCoord(5, 6).setItemName("pickaxeGodumActive");

	public static final Item axeEndurum = (new ItemAxeSensMod(1103, Core.ENDURUM, EnumRarity.uncommon, false)).setIconCoord(0, 7).setItemName("axeEndurum");
	public static final Item axeXircium = (new ItemAxeSensMod(1203, Core.XIRCIUM, EnumRarity.uncommon, false)).setIconCoord(1, 7).setItemName("axeXircium");
	public static final Item axeNetherite = (new ItemAxeSensMod(1303, Core.NETHERITE, EnumRarity.uncommon, false)).setIconCoord(2, 7).setItemName("axeNetherite");
	public static final Item axeValarium = (new ItemAxeSensMod(1403, Core.VALARIUM, EnumRarity.rare, true)).setIconCoord(3, 7).setItemName("axeValarium");
	public static final Item axeScinite = (new ItemAxeSensMod(1503, Core.SCINITE, EnumRarity.rare, true)).setIconCoord(4, 7).setItemName("axeScinite");
	public static final Item axeGodum = (new ItemAxeSensMod(1603, Core.GODUM, EnumRarity.epic, false)).setIconCoord(5, 7).setItemName("axeGodum");
	public static final Item axeGodumActive = (new ItemAxeSensMod(1703, Core.GODUMACTIVE, Core.endgame, true)).setIconCoord(5, 7).setItemName("axeGodumActive");

	public static final Item hoeEndurum = (new ItemHoeSensMod(1104, Core.ENDURUM, EnumRarity.uncommon, false)).setIconCoord(0, 8).setItemName("hoeEndurum");
	public static final Item hoeXircium = (new ItemHoeSensMod(1204, Core.XIRCIUM, EnumRarity.uncommon, false)).setIconCoord(1, 8).setItemName("hoeXircium");
	public static final Item hoeNetherite = (new ItemHoeSensMod(1304, Core.NETHERITE, EnumRarity.uncommon, false)).setIconCoord(2, 8).setItemName("hoeNetherite");
	public static final Item hoeValarium = (new ItemHoeSensMod(1404, Core.VALARIUM, EnumRarity.rare, true)).setIconCoord(3, 8).setItemName("hoeValarium");
	public static final Item hoeScinite = (new ItemHoeSensMod(1504, Core.SCINITE, EnumRarity.rare, true)).setIconCoord(4, 8).setItemName("hoeScinite");
	public static final Item hoeGodum = (new ItemHoeSensMod(1604, Core.GODUM, EnumRarity.epic, false)).setIconCoord(5, 8).setItemName("hoeGodum");
	public static final Item hoeGodumActive = (new ItemHoeSensMod(1704, Core.GODUMACTIVE, Core.endgame, true)).setIconCoord(5, 8).setItemName("hoeGodumActive");

	public static final Item spaxelWood = (new ItemSpaxelSensMod(900, EnumToolMaterial.WOOD, EnumRarity.common, false)).setIconCoord(0, 15).setItemName("spaxelWood");
	public static final Item spaxelStone = (new ItemSpaxelSensMod(901, EnumToolMaterial.STONE, EnumRarity.common, false)).setIconCoord(1, 15).setItemName("spaxelStone");
	public static final Item spaxelIron = (new ItemSpaxelSensMod(902, EnumToolMaterial.IRON, EnumRarity.common, false)).setIconCoord(2, 15).setItemName("spaxelIron");
	public static final Item spaxelGold = (new ItemSpaxelSensMod(903, EnumToolMaterial.GOLD, EnumRarity.common, false)).setIconCoord(4, 15).setItemName("spaxelGold");
	public static final Item spaxelDiamond = (new ItemSpaxelSensMod(904, EnumToolMaterial.EMERALD, EnumRarity.common, false)).setIconCoord(3, 15).setItemName("spaxelDiamond");
	public static final Item spaxelEndurum = (new ItemSpaxelSensMod(1105, Core.ENDURUM, EnumRarity.uncommon, false)).setIconCoord(0, 9).setItemName("spaxelEndurum");
	public static final Item spaxelXircium = (new ItemSpaxelSensMod(1205, Core.XIRCIUM, EnumRarity.uncommon, false)).setIconCoord(1, 9).setItemName("spaxelXircium");
	public static final Item spaxelNetherite = (new ItemSpaxelSensMod(1305, Core.NETHERITE, EnumRarity.uncommon, false)).setIconCoord(2, 9).setItemName("spaxeleNetherite");
	public static final Item spaxelValarium = (new ItemSpaxelSensMod(1405, Core.VALARIUM, EnumRarity.rare, true)).setIconCoord(3, 9).setItemName("spaxelValarium");
	public static final Item spaxelScinite = (new ItemSpaxelSensMod(1505, Core.SCINITE, EnumRarity.rare, true)).setIconCoord(4, 9).setItemName("spaxelScinite");
	public static final Item spaxelGodum = (new ItemSpaxelSensMod(1605, Core.GODUM, EnumRarity.epic, false)).setIconCoord(5, 9).setItemName("spaxelGodum");
	public static final Item spaxelGodumActive = (new ItemSpaxelSensMod(1705, Core.GODUMACTIVE, Core.endgame, true)).setIconCoord(5, 9).setItemName("spaxelGodumActive");
	
	public static void SetupLanguage () {
		
		LanguageRegistry.addName(swordEndurum, "Endurum Sword");
		LanguageRegistry.addName(swordXircium, "Xircium Sword");
		LanguageRegistry.addName(swordNetherite, "Netherite Sword");
		LanguageRegistry.addName(swordValarium, "Valarium Sword");
		LanguageRegistry.addName(swordScinite, "Scinite Sword");
		LanguageRegistry.addName(swordGodum, "Godum Sword");
		LanguageRegistry.addName(swordGodumActive, "Active Godum Sword");

		LanguageRegistry.addName(spadeEndurum, "Endurum Shovel");
		LanguageRegistry.addName(spadeXircium, "Xircium Shovel");
		LanguageRegistry.addName(spadeNetherite, "Netherite Shovel");
		LanguageRegistry.addName(spadeValarium, "Valarium Shovel");
		LanguageRegistry.addName(spadeScinite, "Scinite Shovel");
		LanguageRegistry.addName(spadeGodum, "Godum Shovel");
		LanguageRegistry.addName(spadeGodumActive, "Active Godum Shovel");

		LanguageRegistry.addName(pickaxeEndurum, "Endurum Pickaxe");
		LanguageRegistry.addName(pickaxeXircium, "Xircium Pickaxe");
		LanguageRegistry.addName(pickaxeNetherite, "Netherite Pickaxe");
		LanguageRegistry.addName(pickaxeValarium, "Valarium Pickaxe");
		LanguageRegistry.addName(pickaxeScinite, "Scinite Pickaxe");
		LanguageRegistry.addName(pickaxeGodum, "Godum Pickaxe");
		LanguageRegistry.addName(pickaxeGodumActive, "Active Godum Pickaxe");

		LanguageRegistry.addName(axeEndurum, "Endurum Axe");
		LanguageRegistry.addName(axeXircium, "Xircium Axe");
		LanguageRegistry.addName(axeNetherite, "Netherite Axe");
		LanguageRegistry.addName(axeValarium, "Valarium Axe");
		LanguageRegistry.addName(axeScinite, "Scinite Axe");
		LanguageRegistry.addName(axeGodum, "Godum Axe");
		LanguageRegistry.addName(axeGodumActive, "Active Godum Axe");

		LanguageRegistry.addName(hoeEndurum, "Endurum Hoe");
		LanguageRegistry.addName(hoeXircium, "Xircium Hoe");
		LanguageRegistry.addName(hoeNetherite, "Netherite Hoe");
		LanguageRegistry.addName(hoeValarium, "Valarium Hoe");
		LanguageRegistry.addName(hoeScinite, "Scinite Hoe");
		LanguageRegistry.addName(hoeGodum, "Godum Hoe");
		LanguageRegistry.addName(hoeGodumActive, "Active Godum Hoe");

		LanguageRegistry.addName(spaxelWood, "Wooden Spaxel");
		LanguageRegistry.addName(spaxelStone, "Stone Spaxel");
		LanguageRegistry.addName(spaxelIron, "Iron Spaxel");
		LanguageRegistry.addName(spaxelGold, "Gold Spaxel");
		LanguageRegistry.addName(spaxelDiamond, "Diamond Spaxel");
		LanguageRegistry.addName(spaxelEndurum, "Endurum Spaxel");
		LanguageRegistry.addName(spaxelXircium, "Xircium Spaxel");
		LanguageRegistry.addName(spaxelNetherite, "Netherite Spaxel");
		LanguageRegistry.addName(spaxelValarium, "Valarium Spaxel");
		LanguageRegistry.addName(spaxelScinite, "Scinite Spaxel");
		LanguageRegistry.addName(spaxelGodum, "Godum Spaxel");
		LanguageRegistry.addName(spaxelGodumActive, "Active Godum Spaxel");
	}
	
	public static void SetupLevels () {
		
		MinecraftForge.setToolClass(swordEndurum, "sword", 3);
		MinecraftForge.setToolClass(swordXircium, "sword", 4);
		MinecraftForge.setToolClass(swordNetherite, "sword", 5);
		MinecraftForge.setToolClass(swordValarium, "sword", 6);
		MinecraftForge.setToolClass(swordScinite, "sword", 7);
		MinecraftForge.setToolClass(swordGodum, "sword", 8);
		MinecraftForge.setToolClass(swordGodumActive, "sword", 999);

		MinecraftForge.setToolClass(spadeEndurum, "shovel", 3);
		MinecraftForge.setToolClass(spadeXircium, "shovel", 4);
		MinecraftForge.setToolClass(spadeNetherite, "shovel", 5);
		MinecraftForge.setToolClass(spadeValarium, "shovel", 6);
		MinecraftForge.setToolClass(spadeScinite, "shovel", 7);
		MinecraftForge.setToolClass(spadeGodum, "shovel", 8);
		MinecraftForge.setToolClass(spadeGodumActive, "spade", 999);

		MinecraftForge.setToolClass(pickaxeEndurum, "pickaxe", 3);
		MinecraftForge.setToolClass(pickaxeXircium, "pickaxe", 4);
		MinecraftForge.setToolClass(pickaxeNetherite, "pickaxe", 5);
		MinecraftForge.setToolClass(pickaxeValarium, "pickaxe", 6);
		MinecraftForge.setToolClass(pickaxeScinite, "pickaxe", 7);
		MinecraftForge.setToolClass(pickaxeGodum, "pickaxe", 8);
		MinecraftForge.setToolClass(pickaxeGodumActive, "pickaxe", 999);

		MinecraftForge.setToolClass(axeEndurum, "axe", 3);
		MinecraftForge.setToolClass(axeXircium, "axe", 4);
		MinecraftForge.setToolClass(axeNetherite, "axe", 5);
		MinecraftForge.setToolClass(axeValarium, "axe", 6);
		MinecraftForge.setToolClass(axeScinite, "axe", 7);
		MinecraftForge.setToolClass(axeGodum, "axe", 8);
		MinecraftForge.setToolClass(axeGodumActive, "axe", 999);

		MinecraftForge.setToolClass(hoeEndurum, "hoe", 3);
		MinecraftForge.setToolClass(hoeXircium, "hoe", 4);
		MinecraftForge.setToolClass(hoeNetherite, "hoe", 5);
		MinecraftForge.setToolClass(hoeValarium, "hoe", 6);
		MinecraftForge.setToolClass(hoeScinite, "hoe", 7);
		MinecraftForge.setToolClass(hoeGodum, "hoe", 8);
		MinecraftForge.setToolClass(hoeGodumActive, "hoe", 999);

		MinecraftForge.setToolClass(spaxelWood, "pickaxe", 0);
		MinecraftForge.setToolClass(spaxelStone, "pickaxe", 1);
		MinecraftForge.setToolClass(spaxelIron, "pickaxe", 2);
		MinecraftForge.setToolClass(spaxelGold, "pickaxe", 0);
		MinecraftForge.setToolClass(spaxelDiamond, "pickaxe", 3);
		MinecraftForge.setToolClass(spaxelEndurum, "pickaxe", 3);
		MinecraftForge.setToolClass(spaxelXircium, "pickaxe", 4);
		MinecraftForge.setToolClass(spaxelNetherite, "pickaxe", 5);
		MinecraftForge.setToolClass(spaxelValarium, "pickaxe", 6);
		MinecraftForge.setToolClass(spaxelScinite, "pickaxe", 7);
		MinecraftForge.setToolClass(spaxelGodum, "pickaxe", 8);
		MinecraftForge.setToolClass(spaxelGodumActive, "spaxel", 999);
	}
	
	public static void SetupRecipes () {
		
		ItemStack rodWoodStack = new ItemStack(Item.stick);
		ItemStack rodIronStack = new ItemStack(SItems.rodIron);
		ItemStack rodEndurumStack = new ItemStack(SItems.rodEndurum);
		ItemStack ingotEndurumStack = new ItemStack(SItems.ingotEndurum);
		ItemStack crystalXirciumStack = new ItemStack(SItems.crystalXircium);
		ItemStack crystalNetheriteStack = new ItemStack(SItems.crystalNetherite);
		ItemStack ingotValariumStack = new ItemStack(SItems.ingotValarium);
		ItemStack crystalSciniteStack = new ItemStack(SItems.crystalScinite);
		ItemStack crystalGodumStack = new ItemStack(SItems.crystalGodum);
		ItemStack ingotGodumStack = new ItemStack(SItems.ingotGodum);
		ItemStack ingotGodumActiveStack = new ItemStack(SItems.ingotGodumActive);
		
		GameRegistry.addShapedRecipe(new ItemStack(swordEndurum), "x", "x", "y", 'x', ingotEndurumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeEndurum), "x", "y", "y", 'x',ingotEndurumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeEndurum), "xxx", " y ", " y ", 'x', ingotEndurumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeEndurum), "xx", "xy", " y", 'x', ingotEndurumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeEndurum), "xx", " y", " y", 'x', ingotEndurumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelEndurum), "xxx", "xxx", " y ", 'x', ingotEndurumStack, 'y', rodIronStack);

		GameRegistry.addShapedRecipe(new ItemStack(swordXircium), "x", "x", "y", 'x', crystalXirciumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeXircium), "x", "y", "y", 'x', crystalXirciumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeXircium), "xxx", " y ", " y ", 'x', crystalXirciumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeXircium), "xx", "xy", " y", 'x', crystalXirciumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeXircium), "xx", " y", " y", 'x', crystalXirciumStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelXircium), "xxx", "xxx", " y ", 'x', crystalXirciumStack, 'y', rodIronStack);

		GameRegistry.addShapedRecipe(new ItemStack(swordNetherite), "x", "x", "y", 'x', crystalNetheriteStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeNetherite), "x", "y", "y", 'x', crystalNetheriteStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeNetherite), "xxx", " y ", " y ", 'x', crystalNetheriteStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeNetherite), "xx", "xy", " y", 'x', crystalNetheriteStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeNetherite), "xx", " y", " y", 'x', crystalNetheriteStack, 'y', rodIronStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelNetherite), "xxx", "xxx", " y ", 'x', crystalNetheriteStack, 'y', rodIronStack);

		GameRegistry.addShapedRecipe(new ItemStack(swordValarium), "x", "x", "y", 'x', ingotValariumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeValarium), "x", "y", "y", 'x', ingotValariumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeValarium), "xxx", " y ", " y ", 'x', ingotValariumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeValarium), "xx", "xy", " y", 'x', ingotValariumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeValarium), "xx", " y", " y", 'x', ingotValariumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelValarium), "xxx", "xxx", " y ", 'x', ingotValariumStack, 'y', rodEndurumStack);

		GameRegistry.addShapedRecipe(new ItemStack(swordScinite), "x", "x", "y", 'x', crystalSciniteStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeScinite), "x", "y", "y", 'x', crystalSciniteStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeScinite), "xxx", " y ", " y ", 'x', crystalSciniteStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeScinite), "xx", "xy", " y", 'x', crystalSciniteStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeScinite), "xx", " y", " y", 'x', crystalSciniteStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelScinite), "xxx", "xxx", " y ", 'x', crystalSciniteStack, 'y', rodEndurumStack);

		GameRegistry.addShapedRecipe(new ItemStack(swordGodum), "x", "x", "y", 'x', ingotGodumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeGodum), "x", "y", "y", 'x', ingotGodumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeGodum), "xxx", " y ", " y ", 'x', ingotGodumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeGodum), "xx", "xy", " y", 'x', ingotGodumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeGodum), "xx", " y", " y", 'x', ingotGodumStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelGodum), "xxx", "xxx", " y ", 'x', ingotGodumStack, 'y', rodEndurumStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(swordGodumActive), "x", "x", "y", 'x', ingotGodumActiveStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spadeGodumActive), "x", "y", "y", 'x', ingotGodumActiveStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(pickaxeGodumActive), "xxx", " y ", " y ", 'x', ingotGodumActiveStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(axeGodumActive), "xx", "xy", " y", 'x', ingotGodumActiveStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(hoeGodumActive), "xx", " y", " y", 'x', ingotGodumActiveStack, 'y', rodEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelGodumActive), "xxx", "xxx", " y ", 'x', ingotGodumActiveStack, 'y', rodEndurumStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(spaxelWood), "xxx", "xyx", " y ", 'x', new ItemStack(Block.planks), 'y', rodWoodStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelStone), "xxx", "xxx", " y ", 'x', new ItemStack(Block.cobblestone), 'y', rodWoodStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelIron), "xxx", "xxx", " y ", 'x', new ItemStack(Item.ingotIron), 'y', rodWoodStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelGold), "xxx", "xxx", " y ", 'x', new ItemStack(Item.ingotGold), 'y', rodWoodStack);
		GameRegistry.addShapedRecipe(new ItemStack(spaxelDiamond), "xxx", "xxx", " y ", 'x', new ItemStack(Item.diamond), 'y', rodWoodStack);
	}

}
