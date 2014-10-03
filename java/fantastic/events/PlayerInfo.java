package fantastic.events;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import fantastic.proxies.CommonProxy;

public class PlayerInfo implements IExtendedEntityProperties
{
	public final static String FantasticPlayer = "PlayerInfo";
	
	private final EntityPlayer player;
	private Random rand = new Random();
	private int DiverAir = 0;
	
	
	public PlayerInfo(EntityPlayer player)
	{
		this.player = player;
		this.DiverAir = 0;
		this.player.getDataWatcher().addObject(20, this.DiverAir);
	}
	
	
	
	
	
	//NBT Tags
	@Override 
	public void saveNBTData(NBTTagCompound nbt)
	{
		nbt.setInteger("DiverAir", this.player.getDataWatcher().getWatchableObjectInt(20));
	}
	
	/**
	* Used to register these extended properties for the player during EntityConstructing event
	* This method is for convenience only; it will make your code look nicer
	*/
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(PlayerInfo.FantasticPlayer, new PlayerInfo(player));
	}

	/**
	* Returns ExtendedPlayer properties for player
	* This method is for convenience only; it will make your code look nicer
	*/
	public static final PlayerInfo get(EntityPlayer player)
	{
		return (PlayerInfo) player.getExtendedProperties(FantasticPlayer);
	}
	/**
	* Makes it look nicer in the methods save/loadProxyData
	*/
	private static String getSaveKey(EntityPlayer player) 
	{
		return player.getCommandSenderName() + ":" + FantasticPlayer;
	}

	/**
	* Does everything I did in onLivingDeathEvent and it's static,
	* so you now only need to use the following in the above event:
	* ExtendedPlayer.saveProxyData((EntityPlayer) event.entity));
	*/
	public static void saveProxyData(EntityPlayer player) 
	{
		PlayerInfo playerData = PlayerInfo.get(player);
		NBTTagCompound savedData = new NBTTagCompound();

		playerData.saveNBTData(savedData);
		
		CommonProxy.storeEntityData(getSaveKey(player), savedData);
	}

	public static final void loadProxyData(EntityPlayer player) 
	{
		PlayerInfo playerData = PlayerInfo.get(player);
		
		NBTTagCompound savedData = CommonProxy.getEntityData(getSaveKey(player));
		
		if (savedData != null) { playerData.loadNBTData(savedData); }
		}
	
	
	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		this.player.getDataWatcher().updateObject(20, nbt.getInteger("DiverAir"));
	}
	
	
	
	//Things
	@Override
	public void init(Entity entity, World world)
	{
		
	}

	
	
	
	
	
	

	
	
	
	
	
	//Setters
	public void setDiverAir(int amount)
	{
		
		this.player.getDataWatcher().updateObject(20, amount);
		
	}
	
	//Getters
	
	public int getDiverAir()
	{
		return this.player.getDataWatcher().getWatchableObjectInt(20);
	}
	
	//Adding and Subtracting

	public void addAir(int amount)
	{
		int diverAir = this.player.getDataWatcher().getWatchableObjectInt(20);
		diverAir += amount;
		this.player.getDataWatcher().updateObject(20, diverAir);
		
	}













	

}
