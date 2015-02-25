package fantastic.entities;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import fantastic.FantasticDebug;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.entities.AI.EntityFFAI.AIState;
import fantastic.entities.AI.EntityFFAI;
import fantastic.entities.AI.FFAI_SwimAwayFromBiggerFish;
import fantastic.entities.AI.FFAI_SwimAwayFromPlayer;
import fantastic.entities.AI.FFAI_SwimChaseSmallerFish;
import fantastic.entities.AI.FFAI_SwimJumpForFlies;
import fantastic.entities.AI.FFAI_SwimStayStill;
import fantastic.entities.AI.FFAI_SwimWanderFullRandom;
import fantastic.entities.AI.FFAI_SwimWanderLikeSurface;
import fantastic.entities.AI.FishMovementHelper;
import fantastic.items.FantasticItems;

public class EntitySailfish extends EntityFantasticFish
{
	//Textures
	private final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/sailfish.png");

	
	//CONSTRUCTOR
	public EntitySailfish(World aWorld)
	{
		super(aWorld);
		brain=new EntityFFAI(this,1000,3000);
		InitializeAI();
	}

	//CONSTRUCTOR
	public EntitySailfish(World aWorld, FishSize aSize, int aTextureIndex, int isOutOfWater)
	{
		this(aWorld);
		InitializeFish(aSize,aTextureIndex,isOutOfWater);
	}
	
	//*** PUBLIC METHOD ***
	@Override
	public void InitializeFish(FishSize aSize, int aTextureIndex, int isOutOfWater)
	{
		SetFishSize(aSize);
		SetTextureIndex(aTextureIndex);
		SetIsOutOfWater(isOutOfWater);
		this.ignoreFrustumCheck = true;
		SetHasNotSpawned(false);
		this.setSize(1.0F, 1.0F);
	}
	
	//This property tells if the class has different size of fish for the same class. By default, it return false. 
	//Override that methof if the class has multiple size.
	@Override
	public boolean GetHasDifferentSize()
	{
		return true;
	}
	
	@Override
	public float GetTailFlapSpeed()
	{
		

		//return 0.5F;
			switch (GetFishSize())
			{
				
				case Tiny : return (float) (1.1F+currentSpeed);
				case Small : return (float) (0.9F+currentSpeed);
				case Medium : return (float) (0.8F+currentSpeed);
				case Big : return (float) (0.7F+currentSpeed);
				case Large : return (float) (0.6F+currentSpeed);
				case Legendary : return (float) (0.5F+currentSpeed);
				default: return 1.1F; 


			}
	}
	
	
	@Override
	public void onDeath(DamageSource par1DamageSource)
	{
		super.onDeath(par1DamageSource);

	}
	
	@Override
	public boolean canBeCollidedWith()
	{
		return true;
		
	}
	


    @Override
	public float GetRenderValueFromSize()
	{
		switch (GetFishSize())
		{
			case Tiny : return 0.40F;
			case Small : return 0.6F;
			case Medium : return 0.8F;
			case Big : return 1.0F;
			case Large : return 1.2F;
			case Legendary : return 2.0F;
			default: return 0.5F; 
		}
	}
    
    @Override
    public float GetSpeedFromAIState(AIState aState)
    {
    	if (aState==AIState.Idle)
    	{
    		return 0;
    	}

    	
    	if (aState==AIState.StayStill)
    	{
    		return 0;
    	}
    	
    	if (aState==AIState.Wander)
    	{
    		return 3;
    	}

    	if (aState==AIState.Fleeing)
    	{
    		return 6;
    	}
    	
    	if (aState==AIState.Jump)
    	{
    		return 6;
    	}
    	
    	if (aState==AIState.Pursuing)
    	{
    		return 6;
    	}

    	
    	//default
    	return 0;
    	
    }
    

    
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	public ResourceLocation GetTexture()
	{
		switch (GetTextureIndex())
		{
			case 1: return texture1;
			default: return texture1;
		}
		
	}
	
	public static int GetNumberOfTextures()
	{
		return 1;
	}
	
    @Override
	public double PositionSizeAdjust()
    {
		switch (GetFishSize())
		{
			case Tiny : return 0;
			case Small : return 0;
			case Medium : return 0;
			case Big : return 1;
			case Large : return 2;
			case Legendary : return 2;
			default: return 0; 
		}
    }
    
    
    //Must be override. Will determine what is the minimum depth for the fish to swim in an area. Bigger fish will avoid shallow water.
    @Override
    public int GetMinimumDepth()
    {

    	switch (this.currentSize)
    	{
	    	case Tiny: return 4;
	    	case Small: return 4;
	    	case Medium: return 5;
	    	case Big: return 6;
	    	case Large: return 6;
	    	case Legendary: return 6;
	    	default: return 6;
        }
    }
	
	//*** PROTECTED METHOD ***
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(15.0D );
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(10);
	}

	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		super.dropFewItems(par1, par2);
		this.entityDropItem(new ItemStack(FantasticItems.rawSailfishDarne, 1 + rand.nextInt(this.getNumberOfItemDroppedFromSize())), 0.0F);
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

	protected boolean canDespawn()
	{
	    return this.hasCustomNameTag() ? false : true;
	}

	
	//*** PRIVATE METHOD ***
	private int getNumberOfItemDroppedFromSize()
	{
		switch (this.GetFishSize())
		{
			case Tiny: return 1;
			case Small: return 2;
			case Medium: return 4;
			case Big: return 6;
			case Large: return 8;
			case Legendary: return 10;
			default : return 1;
		}
	}
	
	private void InitializeAI()
	{
        this.getNavigator().setAvoidsWater(false);
		this.getNavigator().setCanSwim(true);
        this.tasks.taskEntries.clear();
        
        //brain.AddActionToList(new FFAI_SwimAwayFromPlayer(brain, this, 0,EntityPlayer.class,6));
        //brain.AddActionToList(new FFAI_SwimAwayFromBiggerFish(brain, this, 1,EntityFantasticFish.class,3));
        brain.AddActionToList(new FFAI_SwimWanderLikeSurface(brain,this,3,100,12,1,8));



        
	}

	    
}
