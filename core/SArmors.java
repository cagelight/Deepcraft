package sensory.core;

import sensory.item.ItemArmorSensMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class SArmors {
	
	public static Item helmetEndurum = (new ItemArmorSensMod(3100, Core.ARMOR_ENDURUM, 3, 0, EnumRarity.uncommon, false)).setIconCoord(0, 0).setItemName("helmetEndurum");
	public static Item plateEndurum = (new ItemArmorSensMod(3101, Core.ARMOR_ENDURUM, 3, 1, EnumRarity.uncommon, false)).setIconCoord(0, 1).setItemName("plateEndurum");
	public static Item legsEndurum = (new ItemArmorSensMod(3102, Core.ARMOR_ENDURUM, 3, 2, EnumRarity.uncommon, false)).setIconCoord(0, 2).setItemName("legsEndurum");
	public static Item bootsEndurum = (new ItemArmorSensMod(3103, Core.ARMOR_ENDURUM, 3, 3, EnumRarity.uncommon, false)).setIconCoord(0, 3).setItemName("bootsEndurum");
	
	public static Item helmetXircium = (new ItemArmorSensMod(3200, Core.ARMOR_XIRCIUM, 3, 0, EnumRarity.uncommon, false)).setIconCoord(1, 0).setItemName("helmetXircium");
	public static Item plateXircium = (new ItemArmorSensMod(3201, Core.ARMOR_XIRCIUM, 3, 1, EnumRarity.uncommon, false)).setIconCoord(1, 1).setItemName("plateXircium");
	public static Item legsXircium = (new ItemArmorSensMod(3202, Core.ARMOR_XIRCIUM, 3, 2, EnumRarity.uncommon, false)).setIconCoord(1, 2).setItemName("legsXircium");
	public static Item bootsXircium = (new ItemArmorSensMod(3203, Core.ARMOR_XIRCIUM, 3, 3, EnumRarity.uncommon, false)).setIconCoord(1, 3).setItemName("bootsXircium");
	
	public static Item helmetNetherite = (new ItemArmorSensMod(3300, Core.ARMOR_NETHERITE, 3, 0, EnumRarity.uncommon, false)).setIconCoord(2, 0).setItemName("helmetNetherite");
	public static Item plateNetherite = (new ItemArmorSensMod(3301, Core.ARMOR_NETHERITE, 3, 1, EnumRarity.uncommon, false)).setIconCoord(2, 1).setItemName("plateNetherite");
	public static Item legsNetherite = (new ItemArmorSensMod(3302, Core.ARMOR_NETHERITE, 3, 2, EnumRarity.uncommon, false)).setIconCoord(2, 2).setItemName("legsNetherite");
	public static Item bootsNetherite = (new ItemArmorSensMod(3303, Core.ARMOR_NETHERITE, 3, 3, EnumRarity.uncommon, false)).setIconCoord(2, 3).setItemName("bootsNetherite");

	public static Item helmetValarium = (new ItemArmorSensMod(3400, Core.ARMOR_VALARIUM, 3, 0, EnumRarity.rare, true)).setIconCoord(3, 0).setItemName("helmetValarium");
	public static Item plateValarium = (new ItemArmorSensMod(3401, Core.ARMOR_VALARIUM, 3, 1, EnumRarity.rare, true)).setIconCoord(3, 1).setItemName("plateValarium");
	public static Item legsValarium = (new ItemArmorSensMod(3402, Core.ARMOR_VALARIUM, 3, 2, EnumRarity.rare, true)).setIconCoord(3, 2).setItemName("legsValarium");
	public static Item bootsValarium = (new ItemArmorSensMod(3403, Core.ARMOR_VALARIUM, 3, 3, EnumRarity.rare, true)).setIconCoord(3, 3).setItemName("bootsValarium");

	public static Item helmetScinite = (new ItemArmorSensMod(3500, Core.ARMOR_SCINITE, 3, 0, EnumRarity.rare, true)).setIconCoord(4, 0).setItemName("helmetScinite");
	public static Item plateScinite = (new ItemArmorSensMod(3501, Core.ARMOR_SCINITE, 3, 1, EnumRarity.rare, true)).setIconCoord(4, 1).setItemName("plateScinite");
	public static Item legsScinite = (new ItemArmorSensMod(3502, Core.ARMOR_SCINITE, 3, 2, EnumRarity.rare, true)).setIconCoord(4, 2).setItemName("legsScinite");
	public static Item bootsScinite = (new ItemArmorSensMod(3503, Core.ARMOR_SCINITE, 3, 3, EnumRarity.rare, true)).setIconCoord(4, 3).setItemName("bootsScinite");
	
	public static Item helmetGodum = (new ItemArmorSensMod(3600, Core.ARMOR_GODUM, 3, 0, EnumRarity.epic, false)).setIconCoord(5, 0).setItemName("helmetGodum");
	public static Item plateGodum = (new ItemArmorSensMod(3601, Core.ARMOR_GODUM, 3, 1, EnumRarity.epic, false)).setIconCoord(5, 1).setItemName("plateGodum");
	public static Item legsGodum = (new ItemArmorSensMod(3602, Core.ARMOR_GODUM, 3, 2, EnumRarity.epic, false)).setIconCoord(5, 2).setItemName("legsGodum");
	public static Item bootsGodum = (new ItemArmorSensMod(3603, Core.ARMOR_GODUM, 3, 3, EnumRarity.epic, false)).setIconCoord(5, 3).setItemName("bootsGodum");
	
	public static Item helmetGodumActive = (new ItemArmorSensMod(3700, Core.ARMOR_GODUMACTIVE, 3, 0, Core.endgame, true)).setIconCoord(5, 0).setItemName("helmetGodumActive");
	public static Item plateGodumActive = (new ItemArmorSensMod(3701, Core.ARMOR_GODUMACTIVE, 3, 1, Core.endgame, true)).setIconCoord(5, 1).setItemName("plateGodumActive");
	public static Item legsGodumActive = (new ItemArmorSensMod(3702, Core.ARMOR_GODUMACTIVE, 3, 2, Core.endgame, true)).setIconCoord(5, 2).setItemName("legsGodumActive");
	public static Item bootsGodumActive = (new ItemArmorSensMod(3703, Core.ARMOR_GODUMACTIVE, 3, 3, Core.endgame, true)).setIconCoord(5, 3).setItemName("bootsGodumActive");
	
	public static void SetupLanguage(){
		
		LanguageRegistry.addName(helmetEndurum, "Endurum Helmet");
		LanguageRegistry.addName(plateEndurum, "Endurum Chestplate");
		LanguageRegistry.addName(legsEndurum, "Endurum Leggings");
		LanguageRegistry.addName(bootsEndurum, "Endurum Boots");
		
		LanguageRegistry.addName(helmetXircium, "Xircium Helmet");
		LanguageRegistry.addName(plateXircium, "Xircium Chestplate");
		LanguageRegistry.addName(legsXircium, "Xircium Leggings");
		LanguageRegistry.addName(bootsXircium, "Xircium Boots");
		
		LanguageRegistry.addName(helmetNetherite, "Netherite Helmet");
		LanguageRegistry.addName(plateNetherite, "Netherite Chestplate");
		LanguageRegistry.addName(legsNetherite, "Netherite Leggings");
		LanguageRegistry.addName(bootsNetherite, "Netherite Boots");
		
		LanguageRegistry.addName(helmetValarium, "Valarium Helmet");
		LanguageRegistry.addName(plateValarium, "Valarium Chestplate");
		LanguageRegistry.addName(legsValarium, "Valarium Leggings");
		LanguageRegistry.addName(bootsValarium, "Valarium Boots");
		
		LanguageRegistry.addName(helmetScinite, "Scinite Helmet");
		LanguageRegistry.addName(plateScinite, "Scinite Chestplate");
		LanguageRegistry.addName(legsScinite, "Scinite Leggings");
		LanguageRegistry.addName(bootsScinite, "Scinite Boots");
		
		LanguageRegistry.addName(helmetGodum, "Godum Helmet");
		LanguageRegistry.addName(plateGodum, "Godum Chestplate");
		LanguageRegistry.addName(legsGodum, "Godum Leggings");
		LanguageRegistry.addName(bootsGodum, "Godum Boots");
		
		LanguageRegistry.addName(helmetGodumActive, "Active Godum Helmet");
		LanguageRegistry.addName(plateGodumActive, "Active Godum Chestplate");
		LanguageRegistry.addName(legsGodumActive, "Active Godum Leggings");
		LanguageRegistry.addName(bootsGodumActive, "Active Godum Boots");
	}
	
	public static void SetupRecipes(){
		
		ItemStack rodWoodStack = new ItemStack(Item.stick);
		ItemStack ingotEndurumStack = new ItemStack(SItems.ingotEndurum);
		ItemStack crystalXirciumStack = new ItemStack(SItems.crystalXircium);
		ItemStack crystalNetheriteStack = new ItemStack(SItems.crystalNetherite);
		ItemStack ingotValariumStack = new ItemStack(SItems.ingotValarium);
		ItemStack crystalSciniteStack = new ItemStack(SItems.crystalScinite);
		ItemStack ingotGodumStack = new ItemStack(SItems.ingotGodum);
		ItemStack ingotGodumActiveStack = new ItemStack(SItems.ingotGodumActive);

		GameRegistry.addShapedRecipe(new ItemStack(helmetEndurum), "xxx", "x x", 'x', ingotEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateEndurum), "x x", "xxx", "xxx", 'x', ingotEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsEndurum), "xxx", "x x", "x x", 'x', ingotEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsEndurum), "x x", "x x", 'x', ingotEndurumStack);

		GameRegistry.addShapedRecipe(new ItemStack(helmetXircium), "xxx", "x x", 'x', crystalXirciumStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateXircium), "x x", "xxx", "xxx", 'x', crystalXirciumStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsXircium), "xxx", "x x", "x x", 'x', crystalXirciumStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsXircium), "x x", "x x", 'x', crystalXirciumStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(helmetNetherite), "xxx", "x x", 'x', crystalNetheriteStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateNetherite), "x x", "xxx", "xxx", 'x', crystalNetheriteStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsNetherite), "xxx", "x x", "x x", 'x', crystalNetheriteStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsNetherite), "x x", "x x", 'x', crystalNetheriteStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(helmetValarium), "xxx", "x x", 'x', ingotValariumStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateValarium), "x x", "xxx", "xxx", 'x', ingotValariumStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsValarium), "xxx", "x x", "x x", 'x', ingotValariumStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsValarium), "x x", "x x", 'x', ingotValariumStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(helmetScinite), "xxx", "x x", 'x', crystalSciniteStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateScinite), "x x", "xxx", "xxx", 'x', crystalSciniteStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsScinite), "xxx", "x x", "x x", 'x', crystalSciniteStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsScinite), "x x", "x x", 'x', crystalSciniteStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(helmetGodum), "xxx", "x x", 'x', ingotGodumStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateGodum), "x x", "xxx", "xxx", 'x', ingotGodumStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsGodum), "xxx", "x x", "x x", 'x', ingotGodumStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsGodum), "x x", "x x", 'x', ingotGodumStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(helmetGodumActive), "xxx", "x x", 'x', ingotGodumActiveStack);
		GameRegistry.addShapedRecipe(new ItemStack(plateGodumActive), "x x", "xxx", "xxx", 'x', ingotGodumActiveStack);
		GameRegistry.addShapedRecipe(new ItemStack(legsGodumActive), "xxx", "x x", "x x", 'x', ingotGodumActiveStack);
		GameRegistry.addShapedRecipe(new ItemStack(bootsGodumActive), "x x", "x x", 'x', ingotGodumActiveStack);
		
	}

}
