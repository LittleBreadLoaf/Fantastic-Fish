package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;

public class BlockSnakeCoralBlue extends BlockBushCoral {

	public BlockSnakeCoralBlue(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "snakecoral_blue");
		this.setUnlocalizedName("snakecoral_blue");
	}

}