package fantastic.items;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.passive.EntitySquid;
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

public class ItemSquid extends Item
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	private static final String[] ICON = Names.Lobster_UnlocalizedName;

	public ItemSquid()
	{
		super();
		this.maxStackSize = 1;
		this.setCreativeTab(FantasticItems.tabFish);
		this.setUnlocalizedName(Names.Squid_UnlocalizedName);

	}




	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		
		this.itemIcon = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.Squid_UnlocalizedName);
		
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
            
            	EntitySquid Squid = new EntitySquid(par3World);
            	Squid.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + d0, (double)par6 + 0.5D, 0, 0);
    			par3World.spawnEntityInWorld(Squid);
    			
                if (Squid != null)
                {
                    if (par1ItemStack.hasDisplayName())
                    {
                        Squid.setCustomNameTag(par1ItemStack.getDisplayName());
                    }

                    if (!par2EntityPlayer.capabilities.isCreativeMode)
                    {
                        --par1ItemStack.stackSize;
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
                    	
                        EntitySquid Squid = new EntitySquid(par2World);
            			Squid.setLocationAndAngles((double)i, (double)j, (double)k, 0, 0);
            			par2World.spawnEntityInWorld(Squid);
                        if (Squid != null)
                        {
                            if (par1ItemStack.hasDisplayName())
                            {
                                Squid.setCustomNameTag(par1ItemStack.getDisplayName());
                            }

                            if (!par3EntityPlayer.capabilities.isCreativeMode)
                            {
                                --par1ItemStack.stackSize;
                            }
                        }
                    	
                        
                       
                    }
                }

                return par1ItemStack;
            }
        }
    }


}
