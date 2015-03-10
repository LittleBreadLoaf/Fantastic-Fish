/*package fantastic.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;
import fantastic.entities.EntityFantasticFish.FishSize;
import fantastic.entities.EntityMantaRay;
import fantastic.entities.EntityNurseShark;
import fantastic.entities.EntitySailfish;

public class ItemRandomFish extends Item
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	private static final String[] ICON = Names.RandomFish_UnlocalizedName;

	public ItemRandomFish()
	{
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(FantasticItems.tabFish);
		this.setHasSubtypes(true);

	}



	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.RandomFish_UnlocalizedName[itemstack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage)
	{
		return icons[damage];
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


    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (par3World.isRemote)
        {
            return true;
        }
        else
        {
        	  Block i1 = par3World.getBlock(par4, par5, par6);
              par4 += Facing.offsetsXForSide[par7];
              par5 += Facing.offsetsYForSide[par7];
              par6 += Facing.offsetsZForSide[par7];
              double d0 = 0.0D;

              if (par7 == 1 && i1 != null && i1.getRenderType() == 11)
              {
                  d0 = 0.5D;
              }

            if(par1ItemStack.getItemDamage() == 0)
            {
            	EntitySailfish Fish = new EntitySailfish(par3World);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
            	//Fish.setRenderSize(1.0F);
            	//Fish.setHasNotSpawned(false);
            	par3World.spawnEntityInWorld(Fish);
	
            	if (Fish != null)
            	{
            		if (par1ItemStack.hasDisplayName())
            		{
            			Fish.setCustomNameTag(par1ItemStack.getDisplayName());
            		}

            		if (!par2EntityPlayer.capabilities.isCreativeMode)
            		{
            			--par1ItemStack.stackSize;
            		}
            	}
            }
            else if(par1ItemStack.getItemDamage() > 0 && par1ItemStack.getItemDamage() < 4)
            {
            	EntityNurseShark Fish = new EntityNurseShark(par3World, FishSize.Big,0,0);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
            	//Fish.setRenderSize(1.0F);
            	//Fish.setHasNotSpawned(false);
            	par3World.spawnEntityInWorld(Fish);
	
            	if (Fish != null)
            	{
            		if (par1ItemStack.hasDisplayName())
            		{
            			Fish.setCustomNameTag(par1ItemStack.getDisplayName());
            		}

            		if (!par2EntityPlayer.capabilities.isCreativeMode)
            		{
            			--par1ItemStack.stackSize;
            		}
            	}
            }
          
            else  if(par1ItemStack.getItemDamage() == 4)
            {
            	EntityMantaRay Fish = new EntityMantaRay(par3World);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
            	//Fish.setRenderSize(1.0F);
            	//Fish.setHasNotSpawned(false);
            	par3World.spawnEntityInWorld(Fish);
	
            	if (Fish != null)
            	{
            		if (par1ItemStack.hasDisplayName())
            		{
            			Fish.setCustomNameTag(par1ItemStack.getDisplayName());
            		}

            		if (!par2EntityPlayer.capabilities.isCreativeMode)
            		{
            			--par1ItemStack.stackSize;
            		}
            	}
            }

            return true;
        }
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par2World.isRemote)
        {
            return par1ItemStack;
        }
        else
        {
            MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(par2World, par3EntityPlayer, true);

            if (movingobjectposition == null)
            {
                return par1ItemStack;
            }
            else
            {
                if (movingobjectposition.typeOfHit == MovingObjectType.BLOCK)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!par2World.canMineBlock(par3EntityPlayer, i, j, k))
                    {
                        return par1ItemStack;
                    }

                    if (!par3EntityPlayer.canPlayerEdit(i, j, k, movingobjectposition.sideHit, par1ItemStack))
                    {
                        return par1ItemStack;
                    }

                    if (par2World.getBlock(i, j, k).getMaterial() == Material.water)
                    {

                    	if(par1ItemStack.getItemDamage() == 0)
                    	{
                    		EntitySailfish Fish = new EntitySailfish(par2World);
                    		Fish.setLocationAndAngles(i, j, k, 0, 0);
                    		//Fish.setRenderSize(1.0F);
                    		//Fish.setHasNotSpawned(false);
                    		par2World.spawnEntityInWorld(Fish);
	
                    		if (Fish != null)
                    		{
                    			if (par1ItemStack.hasDisplayName())
                    				{
                    				Fish.setCustomNameTag(par1ItemStack.getDisplayName());
                    				}

                    			if (!par3EntityPlayer.capabilities.isCreativeMode)
                    			{
                    				--par1ItemStack.stackSize;
                    			}
                    		}
                    	}	
                    	else if(par1ItemStack.getItemDamage() > 0 && par1ItemStack.getItemDamage() < 4)
                    	{
                    		EntityNurseShark Fish = new EntityNurseShark(par2World, FishSize.Big,0,0);
                    		Fish.setLocationAndAngles(i, j, k, 0, 0);
                    		//Fish.setRenderSize(1.0F);
                    		//Fish.setHasNotSpawned(false);
                    		par2World.spawnEntityInWorld(Fish);
	
                    		if (Fish != null)
                    		{
                    			if (par1ItemStack.hasDisplayName())
                    				{
                    				Fish.setCustomNameTag(par1ItemStack.getDisplayName());
                    				}

                    			if (!par3EntityPlayer.capabilities.isCreativeMode)
                    			{
                    				--par1ItemStack.stackSize;
                    			}
                    		}
                    	}	
                    	else if(par1ItemStack.getItemDamage() == 4)
                    	{
                    		EntityMantaRay Fish = new EntityMantaRay(par2World);
                    		Fish.setLocationAndAngles(i, j, k, 0, 0);
                    		//Fish.setRenderSize(1.0F);
                    		//Fish.setHasNotSpawned(false);
                    		par2World.spawnEntityInWorld(Fish);
	
                    		if (Fish != null)
                    		{
                    			if (par1ItemStack.hasDisplayName())
                    				{
                    				Fish.setCustomNameTag(par1ItemStack.getDisplayName());
                    				}

                    			if (!par3EntityPlayer.capabilities.isCreativeMode)
                    			{
                    				--par1ItemStack.stackSize;
                    			}
                    		}
                    	}	
                    }
                }

                return par1ItemStack;
            }
        }
    }

    
    @Override
	public void getSubItems(Item id, CreativeTabs tab, List list) 
	{
		for(int i = 0; i < icons.length; i++) 
		{
			ItemStack itemstack = new ItemStack(id, 1, i);
			list.add(itemstack);
		}
	}

}*/
