package fantastic.world;

import java.util.List;
import java.util.Random;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageCreationHandler;

public class FishermanHandler implements IVillageCreationHandler {

    public StructureVillagePieceWeight getVillagePieceWeight(Random random, int size) 
    {
              return new StructureVillagePieceWeight(ComponentFishermanHut.class, 15, MathHelper.getRandomIntegerInRange(random, 0, 1));
    }

    public Class getComponentClass() 
    {
              return ComponentFishermanHut.class;
    }

    public Object buildComponent(StructureVillagePieceWeight villagePiece, ComponentVillageStartPiece startPiece, List pieces, Random random, int p1, int p2, int p3, int p4, int p5) 
    {
              return ComponentFishermanHut.buildComponent(startPiece, pieces, random, p1, p2, p3, p4, p5);
    }
}