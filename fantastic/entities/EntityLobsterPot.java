package fantastic.entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityLobsterPot extends Entity
{
	int blueLobsters;
	int redLobsters;

	public EntityLobsterPot(World par1World) 
	{
		super(par1World);
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 1.0F);
	}
	
	 public EntityLobsterPot(World par1World, double par2, double par4, double par6)
	    {
	        this(par1World);
	        this.setPosition(par2, par4, par6);
	        this.motionX = 0.0D;
	        this.motionY = 0.0D;
	        this.motionZ = 0.0D;
	        this.prevPosX = par2;
	        this.prevPosY = par4;
	        this.prevPosZ = par6;
	    }

	@Override
	protected void entityInit(){}

	public int getLobsters(String type)
	{
		if(type.equalsIgnoreCase("red"))
		{
			return this.redLobsters;
		}
		else
		{
			return this.blueLobsters;
		}
	}
	public void setLobsters(String type, int amount)
	{
		if(type.equalsIgnoreCase("red"))
		{
			this.redLobsters += amount;
		}
		else
		{
			this.blueLobsters += amount;
		}
	}
	@Override
	protected void readEntityFromNBT(NBTTagCompound tag) 
	{
		this.setLobsters("red", tag.getInteger("RedLobsters"));
		this.setLobsters("blue", tag.getInteger("BlueLobsters"));
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound tag) 
	{
		tag.setInteger("RedLobsters", this.getLobsters("red"));
		tag.setInteger("BlueLobsters", this.getLobsters("blue"));
		
	}
	
	
	/**
     * First layer of player interaction
     */
    public boolean interactFirst(EntityPlayer par1EntityPlayer)
    {
		return false;
    	
    }
    
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.motionY *= 0.949999988079071D;
    }

}
