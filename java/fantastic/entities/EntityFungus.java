package fantastic.entities;

import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import fantastic.FantasticInfo;
import fantastic.items.FantasticItems;

public class EntityFungus extends EntityFantasticFish
{
	//Textures
	private static final ResourceLocation texture1 = new ResourceLocation(FantasticInfo.ID.toLowerCase() + ":textures/models/mobs/fungus_fish.png");
	
	
	//CONSTRUCTOR
	public EntityFungus(World aWorld)
	{
		super(aWorld);
		InitializeAI();
	}

	//CONSTRUCTOR
	public EntityFungus(World aWorld, FishSize aSize, int aTextureIndex, int isOutOfWater)
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
			case Tiny : return 1.0F;
			case Small : return 0.8F;
			case Medium : return 0.7F;
			case Big : return 0.6F;
			case Large : return 0.5F;
			case Legendary : return 0.4F;
			default: return 1.0F; 
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
    public void moveEntityWithHeading(float p_70612_1_, float p_70612_2_)
    {
    	this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    @Override
	public float GetRenderValueFromSize()
	{
		switch (GetFishSize())
		{
			case Tiny : return 0.20F;
			case Small : return 0.50F;
			case Medium : return 0.75F;
			case Big : return 1F;
			case Large : return 1.1F;
			case Legendary : return 1.4F;
			default: return 0.20F; 
		}
	}
    
    /*@Override
    public float GetRenderDropDownFromSide()
    {
		switch (GetFishSize())
		{
			case Legendary : return 0.2F;
			default: return 0F; 
		}   
    }*/
	
	public EnumCreatureAttribute getCreatureAttribute()
	{
		return EnumCreatureAttribute.UNDEFINED;
	}
	
	public ResourceLocation GetTexture()
	{
		
		return texture1;
	
	}
	
	public static int GetNumberOfTextures()
	{
		return 2;
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
		this.entityDropItem(new ItemStack(FantasticItems.rawSalmonFillet, 1 + rand.nextInt(this.getNumberOfItemDroppedFromSize())), 0.0F);
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
			case Small: return 1;
			case Medium: return 2;
			case Big: return 3;
			case Large: return 4;
			case Legendary: return 6;
			default : return 1;
		}
	}
	
	private void InitializeAI()
	{
        this.getNavigator().setAvoidsWater(false);
		this.getNavigator().setCanSwim(true);
        this.tasks.taskEntries.clear();
        

	}

	    
}
