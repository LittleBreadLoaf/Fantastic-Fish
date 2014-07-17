package fantastic.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fantastic.FantasticIds;
import fantastic.Names;
import fantastic.blocks.bushcoral.*;
import fantastic.blocks.seaplant.*;
import fantastic.blocks.wholecoral.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

public class FantasticBlocks 
{
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
	
	public static void init() 
	{
		//Base Blocks
    	coralWholeBlock = new BlockCoral(2002, Material.coral);
    	coralBushBlock = new BlockBushCoral(2000, Material.water);
    	coralTallSeaPlant = new BlockTallSeaPlant(2001, Material.water);
    	
    	//Anemones
    	anemoneSmall = new BlockAnemoneSmall(FantasticIds.anemoneSmallID, Material.water);
    	anemoneTall = new BlockAnemoneTall(FantasticIds.anemoneTallID, Material.water);
    	
        //Brain Corals
        brainCoralNormal = new BlockBrainCoralNormal(FantasticIds.brainCoralNormalID, Material.coral);
        brainCoralPurple = new BlockBrainCoralPurple(FantasticIds.brainCoralPurpleID, Material.coral);
        brainCoralRed = new BlockBrainCoralRed(FantasticIds.brainCoralRedID, Material.coral);
        brainCoralYellow = new BlockBrainCoralYellow(FantasticIds.brainCoralYellowID, Material.coral);
        
        //Bush Corals
        bushCoralBlue = new BlockBushCoralBlue(FantasticIds.bushCoralBlueID, Material.water);
        bushCoralPurple = new BlockBushCoralPurple(FantasticIds.bushCoralPurpleID, Material.water);
        bushCoralRed = new BlockBushCoralRed(FantasticIds.bushCoralRedID, Material.water);
        bushCoralYellow = new BlockBushCoralYellow(FantasticIds.bushCoralYellowID, Material.water);
        
        //Leafy Corals
        leafyCoralBlue = new BlockLeafyCoralBlue(FantasticIds.leafyCoralBlueID, Material.water);
        leafyCoralCreeper = new BlockLeafyCoralCreeper(FantasticIds.leafyCoralCreeperID, Material.water);
        leafyCoralCyan = new BlockLeafyCoralCyan(FantasticIds.leafyCoralCyanID, Material.water);
        leafyCoralRed = new BlockLeafyCoralRed(FantasticIds.leafyCoralRedID, Material.water);
        
        //Snake Corals
        snakeCoralBlue = new BlockSnakeCoralBlue(FantasticIds.snakeCoralBlueID, Material.water);
        snakeCoralPink = new BlockSnakeCoralPink(FantasticIds.snakeCoralPinkID, Material.water);
        
        //Sponge Corals
        spongeCoralLightgreen = new BlockSpongeCoralLightgreen(FantasticIds.spongeGreenID, Material.coral);
        spongeCoralOrange = new BlockSpongeCoralOrange(FantasticIds.spongeOrangeID, Material.coral);
        spongeCoralPink = new BlockSpongeCoralPink(FantasticIds.spongePinkID, Material.coral);
        
        //Tall Sea Plants
        plantKelp = new BlockPlantKelp(FantasticIds.kelpBlockID, Material.water);
        plantSeaweed = new BlockPlantSeaweed(FantasticIds.seaweedBlockID, Material.water);
    	
    	
    	/*
    	 * Register Blocks
    	 */
        
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
        GameRegistry.registerBlock(plantKelp, "Kelp");
        GameRegistry.registerBlock(plantSeaweed, "Seaweed");


	}

	public static void addNames() 
	{
		//Anemones
				LanguageRegistry.addName(anemoneSmall, "Small Anemone");
				LanguageRegistry.addName(anemoneTall, "Tall Anemone");
		        
		        //Brain Corals
		        LanguageRegistry.addName(brainCoralNormal, "Brain Coral");
		        LanguageRegistry.addName(brainCoralPurple, "Purple Brain Coral");
		        LanguageRegistry.addName(brainCoralRed, "Red Brain Coral");
		        LanguageRegistry.addName(brainCoralYellow, "Yellow Brain Coral");
		        
		        //Bush Corals
		        LanguageRegistry.addName(bushCoralBlue, "Blue Bush Coral");
		        LanguageRegistry.addName(bushCoralPurple, "Purple Bush Coral");
		        LanguageRegistry.addName(bushCoralRed, "Red Bush Coral");
		        LanguageRegistry.addName(bushCoralYellow, "Yellow Bush Coral");
		        
		        //Leafy Corals
		        LanguageRegistry.addName(leafyCoralBlue, "Leafy Blue Coral");
		        LanguageRegistry.addName(leafyCoralCreeper, "Leafy Creeper Coral");
		        LanguageRegistry.addName(leafyCoralCyan, "Leafy Cyan Coral");
		        LanguageRegistry.addName(leafyCoralRed, "Leafy Red Coral");
		        
		        //Snake Corals
		        LanguageRegistry.addName(snakeCoralBlue, "Blue Snake Coral");
		        LanguageRegistry.addName(snakeCoralPink, "Pink Snake Coral");
		        
		        //Sponge Corals
		        LanguageRegistry.addName(spongeCoralLightgreen, "Green Sponge Coral");
		        LanguageRegistry.addName(spongeCoralOrange, "Orange Sponge Coral");
		        LanguageRegistry.addName(spongeCoralPink, "Pink Sponge Coral");
		        
		        //Tall Sea Plants
		        LanguageRegistry.addName(plantKelp, "Kelp");
		        LanguageRegistry.addName(plantSeaweed, "Seaweed");
		
	}
}