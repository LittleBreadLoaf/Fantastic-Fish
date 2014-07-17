package fantastic.blocks.wholecoral;


import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockCoral;

public class BlockSpongeCoralOrange extends BlockCoral {

	public BlockSpongeCoralOrange(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "spongecoral_orange");
		this.setUnlocalizedName("spongecoral_orange");
	}

}