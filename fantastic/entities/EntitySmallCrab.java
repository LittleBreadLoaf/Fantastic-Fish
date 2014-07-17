package fantastic.entities;

import java.util.Random;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import fantastic.items.FantasticItems;

public class EntitySmallCrab extends EntityAnimal
{

	private static Random rand = new Random();
	private boolean hasNotSpawned = true;

	public EntitySmallCrab(World par1)
	{
		this(par1, rand.nextInt(3));
	}

	public EntitySmallCrab(World par1World, int par2)
	{
		super(par1World);
		this.setTexture(par2);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityPlayer.class, 5, 0.3F, 0.4F));
		this.tasks.addTask(2, new EntityAIMoveTowardsRestriction(this, 0.3D));
		this.tasks.addTask(3, new EntityAIWander(this, 0.3D));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;
		this.setSize(0.3F, 0.3F);
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
		return 0;
	}

	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(5.0D);
		
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

		return null;
		

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
	
	

	public int getTexture()
	{
		return this.dataWatcher.getWatchableObjectInt(19);
	}
	
	

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(19, Integer.valueOf(0));
		this.dataWatcher.addObject(21, Float.valueOf(0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Texture", this.getTexture());
		par1NBTTagCompound.setBoolean("HasNotSpawned", this.getHasNotSpawned());
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setTexture(par1NBTTagCompound.getInteger("Texture"));
		this.setHasNotSpawned(par1NBTTagCompound.getBoolean("HasNotSpawned"));
	}

	
	/**
	 * randomly selected ChunkCoordinates in a 7x6x7 box around the bat (y
	 * offset -2 to 4) towards which it will fly. upon getting close a new
	 * target will be selected
	 */

	
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		if(this.isInWater())
		{
				this.setAir(2000);
		}
			
		
		
	}

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
		
	}



	
	
	 public boolean interact(EntityPlayer par1EntityPlayer)
	    {
		 	ItemStack item = par1EntityPlayer.inventory.getCurrentItem();
		 	if(item != null && item.itemID == FantasticItems.fishingNet.itemID)
		 	{
		 		ItemStack crab = new ItemStack(FantasticItems.smallCrab, 1);
		 		int damage = 5;
		 		
		 		crab.setItemDamage(this.getTexture());
		 		if(this.hasCustomNameTag())
		 		{
			 		crab.setItemName(this.getCustomNameTag());
		 		}
		 		EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, crab);
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
		 	
			return true;
	    }
	 /**
	     * Determines if an entity can be despawned, used on idle far away entities
	     */
	    protected boolean canDespawn()
	    {
	        return this.hasCustomNameTag() ? false : true;
	    }

	@Override
	public EntityAgeable createChild(EntityAgeable entityageable) {
		// TODO Auto-generated method stub
		return null;
	}
}
