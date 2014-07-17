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

public class ItemPearl extends Item
{


	public ItemPearl(int id)
	{
		super(id);
		this.maxStackSize = 64;
		this.setCreativeTab(FantasticItems.tabFantastic);
		this.setUnlocalizedName(Names.Pearl_UnlocalizedName);

	}



	

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister icon)
	{
		
		this.itemIcon = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.Pearl_UnlocalizedName);
		
	}

	
}
