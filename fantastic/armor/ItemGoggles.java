package fantastic.armor;


import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;
import fantastic.items.FantasticItems;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGoggles extends ItemArmor 
{

	public ItemGoggles(int par1, EnumArmorMaterial par2, int par3, int par4) 
	{
		super(par1, par2, par3, par4);
		this.setUnlocalizedName(Names.Goggles_UnlocalizedName);
		this.setCreativeTab(FantasticItems.tabFantastic);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister par1RegisterIcon)
	{
		this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.Goggles_UnlocalizedName);
	}


	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer)
	{
		return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/scuba_1.png";
	}

	  /**
     * Called when item is crafted/smelted. Used only by maps so far.
     */
    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par1ItemStack.addEnchantment(Enchantment.respiration, 3);
    }
    
    

    /**
     * Called each tick as long the item is on a player inventory. Uses by maps to check if is on a player hand and
     * update it's contents.
     */
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) 
    {
    	if(!par1ItemStack.isItemEnchanted())
    	{
    		par1ItemStack.addEnchantment(Enchantment.respiration, 3);
    	}
    }
    



}