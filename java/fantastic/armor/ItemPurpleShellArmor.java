package fantastic.armor;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.FantasticMod;
import fantastic.Names;
import fantastic.items.FantasticItems;

public class ItemPurpleShellArmor extends ItemArmor 
{

	public ItemPurpleShellArmor(ArmorMaterial par2, int par3, int par4) 
	{
		super(par2, par3, par4);
		this.setCreativeTab(FantasticItems.tabFantastic);
		if (par4 == 0) 
		{
			this.setTextureName(FantasticInfo.ID + ":shellhelmet_purple");
		}
		if (par4 == 1) 
		{
			this.setTextureName(FantasticInfo.ID + ":shellarmor_purple");
		}
		else if (par4 == 2) 
		{
			this.setTextureName(FantasticInfo.ID + ":shellbottom_purple");
		}
		else if (par4 == 3) 
		{
			this.setTextureName(FantasticInfo.ID + ":shellboots_purple");
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1RegisterIcon)
	{
		if (this == FantasticArmor.purpleShellHelm) 
		{
		this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":shellhelmet_purple"); // You can also replace blockID and blockIcon with this and itemIcon
		}
		if 
		(this == FantasticArmor.purpleShellChest) 
		{
			this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":shellarmor_purple"); // You can also replace blockID and blockIcon with this and itemIcon
			}

			if (this == FantasticArmor.purpleShellLegs) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":shellbottom_purple"); // You can also replace blockID and blockIcon with this and itemIcon
			}

			if (this == FantasticArmor.purpleShellBoots) 
			{
			this.itemIcon = par1RegisterIcon.registerIcon(FantasticInfo.ID.toLowerCase() + ":shellboots_purple"); // You can also replace blockID and blockIcon with this and itemIcon
			}

			
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String layer) 
	{
			if (
			 stack.getItem() == FantasticArmor.purpleShellChest
			|| stack.getItem() == FantasticArmor.purpleShellBoots 
			|| stack.getItem() == FantasticArmor.purpleShellHelm) {
				return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/purple_shell_1.png";
			}
			if (stack.getItem() == FantasticArmor.purpleShellLegs) 
			{
				return FantasticInfo.ID.toLowerCase() + ":textures/models/armor/purple_shell_2.png";
			} 
			else 
			{
				return null;
			}

		}

	

	
}