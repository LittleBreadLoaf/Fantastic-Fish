package fantastic.blocks.bushcoral;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;
import fantastic.items.FantasticItems;


public class BlockLeafyCoralCreeper extends BlockBushCoral {

	public BlockLeafyCoralCreeper(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "leafycoral_creeper");
		this.setUnlocalizedName("leafycoral_creeper");
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int meta) {
		if(new Random().nextDouble() < 0.4) {
			world.createExplosion(null, x, y, z, 2f, false);
		} else {
			dropBlockAsItem(world, x, y, z, blockID, 0);
		}
	}
	 /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Item.gunpowder.itemID;
    }

}