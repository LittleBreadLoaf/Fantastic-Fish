package fantastic.blocks.wholecoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockBrainCoralYellow extends BlockCoral {

	public BlockBrainCoralYellow(Material material) {
		super(material);
		setBlockName(FantasticInfo.ID + ":" + "braincoral_yellow");
	}

}