package fantastic.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import fantastic.FantasticInfo;
import fantastic.blocks.bushcoral.BlockAnemoneSmall;
import fantastic.blocks.bushcoral.BlockAnemoneTall;
import fantastic.blocks.bushcoral.BlockBushCoralBlue;
import fantastic.blocks.bushcoral.BlockBushCoralPurple;
import fantastic.blocks.bushcoral.BlockBushCoralRed;
import fantastic.blocks.bushcoral.BlockBushCoralYellow;
import fantastic.blocks.bushcoral.BlockLeafyCoralBlue;
import fantastic.blocks.bushcoral.BlockLeafyCoralCreeper;
import fantastic.blocks.bushcoral.BlockLeafyCoralCyan;
import fantastic.blocks.bushcoral.BlockLeafyCoralRed;
import fantastic.blocks.bushcoral.BlockSnakeCoralBlue;
import fantastic.blocks.bushcoral.BlockSnakeCoralPink;
import fantastic.blocks.decoration.BlockSkeleton;
import fantastic.blocks.seaplant.BlockPlantKelp;
import fantastic.blocks.seaplant.BlockPlantSeaweed;
import fantastic.blocks.wholecoral.BlockBrainCoralNormal;
import fantastic.blocks.wholecoral.BlockBrainCoralPurple;
import fantastic.blocks.wholecoral.BlockBrainCoralRed;
import fantastic.blocks.wholecoral.BlockBrainCoralYellow;
import fantastic.blocks.wholecoral.BlockSpongeCoralLightgreen;
import fantastic.blocks.wholecoral.BlockSpongeCoralOrange;
import fantastic.blocks.wholecoral.BlockSpongeCoralPink;

public class FantasticBlocks 
{
	public static Block aquariumGlass;
	/*
     * Corals/SeaPlants
     */
    //Base Blocks
    public static Block coralBushBlock;
    public static Block coralTallSeaPlant;
    public static Block coralWholeBlock;
    
    //Anemones
    public static Block anemoneSmall;
    public static Block anemoneTall;
    
    //Brain Corals
    public static Block brainCoralNormal;
    public static Block brainCoralPurple;
    public static Block brainCoralRed;
    public static Block brainCoralYellow;
    
    //Bush Corals
    public static Block bushCoralBlue;
    public static Block bushCoralPurple;
    public static Block bushCoralRed;
    public static Block bushCoralYellow;
    
    //Leafy Corals
    public static Block leafyCoralBlue;
    public static Block leafyCoralCreeper;
    public static Block leafyCoralCyan;
    public static Block leafyCoralRed;
    
    //Snake Corals
    public static Block snakeCoralBlue;
    public static Block snakeCoralPink;
    
    //Sponge Corals
    public static Block spongeCoralLightgreen;
    public static Block spongeCoralOrange;
    public static Block spongeCoralPink;
    
    //Tall Sea Plants
    public static Block plantKelp;
    public static Block plantSeaweed;
    
    public static Block smokeBlock;
    
    public static Block airComp;
    
    public static Block skeleton;
    
   // public static Block lobsterPot;
	
