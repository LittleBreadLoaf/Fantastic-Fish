package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockBushCoralRed extends BlockBushCoral {

	public BlockBushCoralRed(Material material) {
		super(material);
		setBlockName(FantasticInfo.ID + ":" + "bushcoral_red");
	}

}