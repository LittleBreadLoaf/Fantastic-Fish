package fantastic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticInfo;
import fantastic.items.FantasticItems;

public class BlockAquariumGlass extends Block
{
	
    /** Set this to allow trapdoors to remain free-floating */
    private static final String __OBFID = "CL_00000327";

    protected BlockAquariumGlass(Material p_i45434_1_)
    {
        super(p_i45434_1_);
        float f = 0.5F;
        float f1 = 1.0F;
		setBlockName("fantastic:aqua_glass");
        this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
        this.setCreativeTab(FantasticItems.tabFantastic);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 0;
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
        return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        this.func_150117_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
    }

    /**
     * Sets the block's bounds for rendering it as an item
     */
    public void setBlockBoundsForItemRender()
    {
        float f = 0.1875F;
        this.setBlockBounds(0.0F, 0.5F - f / 2.0F, 0.0F, 1.0F, 0.5F + f / 2.0F, 1.0F);
    }

    public void func_150117_b(int p_150117_1_)
    {
        float f = 0.1875F;

        if ((p_150117_1_ & 8) != 0)
        {
            this.setBlockBounds(0.0F, 1.0F - f, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        else
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
        }

        if (func_150118_d(p_150117_1_))
        {
            if ((p_150117_1_ & 3) == 0)
            {
                this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
            }

            if ((p_150117_1_ & 3) == 1)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
            }

            if ((p_150117_1_ & 3) == 2)
            {
                this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }

            if ((p_150117_1_ & 3) == 3)
            {
                this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
            }
        }
    }

    /**
     * Called when a player hits the block. Args: world, x, y, z, player
     */
    public void onBlockClicked(World p_149699_1_, int p_149699_2_, int p_149699_3_, int p_149699_4_, EntityPlayer p_149699_5_) {}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (this.blockMaterial == Material.iron)
        {
            return true;
        }
        else
        {
        	return true;
        }
    }

  

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        if (!p_149695_1_.isRemote)
        {
            int l = p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_);
            int i1 = p_149695_2_;
            int j1 = p_149695_4_;

            if ((l & 3) == 0)
            {
                j1 = p_149695_4_ + 1;
            }

            if ((l & 3) == 1)
            {
                --j1;
            }

            if ((l & 3) == 2)
            {
                i1 = p_149695_2_ + 1;
            }

            if ((l & 3) == 3)
            {
                --i1;
            }



          
        }
    }

    /**
     * Ray traces through the blocks collision from start vector to end vector returning a ray trace hit. Args: world,
     * x, y, z, startVec, endVec
     */
    public MovingObjectPosition collisionRayTrace(World p_149731_1_, int p_149731_2_, int p_149731_3_, int p_149731_4_, Vec3 p_149731_5_, Vec3 p_149731_6_)
    {
        this.setBlockBoundsBasedOnState(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_);
        return super.collisionRayTrace(p_149731_1_, p_149731_2_, p_149731_3_, p_149731_4_, p_149731_5_, p_149731_6_);
    }

    @Override
    public boolean isSideSolid(IBlockAccess world, int x, int y, int z, ForgeDirection side)
    {
        int meta = world.getBlockMetadata(x, y, z);
        
        return true;
        
    }
    
    
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        int j1 = 0;
       
        
     	   
     	
        
        if(p_149660_6_ == 1.0F)
        {
        	if((p_149660_7_ + p_149660_8_ < 1.2) && (p_149660_7_ + p_149660_8_ > 0.8))
        		return 7;
        	if(p_149660_8_ < p_149660_7_ && p_149660_8_ < 0.3)
        		return 5;
        	if(p_149660_8_ > p_149660_7_ && p_149660_8_ > 0.7)
        		return 4;
        	if(p_149660_7_ < p_149660_8_ && p_149660_7_ < 0.3)
        		return 0;
        	if(p_149660_7_ > p_149660_8_ && p_149660_7_ > 0.7)
        		return 11;
        }
        if(p_149660_6_ == 0.0F)
        {
        	if((p_149660_7_ + p_149660_8_ < 1.2) && (p_149660_7_ + p_149660_8_ > 0.8))
        		return 6;
        	if(p_149660_8_ < p_149660_7_ && p_149660_8_ < 0.3)
        		return 5;
        	if(p_149660_8_ > p_149660_7_ && p_149660_8_ > 0.7)
        		return 4;
        	if(p_149660_7_ < p_149660_8_ && p_149660_7_ < 0.3)
        		return 0;
        	if(p_149660_7_ > p_149660_8_ && p_149660_7_ > 0.7)
        		return 11;
        }
        if(p_149660_8_ == 1.0F)
        {
        	if((p_149660_7_ + p_149660_6_ < 1.2) && (p_149660_7_ + p_149660_6_ > 0.8))
        		return 5;
        	if(p_149660_6_ < p_149660_7_ && p_149660_6_ < 0.3)
        		return 7;
        	if(p_149660_6_ > p_149660_7_ && p_149660_6_ > 0.7)
        		return 6;
        	if(p_149660_7_ < p_149660_8_ && p_149660_7_ < 0.3)
        		return 0;
        	if(p_149660_7_ > p_149660_8_ && p_149660_7_ > 0.7)
        		return 11;
        }
        if(p_149660_8_ == 0.0F)
        {
        	if((p_149660_7_ + p_149660_6_ < 1.2) && (p_149660_7_ + p_149660_6_ > 0.8))
        		return 4;
        	if(p_149660_6_ < p_149660_7_ && p_149660_6_ < 0.3)
        		return 7;
        	if(p_149660_6_ > p_149660_7_ && p_149660_6_ > 0.7)
        		return 6;
        	if(p_149660_7_ < p_149660_8_ && p_149660_7_ < 0.3)
        		return 0;
        	if(p_149660_7_ > p_149660_8_ && p_149660_7_ > 0.7)
        		return 11;
        }     
        if(p_149660_7_ == 1.0F)
        {
        	if((p_149660_6_ + p_149660_8_ < 1.2) && (p_149660_6_ + p_149660_8_ > 0.8))
            {
        		return 0;
            }
        	if(p_149660_8_ < p_149660_6_ && p_149660_8_ < 0.3)
        		return 5;
        	if(p_149660_8_ > p_149660_6_ && p_149660_8_ > 0.7)
        		return 4;
        	if(p_149660_6_ < p_149660_8_ && p_149660_6_ < 0.3)
        		return 7;
        	if(p_149660_6_ > p_149660_8_ && p_149660_6_ > 0.7)
        		return 6;
        }
        if(p_149660_7_ == 0.0F)
        {
        	if((p_149660_6_ + p_149660_8_ < 1.2) && (p_149660_6_ + p_149660_8_ > 0.8))
        		return 11;
        	if(p_149660_8_ < p_149660_6_ && p_149660_8_ < 0.3)
        		return 5;
        	if(p_149660_8_ > p_149660_6_ && p_149660_8_ > 0.7)
        		return 4;
        	if(p_149660_6_ < p_149660_8_ && p_149660_6_ < 0.3)
        		return 7;
        	if(p_149660_6_ > p_149660_8_ && p_149660_6_ > 0.7)
        		return 6;  
        }
       
        return j1;
    }

    @Override
    /**
     * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
     */
    public boolean canPlaceBlockOnSide(World p_149707_1_, int p_149707_2_, int p_149707_3_, int p_149707_4_, int p_149707_5_)
    {
       
            return true;
 
    }
    
    @Override
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
    	return true;
    }

    public static boolean func_150118_d(int p_150118_0_)
    {
        return (p_150118_0_ & 4) != 0;
    }

    
}