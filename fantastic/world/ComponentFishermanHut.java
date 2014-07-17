package fantastic.world;


import static net.minecraftforge.common.ChestGenHooks.VILLAGE_BLACKSMITH;

import java.util.List;
import java.util.Random;

import fantastic.FantasticIds;
import fantastic.items.FantasticItems;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHangingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillage;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraftforge.common.ChestGenHooks;

public class ComponentFishermanHut extends ComponentVillage
{
    public ComponentFishermanHut() {}
    private boolean hasMadeChest;
    
    public ComponentFishermanHut(ComponentVillageStartPiece par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
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

        int StairL = this.getMetadataWithOffset(Block.stairsBrick.blockID, 4);
        int StairR = this.getMetadataWithOffset(Block.stairsNetherBrick.blockID, 5);
        int StairB = this.getMetadataWithOffset(Block.stairsNetherBrick.blockID, 6);
        int StairF = this.getMetadataWithOffset(Block.stairsNetherQuartz.blockID, 7);
        
       
        int LRWood = this.getMetadataWithOffset(Block.wood.blockID, 4);
        int FBWood = this.getMetadataWithOffset(Block.wood.blockID, 8);
        
        //Walls
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 1, 1, 7, 4, 4, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 2, 1, 6, 8, 4, 10, 0, 0, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 1, 0, 6, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 1, 6, 6, 4, 6, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 6, 0, 4, 6, Block.wood.blockID, Block.wood.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 1, 0, 0, 4, 0, Block.wood.blockID, Block.wood.blockID, false);
        
        for (int k = 1; k <= 5; ++k)
        {
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, LRWood, k, 1, 0, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 6, 1, k, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID,LRWood, k, 1, 6, par3StructureBoundingBox);
       
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 0, 1, k, par3StructureBoundingBox);

                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 6, 4, k, par3StructureBoundingBox);

                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 6, 5, k, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, LRWood, k, 4, 6, par3StructureBoundingBox);
               
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 0, 4, k, par3StructureBoundingBox);

                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 0, 5, k, par3StructureBoundingBox);
        
                this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, LRWood, k, 4, 0, par3StructureBoundingBox);
                
        }
        
        for (int k = 1; k <= 5; ++k)
        {
        	this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 4, 4, k, par3StructureBoundingBox);
        	this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, FBWood, 2, 4, k, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, LRWood, k, 4, 2, par3StructureBoundingBox);
            this.placeBlockAtCurrentPosition(par1World, Block.wood.blockID, LRWood, k, 4, 4, par3StructureBoundingBox);
            
        }
        for (int k = 0; k <= 6; ++k)
        {
        	 this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 0, k, 6, 2, par3StructureBoundingBox);
        	 this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 0, k, 6, 3, par3StructureBoundingBox);
        	 this.placeBlockAtCurrentPosition(par1World, Block.planks.blockID, 0, k, 6, 4, par3StructureBoundingBox);
             
        }
        //Walls
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 0, 5, 3, 0, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 6, 2, 1, 6, 3, 5, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 2, 6, 5, 3, 6, Block.planks.blockID, Block.planks.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 2, 1, 0, 3, 5, Block.planks.blockID, Block.planks.blockID, false);
        
        //Floor
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 0, 0, 0, 6, 0, 6, Block.cobblestone.blockID, Block.cobblestone.blockID, false);
        this.fillWithBlocks(par1World, par3StructureBoundingBox, 1, 0, 1, 5, 0, 5, Block.planks.blockID, Block.planks.blockID, false);
       
        //Insides
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodBirch.blockID, StairF, 1, 1, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodBirch.blockID, StairF, 2, 1, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodBirch.blockID, StairR, 2, 1, 3, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodBirch.blockID, StairR, 2, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodBirch.blockID, StairR, 2, 1, 5, par3StructureBoundingBox);
        
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodJungle.blockID, StairF, 5, 1, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodJungle.blockID, StairF, 5, 2, 5, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodJungle.blockID, StairB, 5, 1, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodJungle.blockID, StairB, 5, 2, 4, par3StructureBoundingBox);
        
        
        //Torches
        this.placeBlockAtCurrentPosition(par1World, Block.torchWood.blockID, 0, 2, 5, 2, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.torchWood.blockID, 0, 2, 5, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.torchWood.blockID, 0, 4, 5, 4, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.torchWood.blockID, 0, 4, 5, 2, par3StructureBoundingBox);
       
        //tests
        
        this.placeBlockAtCurrentPosition(par1World, Block.torchWood.blockID, 0, 5, 2, -1, par3StructureBoundingBox);
        
        
         int i = this.getMetadataWithOffset(Block.stairsWoodOak.blockID, 3);
         int j = this.getMetadataWithOffset(Block.stairsWoodOak.blockID, 2);
         int k;
         int l;
 
         for (k = -1; k <= 2; ++k)
         {
             for (l = -1; l <= 7; ++l)
             {
                 this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, i, l, 5 + k, k, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, StairB, -1, 5 + k, k+1, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, StairB, 7, 5 + k, k+1, par3StructureBoundingBox);
                 
               
             }
         }
         for (k = 4; k <= 7; ++k)
         {
             for (l = -1; l <= 7; ++l)
             {
                 this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, j, l, 11 - k, k, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, StairF, -1, 11 - k, k-1, par3StructureBoundingBox);
                 this.placeBlockAtCurrentPosition(par1World, Block.stairsWoodOak.blockID, StairF, 7, 11 - k, k-1, par3StructureBoundingBox);
                 
             }
         }
       //Ceiling 
         this.fillWithBlocks(par1World, par3StructureBoundingBox, -1, 7, 3, 7, 7, 3, Block.planks.blockID, Block.planks.blockID, false);
  
         int stairs = this.getMetadataWithOffset(Block.stairsCobblestone.blockID, 3);
        this.placeDoorAtCurrentPosition(par1World, par3StructureBoundingBox, par2Random, 4, 1, 0, stairs);
        this.placeBlockAtCurrentPosition(par1World, Block.stairsCobblestone.blockID, stairs, 4, 0, -1, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.thinGlass.blockID, 0, 2, 2, 0, par3StructureBoundingBox);
        this.placeBlockAtCurrentPosition(par1World, Block.thinGlass.blockID, 0, 6, 2, 3, par3StructureBoundingBox);
        
        if (!this.hasMadeChest)
        {
        	 int s = this.getYWithOffset(1);
             int t = this.getXWithOffset(5, 5);
             int m = this.getZWithOffset(5, 5);

             if (par3StructureBoundingBox.isVecInside(t, s, m))
             {
                 this.hasMadeChest = true;
                 this.generateStructureChestContents(par1World, par3StructureBoundingBox, par2Random, 5, 1, 1, ChestGenHooks.getItems("FISHERMAN", par2Random), ChestGenHooks.getCount("FISHERMAN", par2Random));
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
    
    public static ComponentFishermanHut buildComponent(ComponentVillageStartPiece startPiece, List par1List, Random random, int par3, int par4, int par5, int par6, int par7) 
	 {
		 StructureBoundingBox var8 = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 5, 9, 10, par6);
		 return canVillageGoDeeper(var8) && StructureComponent.findIntersecting(par1List, var8) == null ? new ComponentFishermanHut(startPiece, par7, random, var8, par6) : null;
	 }
}
