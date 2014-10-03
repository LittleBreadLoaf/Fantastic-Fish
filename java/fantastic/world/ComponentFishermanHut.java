package fantastic.world;


import java.util.List;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;
import net.minecraftforge.common.ChestGenHooks;
import fantastic.FantasticIds;

public class ComponentFishermanHut extends StructureVillagePieces.Village
{
    public ComponentFishermanHut() {}
    private boolean hasMadeChest;
    
    public ComponentFishermanHut(StructureVillagePieces.Start par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super();
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
    }

    protected void func_143012_a(NBTTagCompound par1NBTTagCompound)
    {
        super.func_143012_a(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("Chest", this.hasMadeChest);
    }

    protected void func_143011_b(NBTTagCompound par1NBTTagCompound)
    {
        super.func_143011_b(par1NBTTagCompound);
        this.hasMadeChest = par1NBTTagCompound.getBoolean("Chest");
    }
    
    @Override
    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        if (this.field_143015_k < 0)
        {
            this.field_143015_k = this.getAverageGroundLevel(par1World, par3StructureBoundingBox) + 2;

            if (this.field_143015_k < 0)
            {
                return true;
            }

            this.boundingBox.offset(0, this.field_143015_k - this.boundingBox.maxY + 7 - 1, 0);
        }

        int StairL = this.getMetadataWithOffset(Blocks.brick_stairs, 4);
        int StairR = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 5);
        int StairB = this.getMetadataWithOffset(Blocks.nether_brick_stairs, 6);
        int StairF = this.getMetadataWithOffset(Blocks.quartz_stairs, 7);
        
       
        int LRlog = this.getMetadataWithOffset(Blocks.log, 4);
        int FBlog = this.getMetadataWithOffset(Blocks.log, 8);
        
        //Walls
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 1, 7, 4, 4, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 6, 8, 4, 10, Blocks.air, Blocks.air, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 1, 0, 6, 4, 0, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 1, 6, 6, 4, 6, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 6, 0, 4, 6, Blocks.log, Blocks.log, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 4, 0, Blocks.log, Blocks.log, false);
        
        for (int k = 1; k <= 5; ++k)
        {
                this.placeBlockAtCurrentPosition(par1World, Blocks.log, LRlog, k, 1, 0, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 6, 1, k, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Blocks.log,LRlog, k, 1, 6, par3StructureBoundingBox);
       
                this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 0, 1, k, par3StructureBoundingBox);

                this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 6, 4, k, par3StructureBoundingBox);

                this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 6, 5, k, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Blocks.log, LRlog, k, 4, 6, par3StructureBoundingBox);
               
                this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 0, 4, k, par3StructureBoundingBox);

                this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 0, 5, k, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Blocks.log, LRlog, k, 4, 0, par3StructureBoundingBox);
                
        }
        
        for (int k = 1; k <= 5; ++k)
        {
        	this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 4, 4, k, par3StructureBoundingBox);
        	this.placeBlockAtCurrentPosition(par1World, Blocks.log, FBlog, 2, 4, k, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Blocks.log, LRlog, k, 4, 2, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Blocks.log, LRlog, k, 4, 4, par3StructureBoundingBox);
            
        }
        for (int k = 0; k <= 6; ++k)
        {
        	 this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, k, 6, 2, par3StructureBoundingBox);
        	 this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, k, 6, 3, par3StructureBoundingBox);
        	 this.placeBlockAtCurrentPosition(par1World, Blocks.planks, 0, k, 6, 4, par3StructureBoundingBox);
             
        }
        //Walls
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 0, 5, 3, 0, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 2, 1, 6, 3, 5, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 6, 5, 3, 6, Blocks.planks, Blocks.planks, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 1, 0, 3, 5, Blocks.planks, Blocks.planks, false);
        
        //Floor
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 6, 0, 6, Blocks.cobblestone, Blocks.cobblestone, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 5, 0, 5, Blocks.planks, Blocks.planks, false);
       
        //Insides
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairB, 1, 1, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairB, 2, 1, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairR, 2, 1, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairR, 2, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairR, 2, 1, 5, par3StructureBoundingBox);
        
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairB, 5, 1, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairB, 5, 2, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairF, 5, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.birch_stairs, StairF, 5, 2, 4, par3StructureBoundingBox);
        
        
        //Torches
        this.placeBlockAtCurrentPosition(par1World, Blocks.torch, 0, 2, 5, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.torch, 0, 2, 5, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.torch, 0, 4, 5, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.torch, 0, 4, 5, 2, par3StructureBoundingBox);
       
        //tests
        
        this.placeBlockAtCurrentPosition(par1World, Blocks.torch, 0, 5, 2, -1, par3StructureBoundingBox);
        
        
         int i = this.getMetadataWithOffset(Blocks.oak_stairs, 3);
         int j = this.getMetadataWithOffset(Blocks.oak_stairs, 2);
         int k;
         int l;
 
         for (k = -1; k <= 2; ++k)
         {
             for (l = -1; l <= 7; ++l)
             {
                 this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, i, l, 5 + k, k, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, StairF, -1, 5 + k, k+1, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, StairF, 7, 5 + k, k+1, par3StructureBoundingBox);
                 
               
             }
         }
         for (k = 4; k <= 7; ++k)
         {
             for (l = -1; l <= 7; ++l)
             {
                 this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, j, l, 11 - k, k, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, StairB, -1, 11 - k, k-1, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Blocks.oak_stairs, StairB, 7, 11 - k, k-1, par3StructureBoundingBox);
                 
             }
         }
       //Ceiling 
         this.fillWithBlocks(par1World, par3StructureBoundingBox, -1, 7, 3, 7, 7, 3, Blocks.planks, Blocks.planks, false);
  
         int stairs = this.getMetadataWithOffset(Blocks.stone_stairs, 3);
        this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 4, 1, 0, stairs);
        this.placeBlockAtCurrentPosition(par1World, Blocks.stone_stairs, stairs, 4, 0, -1, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 2, 2, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Blocks.glass_pane, 0, 6, 2, 3, par3StructureBoundingBox);
        
        if (!this.hasMadeChest)
        {
        	 int s = this.getYWithOffset(1);
             int t = this.getXWithOffset(5, 5);
             int m = this.getZWithOffset(5, 5);

             if (par3StructureBoundingBox.isVecInside(t, s, m))
             {
                 this.hasMadeChest = true;
                 this.generateStructureChestContents(par1World, par3StructureBoundingBox, par2Random, 1, 1, 3, ChestGenHooks.getItems("FISHERMAN", par2Random), ChestGenHooks.getCount("FISHERMAN", par2Random));
              System.out.println("Generated Chest");
             }
        }

        
        this.spawnVillagers(par1World, par3StructureBoundingBox, 4, 1, 2, 2);
        return true;
    }
    
    
    
    
    /**
     * Returns the villager type to spawn in this component, based on the number of villagers already spawned.
     */
    protected int getVillagerType(int par1)
    {
        return FantasticIds.fishermanID;
    }
    
    public static ComponentFishermanHut buildComponent(StructureVillagePieces.Start startPiece, List par1List, Random random, int par3, int par4, int par5, int par6, int par7) 
	 {
		 StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 5, 9, 10, par6);
		 return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new ComponentFishermanHut(startPiece, par7, random, var8, par6) : null;
	 }
}
