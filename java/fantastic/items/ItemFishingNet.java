package fantastic.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;

public class ItemFishingNet extends Item 
{
	 public final int itemUseDuration;
		public ItemFishingNet()
		{
			super();
			this.setCreativeTab(FantasticItems.tabFantastic);
			this.setUnlocalizedName(Names.FishingNet_UnlocalizedName);
			this.itemUseDuration = 32;
	        this.setMaxDamage(64);
	        this.setMaxStackSize(1);


		}

		@Override
		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister icon)
		{
			itemIcon = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.FishingNet_UnlocalizedName);
		}

		public int getMaxItemUseDuration(ItemStack par1ItemStack)
	    {
	        return 32;
	    }

		public EnumAction getItemUseAction(ItemStack par1ItemStack)
		{
			return EnumAction.eat;
		}
		   /**
	     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	     */
		@Override
	    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	    {
			par3EntityPlayer.swingItem();
	        return par1ItemStack;
	    }

		  @SideOnly(Side.CLIENT)

		    /**
		     * Returns True is the item is renderer in full 3D when hold.
		     */
		    public boolean isFull3D()
		    {
		        return true;
		    }
	    
		public ItemStack onEaten(ItemStack itemstack, World world, EntityPlayer player)
		{
			return itemstack;
		}
}