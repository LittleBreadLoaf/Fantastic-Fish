package fantastic.blocks.wholecoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockBrainCoralPurple extends BlockCoral {

	public BlockBrainCoralPurple(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "braincoral_purple");
		this.setUnlocalizedName("braincoral_purple");
	}

}