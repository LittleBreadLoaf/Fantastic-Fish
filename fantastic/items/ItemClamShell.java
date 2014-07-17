package fantastic.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;
import fantastic.entities.EntityBasicFish;
import fantastic.entities.EntityCaveFish;

public class ItemClamShell extends Item
{
	@SideOnly(Side.CLIENT)
	public static Icon[] icons;

	private static final String[] ICON = Names.ClamShell_UnlocalizedName;

	public ItemClamShell(int id)
	{
		super(id);
		this.maxStackSize = 64;
		this.setCreativeTab(FantasticItems.tabFantastic);
		this.setHasSubtypes(true);

	}



	@Override
	public String getUnlocalizedName(ItemStack itemstack)
	{
		return Names.ClamShell_UnlocalizedName[itemstack.getItemDamage()];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamage(int damage)
	{
		return icons[damage];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		icons = new Icon[ICON.length];

		for (int i = 0; i < icons.length; i++)
		{
			icons[i] = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + ICON[i]);
		}
	}

	

	@Override
	public void getSubItems(int id, CreativeTabs tab, List list) 
	{
		for(int i = 0; i < icons.length; i++) 
		{
			ItemStack itemstack = new ItemStack(id, 1, i);
			list.add(itemstack);
		}
	}

}
