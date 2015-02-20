package fantastic;

import java.util.Random;

import net.minecraft.command.ICommandManager;
import net.minecraft.command.ServerCommandManager;
import net.minecraft.init.Items;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import cpw.mods.fml.relauncher.Side;
import fantastic.armor.FantasticArmor;
import fantastic.blocks.FantasticBlocks;
import fantastic.blocks.decoration.TileSkeletonBlock;
import fantastic.entities.FantasticEntities;
import fantastic.events.FantasticEvents;
import fantastic.events.VillagerTradeHandler;
import fantastic.gui.GuiHandler;
import fantastic.items.FantasticItems;
import fantastic.network.ACMessage;
import fantastic.network.DecideMessage;
import fantastic.network.MoveMessage;
import fantastic.proxies.CommonProxy;
import fantastic.spawner.SmartSpawnerControl;
import fantastic.tiles.TileAirCompressor;
import fantastic.world.ComponentFishermanHut;
import fantastic.world.CoralGenerator;
import fantastic.world.FishermanHandler;

@Mod(modid = FantasticInfo.ID, name = FantasticInfo.NAME, version = FantasticInfo.VERSION)

public class FantasticMod
{

    private static CoralGenerator generator = new CoralGenerator();
    
	@SidedProxy(clientSide = FantasticInfo.PROXY_LOCATION + ".ClientProxy", serverSide = FantasticInfo.PROXY_LOCATION + ".CommonProxy")
	public static CommonProxy proxy;

	@Instance(FantasticInfo.ID)
	public static FantasticMod instance;


	public static SimpleNetworkWrapper network;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		//Set to true to turn on the debug mode in output window.
		FantasticDebug.DebugMode=false;
		
		proxy.initRenderers();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		network = NetworkRegistry.INSTANCE.newSimpleChannel("FantasticChannel");
		FantasticMod.network.registerMessage(DecideMessage.Handler.class, DecideMessage.class, 0, Side.SERVER);
		FantasticMod.network.registerMessage(MoveMessage.Handler.class, MoveMessage.class, 1, Side.CLIENT);
		FantasticMod.network.registerMessage(ACMessage.Handler.class, ACMessage.class, 2, Side.SERVER);
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		//DimensionManager.registerProviderType(BleachIds.worldHuecoMundoID, HuecoMundoWorldProvider.class, false);
		//DimensionManager.registerDimension(BleachIds.worldHuecoMundoID, BleachIds.worldHuecoMundoID);
		

	}

	@EventHandler
	public static void init(FMLInitializationEvent event)
	{
		Random rand = new Random();

		FantasticItems.init();

		FantasticBlocks.init();

		FantasticEntities.init();

		FantasticArmor.init();


		Recipes.init();

		SmartSpawnerControl.Init();
		
		proxy.loadKeys();


		GameRegistry.registerWorldGenerator(generator, 0);

		MinecraftForge.EVENT_BUS.register(new FantasticEvents());
		
		proxy.registerVillagers();
		ResourceLocation villagerSkin = new ResourceLocation("fantastic:textures/models/mobs/fantastic_villager");
		VillagerRegistry.instance().getRegisteredVillagers();
		VillagerRegistry.instance().registerVillagerId(FantasticIds.fishermanID);
		VillagerTradeHandler newTradeHandler = new VillagerTradeHandler();
		VillagerRegistry.instance().registerVillageTradeHandler(FantasticIds.fishermanID, newTradeHandler);
		FishermanHandler FishermanHut = new FishermanHandler();
		ComponentFishermanHut Hut = new ComponentFishermanHut();
		VillagerRegistry.instance().registerVillageCreationHandler(FishermanHut);
		MapGenStructureIO.func_143031_a(ComponentFishermanHut.class, "Fisherman");
		
		
		
		
		ChestGenHooks contents = ChestGenHooks.getInfo("FISHERMAN");
		//160 Total
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.bigFish, 1, rand.nextInt(7)), 1, 1, 3)); //2%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.clamShell, 1, rand.nextInt(4)), 1, 1, 8));//5%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.filletCooked, 1), 2, 4, 12));//7%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.clawCooked, 1), 1, 3, 10));//6%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.tailCooked, 1), 1, 2, 8));//5%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.lobster, 1, rand.nextInt(2)), 1, 1, 5));//3%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.fishingNet, 1), 1, 1, 7));//4%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Items.fishing_rod, 1), 1, 1, 10));//6%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.tinyFish, 1, 7), 1, 1, 8));//5%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.tinyFish, 1, 3), 1, 1, 14));//9%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.pearl, 1), 1, 2, 9));//6%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Items.string, 1), 1, 4, 20));//12%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Items.stick, 1), 3, 5, 23));//15%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Items.lead, 1), 1, 1, 14));//9%
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(Items.name_tag, 1), 1, 1, 6));//%4
		contents.getInfo("FISHERMAN").addItem(new WeightedRandomChestContent(new ItemStack(FantasticItems.randomFish, 0), 1, 1, 3));//2%
		contents.setMin(9);
		contents.setMax(5);
		proxy.initTileRenders();

		GameRegistry.registerTileEntity(TileAirCompressor.class, "AirCompressor");
		GameRegistry.registerTileEntity(TileSkeletonBlock.class, "SkeletonBlock");
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