	public static void init() 
	{
		
		//aquariumGlass = new BlockAquariumGlass(Material.rock).setBlockTextureName("glass");
		//Base Blocks
    	coralWholeBlock = new BlockCoral(Material.coral);
    	coralBushBlock = new BlockBushCoral(Material.water);
    	coralTallSeaPlant = new BlockTallSeaPlant(Material.water);
    	
    	//Anemones
    	anemoneSmall = new BlockAnemoneSmall(Material.water).setBlockTextureName("fantastic:anemone_small");
    	anemoneTall = new BlockAnemoneTall(Material.water).setBlockTextureName("fantastic:anemone_tall");
    	
        //Brain Corals
        brainCoralNormal = new BlockBrainCoralNormal(Material.coral).setBlockTextureName("fantastic:braincoral_normal");
        brainCoralPurple = new BlockBrainCoralPurple(Material.coral).setBlockTextureName("fantastic:braincoral_purple");
        brainCoralRed = new BlockBrainCoralRed(Material.coral).setBlockTextureName("fantastic:braincoral_red");
        brainCoralYellow = new BlockBrainCoralYellow(Material.coral).setBlockTextureName("fantastic:braincoral_yellow");
        
        //Bush Corals
        bushCoralBlue = new BlockBushCoralBlue(Material.water).setBlockTextureName("fantastic:bushcoral_blue");
        bushCoralPurple = new BlockBushCoralPurple(Material.water).setBlockTextureName("fantastic:bushcoral_purple");
        bushCoralRed = new BlockBushCoralRed(Material.water).setBlockTextureName("fantastic:bushcoral_red");
        bushCoralYellow = new BlockBushCoralYellow(Material.water).setBlockTextureName("fantastic:bushcoral_yellow");
        
        //Leafy Corals
        leafyCoralBlue = new BlockLeafyCoralBlue(Material.water).setBlockTextureName("fantastic:leafycoral_blue");
        leafyCoralCreeper = new BlockLeafyCoralCreeper(Material.water).setBlockTextureName("fantastic:leafycoral_creeper");
        leafyCoralCyan = new BlockLeafyCoralCyan(Material.water).setBlockTextureName("fantastic:leafycoral_cyan");
        leafyCoralRed = new BlockLeafyCoralRed(Material.water).setBlockTextureName("fantastic:leafycoral_red");
        
        //Snake Corals
        snakeCoralBlue = new BlockSnakeCoralBlue(Material.water).setBlockTextureName("fantastic:snakecoral_blue");
        snakeCoralPink = new BlockSnakeCoralPink(Material.water).setBlockTextureName("fantastic:snakecoral_pink");
        
        //Sponge Corals
        spongeCoralLightgreen = new BlockSpongeCoralLightgreen(Material.coral).setBlockTextureName("fantastic:spongecoral_lightgreen");
        spongeCoralOrange = new BlockSpongeCoralOrange(Material.coral).setBlockTextureName("fantastic:spongecoral_orange");
        spongeCoralPink = new BlockSpongeCoralPink(Material.coral).setBlockTextureName("fantastic:spongecoral_pink");
        
        //Tall Sea Plants
        plantKelp = new BlockPlantKelp(Material.water).setBlockTextureName("fantastic:plant_kelp");
        plantSeaweed = new BlockPlantSeaweed(Material.water).setBlockTextureName("fantastic:plant_seaweed");
        
        smokeBlock = new BlockSmoke(Material.rock).setBlockTextureName("fantastic:smoke_block");
    	
        airComp = new BlockAirCompressor(Material.iron).setBlockTextureName(FantasticInfo.ID + ":compressor_item");
    	
        skeleton = new BlockSkeleton(Material.clay).setBlockTextureName("fantastic:skeleton_item");
       // lobsterPot = new BlockLobsterPot().setBlockTextureName(FantasticInfo.ID + ":compressor_item");
        /*
    	 * Register Blocks
    	 */
        
        //GameRegistry.registerBlock(aquariumGlass, "Aquarium Glass");
        //Anemones
        GameRegistry.registerBlock(anemoneSmall, "Small Anemone");
        GameRegistry.registerBlock(anemoneTall, "Tall Anemone");
        
        //Brain Corals
        GameRegistry.registerBlock(brainCoralNormal, "Brain Coral");
        GameRegistry.registerBlock(brainCoralPurple, "Purple Brain Coral");
        GameRegistry.registerBlock(brainCoralRed, "Red Brain Coral");
        GameRegistry.registerBlock(brainCoralYellow, "Yellow Brain Coral");
        
        //Bush Corals
        GameRegistry.registerBlock(bushCoralBlue, "Blue Bush Coral");
        GameRegistry.registerBlock(bushCoralPurple, "Purple Bush Coral");
        GameRegistry.registerBlock(bushCoralRed, "Red Bush Coral");
        GameRegistry.registerBlock(bushCoralYellow, "Yellow Bush Coral");
        
        //Leafy Corals
        GameRegistry.registerBlock(leafyCoralBlue, "Leafy Blue Coral");
        GameRegistry.registerBlock(leafyCoralCreeper, "Leafy Creeper Coral");
        GameRegistry.registerBlock(leafyCoralCyan, "Leafy Cyan Coral");
        GameRegistry.registerBlock(leafyCoralRed, "Leafy Red Coral");
        
        //Snake Corals
        GameRegistry.registerBlock(snakeCoralBlue, "Blue Snake Coral");
        GameRegistry.registerBlock(snakeCoralPink, "Pink Snake Coral");
        
        //Sponge Corals
        GameRegistry.registerBlock(spongeCoralLightgreen, "Green Sponge Coral");
        GameRegistry.registerBlock(spongeCoralOrange, "Orange Sponge Coral");
        GameRegistry.registerBlock(spongeCoralPink, "Pink Sponge Coral");
        
        //Tall Sea Plants
        GameRegistry.registerBlock(plantKelp, "Kelp Block");
        GameRegistry.registerBlock(plantSeaweed, "Seaweed Block");
        
        GameRegistry.registerBlock(smokeBlock, "Smoke Rock");
        
        GameRegistry.registerBlock(airComp, "Air Compressor");
        
        GameRegistry.registerBlock(skeleton, "Skeleton Block");
        
        //GameRegistry.registerBlock(lobsterPot, "Lobster Pot");


	}

}