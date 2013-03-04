package deepcraft.core;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import deepcraft.block.*;
import deepcraft.block.misc.MaterialLiquidSensMod;
import deepcraft.core.client.*;
import deepcraft.fx.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;

public class SBlocks {
		
	public static final Material artifact = (new Material(MapColor.ironColor));
	
	public static final Block oreCoalNether = (new BlockCrystalOreSensMod(2400, 3, Item.coal.itemID, 0, 1, 0)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreCoalNether");
	public static final Block oreIronNether = (new BlockOreSensMod(2401, 19)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreIronNether");
	public static final Block oreGoldNether = (new BlockOreSensMod(2402, 35)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreGoldNether");
	public static final Block oreDiamondNether = (new BlockCrystalOreSensMod(2403, 51, Item.diamond.itemID, 0, 1, 0)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreDiamondNether");
	public static final Block oreRedstoneNether = (new BlockRedstoneOreNether(2404, 67, false)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreRedstoneNether").setRequiresSelfNotify().setCreativeTab(CreativeTabs.tabBlock);
	public static final Block oreRedstoneNetherGlowing = (new BlockRedstoneOreNether(2405, 67, true)).setLightValue(0.625F).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreRedstoneNetherGlowing").setRequiresSelfNotify();
	public static final Block oreLapisNether = (new BlockCrystalOreSensMod(2406, 83, Item.dyePowder.itemID, 4, 4, 5)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreLapisNether");
	public static final Block oreEmeraldNether = (new BlockCrystalOreSensMod(2407, 99, Item.emerald.itemID, 0, 1, 0)).setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).setBlockName("oreEmeraldNether");
	
	public final static Block oreEndurum = new BlockOreSensMod(1198, 0).setBlockName("oreEndurum").setHardness(4.0F).setResistance(6.0F);
	public final static Block oreXircium = new BlockCrystalOreSensMod(1298, 16, SItems.crystalXircium.itemID, 0, 1, 0).setBlockName("oreXircium").setLightValue(0.25f).setHardness(5.0F).setResistance(7.0F);
	public final static Block oreNetherite = new BlockCrystalOreSensMod(1398, 32, SItems.crystalNetherite.itemID, 0, 1, 0).setBlockName("oreNetherite").setHardness(7.0F).setResistance(10.0F);
	public final static Block oreValarium = new BlockOreSensMod(1498, 48).setBlockName("oreValarium").setLightValue(0.25f).setHardness(10.0F).setResistance(15.0F);
	public final static Block oreScinite = new BlockCrystalOreSensMod(1598, 64, SItems.crystalScinite.itemID, 0, 1, 0).setBlockName("oreScinite").setLightValue(1.0f).setHardness(20.0F).setResistance(30.0F);
	public final static Block oreGodum = new BlockOreSensMod(1698, 80).setBlockName("oreGodum").setHardness(50.0F).setResistance(100.0F);

	public final static Block oreEndurumNether = new BlockOreSensMod(1196, 2).setBlockName("oreEndurumNether").setHardness(4.0F).setResistance(6.0F);
	public final static Block oreXirciumNether = new BlockCrystalOreSensMod(1296, 18, SItems.crystalXircium.itemID, 0, 1, 0).setBlockName("oreXirciumNether").setLightValue(0.25f).setHardness(5.0F).setResistance(7.0F);
	public final static Block oreNetheriteNether = new BlockCrystalOreSensMod(1396, 34, SItems.crystalNetherite.itemID, 0, 1, 0).setBlockName("oreNetheriteNether").setHardness(7.0F).setResistance(10.0F);
	public final static Block oreValariumNether = new BlockOreSensMod(1496, 50).setBlockName("oreValariumNether").setLightValue(0.25f).setHardness(10.0F).setResistance(15.0F);
	public final static Block oreSciniteNether = new BlockCrystalOreSensMod(1596, 66, SItems.crystalScinite.itemID, 0, 1, 0).setBlockName("oreSciniteNether").setLightValue(1.0f).setHardness(20.0F).setResistance(30.0F);
	public final static Block oreGodumNether = new BlockOreSensMod(1696, 82).setBlockName("oreGodumNether").setHardness(50.0F).setResistance(100.0F);
	
	public final static Block oreXirciumXirk = new BlockOreXirciumSandstone(1290).setBlockName("oreXirciumXirk").setHardness(5.0F).setResistance(7.0F);
	public final static Block oreNetheriteDeepNether = new BlockCrystalOreSensMod(1370, 98, SItems.crystalNetherite.itemID, 0, 1, 0).setBlockName("oreNetheriteDeepNether").setHardness(7.0F).setResistance(10.0F);

	public final static Block blockEndurum = new BlockSensMod(1197, 1, Material.iron).setBlockName("blockEndurum").setHardness(8.0F).setResistance(12.0F);
	public final static Block blockXircium = new BlockSensMod(1297, 17, Material.iron).setBlockName("blockXircium").setHardness(10.0F).setResistance(14.0F).setLightValue(0.25F);
	public final static Block blockNetherite = new BlockSensMod(1397, 33, Material.iron).setBlockName("blockNetherite").setHardness(14.0F).setResistance(20.0F);
	public final static Block blockValarium = new BlockSensMod(1497, 49, Material.iron).setBlockName("blockValarium").setHardness(20.0F).setResistance(30.0F).setLightValue(0.25F);
	public final static Block blockScinite = new BlockSensMod(1597, 65, Material.iron).setBlockName("blockScinite").setHardness(40.0F).setResistance(60.0F).setLightValue(1.0F);
	public final static Block blockGodum = new BlockSensMod(1697, 81,  Material.iron).setBlockName("blockGodum").setHardness(100.0F).setResistance(200.0F);
	
	public final static Block netherrackDeep = new BlockDeepNetherrack(1380, 103).setHardness(1.2F).setStepSound(Block.soundStoneFootstep).setBlockName("netherrackDeep");
	public final static Block slowSandDeep = (new BlockTormentedSoulSand(1381, 104)).setHardness(0.75F).setStepSound(Block.soundSandFootstep).setBlockName("slowSandDeep");
    public static final Block netherBrickDeep = (new BlockSensMod(1382, 224, Material.rock)).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("netherBrickDeep").setCreativeTab(CreativeTabs.tabBlock);
    public static final Block netherFenceDeep = (new BlockFenceSensMod(1383, 224, Material.rock)).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setBlockName("netherFenceDeep");
    public static final Block stairsNetherBrickDeep = (new BlockStairsSensMod(1384, netherBrickDeep, 0)).setBlockName("stairsNetherBrickDeep").setRequiresSelfNotify();
    public static final Block lavaBlueMoving = (new BlockBlueLavaFlowing(1385, Material.lava)).setHardness(0.0F).setLightValue(1.0F).setLightOpacity(255).setBlockName("lavaBlueMoving").setRequiresSelfNotify().setCreativeTab(CreativeTabs.tabBlock);
    public static final Block lavaBlueStill = (new BlockBlueLavaStationary(1386, Material.lava)).setHardness(100.0F).setLightValue(1.0F).setLightOpacity(255).setBlockName("lavaBlueStill").setRequiresSelfNotify().setCreativeTab(CreativeTabs.tabBlock);
    public static final BlockBlueFire fireBlue = (BlockBlueFire)(new BlockBlueFire(1387, 31)).setHardness(0.0F).setLightValue(1.0F).setStepSound(Block.soundWoodFootstep).setBlockName("fireBlue");
	
	public final static Block blockInfurnace = new BlockInfurnace(505, false).setBlockName("blockInfurnace").setCreativeTab(CreativeTabs.tabDecorations);
	public final static Block blockInfurnaceActive = new BlockInfurnace(506, true).setBlockName("blockInfurnaceActive");
	
	public final static Block blockGodumActive = new BlockSensMod(1797, 9,  Material.iron).setBlockName("blockGodumActive").setHardness(10000.0F).setResistance(20000.0F);
	
	public final static BlockPortalEndurai portalEndurai = (BlockPortalEndurai) new BlockPortalEndurai(4000, 10).setHardness(-1.0F).setLightValue(0.75F).setBlockName("portalEndurai");
	public final static BlockPortalXirk portalXirk = (BlockPortalXirk) new BlockPortalXirk(4001, 11).setHardness(-1.0F).setLightValue(0.75F).setBlockName("portalXirk");
	public final static BlockPortalDeepNether portalDeepNether = (BlockPortalDeepNether) new BlockPortalDeepNether(4002, 12).setHardness(-1.0F).setLightValue(0.75F).setBlockName("portalDeepNether");
	
	public final static BlockArtifact artifactEnduraiBlock = (BlockArtifact) new BlockArtifact(2450, 24, artifact, SItems.artifactEndurai.itemID).setBlockName("artifactEnduraiBlock");
	public final static BlockArtifact artifactXirkBlock = (BlockArtifact) new BlockArtifact(2451, 25, artifact, SItems.artifactXirk.itemID).setBlockName("artifactXirkBlock");
	public final static BlockArtifact artifactDeepNetherBlock = (BlockArtifact) new BlockArtifact(2452, 40, artifact, SItems.artifactDeepNether.itemID).setBlockName("artifactDeepNetherBlock");
	
	public static void SetupLanguage () {
		
		LanguageRegistry.addName(oreCoalNether, "Coal Ore");
		LanguageRegistry.addName(oreIronNether, "Iron Ore");
		LanguageRegistry.addName(oreGoldNether, "Gold Ore");
		LanguageRegistry.addName(oreDiamondNether, "Diamond Ore");
		LanguageRegistry.addName(oreRedstoneNether, "Redstone Ore");
		LanguageRegistry.addName(oreLapisNether, "Lapis Lazuli Ore");
		LanguageRegistry.addName(oreEmeraldNether, "Emerald Ore");

		LanguageRegistry.addName(oreEndurum, "Endurum Ore");
		LanguageRegistry.addName(oreXircium, "Xircium Ore");
		LanguageRegistry.addName(oreNetherite, "Netherite Ore");
		LanguageRegistry.addName(oreValarium, "Valarium Ore");
		LanguageRegistry.addName(oreScinite, "Scinite Ore");
		LanguageRegistry.addName(oreGodum, "Godum Ore");
		
		LanguageRegistry.addName(oreXirciumXirk, "Sandstone Xircium Ore");
		LanguageRegistry.addName(oreNetheriteDeepNether, "Netherite Ore");

		LanguageRegistry.addName(oreEndurumNether, "Netherrack Endurum Ore");
		LanguageRegistry.addName(oreXirciumNether, "Netherrack Xircium Ore");
		LanguageRegistry.addName(oreNetheriteNether, "Netherrack Netherite Ore");
		LanguageRegistry.addName(oreValariumNether, "Netherrack Valarium Ore");
		LanguageRegistry.addName(oreSciniteNether, "Netherrack Scinite Ore");
		LanguageRegistry.addName(oreGodumNether, "Netherrack Godum Ore");

		LanguageRegistry.addName(blockEndurum, "Block of Endurum");
		LanguageRegistry.addName(blockXircium, "Block of Xircium");
		LanguageRegistry.addName(blockNetherite, "Block of Netherite");
		LanguageRegistry.addName(blockValarium, "Block of Valarium");
		LanguageRegistry.addName(blockScinite, "Block of Scinite");
		LanguageRegistry.addName(blockGodum, "Block of Godum");
		
		LanguageRegistry.addName(netherrackDeep, "Deep Netherrack");
		LanguageRegistry.addName(slowSandDeep, "Tormented Soul Sand");
		LanguageRegistry.addName(netherBrickDeep, "Deep Nether Bricks");
		LanguageRegistry.addName(netherFenceDeep, "Deep Nether Fence");
		LanguageRegistry.addName(stairsNetherBrickDeep, "Deep Nether Stairs");
		LanguageRegistry.addName(lavaBlueMoving, "Flowing Blue Lava");
		LanguageRegistry.addName(lavaBlueStill, "Still Blue Lava");

		LanguageRegistry.addName(blockInfurnace, "Netherite Furnace");
		LanguageRegistry.addName(blockInfurnaceActive, "Netherite Furnace");
		
		LanguageRegistry.addName(blockGodumActive, "Active Godum Block");
		
		LanguageRegistry.addName(portalEndurai, "Endurai Portal");
		LanguageRegistry.addName(portalXirk, "Xirk Portal");
		LanguageRegistry.addName(portalDeepNether, "Deep Nether Portal");
		
		LanguageRegistry.addName(artifactEnduraiBlock, "Endurai Artifact Block");
		LanguageRegistry.addName(artifactXirkBlock, "Xirk Artifact Block");
		LanguageRegistry.addName(artifactDeepNetherBlock, "Deep Nether Artifact Block");
	}
	
	public static void SetupLevels() {
		
		MinecraftForge.setBlockHarvestLevel(oreCoalNether, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreIronNether, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreGoldNether, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreDiamondNether, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreRedstoneNether, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreRedstoneNetherGlowing, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(oreLapisNether, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(oreEmeraldNether, "pickaxe", 2);

		MinecraftForge.setBlockHarvestLevel(oreEndurum, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreXircium, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreNetherite, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(oreValarium, "pickaxe", 5);
		MinecraftForge.setBlockHarvestLevel(oreScinite, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(oreGodum, "pickaxe", 7);
		
		MinecraftForge.setBlockHarvestLevel(oreXirciumXirk, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreNetheriteDeepNether, "pickaxe", 4);

		MinecraftForge.setBlockHarvestLevel(oreEndurumNether, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreXirciumNether, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(oreNetheriteNether, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(oreValariumNether, "pickaxe", 5);
		MinecraftForge.setBlockHarvestLevel(oreSciniteNether, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(oreGodumNether, "pickaxe", 7);
	}
	
	public static void Register () {
		
		GameRegistry.registerBlock(oreCoalNether, "oreCoalNether");
		GameRegistry.registerBlock(oreIronNether, "oreIronNether");
		GameRegistry.registerBlock(oreGoldNether, "oreGoldNether");
		GameRegistry.registerBlock(oreDiamondNether, "oreDiamondNether");
		GameRegistry.registerBlock(oreRedstoneNether, "oreRedstoneNether");
		GameRegistry.registerBlock(oreRedstoneNetherGlowing, "oreRedstoneNetherGlowing");
		GameRegistry.registerBlock(oreLapisNether, "oreLapisNether");
		GameRegistry.registerBlock(oreEmeraldNether, "oreEmeraldNether");

		GameRegistry.registerBlock(oreEndurum, "oreEndurum");
		GameRegistry.registerBlock(oreXircium, "oreXircium");
		GameRegistry.registerBlock(oreNetherite, "oreNetherite");
		GameRegistry.registerBlock(oreValarium, "oreValarium");
		GameRegistry.registerBlock(oreScinite, "oreScinite");
		GameRegistry.registerBlock(oreGodum, "oreGodum");
		
		GameRegistry.registerBlock(oreXirciumXirk, "oreXirciumXirk");
		GameRegistry.registerBlock(oreNetheriteDeepNether, "oreNetheriteDeepNether");

		GameRegistry.registerBlock(oreEndurumNether, "oreEndurumNether");
		GameRegistry.registerBlock(oreXirciumNether, "oreXirciumNether");
		GameRegistry.registerBlock(oreNetheriteNether, "oreNetheriteNether");
		GameRegistry.registerBlock(oreValariumNether, "oreValariumNether");
		GameRegistry.registerBlock(oreSciniteNether, "oreSciniteNether");
		GameRegistry.registerBlock(oreGodumNether, "oreGodumNether");

		GameRegistry.registerBlock(blockEndurum, "blockEndurum");
		GameRegistry.registerBlock(blockXircium, "blockXircium");
		GameRegistry.registerBlock(blockNetherite, "blockNetherite");
		GameRegistry.registerBlock(blockValarium, "blockValarium");
		GameRegistry.registerBlock(blockScinite, "blockScinite");
		GameRegistry.registerBlock(blockGodum, "blockGodum");
		
		GameRegistry.registerBlock(netherrackDeep, "netherrackDeep");
		GameRegistry.registerBlock(slowSandDeep, "slowSandDeep");
		GameRegistry.registerBlock(netherBrickDeep, "netherBrickDeep");
		GameRegistry.registerBlock(netherFenceDeep, "netherFenceDeep");
		GameRegistry.registerBlock(stairsNetherBrickDeep, "stairsNetherBrickDeep");
		GameRegistry.registerBlock(lavaBlueMoving, "lavaBlueMoving");
		GameRegistry.registerBlock(lavaBlueStill, "lavaBlueStill");
		GameRegistry.registerBlock(fireBlue, "fireBlue");

		GameRegistry.registerBlock(blockInfurnace, "blockInfurnace");
		GameRegistry.registerBlock(blockInfurnaceActive, "blockInfurnaceActive");
		
		GameRegistry.registerBlock(blockGodumActive, "blockGodumActive");
		
		GameRegistry.registerBlock(portalEndurai, "portalEndurai");
		GameRegistry.registerBlock(portalXirk, "portalXirk");
		GameRegistry.registerBlock(portalDeepNether, "portalDeepNether");
		
		GameRegistry.registerBlock(artifactEnduraiBlock, "artifactEnduraiBlock");
		GameRegistry.registerBlock(artifactXirkBlock, "artifactXirkBlock");
		GameRegistry.registerBlock(artifactDeepNetherBlock, "artifactDeepNetherBlock");
	}
	
	public static void SetupRecipes() {
		
		ItemStack ingotEndurumStack = new ItemStack(SItems.ingotEndurum);
		ItemStack crystalXirciumStack = new ItemStack(SItems.crystalXircium);
		ItemStack crystalNetheriteStack = new ItemStack(SItems.crystalNetherite);
		ItemStack ingotValariumStack = new ItemStack(SItems.ingotValarium);
		ItemStack crystalSciniteStack = new ItemStack(SItems.crystalScinite);
		ItemStack ingotGodumStack = new ItemStack(SItems.ingotGodum);
		ItemStack ingotGodumActiveStack = new ItemStack(SItems.ingotGodumActive);
		
		Core.addSmeltingRecipes(oreCoalNether.blockID, new ItemStack(Item.coal), 0.1F);
		Core.addSmeltingRecipes(oreIronNether.blockID, new ItemStack(Item.ingotIron), 0.7F);
		Core.addSmeltingRecipes(oreGoldNether.blockID, new ItemStack(Item.ingotGold), 1.0F);
		Core.addSmeltingRecipes(oreDiamondNether.blockID, new ItemStack(Item.diamond), 1.0F);
		Core.addSmeltingRecipes(oreRedstoneNether.blockID, new ItemStack(Item.redstone), 0.7F);
		Core.addSmeltingRecipes(oreLapisNether.blockID, new ItemStack(Item.dyePowder, 1, 4), 0.2F);
		Core.addSmeltingRecipes(oreEmeraldNether.blockID, new ItemStack(Item.emerald), 1.0F);

		Core.addSmeltingRecipes(oreEndurum.blockID, ingotEndurumStack, 1.5F);
		Core.addSmeltingRecipes(oreXircium.blockID, crystalXirciumStack, 7.5F);
		Core.addSmeltingRecipes(oreNetherite.blockID, crystalNetheriteStack, 3.0F);

		Core.addSmeltingRecipes(oreXirciumXirk.blockID, crystalXirciumStack, 7.5F);
		Core.addSmeltingRecipes(oreNetheriteDeepNether.blockID, crystalNetheriteStack, 3.0F);
		
		Core.addSmeltingRecipes(oreEndurumNether.blockID, ingotEndurumStack, 1.5F);
		Core.addSmeltingRecipes(oreXirciumNether.blockID, crystalXirciumStack, 2.5F);
		Core.addSmeltingRecipes(oreNetheriteNether.blockID, crystalNetheriteStack, 3.0F);
		
		GameRegistry.addShapedRecipe(new ItemStack(blockEndurum), "xxx", "xxx", "xxx", 'x', ingotEndurumStack);
		GameRegistry.addShapedRecipe(new ItemStack(blockXircium), "xxx", "xxx", "xxx", 'x', crystalXirciumStack);
		GameRegistry.addShapedRecipe(new ItemStack(blockNetherite), "xxx", "xxx", "xxx", 'x', crystalNetheriteStack);
		GameRegistry.addShapedRecipe(new ItemStack(blockValarium), "xxx", "xxx", "xxx", 'x', ingotValariumStack);
		GameRegistry.addShapedRecipe(new ItemStack(blockScinite), "xxx", "xxx", "xxx", 'x', crystalSciniteStack);
		GameRegistry.addShapedRecipe(new ItemStack(blockGodum), "xxx", "xxx", "xxx", 'x', ingotGodumStack);
		GameRegistry.addShapedRecipe(new ItemStack(blockGodumActive), "xxx", "xxx", "xxx", 'x', ingotGodumActiveStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(blockInfurnace), "xxx", "x x", "xxx", 'x', crystalNetheriteStack);
		
		GameRegistry.addShapedRecipe(new ItemStack(SItems.ingotEndurum, 9), "x", 'x', new ItemStack(blockEndurum));
		GameRegistry.addShapedRecipe(new ItemStack(SItems.crystalXircium, 9), "x", 'x', new ItemStack(blockXircium));
		GameRegistry.addShapedRecipe(new ItemStack(SItems.crystalNetherite, 9), "x", 'x', new ItemStack(blockNetherite));
		GameRegistry.addShapedRecipe(new ItemStack(SItems.ingotValarium, 9), "x", 'x', new ItemStack(blockValarium));
		GameRegistry.addShapedRecipe(new ItemStack(SItems.crystalScinite, 9), "x", 'x', new ItemStack(blockScinite));
		GameRegistry.addShapedRecipe(new ItemStack(SItems.ingotGodum, 9), "x", 'x', new ItemStack(blockGodum));
		GameRegistry.addShapedRecipe(new ItemStack(SItems.ingotGodumActive, 9), "x", 'x', new ItemStack(blockGodumActive));
	}

	public static void SetupTextureFX() {	
		TextureFXManager.instance().addAnimation(new TextureGodumActiveFX());
		TextureFXManager.instance().addAnimation(new TexturePortalFXSensMod(portalEndurai, new int[]{2,2,1,3}));
		TextureFXManager.instance().addAnimation(new TexturePortalFXSensMod(portalXirk, new int[]{1,0,0,3}));
		TextureFXManager.instance().addAnimation(new TexturePortalFXSensMod(portalDeepNether, new int[]{1,1,2,3}));
		TextureFXManager.instance().addAnimation(new TextureBlueLavaFX());
		TextureFXManager.instance().addAnimation(new TextureBlueLavaFlowingFX());
		TextureFXManager.instance().addAnimation(new TextureBlueFlamesFX(0));
		TextureFXManager.instance().addAnimation(new TextureBlueFlamesFX(1));
	}

}
