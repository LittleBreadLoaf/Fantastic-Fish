package fantastic;

import java.util.Random;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fantastic.armor.FantasticArmor;
import fantastic.blocks.FantasticBlocks;
import fantastic.entities.FantasticEntities;
import fantastic.events.FantasticEvents;
import fantastic.events.VillagerTradeHandler;
import fantastic.items.FantasticItems;
import fantastic.proxies.CommonProxy;
import fantastic.world.ComponentFishermanHut;
import fantastic.world.CoralGenerator;
import fantastic.world.FishermanHandler;

@Mod(modid = FantasticInfo.ID, name = FantasticInfo.NAME, version = FantasticInfo.VERSION)
@NetworkMod(channels =
{ FantasticInfo.CHANNEL, "Scratch" }, clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class)

public class FantasticMod
{

    private static CoralGenerator generator = new CoralGenerator();
    
	@SidedProxy(clientSide = FantasticInfo.PROXY_LOCATION + ".ClientProxy", serverSide = FantasticInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;

	@Instance(FantasticInfo.ID)
	public static FantasticMod instance;

	// public static Item customSpawner;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		proxy.initRenderers();
		proxy.registerServerTickHandler();
		ConfigHandler.init(event.getSuggestedConfigurationFile());

		//GameRegistry.registerWorldGenerator(new BleachWorldGen());
		//new BleachBiomes();

		//DimensionManager.registerProviderType(BleachIds.worldHuecoMundoID, HuecoMundoWorldProvider.class, false);
		//DimensionManager.registerDimension(BleachIds.worldHuecoMundoID, BleachIds.worldHuecoMundoID);
		

	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		Random rand = new Random();
//		proxy.loadParts();
		FantasticItems.init();
		FantasticItems.addNames();

		FantasticBlocks.init();
		FantasticBlocks.addNames();

		FantasticEntities.addNames();
		FantasticEntities.init();

		FantasticArmor.init();
		FantasticArmor.addNames();


		//new GuiHandler();

		Recipes.init();

		proxy.loadKeys();

		GameRegistry.registerWorldGenerator(generator);

		MinecraftForge.EVENT_BUS.register(new FantasticEvents());
		
		VillagerRegistry.instance().registerVillagerId(FantasticIds.fishermanID);
		VillagerRegistry.instance().registerVillagerSkin(FantasticIds.fishermanID, new ResourceLocation(FantasticInfo.ID + ":textures/models/mobs/fantastic_fisherman.png")); //id must be greater than 6
		VillagerTradeHandler newTradeHandler = new VillagerTradeHandler();
		VillagerRegistry.instance().registerVillageTradeHandler(FantasticIds.fishermanID, newTradeHandler);
		FishermanHandler FishermanHut = new FishermanHandler();
		VillagerRegistry.instance().registerVillageCreationHandler(FishermanHut);
		VillagerRegistry.instance().getRegisteredVillagers();
		MapGenStructureIO.func_143031_a(ComponentFishermanHut.class, "Fisherman");
		
		ChestGenHooks contents = ChestGenHooks.getInfo("FISHERMAN");
		ItemStack Goggles = new ItemStack(FantasticArmor.goggles, 1, 1);
		Goggles.addEnchantment(Enchantment.respiration, 3);
		//160 Total
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.bigFish, 1, rand.nextInt(7)), 1, 1, 3)); //2%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.clamShell, 1, rand.nextInt(4)), 1, 1, 8));//5%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.filletCooked, 1), 2, 4, 12));//7%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.clawCooked, 1), 1, 3, 10));//6%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.tailCooked, 1), 1, 2, 8));//5%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.lobster, 1, rand.nextInt(2)), 1, 1, 5));//3%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.fishingNet, 1), 1, 1, 7));//4%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Item.fishingRod, 1), 1, 1, 10));//6%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.tinyFish, 1, 7), 1, 1, 8));//5%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.tinyFish, 1, 3), 1, 1, 14));//9%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.pearl, 1), 1, 2, 9));//6%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Item.silk, 1), 1, 4, 20));//12%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Item.stick, 1), 3, 5, 23));//15%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Item.leash, 1), 1, 1, 14));//9%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Item.nameTag, 1), 1, 1, 6));//%4
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(Goggles, 1, 1, 3));//2%
		contents.setMin(9);
		contents.setMax(5);
		proxy.initZanpakutoRenderers();
	}

	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{

		proxy.loadGUI();
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event)
	{
		MinecraftServer server = MinecraftServer.getServer();
		ICommandManager command = server.getCommandManager();
		ServerCommandManager serverCommand = ((ServerCommandManager) command);

		//serverCommand.registerCommand(new CommandResetSpirit());
	}
	
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent evt)
	{
		if(Loader.isModLoaded("craftingpillars"))
		{
			
		}
	}
}
