package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockSnakeCoralPink extends BlockBushCoral {

	public BlockSnakeCoralPink(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "snakecoral_pink");
		this.setUnlocalizedName("snakecoral_pink");
	}

}