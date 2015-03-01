package fantastic.entities.sharks;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import fantastic.entities.EntityFantasticFish;

public class EntityFantasticShark extends EntityFantasticFish

{

	private Entity currentTarget;
	
	public EntityFantasticShark(World aWorld) 
	{
		super(aWorld);

	}
	
	public ResourceLocation GetTexture()
	{
		return null;
		
	}
	
	public void SetCurrentTarget(Entity aTarget)
	{
		currentTarget=aTarget;
	}
	
	public Entity GetCurrentTarget()
	{
		return currentTarget;
	}

	
}


/*package fantastic.entities.sharks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import fantastic.entities.EntityBasicFish;
import fantastic.items.FantasticItems;

public class EntityBasicShark extends EntityWaterMob
{

	private Vec3 currentSwimTarget;
	private int jumpTimer = 60;
	public int extraSpeed = 1;
	Entity hungryTarget;
	int hungry = 1200;
	private static Random rand = new Random();
	

	private boolean hasNotSpawned = true;

	public enum Type {GREAT, BULL, TIGER, HAMMER, BASIC};

	public Type sharkType;
	private int newTarget = 500;
	
	public EntityBasicShark(World par1World)
	{
		super(par1World);
		this.sharkType = Type.BASIC;
        this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;
		this.setSize(1.2F, 1.1F);
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
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(25.0D );
		
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20);

	}

	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}


	protected String getHurtSound()
	{

		return null;
		

	}


	protected String getLivingSound()
	{
	
			return null;
		
	}


	protected String getDeathSound()
	{
		return null;
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		if(rand.nextInt(10) == 0)
			this.entityDropItem(new ItemStack(FantasticItems.sharkFin, 1), 0.0F);
		
			this.entityDropItem(new ItemStack(FantasticItems.sharkTooth, rand.nextInt(3)), 0.0F);

	}


	protected void fall(float var1)
	{
	}


	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);
	}
	

	public int getTexture()
	{
		return this.dataWatcher.getWatchableObjectInt(19);
	}
	
	

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(19, Integer.valueOf(0));
	}


	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setBoolean("HasNotSpawned", this.getHasNotSpawned());
		
	}

	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setHasNotSpawned(par1NBTTagCompound.getBoolean("HasNotSpawned"));
	}

	

	
	public void setPosition(double par1, double par3, double par5) {
		super.setPosition(par1, par3, par5);
		if(currentSwimTarget == null){
			currentSwimTarget = Vec3.createVectorHelper(par1, par3, par5);
		}
	}
	EntityPlayer playerThatsFishing = null;
	public int attackTimer = 40;
	int degreesCircled = 0;
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		
		if(this.isInWater())
		{
			--hungry;
			EntityPlayer avoidPlayer= null;
			
				
			if(worldObj.getClosestPlayerToEntity(this, 20) != null && hungry <=0)
			{
				avoidPlayer = worldObj.getClosestPlayerToEntity(this, 20);
				--attackTimer;
				this.currentSwimTarget = this.handlePlayerInRange(avoidPlayer);
				hungryTarget = avoidPlayer;
			}
			else
				currentSwimTarget = findRandomTarget(this.posX, this.posY, this.posZ, false);
			
			if(hungry <= -2400)
			{
				hungry = -1;
				this.damageEntity(DamageSource.generic, 1.0F);
			}
			
			if(hungry <= 0 )
			{
				if(hungryTarget == null)
					this.currentSwimTarget = this.getHungryTarget();
				else
					--newTarget;
				
			}
			else
				currentSwimTarget = findRandomTarget(this.posX, this.posY, this.posZ, false);
			
			if(newTarget <= 0 || (hungryTarget != null && this.getDistanceToEntity(hungryTarget) > 15))
			{
				newTarget = 500;
				hungryTarget = null;
			}
			
			if(this.currentSwimTarget != null)
			{
				approachTarget(this.posX, this.posY, this.posZ, 2);
			}
			
			if(!this.worldObj.isAirBlock((int)this.posX, (int)this.posY+1, (int)this.posZ) && !this.worldObj.isAirBlock((int)this.posX, (int)this.posY+2, (int)this.posZ))
			{
				this.motionY += 0.0160829F;
			}
			
			
		}
		else
		{
			this.setJumping(true);
			if(this.onGround)
			{
				this.motionX *= 0.031;
				this.motionZ *= 0.031;
		
			}
		}
		
	}
	
	
	
	public Vec3 handlePlayerInRange(EntityPlayer player)
	{
		if(player.ridingEntity == null && player.isInWater() && attackTimer < 0)
			return Vec3.createVectorHelper(player.posX, player.posY, player.posZ);
		else
			return this.findRandomTarget(this.posX, this.posY, this.posZ, false);
		
		
		
	}

	public void setHungry(int var1)
	{
		hungry = var1;
		hungryTarget = null;
	}
	public int getHungry()
	{
		return hungry;
	}
	
	
	public Vec3 getHungryTarget()
	{
		EntityLivingBase Target = null;
		Vec3 normalizer = Vec3.createVectorHelper(1, 1, 1).normalize();
		List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.copy().expand(Math.abs(normalizer.xCoord * 7.0D) + 7, Math.abs(normalizer.yCoord * 7.0D) + 7, Math.abs(normalizer.zCoord * 7.0D) + 7));
		for (int l = 0; l < list.size(); ++l)
		{
			Entity entity1 = (Entity) list.get(l);
			
			if(entity1.isInWater() && entity1 instanceof EntityLivingBase)
			{
					Target = getTargetPriority(Target, (EntityLivingBase)entity1);
					hungryTarget = Target;
			}
			
		}
		if(Target == null)
			return findRandomTarget(posX, posY, posZ, false);
		else
			return Vec3.createVectorHelper(Target.posX, Target.posY, Target.posZ);
	}
	
	public EntityLivingBase getTargetPriority(EntityLivingBase Target, EntityLivingBase entity1)
	{
		if(Target != null)
		{
			if(Target instanceof EntityBasicShark)
				return entity1;
			else
				return Target;
		}
		else
			return entity1;
	}
	//Math converted to use more accurate and readable Vec3's
	private void approachTarget(double X, double Y, double Z, int speed) 
	{
		Vec3 vec3 = Vec3.createVectorHelper(this.currentSwimTarget.xCoord + 0.5D - X, this.currentSwimTarget.yCoord + 0.1D - Y, this.currentSwimTarget.zCoord + 0.5D - Z).normalize();
			this.motionX += (vec3.xCoord * 0.5D - this.motionX) * 0.05000000149011612D * speed;
			this.motionY += (vec3.yCoord * 0.699999988079071D - this.motionY) * 0.05000000149011612D * speed;
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
	int xMovement = -1,yMovement = -1,zMovement = -1;
	//If force is set to true, no check will be done to see if a fish is attached.
	//False will send to setEscape is necessary, which then recalls this method with force
	//set to true.
	public Vec3 findRandomTarget(double X, double Y, double Z, boolean force) 
	{
		if(isInWater()){
			movementskip--;
			
			if(movementskip <= 0){
				//Will cause server and client to produce random yet identical rolls.
				rand.setSeed(getEntityId() + chunkCoordX + chunkCoordY + chunkCoordZ);
				movementskip = rand.nextInt(15);
				int randomWaterCheck = 0;
				
				Block blockID1 = Blocks.bedrock;
				Block blockID2 = Blocks.bedrock;
				Vec3 newPos = null;
				//Give up after 20 rolls
				//Bad luck or cannot move in the current conditions
				
				while(randomWaterCheck < 20){
					//reuse last movement unless a wall is there.
					if(randomWaterCheck == 0 && xMovement != -1){
						newPos = Vec3.createVectorHelper(X + xMovement, Y + yMovement, Z + zMovement);
						blockID1 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord - (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord - (this.width / 2.0f)));
						blockID2 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord + (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord + (this.width / 2.0f)));
						if(blockID1 instanceof BlockLiquid){
							if(blockID2 instanceof BlockLiquid) 
								break;
							}
						blockID1 = Blocks.bedrock;
						blockID2 = Blocks.bedrock;
						}
					randomWaterCheck++;
					xMovement = (rand.nextInt(10) - 5);
					yMovement = (rand.nextInt(2) - 1);
					zMovement = (rand.nextInt(10) - 5);
					newPos = Vec3.createVectorHelper(X + xMovement, Y + yMovement, Z + zMovement);
					blockID1 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord - (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord - (this.width / 2.0f)));
					blockID2 = worldObj.getBlock(MathHelper.floor_double(newPos.xCoord + (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord + (this.width / 2.0f)));
					if(blockID1 instanceof BlockLiquid ){
						if(blockID2 instanceof BlockLiquid) break;
					}
					blockID1 = Blocks.bedrock;
					blockID2 = Blocks.bedrock;
				}
				if(blockID1 != Blocks.bedrock){
					this.extraSpeed = 1;
					return newPos;
				}
				else return currentSwimTarget;
			}
		}
		
		return currentSwimTarget;
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
		
		if(hungry <= 0 && par1Entity == hungryTarget)
		{
			par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 4.0F);
			this.attackTimer = 60;
		}
	}
	
	
	

	    protected boolean canDespawn()
	    {
	        return this.hasCustomNameTag() ? false : true;
	    }
}*/
