package fantastic.items;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityCatfish;
import fantastic.entities.EntityCaveFish;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityHarpoon;
import fantastic.entities.EntityMantaRay;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntityNurseShark;
import fantastic.entities.EntitySailfish;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntityTuna;

public class ItemHarpoon extends Item
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	private Random rand = new Random();
	
	public EntityHarpoon theHarpoon;
	private static final String[] ICON = Names.Harpoon_UnlocalizedName;

	public ItemHarpoon()
	{
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(FantasticItems.tabFantastic);
		this.setHasSubtypes(true);
		this.setMaxDamage(41);

	}



	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return itemstack.getItemDamage()%2 == 0 ? Names.Harpoon_UnlocalizedName[0] : Names.Harpoon_UnlocalizedName[1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{

		return damage%2 == 0 ? icons[0] : icons[1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		icons = new IIcon[ICON.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + ICON[i]);
		}
	}

	

	@Override
    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		
        	par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
		
		return par1ItemStack;
		
	}
	
	
	@Override
	 /**
    * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
    * update it's contents.
    */
   public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
	{
		if(par3Entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)par3Entity;
			if(player.getCurrentEquippedItem() != par1ItemStack)
			{
				if(par1ItemStack.getItemDamage()%2 != 0)
					 if(par1ItemStack.getItemDamage() < 41)

	                     par1ItemStack.attemptDamageItem(1, rand);
					 else
					 {
						 if(theHarpoon != null)
							 theHarpoon.setDead();
						 par1ItemStack.stackSize--;
					 }
					
				if(this.theHarpoon != null)
				{
					
					this.theHarpoon.setDead();
					this.theHarpoon.angler = null;
					this.theHarpoon = null;
				}
			}
			
			
		}
		
	}
	
	@Override
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 72000;
    }

    
	@Override
    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
	
	@Override
    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return par1ItemStack;
    }


	
	
	
	
	
	
	@Override
    /**
     * called when the player releases the use item button. Args: itemstack, world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4)
    {
        int j = this.getMaxItemUseDuration(par1ItemStack) - par4;


        if(par1ItemStack.getItemDamage()%2 == 0)
        {
        	ArrowLooseEvent event = new ArrowLooseEvent(par3EntityPlayer, par1ItemStack, j);
        	MinecraftForge.EVENT_BUS.post(event);
        	if (event.isCanceled())
        	{
        		return;
        	}
        	j = event.charge;

        	boolean flag = par3EntityPlayer.capabilities.isCreativeMode;
        		float f = (float)j / 20.0F;
        		f = (f * f + f * 2.0F) / 3.0F;
        		
        		if ((double)f < 0.1D)
        		{
        			return;
        		}

        		if (f > 1.0F)
        		{
        			f = 1.0F;
        		}	


  				EntityHarpoon harpoon = new EntityHarpoon(par2World, par3EntityPlayer, 1.5F);
              if (f == 1.0F)
              {
                 
                  if(!par2World.isRemote)
                  
                      par2World.spawnEntityInWorld(harpoon);
                  
                  if(par1ItemStack.getItemDamage() < 41)

	                     par1ItemStack.attemptDamageItem(1, rand);
                  else
 				 {
 					 if(theHarpoon != null)
 						 theHarpoon.setDead();
 					 par1ItemStack.stackSize--;
 				 }
                  
    				this.theHarpoon = harpoon;
              }

        			
        	}
        	else
        	{
        		boolean flag = par3EntityPlayer.capabilities.isCreativeMode;
        		float f = (float)j / 20.0F;
        		f = (f * f + f * 2.0F) / 3.0F;
        		
        		

        		if (f > 2.0F)
        		{
        			f = 2.0F;
        		}
        		
        		if(theHarpoon != null)
        		{
        			if(theHarpoon.ridingEntity != null && theHarpoon.ridingEntity instanceof EntityLiving)
        			{
        				double moveX = (theHarpoon.ridingEntity.posX - par3EntityPlayer.posX);
        				double moveY = (theHarpoon.ridingEntity.posY - par3EntityPlayer.posY);
        				double moveZ = (theHarpoon.ridingEntity.posZ - par3EntityPlayer.posZ);
        				double angle = Math.atan2(moveZ, moveX);
        				
        				if(theHarpoon.ridingEntity.isInsideOfMaterial(Material.water))
        					f +=2.0;
        				moveX = -f * (Math.cos(angle));
        				moveZ = -f * (Math.sin(angle));
        				moveY = f  * 0.3F;
        				theHarpoon.ridingEntity.addVelocity(moveX, moveY, moveZ);
        				
        				
        				theHarpoon.ridingEntity = null;
        				
        				
        			}
        			this.theHarpoon.setDead();
					this.theHarpoon.angler = null;
					this.theHarpoon = null;
        		}
        		if(par1ItemStack.getItemDamage() < 41)

                    par1ItemStack.attemptDamageItem(1, rand);
				 else
				 {
					 if(theHarpoon != null)
						 theHarpoon.setDead();
					 par1ItemStack.stackSize--;
				 }
                 
        	}
             
    }



	  



}
