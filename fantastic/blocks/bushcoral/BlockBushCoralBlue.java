package fantastic.blocks.bushcoral;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockBushCoralBlue extends BlockBushCoral {

	public BlockBushCoralBlue(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "bushcoral_blue");
		this.setUnlocalizedName("bushcoral_blue");
	}
	
	
	

}