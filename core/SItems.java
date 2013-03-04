package sensory.core;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import sensory.item.*;

public class SItems {
	
	public static final Item rodIron = (new ItemSensMod(1000, EnumRarity.common, false)).setIconCoord(6, 4).setItemName("rodIron").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item rodEndurum = (new ItemSensMod(1001, EnumRarity.uncommon, false)).setIconCoord(7, 4).setItemName("rodEndurum").setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item ingotEndurum = (new ItemSensMod(1199, EnumRarity.uncommon, false)).setIconCoord(6, 1).setItemName("ingotEndurum").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item crystalXircium = (new ItemSensMod(1299, EnumRarity.uncommon, false)).setIconCoord(7, 1).setItemName("crystalXircium").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item crystalNetherite = (new ItemSensMod(1399, EnumRarity.uncommon, false)).setIconCoord(6, 2).setItemName("crystalNetherite").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item ingotValarium = (new ItemSensMod(1499, EnumRarity.rare, true)).setIconCoord(7, 2).setItemName("ingotValarium").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item crystalScinite = (new ItemSensMod(1599, EnumRarity.rare, true)).setIconCoord(6, 3).setItemName("crystalScinite").setCreativeTab(CreativeTabs.tabMaterials);
	
	public static final Item crystalGodum = (new ItemSensMod(1650, EnumRarity.epic, false)).setIconCoord(7, 0).setItemName("crystalGodum").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item ingotGodum = (new ItemSensMod(1651, EnumRarity.epic, false)).setIconCoord(7, 3).setItemName("ingotGodum").setCreativeTab(CreativeTabs.tabMaterials);
	public static final Item ingotGodumActive = (new ItemSensMod(1699, Core.endgame, true)).setIconCoord(7, 3).setItemName("ingotGodumActive").setCreativeTab(CreativeTabs.tabMaterials);

	public static final Item itemValarFuel = (new ItemSensMod(560, EnumRarity.rare, true)).setIconCoord(6, 0).setItemName("itemValarFuel").setCreativeTab(CreativeTabs.tabMaterials);
	
	public static final Item artifactEndurai = (new ItemEnduraiArtifact(3900, EnumRarity.rare, false)).setIconCoord(8, 1).setItemName("artifactEndurai").setCreativeTab(CreativeTabs.tabMisc);
	public static final Item artifactXirk = (new ItemXirkArtifact(3901, EnumRarity.rare, false)).setIconCoord(9, 1).setItemName("artifactXirk").setCreativeTab(CreativeTabs.tabMisc);
	public static final Item artifactDeepNether = (new ItemDeepNetherArtifact(3902, EnumRarity.rare, false)).setIconCoord(8, 2).setItemName("artifactDeepNether").setCreativeTab(CreativeTabs.tabMisc);
	
	public static void SetupLanguage () {
		
		LanguageRegistry.addName(rodIron, "Iron Rod");
		LanguageRegistry.addName(rodEndurum, "Endurum Rod");

		LanguageRegistry.addName(ingotEndurum, "Endurum Ingot");
		LanguageRegistry.addName(crystalXircium, "Xircium Crystal");
		LanguageRegistry.addName(crystalNetherite, "Netherite Shard");
		LanguageRegistry.addName(ingotValarium, "Valarium Ingot");
		LanguageRegistry.addName(crystalScinite, "Scinite Cluster");
		
		LanguageRegistry.addName(crystalGodum, "Unrefined Godum Cluster");
		LanguageRegistry.addName(ingotGodum, "Inactive Godum Ingot");
		LanguageRegistry.addName(ingotGodumActive, "Active Godum Ingot");
		
		LanguageRegistry.addName(itemValarFuel, "Valar Fuel");
		
		LanguageRegistry.addName(artifactEndurai, "Endurai Artifact");
		LanguageRegistry.addName(artifactXirk, "Xirk Artifact");
		LanguageRegistry.addName(artifactDeepNether, "Deep Nether Artifact");
	}
	
	public static void SetupRecipes () {
		
		ItemStack rodWoodStack = new ItemStack(Item.stick);
		ItemStack rodIronStack = new ItemStack(rodIron);
		ItemStack rodEndurumStack = new ItemStack(rodEndurum);
		ItemStack ingotEndurumStack = new ItemStack(ingotEndurum);
		ItemStack crystalXirciumStack = new ItemStack(crystalXircium);
		ItemStack crystalNetheriteStack = new ItemStack(crystalNetherite);
		ItemStack ingotValariumStack = new ItemStack(ingotValarium);
		ItemStack crystalSciniteStack = new ItemStack(crystalScinite);
		ItemStack crystalGodumStack = new ItemStack(crystalGodum);
		ItemStack ingotGodumStack = new ItemStack(ingotGodum);
		ItemStack ingotGodumActiveStack = new ItemStack(ingotGodumActive);
		ItemStack itemValarFuelStack = new ItemStack(itemValarFuel);
		
		GameRegistry.addShapelessRecipe(new ItemStack(itemValarFuel), crystalXirciumStack, ingotValariumStack);

		GameRegistry.addShapedRecipe(new ItemStack(rodIron, 4), "x", "x", 'x', new ItemStack(Item.ingotIron));
		GameRegistry.addShapedRecipe(new ItemStack(rodEndurum, 4), "x", "x", 'x', new ItemStack(ingotEndurum));
		
		GameRegistry.addShapedRecipe(new ItemStack(ingotGodumActive), "zzz", "yxy", "zzz", 'x', ingotGodumStack, 'y', crystalSciniteStack, 'z', itemValarFuelStack);
		
	}

}
