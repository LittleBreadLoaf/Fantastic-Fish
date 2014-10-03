package fantastic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import fantastic.items.FantasticItems;


public class BlockTallSeaPlant extends Block {
	
	private Block[] acceptable = {
    		Blocks.sand, Blocks.gravel, Blocks.dirt
    };
	 
	 int maxHeight;
	 int phases;

	public BlockTallSeaPlant(Material material) {
		super(material);
		this.setCreativeTab(FantasticItems.tabFantastic);
        setTickRandomly(true);
        this.maxHeight = 5;
        this.phases = 16;
	}
	
	public BlockTallSeaPlant(Material material, int maxHeight) {
		super(material);
		setCreativeTab(FantasticItems.tabFantastic);
        setTickRandomly(true);
        this.maxHeight = maxHeight;
        this.phases = 16;
	}
	
	public BlockTallSeaPlant(Material material, int maxHeight, int phases) {
		super(material);
		setCreativeTab(FantasticItems.tabFantastic);
        setTickRandomly(true);
        this.maxHeight = maxHeight;
        this.phases = phases;
	}
	
	
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
        return null;
    }
	
	
	
	public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }
	
	@Override
	public boolean canBlockStay(World world, int x, int y, int z) 
	{
        return this.canPlaceBlockAt(world, x, y, z);
	}
	
	@Override
	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		Block block = world.getBlock(x, y - 1, z);
        return (block != null && acceptable(block));
    }
	
	boolean acceptable(Block block)
	{
		if(block == Blocks.sand || block == Blocks.dirt || 
				block == FantasticBlocks.plantKelp || block == FantasticBlocks.plantSeaweed)
		return true;
		else
			return false;
	}
}