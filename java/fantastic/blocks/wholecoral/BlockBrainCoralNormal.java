package fantastic.blocks.wholecoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockBrainCoralNormal extends BlockCoral {

	public BlockBrainCoralNormal(Material material) {
		super(material);
		setBlockName(FantasticInfo.ID + ":" + "braincoral_normal");
	}

}