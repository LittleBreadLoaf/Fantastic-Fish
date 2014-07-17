package fantastic.proxies;


import net.minecraft.client.Minecraft;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.events.FantasticSounds;
import fantastic.renders.entity.EntityRender;

public class ClientProxy extends CommonProxy
{
	@Override
	public void initRenderers()
	{
		
		
		EntityRender.renderEntities();

		MinecraftForge.EVENT_BUS.register(new FantasticSounds());
	}

	

	@Override
	public void loadParts()
	{
//		BleachItems.init();
//		BleachItems.addNames();
//
//		BleachBlocks.init();
//		BleachBlocks.addNames();
//
//		Entities.addNames();
//		Entities.init();
//
//		Armor.init();
//		Armor.addNames();

	}

	@Override
	public int addArmor(String string)
	{
		return RenderingRegistry.addNewArmourRendererPrefix(string);
	}

	@Override
	public void loadGUI()
	{
		//MinecraftForge.EVENT_BUS.register(new GuiGoggles(Minecraft.getMinecraft()));
	}

	@Override
	public void loadKeys()
	{
		//KeyBinding[] shikaiKey =
		//{ new KeyBinding("Deactivate", Keyboard.KEY_Z) };
		//boolean[] repeat =
		//{ false };
		//KeyBindingRegistry.registerKeyBinding(new ShikaiKeyBind(shikaiKey, repeat));

		
	}

	@Override
	public void sendToServer(Packet packet)
	{
		FMLClientHandler.instance().getClient().getNetHandler().addToSendQueue(packet);
	}
	
	@Override
	public void registerVillagers()
	{
		VillagerRegistry.instance().registerVillagerSkin(FantasticIds.fishermanID, new ResourceLocation(FantasticInfo.ID + ":textures/models/mobs/fantastic_fisherman.png")); //id must be greater than 6

	}

}
