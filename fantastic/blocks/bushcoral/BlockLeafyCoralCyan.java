package fantastic.blocks.bushcoral;

import net.minecraft.block.material.Material;
import fantastic.FantasticInfo;
import fantastic.blocks.BlockBushCoral;


public class BlockLeafyCoralCyan extends BlockBushCoral {

	public BlockLeafyCoralCyan(int id, Material material) {
		super(id, material);
		setTextureName(FantasticInfo.ID + ":" + "leafycoral_cyan");
		this.setUnlocalizedName("leafycoral_cyan");
	}

}