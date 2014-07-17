package fantastic.entities;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.items.FantasticItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityClam extends EntityWaterMob
{

	private static Random rand = new Random();

	private boolean hasNotSpawned = true;

	public EntityClam(World par1)
	{
		this(par1, rand.nextInt(4), rand.nextInt(10));
	}

	public EntityClam(World par1World, int par2, int par3)
	{
		super(par1World);
		this.setTexture(par2);
		this.setPearl(par3);
        this.getNavigator().setAvoidsWater(false);
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;

		
		
		
		
		this.setSize(1.0F, 1.0F);
	}

	

	boolean isClosed;
	
	public void setPearl(int par3)
	{
		if(par3 == 0)
		{
			this.setHasPearl((byte) 0);
		}
		else
		{
			this.setHasPearl((byte) 1);
		}
	}
	
	public void setIsClosed(boolean par1)
	{
		isClosed = par1;
	}
	public boolean getIsClosed()
	{
		return isClosed;
	}
	
	public boolean getHasNotSpawned()
	{
		return this.hasNotSpawned;
	}
	
	public void setHasNotSpawned(boolean par1)
	{
		this.hasNotSpawned = par1;
	}
	
	protected boolean isAIEnabled()
	{
		return true;

	}

	public int getTotalArmorValue()
	{
		return 2;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(20.0D );
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(10);

	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound()
	{
		if(this.getHealth() >= 19)
		{
			return "fantastic.clamShut";
		}
		else
		{
			return null;
		}

	}

	/**
	 * Returns the sound this mob makes while it's alive.
	 */
	protected String getLivingSound()
	{
	
			return null;
		
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound()
	{
		return null;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(FantasticItems.clamShell, 1, this.getTexture()), 0.0F);

	}

	
	
	protected void fall(float var1)
	{
	}


	/**
	 * Called when the mob's health reaches 0.
	 */
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

	}
	public void setTexture(int par1)
	{
		this.dataWatcher.updateObject(19, Integer.valueOf(par1));
	}
	public void setHasPearl(byte par1)
	{
		this.dataWatcher.updateObject(24, Byte.valueOf(par1));
	}
	public byte getHasPearl()
	{
		return this.dataWatcher.getWatchableObjectByte(24);
	}
	
	
	public int getTexture()
	{
		return this.dataWatcher.getWatchableObjectInt(19);
	}
	
	

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(19, Integer.valueOf(0));
		this.dataWatcher.addObject(24, Byte.valueOf((byte)1));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Texture", this.getTexture());
		par1NBTTagCompound.setBoolean("HasNotSpawned", this.getHasNotSpawned());
		par1NBTTagCompound.setBoolean("IsClosed", this.getIsClosed());
		par1NBTTagCompound.setByte("HasPearl", this.getHasPearl());
		
		
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setTexture(par1NBTTagCompound.getInteger("Texture"));
		this.setHasNotSpawned(par1NBTTagCompound.getBoolean("HasNotSpawned"));
		this.setIsClosed(par1NBTTagCompound.getBoolean("IsClosed"));
		this.setHasPearl(par1NBTTagCompound.getByte("HasPearl"));
	}

	

	public boolean outOfWater;
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if(this.isInWater())
		{
			
			if(this.getHealth() < 20)
			{
				this.setIsClosed(true);
			}
		}
		
		else
		{
				setIsOutOfWater(true);
				setIsClosed(true);
				
		}
	}
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();	
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
		
	}

	
	
	public boolean getIsOutOfWater()
	{
		return outOfWater;
	}
	
	public void setIsOutOfWater(boolean par1)
	{
		outOfWater = par1;
	}




	public boolean interact(EntityPlayer par1EntityPlayer)
	    {
			super.interact(par1EntityPlayer);
		 	ItemStack item = par1EntityPlayer.getHeldItem();
		 	
		 	if(!worldObj.isRemote)
		 	{
		 	
		 	if(item == null && !isClosed && this.getHasPearl() == 0)
		 	{
		 		
		 		EntityItem pearl = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(FantasticItems.pearl, 1));
		 		
		 		this.worldObj.spawnEntityInWorld(pearl);
		 		
		 		this.setHasPearl((byte) 1);
		 	}
		 	}
		 	
		 	if(item != null && item.itemID == FantasticItems.fishingNet.itemID)
		 	{
		 		ItemStack clamDrop = new ItemStack(FantasticItems.clam, 1);
		 		int damage = 5;
		 		
		 		clamDrop.setItemDamage(this.getTexture());
		 		if(this.hasCustomNameTag())
		 		{
			 		clamDrop.setItemName(this.getCustomNameTag());
		 		}
		 		EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, clamDrop);
		 		if(!this.worldObj.isRemote)
		 		{
		 			this.worldObj.spawnEntityInWorld(entityitem);
		 		}
                if(!par1EntityPlayer.capabilities.isCreativeMode)
                {
                	item.damageItem(damage, par1EntityPlayer);
                }
                this.setDead();
		 		
		 	}
		 	else if(item != null && item.itemID == Item.nameTag.itemID)
		 	{
		 		if(item.hasDisplayName())
		 		{
		 			this.setCustomNameTag(item.getDisplayName());
		 			item.stackSize--;
		 		}
		 	}
		 	
		 	
		 	this.setIsClosed(true);
		 	if(this.getHealth() == 20)
		 	{
		 		this.setHealth(this.getHealth() - 1);
            	this.worldObj.playSoundAtEntity(par1EntityPlayer, "fantastic:clamShut", 0.4F, 1.0F);
		 	}
			return true;
		 	
	    }
	
	
	 /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return this.hasCustomNameTag() ? false : true;
    }
}
