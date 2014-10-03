package fantastic.items;

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
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityCatfish;
import fantastic.entities.EntityCaveFish;
import fantastic.entities.EntityFeeder;
import fantastic.entities.EntityFungus;
import fantastic.entities.EntityMossy;
import fantastic.entities.EntitySalmon;
import fantastic.entities.EntityTuna;

public class ItemSmallFish extends Item
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	private static final String[] ICON = Names.SmallFish_UnlocalizedName;

	public ItemSmallFish()
	{
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(FantasticItems.tabFish);
		this.setHasSubtypes(true);

	}



	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.SmallFish_UnlocalizedName[itemstack.getItemDamage()];
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
			icons[i] = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + ICON[i].substring(1));
		}
	}

	 /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
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

            if(par1ItemStack.getItemDamage() < 6)
            {
            	EntityBasicFish Fish = new EntityBasicFish(par3World, this.getDamage(par1ItemStack), 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 6)
            {
            	EntityCaveFish Fish = new EntityCaveFish(par3World, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
           
            else if(par1ItemStack.getItemDamage() == 7)
            {
            	EntityFeeder Fish = new EntityFeeder(par3World, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 8)
            {
            	EntityMossy Fish = new EntityMossy(par3World, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 9)
            {
            	EntityTuna Fish = new EntityTuna(par3World, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 10)
            {
            	EntityCatfish Fish = new EntityCatfish(par3World, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 11)
            {
            	EntitySalmon Fish = new EntitySalmon(par3World, 1, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 12)
            {
            	EntitySalmon Fish = new EntitySalmon(par3World, 1, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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
            else if(par1ItemStack.getItemDamage() == 13)
            {
            	EntityFungus Fish = new EntityFungus(par3World, 1);
            	Fish.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			Fish.setRenderSize(0.5F);
    			Fish.setHasNotSpawned(false);
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

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
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
                    	if(par1ItemStack.getItemDamage() < 6)
                    	{
                        EntityBasicFish Fish = new EntityBasicFish(par2World, this.getDamage(par1ItemStack), 1);
            			Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
            			Fish.setRenderSize(0.5F);
            			Fish.setHasNotSpawned(false);
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
                        
                        else if(par1ItemStack.getItemDamage() == 6)
                        {
                        	EntityCaveFish Fish = new EntityCaveFish(par2World, 1);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        
                        else if(par1ItemStack.getItemDamage() == 7)
                        {
                        	EntityFeeder Fish = new EntityFeeder(par2World, 1);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        else if(par1ItemStack.getItemDamage() == 8)
                        {
                        	EntityMossy Fish = new EntityMossy(par2World, 1);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        else if(par1ItemStack.getItemDamage() == 9)
                        {
                        	EntityTuna Fish = new EntityTuna(par2World, 3);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        else if(par1ItemStack.getItemDamage() == 10)
                        {
                        	EntityCatfish Fish = new EntityCatfish(par2World, 0);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        else if(par1ItemStack.getItemDamage() == 11)
                        {
                        	EntitySalmon Fish = new EntitySalmon(par2World, 1, 0);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        else if(par1ItemStack.getItemDamage() == 12)
                        {
                        	EntitySalmon Fish = new EntitySalmon(par2World, 1, 1);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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
                        else if(par1ItemStack.getItemDamage() == 13)
                        {
                        	EntityFungus Fish = new EntityFungus(par2World, 1);
                        	Fish.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
                			Fish.setRenderSize(0.5F);
                			Fish.setHasNotSpawned(false);
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

}
