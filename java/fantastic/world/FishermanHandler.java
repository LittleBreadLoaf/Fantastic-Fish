package fantastic.world;

import java.util.List;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.PieceWeight;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class FishermanHandler implements IVillageCreationHandler {

	@Override
    public StructureVillagePieces.PieceWeight getVillagePieceWeight(Random random, int size) 
    {
              return new PieceWeight(ComponentFishermanHut.class, 15, MathHelper.getRandomIntegerInRange(random, 0, 4));
    }

    public Class<?> getComponentClass() 
    {
              return ComponentFishermanHut.class;
    }

    public Object buildComponent(StructureVillagePieces.PieceWeight villagePiece, StructureVillagePieces.Start startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) 
    {
              return ComponentFishermanHut.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }

	
	
}