package fantastic.blocks.wholecoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockBrainCoralRed extends BlockCoral {

	public BlockBrainCoralRed(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "braincoral_red");
		this.setUnlocalizedName("braincoral_red");
	}

}