package fantastic.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;

public class ItemClamShell extends Item
{
	@SideOnly(Side.CLIENT)
	public static IIcon[] icons;

	private static final String[] ICON = Names.ClamShell_UnlocalizedName;

	public ItemClamShell()
	{
		super();
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
