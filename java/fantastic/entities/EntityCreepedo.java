package fantastic.entities;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityCreepedo extends EntityWaterMob
{

	private Vec3 currentSwimTarget;
	private Vec3 bobberTarget;
	private int ignoreTimer = (int)(500 *this.getRenderSize());
	private int jumpTimer = 60;
	public int extraSpeed = 1;
	boolean isBobber;
	public boolean outOfWater;
	private static Random rand = new Random();
	

	private boolean hasNotSpawned = true;

	public EntityCreepedo(World par1)
	{
		this(par1, null, 1);
	}
	
	private EntityPlayer launcher;
	private int Size;
	private double newX, newZ;

	public EntityCreepedo(World par1World, EntityPlayer par3, int size)
	{
		super(par1World);
		this.setPreRenderSize(size);
		this.setLaunchLook(par3);
		this.Size = size;
		this.launcher = par3;
        this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.4D));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;
		this.setSize(1.2F, 1.1F);
	}


	private void setLaunchLook(EntityPlayer player)
	{
		if(player != null)
		{
			Vec3 escapeDirection = Vec3.createVectorHelper(posX - player.posX, 0, posZ - player.posZ).normalize();
			//Not much to say here, it assigns the pathing distance check to be performed 3^2 blocks away in the direction
			//the player is facing.
			xMovement = (int) Math.round(escapeDirection.xCoord * 3);
			zMovement = (int) Math.round(escapeDirection.zCoord * 3);
		}
	}
	private void setPreRenderSize(int par3) 
	{
		
		this.setRenderSize(par3);
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
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(4.0D );
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10);

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
	
			return "random.fuse";
		
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
		this.entityDropItem(new ItemStack(Items.gunpowder, 1 + rand.nextInt(1)), 0.0F);

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
		if(!this.worldObj.isRemote)
		this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.Size, true);

	}
	//This returns the fishing hook
		//getBobber().bobber will retrieve the fish that is attached.
		//It should equal this, otherwise, remove this reference 
		//getBobber().angler returns the player that is fishing
		//it gets assigned locally to 'playerThatsFishing'
		
	

	
	public void setRenderSize(float par1) 
	{
		this.dataWatcher.updateObject(21, Float.valueOf(par1));
		
	}
	
	
	public float getRenderSize()
	{
		return this.dataWatcher.getWatchableObjectFloat(21);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(21, Float.valueOf(0));
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setFloat("RenderSize", this.getRenderSize());
		par1NBTTagCompound.setBoolean("HasNotSpawned", this.getHasNotSpawned());
		
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setRenderSize(par1NBTTagCompound.getFloat("RenderSize"));
		this.setHasNotSpawned(par1NBTTagCompound.getBoolean("HasNotSpawned"));
	}

	
	/**
	 * randomly selected ChunkCoordinates in a 7x6x7 box around the bat (y
	 * offset -2 to 4) towards which it will fly. upon getting close a new
	 * target will be selected
	 */
	
	public void setPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
		if(currentSwimTarget == null){
			currentSwimTarget = Vec3.createVectorHelper(par1, par3, par5);
		}
	}
	
	EntityPlayer playerThatsFishing = null;
	int aliveTicks = 0;
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		
		if(this.isInWater())
		{
			++aliveTicks;
			
			if(aliveTicks >= 600)
			{
				if(!this.worldObj.isRemote)
				this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.Size, true);
				this.setDead();
			}
			
			EntityPlayer avoidPlayer= null;
			
			
				if(worldObj.getClosestPlayerToEntity(this, 25) != null)
				{
					avoidPlayer = worldObj.getClosestPlayerToEntity(this, 25);
					if(avoidPlayer != launcher)
					{
						
						if(this.getDistanceToEntity(avoidPlayer) < 2.0)
						{
							if(!this.worldObj.isRemote)
							this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.Size, true);
							this.setDead();
						}
						if((avoidPlayer.ridingEntity != null && avoidPlayer.ridingEntity instanceof EntityBoat) || avoidPlayer.isInWater())
							currentSwimTarget = Vec3.createVectorHelper(avoidPlayer.posX, avoidPlayer.posY, avoidPlayer.posZ);
					}
				}
			
			if(this.currentSwimTarget != null)
			{
				approachTarget(this.posX, this.posY, this.posZ, 4);
			}
			
			if(!this.worldObj.isAirBlock((int)this.posX, (int)this.posY+1, (int)this.posZ) && !this.worldObj.isAirBlock((int)this.posX, (int)this.posY+2, (int)this.posZ))
			{
				this.motionY -= 0.0160829F;
			}
			findRandomTarget(this.posX, this.posY, this.posZ, false);
		}
		else
		{

			
		}
		
	}
	//Math converted to use more accurate and readable Vec3's
	private void approachTarget(double X, double Y, double Z, int speed) 
	{
		Vec3 vec3 = Vec3.createVectorHelper(this.currentSwimTarget.xCoord + 0.5D - X, this.currentSwimTarget.yCoord + 0.1D - Y, this.currentSwimTarget.zCoord + 0.5D - Z).normalize();
			this.motionX += (vec3.xCoord * 0.5D - this.motionX) * 0.05000000149011612D * speed;
			this.motionY += (vec3.yCoord * 0.699999988079071D - this.motionY) * 0.03000000149011612D * speed;
			this.motionZ += (vec3.zCoord * 0.5D - this.motionZ) * 0.05000000149011612D * speed;
		
			float f = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
			float f1 = MathHelper.wrapAngleTo180_float(f - this.rotationYaw);
			this.moveForward = 0.15F * speed;
			this.rotationYaw += f1;
			this.motionY += 0.0160829F;
			
			Block blockID = worldObj.getBlock(MathHelper.floor_double(this.currentSwimTarget.xCoord), MathHelper.floor_double(this.currentSwimTarget.yCoord), MathHelper.floor_double(this.currentSwimTarget.zCoord));
		if(currentSwimTarget != null && (currentSwimTarget.squareDistanceTo((int)X, (int)Y, (int)Z) < 3 || blockID == null || !(blockID instanceof BlockLiquid)))
		{
			currentSwimTarget = null;
		}
	}

	
	
	int movementskip = 0;
	double xMovement = -1,yMovement = -1,zMovement = -1;
	//If force is set to true, no check will be done to see if a fish is attached.
	//False will send to setEscape is necessary, which then recalls this method with force
	//set to true.
	private void findRandomTarget(double X, double Y, double Z, boolean force) 
	{
		
				Vec3 newPos = null;
				if(this.ticksExisted < 3)
				setLaunchLook(launcher);
				newPos = Vec3.createVectorHelper(X + xMovement, Y - 0.01 , Z + zMovement);
				Vec3 normalizer = Vec3.createVectorHelper(this.motionX, this.motionY, this.motionZ).normalize();
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 20.0D) + 5, Math.abs(normalizer.yCoord * 20.0D) + 5, Math.abs(normalizer.zCoord * 20.0D) + 5));
				for (int l = 0; l < list.size(); ++l)
				{
					Entity entity1 = (Entity) list.get(l);
					
					if(entity1 instanceof EntityBoat)
					{
						if(launcher != null && launcher.ridingEntity != null)
						{
							if(!((EntityBoat)entity1).equals(launcher.ridingEntity))
								newPos = Vec3.createVectorHelper(entity1.posX, entity1.posY - 0.3, entity1.posZ);
						}
						else
						{
							newPos = Vec3.createVectorHelper(entity1.posX, entity1.posY - 0.3, entity1.posZ);
						}
						
					}
				}
					
					
					this.currentSwimTarget = newPos;
				
		
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

		
		if(launcher != null && !par1Entity.equals(launcher))
		{
			if( launcher.ridingEntity != null && par1Entity.equals(launcher.ridingEntity))
			{
				return;
			}
			else
			{
				if(!this.worldObj.isRemote)
					this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.Size, true);
				this.setDead();
			}
		}
	}
	
	
	
	
	
	 public boolean interact(EntityPlayer par1EntityPlayer)
	    {

			if(!this.worldObj.isRemote)
			this.worldObj.createExplosion(null, this.posX, this.posY, this.posZ, this.Size, true);
			this.setDead();
		 
			return true;
	    }
	 /**
	     * Determines if an entity can be despawned, used on idle far away entities
	     */
	    protected boolean canDespawn()
	    {
	        return this.hasCustomNameTag() ? false : true;
	    }


	public void setCurrentSwimTarget(double d, double e, double f) 
	{
		this.currentSwimTarget = Vec3.createVectorHelper(d, e, f);
	}
}
