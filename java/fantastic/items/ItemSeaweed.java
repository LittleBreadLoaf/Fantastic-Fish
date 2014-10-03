package fantastic.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.Names;
import fantastic.blocks.FantasticBlocks;

public class ItemSeaweed extends Item
{
    /** The ID of the block the reed will spawn when used from inventory bar. */

    public ItemSeaweed(Block par2Block)
    {
        super();
        this.setCreativeTab(FantasticItems.tabFantastic);
		this.setUnlocalizedName(Names.Seaweed_UnlocalizedName);
    }
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister icon)
	{
		itemIcon = icon.registerIcon(FantasticInfo.ID.toLowerCase() + ":" + Names.Seaweed_UnlocalizedName);
	}
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        Block i1 = par3World.getBlock(par4, par5, par6);

        if (i1 == Blocks.snow && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
        {
            par7 = 1;
        }
        else if (i1 != Blocks.vine && i1 != Blocks.tallgrass && i1 != Blocks.deadbush)
        {
            if (par7 == 0)
            {
                --par5;
            }

            if (par7 == 1)
            {
                ++par5;
            }

            if (par7 == 2)
            {
                --par6;
            }

            if (par7 == 3)
            {
                ++par6;
            }

            if (par7 == 4)
            {
                --par4;
            }

            if (par7 == 5)
            {
                ++par4;
            }
        }

        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
        {
            return false;
        }
        else if (par1ItemStack.stackSize == 0)
        {
            return false;
        }
        else
        {
            if (par3World.canPlaceEntityOnSide(FantasticBlocks.plantSeaweed, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
            {
                Block block = FantasticBlocks.plantSeaweed;
                int j1 = block.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
                if(par3World.getBlock(par4, par5+1, par6) == Blocks.water)
                {
                if (par3World.setBlock(par4, par5, par6, FantasticBlocks.plantSeaweed, j1, 3))
                {
                    if (par3World.getBlock(par4, par5, par6) == FantasticBlocks.plantSeaweed)
                    {
                        FantasticBlocks.plantSeaweed.onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
                        FantasticBlocks.plantSeaweed.onPostBlockPlaced(par3World, par4, par5, par6, j1);
                    }

                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), block.stepSound.getBreakSound(), (block.stepSound.getVolume() + 1.0F) / 2.0F, block.stepSound.getPitch() * 0.8F);
                    --par1ItemStack.stackSize;
                }
            }
            }

            return true;
        }
    }
}
