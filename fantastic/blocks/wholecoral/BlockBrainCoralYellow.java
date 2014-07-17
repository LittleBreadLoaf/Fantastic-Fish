package fantastic.blocks.wholecoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockBrainCoralYellow extends BlockCoral {

	public BlockBrainCoralYellow(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "braincoral_yellow");
		this.setUnlocalizedName("braincoral_yellow");
	}

}