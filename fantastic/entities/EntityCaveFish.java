package fantastic.entities;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.items.FantasticItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.BlockFluid;
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
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityCaveFish extends EntityWaterMob
{

	private Vec3 currentSwimTarget;
	public int extraSpeed = 1;
	public boolean outOfWater;
	private static Random rand = new Random();
	private boolean hasNotSpawned = true;

	public EntityCaveFish(World par1)
	{
		this(par1, rand.nextInt(5));
	}

	public EntityCaveFish(World par1World, int par2)
	{
		super(par1World);
		this.setPreRenderSize(par2);
        this.getNavigator().setAvoidsWater(false);
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.4D));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false));
		this.ignoreFrustumCheck = true;
		this.setSize(1.2F, 1.1F);
	}


	private void setPreRenderSize(int par3) 
	{
		if(par3 == 0)
		{
			this.setRenderSize(0.25F);
		}
		if(par3 == 1)
		{
			this.setRenderSize(0.5F);
		}
		if(par3 == 2)
		{
			this.setRenderSize(0.8F);
		}
		if(par3 == 3)
		{
			this.setRenderSize(1.0F);
		}
		if(par3 == 4)
		{
			this.setRenderSize(1.3F);
		}
		
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
		
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(15.0D);
		
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
		this.entityDropItem(new ItemStack(FantasticItems.filletRaw, 1 + rand.nextInt(this.getNumberFromSize())), 0.0F);

	}

	
	protected int getNumberFromSize()
	{
		int number = 1;
		if(this.getRenderSize() == 0.25F)
		{
			number = 1;
		}
		if(this.getRenderSize() == 0.5F)
		{
			number = 2;
		}
		if(this.getRenderSize() == 0.8F)
		{
			number = 3;
		}
		if(this.getRenderSize() == 1.0F)
		{
			number = 4;
		}
		if(this.getRenderSize() == 1.3F)
		{
			number = 5;
		}
		if(this.getRenderSize() == 1.8F)
		{
			number = 10;
		}
		return number;
	}
	
	protected float getSizeFromRender()
	{
		float size = 1;
		if(this.getRenderSize() == 0.25F)
		{
			size = 0F;
		}
		if(this.getRenderSize() == 0.5F)
		{
			size = 0.2F;
		}
		if(this.getRenderSize() == 0.8F)
		{
			size = 0.4F;
		}
		if(this.getRenderSize() == 1.0F)
		{
			size = 0.8F;
		}
		if(this.getRenderSize() == 1.3F)
		{
			size = 1.0F;
		}
		if(this.getRenderSize() == 1.8F)
		{
			size = 1.2F;
		}
		return size;
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
	
	
	public int getIsOutOfWater()
	{
		return this.dataWatcher.getWatchableObjectInt(17);
	}
	
	public void setIsOutOfWater(int par1)
	{
		this.dataWatcher.updateObject(17, Integer.valueOf(par1));
	}
	public void setTexture(int par1)
	{
		this.dataWatcher.updateObject(19, Integer.valueOf(par1));
	}
	
	public void setRenderSize(float par1) 
	{
		this.dataWatcher.updateObject(21, Float.valueOf(par1));
		
	}

	public int getTexture()
	{
		return this.dataWatcher.getWatchableObjectInt(19);
	}
	
	public float getRenderSize()
	{
		return this.dataWatcher.getWatchableObjectFloat(21);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(17, Integer.valueOf(0));
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
		par1NBTTagCompound.setFloat("RenderSize", this.getRenderSize());
		par1NBTTagCompound.setBoolean("HasNotSpawned", this.getHasNotSpawned());
		par1NBTTagCompound.setInteger("isOutOfWater", this.getIsOutOfWater());
		
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setTexture(par1NBTTagCompound.getInteger("Texture"));
		this.setRenderSize(par1NBTTagCompound.getFloat("RenderSize"));
		this.setHasNotSpawned(par1NBTTagCompound.getBoolean("HasNotSpawned"));
		this.setIsOutOfWater(par1NBTTagCompound.getInteger("isOutOfWater"));
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
	@Override
	protected void updateAITasks()
	{
		super.updateAITasks();
		

		
		if(this.isInWater())
		{
			
			
			setIsOutOfWater(1);
			
			playerThatsFishing = null;
			EntityPlayer avoidPlayer= null;
			//Now this will search for all three in first pass.
			if(playerThatsFishing == null)
			{
				if(worldObj.getClosestPlayerToEntity(this, 6) != null)
				{
					avoidPlayer = worldObj.getClosestPlayerToEntity(this, 6);
					setEscape(avoidPlayer, this.posX, this.posY, this.posZ, false);
				}
			}
			
			if(this.currentSwimTarget != null)
			{
				approachTarget(this.posX, this.posY, this.posZ, this.extraSpeed);
			}
			
			if(!this.worldObj.isAirBlock((int)this.posX, (int)this.posY+1, (int)this.posZ) && !this.worldObj.isAirBlock((int)this.posX, (int)this.posY+2, (int)this.posZ))
			{
				this.motionY += 0.0360829F;
			}
			findRandomTarget(this.posX, this.posY, this.posZ, false);
		}
		else
		{
			setIsOutOfWater(0);
			this.setJumping(true);
			this.motionX *= 0.15f;
			this.motionZ *= 0.15f;
			//this.moveEntity(0.3*rand.nextDouble() - 0.3*rand.nextDouble(), this.motionY, 0.3*rand.nextDouble() - 0.3*rand.nextDouble());
		}
		
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
			int blockID = worldObj.getBlockId(MathHelper.floor_double(this.currentSwimTarget.xCoord), MathHelper.floor_double(this.currentSwimTarget.yCoord), MathHelper.floor_double(this.currentSwimTarget.zCoord));
		if(currentSwimTarget != null && (currentSwimTarget.squareDistanceTo((int)X, (int)Y, (int)Z) < 3 || Block.blocksList[blockID] == null || !(Block.blocksList[blockID] instanceof BlockFluid)))
		{
			currentSwimTarget = null;
		}
	}

	private void setEscape(EntityPlayer theAngler, double X, double Y, double Z, boolean Jump) 
	{
		//The following line will take the distance difference of the two entity locations and normalize them.
		//This reduces the distances to their fractional ratios, ie, > -1.0 and < 1.0
		Vec3 escapeDirection = Vec3.createVectorHelper(X - theAngler.posX, 0, Z - theAngler.posZ).normalize();
		//Not much to say here, it assigns the pathing distance check to be performed 3^2 blocks away in the direction
		//the player is facing.
		xMovement = (int) Math.round(escapeDirection.xCoord * 3);
		yMovement = (int) Math.round(escapeDirection.yCoord * 3);
		zMovement = (int) Math.round(escapeDirection.zCoord * 3);
        currentSwimTarget = Vec3.createVectorHelper(X, Y, Z);
        //The above will enforce a direction opposing the player
        //if any water is in that direction, otherwise it will change
        //direction until it finds a path opposing the player
        
        //This line will enforce a pathing check to be performed so the fish can change direction if needed
        movementskip = 0;
        //Skip the callback to this method since our directional data is set now
        findRandomTarget(X, Y, Z, true);
        //double speed when running
		this.extraSpeed = 2;
		
		if(!this.worldObj.isAirBlock((int)X, (int)Y+1, (int)Z))
		{
			this.motionY += 0.0660829F;
		}
		
	}
	int movementskip = 0;
	int xMovement = -1,yMovement = -1,zMovement = -1;
	//If force is set to true, no check will be done to see if a fish is attached.
	//False will send to setEscape is necessary, which then recalls this method with force
	//set to true.
	private void findRandomTarget(double X, double Y, double Z, boolean force) 
	{
		if(isInWater()){
			movementskip--;
			
			if(movementskip <= 0){
				//Will cause server and client to produce random yet identical rolls.
				rand.setSeed(entityId + chunkCoordX + chunkCoordY + chunkCoordZ);
				movementskip = rand.nextInt(15);
				int randomWaterCheck = 0;
				
				int blockID1 = -1;
				int blockID2 = -1;
				Vec3 newPos = null;
				//Give up after 20 rolls
				//Bad luck or cannot move in the current conditions
				
				while(randomWaterCheck < 20){
					//reuse last movement unless a wall is there.
					if(randomWaterCheck == 0 && xMovement != -1){
						newPos = Vec3.createVectorHelper(X + xMovement, Y + yMovement, Z + zMovement);
						blockID1 = worldObj.getBlockId(MathHelper.floor_double(newPos.xCoord - (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord - (this.width / 2.0f)));
						blockID2 = worldObj.getBlockId(MathHelper.floor_double(newPos.xCoord + (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord + (this.width / 2.0f)));
						if(Block.blocksList[blockID1] instanceof BlockFluid && !(Block.blocksList[blockID1] instanceof BlockFlowing)){
							if(Block.blocksList[blockID2] instanceof BlockFluid && !(Block.blocksList[blockID2] instanceof BlockFlowing)) 
								break;
						}
						blockID1 = -1;
						blockID2 = -1;
					}
					randomWaterCheck++;
					xMovement = (rand.nextInt(10) - 5);
					yMovement = (rand.nextInt(2) - 1);
					zMovement = (rand.nextInt(10) - 5);
					newPos = Vec3.createVectorHelper(X + xMovement, Y + yMovement, Z + zMovement);
					blockID1 = worldObj.getBlockId(MathHelper.floor_double(newPos.xCoord - (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord - (this.width / 2.0f)));
					blockID2 = worldObj.getBlockId(MathHelper.floor_double(newPos.xCoord + (this.width / 2.0f)), MathHelper.floor_double(newPos.yCoord), MathHelper.floor_double(newPos.zCoord + (this.width / 2.0f)));
					if(Block.blocksList[blockID1] instanceof BlockFluid && !(Block.blocksList[blockID1] instanceof BlockFlowing)){
						if(Block.blocksList[blockID2] instanceof BlockFluid && !(Block.blocksList[blockID2] instanceof BlockFlowing)) break;
					}
					blockID1 = -1;
					blockID2 = -1;
				}
				if(blockID1 != -1){
					this.currentSwimTarget = newPos;
					this.extraSpeed = 1;
				}
			}
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
		 		ItemStack droppedFish = new ItemStack(FantasticItems.mediumFish, 1);
		 		int damage = 1;
		 		if(this.getRenderSize() == 0.25F)
		 		{
		 			droppedFish = new ItemStack(FantasticItems.tinyFish, 1);
		 			damage = 1;
		 		}
		 		if(this.getRenderSize() == 0.5F)
		 		{
		 			droppedFish = new ItemStack(FantasticItems.smallFish, 1);
		 			damage = 2;
		 		}
		 		if(this.getRenderSize() == 0.8F)
		 		{
		 			droppedFish = new ItemStack(FantasticItems.mediumFish, 1);
		 			damage = 3;
		 		}
		 		if(this.getRenderSize() == 1.0F)
		 		{
		 			droppedFish = new ItemStack(FantasticItems.bigFish, 1);
		 			damage = 4;
		 		}
		 		if(this.getRenderSize() == 1.3F)
		 		{
		 			droppedFish = new ItemStack(FantasticItems.largeFish, 1);
		 			damage = 5;
		 		}
		 		if(this.getRenderSize() == 1.8F)
		 		{
		 			droppedFish = new ItemStack(FantasticItems.legendaryFish, 1);
		 			damage = 6;
		 		}
		 		
		 		droppedFish.setItemDamage(5);
		 		if(this.hasCustomNameTag())
		 		{
			 		droppedFish.setItemName(this.getCustomNameTag());
		 		}
		 		EntityItem entityitem = new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, droppedFish);
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
	 
	 
	 @SideOnly(Side.CLIENT)
	    public int getBrightnessForRender(float par1)
	    {
	        return 15728880;
	    }

	    /**
	     * Gets how bright this entity is.
	     */
	    public float getBrightness(float par1)
	    {
	        return 1.0F;
	    }
	    
	    
	    /**
	     * Determines if an entity can be despawned, used on idle far away entities
	     */
	    protected boolean canDespawn()
	    {
	        return this.hasCustomNameTag() ? false : true;
	    }
}
