package deepcraft.core;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import deepcraft.block.*;
import deepcraft.fx.TexturePortalFXSensMod;
import deepcraft.infurnace.*;
import deepcraft.item.*;
import deepcraft.item.tool.*;
import deepcraft.world.*;
import net.minecraftforge.client.EnumHelperClient;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.EnumHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.block.BlockRedstoneOre;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;

@Mod(modid="deepcraft", name="Deepcraft", version="0.5.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class Core {

	public static EnumToolMaterial ENDURUM = EnumHelper.addToolMaterial("ENDURUM", 3, 32000, 10.0F, 2, 60);
	public static EnumToolMaterial XIRCIUM = EnumHelper.addToolMaterial("XIRCIUM", 4, 3500, 16.0F, 3, 120);
	public static EnumToolMaterial NETHERITE = EnumHelper.addToolMaterial("NETHERITE", 5, 7000, 24.0F, 4, 60);
	public static EnumToolMaterial VALARIUM = EnumHelper.addToolMaterial("VALARIUM", 6, 8000, 48.0F, 8, 0);
	public static EnumToolMaterial SCINITE = EnumHelper.addToolMaterial("SCINITE", 7, 6400, 32.0F, 12, 480);
	public static EnumToolMaterial GODUM = EnumHelper.addToolMaterial("GODUM", 8, 64000, 25000000.0F, 32, 1200);
	public static EnumToolMaterial GODUMACTIVE = EnumHelper.addToolMaterial("GODUMACTIVE", 999, -1, 2500000000.0F, 5000000, 1600000);
	
	public static EnumArmorMaterial ARMOR_ENDURUM = EnumHelper.addArmorMaterial("ENDURUM", 1024, new int[]{3, 8, 6, 3}, 60);
	public static EnumArmorMaterial ARMOR_XIRCIUM = EnumHelper.addArmorMaterial("XIRCIUM", 128, new int[]{5, 12, 10, 5}, 120);
	public static EnumArmorMaterial ARMOR_NETHERITE = EnumHelper.addArmorMaterial("NETHERITE", 256, new int[]{7, 18, 14, 7}, 60);
	public static EnumArmorMaterial ARMOR_VALARIUM = EnumHelper.addArmorMaterial("VALARIUM", 512, new int[]{10, 24, 18, 10}, 0);
	public static EnumArmorMaterial ARMOR_SCINITE = EnumHelper.addArmorMaterial("SCINITE", 256, new int[]{8, 20, 16, 8}, 480);
	public static EnumArmorMaterial ARMOR_GODUM = EnumHelper.addArmorMaterial("GODUM", 32768, new int[]{50, 150, 100, 50}, 1200);
	public static EnumArmorMaterial ARMOR_GODUMACTIVE = EnumHelper.addArmorMaterial("GODUMACTIVE", Integer.MAX_VALUE, new int[]{500, 1500, 1000, 500}, 120000000);
	
	public static EnumRarity endgame = EnumHelperClient.addRarity("endgame", 5, "Endgame");
	
	@Instance("SensMod")
	public static Core instance;

	@SidedProxy(clientSide="deepcraft.core.client.ClientProxy", serverSide="deepcraft.core.CommonProxy")
	public static CommonProxy proxy;

	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
	}

	@Init
	public void load(FMLInitializationEvent event) {
		proxy.registerRenderers();

		Block.bedrock.setHardness(5000000000.0F);
		MinecraftForge.setBlockHarvestLevel(Block.bedrock, "pickaxe", 8);

		SItems.SetupLanguage();
		SBlocks.SetupLanguage();
		STools.SetupLanguage();
		SArmors.SetupLanguage();
		
		SBlocks.SetupLevels();
		STools.SetupLevels();
		
		SBlocks.Register();
		
		SItems.SetupRecipes();
		SBlocks.SetupRecipes();
		STools.SetupRecipes();
		SArmors.SetupRecipes();
		
		SBlocks.SetupTextureFX();

		GameRegistry.registerTileEntity(InfurnaceTileEntity.class, "containerInfurnace");
		NetworkRegistry.instance().registerGuiHandler(this, new InfurnaceGUIHandler());
		
		SWorlds.SetupWorlds();
		SWorlds.SetupOres();
		
		SensModWatcher SMW = new SensModWatcher();
		TickRegistry.registerScheduledTickHandler(SMW, Side.SERVER);
		GameRegistry.registerCraftingHandler(SMW);	
	}

	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
	}
	
	public static void addSmeltingRecipes(int input, ItemStack output, float xp) {
		GameRegistry.addSmelting(input, output, xp);
		InfurnaceRecipes.smelting().addSmelting(input, output, xp);
	}
	
	public static int cC(int x, int y, int z) {
		return y+(x*128)+(z*2048);
	}
	public static int[] cCr(int n) {
		int c = n;
		int[] t = new int[3];
		while(c>=2048){
			t[2]++;
			c-=2048;
		}
		while(c>=128){
			t[0]++;
			c-=128;
		}
		while(c>=1){
			t[1]++;
			c--;
		}
		return t;
	}
}