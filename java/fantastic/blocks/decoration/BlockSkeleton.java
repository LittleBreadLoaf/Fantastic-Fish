package fantastic.blocks.decoration;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fantastic.FantasticIds;
import fantastic.FantasticInfo;
import fantastic.items.FantasticItems;

public class BlockSkeleton extends BlockContainer
{

	private float rotation;
	public BlockSkeleton(Material material)
	{
		super(material);

		this.setBlockTextureName("skeleton_item");
		this.setBlockName(FantasticInfo.ID + ":skeleton_1");
		this.setHardness(3F);
		this.setResistance(3F);
		this.setCreativeTab(FantasticItems.tabFantastic);
		this.setStepSound(Block.soundTypeWood);
	}

	 public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
	        return null;
	    }
	 
	 
	@Override
	public int getRenderType()
	{
		return FantasticIds.skeletonRenderingID;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	 /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
    	
    	if(world.getTileEntity(x, y, z) != null && world.getTileEntity(x,  y, z) instanceof TileSkeletonBlock)
    	{
    		((TileSkeletonBlock)world.getTileEntity(x, y, z)).setRotation(-player.rotationYaw);
    	}
        return false;
    }
    
	/**
	 * Called when the block is placed in the world.
	 */
	@Override
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLivingBase entity, ItemStack ItemStack)
	{
		this.rotation = entity.rotationYaw;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int metadata)
	{
        TileSkeletonBlock Skelly = new TileSkeletonBlock();
        Skelly.setRotation(-rotation);
		return Skelly;
		
	}
}