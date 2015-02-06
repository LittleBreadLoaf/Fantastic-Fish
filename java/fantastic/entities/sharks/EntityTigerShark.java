package fantastic.entities.sharks;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import fantastic.entities.EntityBasicFish;

public class EntityTigerShark extends EntityBasicShark
{

	private Vec3 currentSwimTarget;
	private int jumpTimer = 60;
	public int extraSpeed = 1;
	private static Random rand = new Random();
	

	private boolean hasNotSpawned = true;

	public EntityTigerShark(World par1)
	{
		this(par1, rand.nextInt(4));
	}

	public EntityTigerShark(World par1World, int par4)
	{
		super(par1World);
		this.sharkType = Type.TIGER;
		this.setCircles(par4);
        this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;
		this.setSize(1.9F, 1.2F);
	}


	
	private void setCircles(int par4) 
	{
		if(par4 == 0)
			par4 = 1;
		else if(par4 == 1)
			par4 = -2;
		else if(par4 == 2)
			par4 = 3;
		else if(par4 == 3)
			par4 = -4;
		this.setSharkCircles(par4);
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
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D );
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20);

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
		

	
	
	public void setSharkCircles(int par1) 
	{
		this.dataWatcher.updateObject(18, Integer.valueOf(par1));
		
	}
	
	public int getSharkCircles()
	{
		return this.dataWatcher.getWatchableObjectInt(18);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(18, Integer.valueOf(rand.nextInt(3) -rand.nextInt(3)));
		this.dataWatcher.addObject(21, Float.valueOf(0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("HasNotSpawned", this.getHasNotSpawned());
		
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setHasNotSpawned(par1NBTTagCompound.getBoolean("HasNotSpawned"));
	}

	

	EntityPlayer playerThatsFishing = null;
	public int attackTimer = 40;
	int degreesCircled = 0;
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
			
	}
	
	public Vec3 handlePlayerInRange(EntityPlayer player)
	{
		if((player.ridingEntity != null && player.ridingEntity instanceof EntityBoat))
		{

				degreesCircled += Math.signum(this.getSharkCircles());
				return Vec3.createVectorHelper(player.posX + 5* this.getSharkCircles() *Math.cos(Math.PI*degreesCircled/180F), player.posY, player.posZ  + 5 * this.getSharkCircles()*Math.sin(Math.PI*degreesCircled/180F));
				
		}
		else
			return super.handlePlayerInRange(player);
		
	}

	
	
	float counter = 0;

	

	@Override
	public boolean canBeCollidedWith()
	{
		return true;
		
	}

	protected void collideWithEntity(Entity par1Entity)
	{
	
		super.collideWithEntity(par1Entity);
	}
	
	
	@Override
	public EntityLivingBase getTargetPriority(EntityLivingBase Target, EntityLivingBase entity1)
	{
		EntityLivingBase priorityEntity = null;
		if(Target == null)
		{
			return entity1;
		}
		if(entity1 instanceof EntityBasicFish)
		{
			if(Target instanceof EntityBasicFish)
			{	
				priorityEntity = ((EntityBasicFish)Target).GetFishSize().ordinal() > ((EntityBasicFish)entity1).GetFishSize().ordinal() ? Target : entity1;
			}
			else		
				priorityEntity = entity1;
		}
		
		
		return priorityEntity;
	}
	
	
	
	
	 /**
	     * Determines if an entity can be despawned, used on idle far away entities
	     */
	    protected boolean canDespawn()
	    {
	        return this.hasCustomNameTag() ? false : true;
	    }
}
