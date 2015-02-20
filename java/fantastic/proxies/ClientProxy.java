package fantastic.proxies;


import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.blocks.decoration.TileSkeletonBlock;
import fantastic.entities.EntityHarpoon;
import fantastic.events.FantasticKeyHandler;
import fantastic.events.FantasticSounds;
import fantastic.gui.GuiAirGauge;
import fantastic.gui.GuiGoggles;
import fantastic.renders.entity.EntityRender;
import fantastic.renders.entity.RenderHarpoon;
import fantastic.renders.models.armor.ModelDiverBoots;
import fantastic.renders.models.armor.ModelDiverChest;
import fantastic.renders.models.armor.ModelDiverHelmet;
import fantastic.renders.models.armor.ModelDiverPants;
import fantastic.renders.models.armor.ModelFlippers;
import fantastic.renders.models.armor.ModelGoggles;
import fantastic.renders.models.armor.ModelScubaTank;
import fantastic.renders.models.armor.ModelSingleTank;
import fantastic.renders.tiles.RenderAirCompressor;
import fantastic.renders.tiles.RenderSkeletonBlock;
import fantastic.tiles.TileAirCompressor;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		
		
		EntityRender.renderEntities();

		RenderingRegistry.registerEntityRenderingHandler(EntityHarpoon.class, new RenderHarpoon());
		MinecraftForge.EVENT_BUS.register(new FantasticSounds());
	}

	

	@Override
	public void loadParts()
	{

	}

	@Override
	public int addArmor(String string)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(string);
	}

	@Override
	public void loadGUI()
	{
		MinecraftForge.EVENT_BUS.register(new GuiAirGauge(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiGoggles(Minecraft.getMinecraft()));
	}

	@Override
	public void loadKeys()
	{

		FMLCommonHandler.instance().bus().register(new FantasticKeyHandler());
		
	}

	
	
	@Override
	public void registerVillagers()
	{
		VillagerRegistry.instance().registerVillagerSkin(FantasticIds.fishermanID, new ResourceLocation(FantasticInfo.ID + ":textures/models/mobs/fantastic_fisherman.png")); //id must be greater than 6

	}
	
	
	private static final ModelGoggles goggles = new ModelGoggles(0.0F);
	private static final ModelScubaTank tank = new ModelScubaTank(0.01F);
	private static final ModelSingleTank single = new ModelSingleTank(0.01F);
	private static final ModelFlippers flippers = new ModelFlippers(0.01F);
	private static final ModelDiverHelmet diverHelm = new ModelDiverHelmet(0.05F);
	private static final ModelDiverChest diverChest = new ModelDiverChest(0.05F);
	private static final ModelDiverPants diverPants = new ModelDiverPants(0.01F);
	private static final ModelDiverBoots diverBoots = new ModelDiverBoots(0.01F);
	private static final ModelBiped robes = new ModelBiped(0.3F);
	
	@Override
	public ModelBiped getArmorModel(int id)
	{
		switch (id){
		case 0:
			return robes;
		case 1:
			return goggles;
		case 2:
			return tank;
		case 3:
			return flippers;
		case 4:
			return single;
		case 5:
			return diverHelm;
		case 6:
			return diverChest;
		case 7:
			return diverPants;
		case 8:
			return diverBoots;
			default:
				break;
		}
		return robes;
		
}
	@Override
	public EntityPlayer getPlayerFromMessage(MessageContext ctx)
	{
		return Minecraft.getMinecraft().thePlayer;
	}

	
	@Override
	public void initTileRenders()
	{
		FantasticIds.airCompressorRenderingID = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileAirCompressor.class, new RenderAirCompressor());
		
		FantasticIds.skeletonRenderingID = RenderingRegistry.getNextAvailableRenderId();
		ClientRegistry.bindTileEntitySpecialRenderer(TileSkeletonBlock.class, new RenderSkeletonBlock());
	}
	
	

}
