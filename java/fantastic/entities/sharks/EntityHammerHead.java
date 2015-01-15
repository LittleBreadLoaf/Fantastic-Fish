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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import fantastic.entities.EntityMantaRay;
import fantastic.items.FantasticItems;

public class EntityHammerHead extends EntityBasicShark
{

	private Vec3 currentSwimTarget;
	private int jumpTimer = 60;
	public int extraSpeed = 1;
	private static Random rand = new Random();
	

	private boolean hasNotSpawned = true;



	public EntityHammerHead(World par1World)
	{
		super(par1World);
		this.sharkType = Type.HAMMER;
        this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;
		this.setSize(1.8F, 1.1F);
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
	//This returns the fishing hook
		//getBobber().bobber will retrieve the fish that is attached.
		//It should equal this, otherwise, remove this reference 
		//getBobber().field_146042_b returns the player that is fishing
		//it gets assigned locally to 'playerThatsFishing'
	

	
	
	protected void entityInit()
	{
		super.entityInit();
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

	
	
	public Vec3 handlePlayerInRange(EntityPlayer player)
	{
		return this.findRandomTarget(this.posX, this.posY, this.posZ, false);
		
	}
	
	@Override
	public EntityLivingBase getTargetPriority(EntityLivingBase Target, EntityLivingBase entity1)
	{
		if(entity1 instanceof EntityMantaRay)
			return entity1;
		else if(Target != null && Target instanceof EntityMantaRay)
			return Target;
		return null;
	}
	
	 /**
	     * Determines if an entity can be despawned, used on idle far away entities
	     */
	    protected boolean canDespawn()
	    {
	        return this.hasCustomNameTag() ? false : true;
	    }
}
