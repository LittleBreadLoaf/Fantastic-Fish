package fantastic.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.Names;

public class ItemWoodenRod extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon theIcon;

    public ItemWoodenRod()
    {
        super();
        this.setMaxDamage(64);
        this.setMaxStackSize(1);
        this.setCreativeTab(FantasticItems.tabFantastic);
        this.setHasSubtypes(true);
        this.setTextureName("legit_rod");
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns True is the item is renderer in full 3D when hold.
     */
    public boolean isFull3D()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
     * hands.
     */
    public boolean shouldRotateAroundWhenRendering()
    {
        return true;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.fishEntity != null)
        {
            int i = par3EntityPlayer.fishEntity.func_146034_e();
            par1ItemStack.damageItem(i, par3EntityPlayer);
            par3EntityPlayer.swingItem();
        }
        else
        {
            par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

            if (!par2World.isRemote)
            {
            	EntityFishHook hook = new EntityFishHook(par2World, par3EntityPlayer);
            	hook.field_146042_b = par3EntityPlayer;
                par2World.spawnEntityInWorld(hook);
            }

            par3EntityPlayer.swingItem();
        }

        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon("fantastic:" + this.iconString + "_uncast");
        this.theIcon = par1IconRegister.registerIcon("fantastic:" + this.iconString + "_cast");
        		
    }
    
    @Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.Wooden_Rod_UnlocalizedName[itemstack.getItemDamage()];
	}

    @SideOnly(Side.CLIENT)
    public IIcon func_94597_g()
    {
        return this.theIcon;
    }
}
