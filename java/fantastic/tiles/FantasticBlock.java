package fantastic.tiles;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.items.FantasticItems;

public class FantasticBlock extends Block
{

	public FantasticBlock()
	{
		super(Material.rock);
		this.setCreativeTab(FantasticItems.tabFantastic);
	}



	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister itemIcon)
	{
		this.blockIcon = itemIcon.registerIcon(FantasticInfo.ID + ":" + this.getUnlocalizedName().substring(5));
	}
}