package fantastic.proxies;

import java.util.HashMap;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fantastic.FantasticIds;
import fantastic.FantasticMod;
import fantastic.Names;
import fantastic.entities.EntityReinforcedFishingHook;
import fantastic.events.VillagerTradeHandler;
import fantastic.world.ComponentFishermanHut;
import fantastic.world.FishermanHandler;

public class CommonProxy implements IGuiHandler
{

	private static HashMap<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	

	
	public void initRenderers()
	{

	}



	public int addArmor(String string)
	{
		return 0;
	}

	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z)
	{
		return null;
	}

	public static void storeEntityData(String name, NBTTagCompound compound)
	{
		extendedEntityData.put(name, compound);
	}

	public static NBTTagCompound getEntityData(String name)
	{
		return extendedEntityData.remove(name);
	}

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

	public void loadGUI()
	{

	}

	public void loadKeys()
	{

	}

	public void initZanpakutoRenderers()
	{

	}

	
	
	
	public void registerVillagers()
	{
		
	}

	public ModelBiped getArmorModel(int id) 
	{
		return null;
	}
	public void loadMessages()
	{

	}
	
	public EntityPlayer getPlayerFromMessage(MessageContext ctx)
	{
		return ctx.getServerHandler().playerEntity;
	}
	
	public void initTileRenders()
	{
		
	}
}
