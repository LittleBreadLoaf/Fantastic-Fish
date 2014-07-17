package fantastic;

import java.io.File;

import net.minecraftforge.common.Configuration;

public class ConfigHandler 
{
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		FantasticIds.aquariumGlassID = config.get(config.CATEGORY_BLOCK, "Aquarium Glass ID", FantasticIds.aquariumGlassID_Default).getInt();
		
		FantasticIds.anemoneSmallID = config.get(config.CATEGORY_BLOCK, "Small Anemone ID", FantasticIds.anemoneSmallID_Default).getInt();
		FantasticIds.anemoneTallID = config.get(config.CATEGORY_BLOCK, "Tall Anemone ID", FantasticIds.anemoneTallID_Default).getInt();
		FantasticIds.bushCoralBlueID = config.get(config.CATEGORY_BLOCK, "Blue Bush ID", FantasticIds.bushCoralBlueID_Default).getInt();
		FantasticIds.bushCoralPurpleID = config.get(config.CATEGORY_BLOCK, "Purple Bush ID", FantasticIds.bushCoralPurpleID_Default).getInt();
		FantasticIds.bushCoralRedID = config.get(config.CATEGORY_BLOCK, "Red Bush ID", FantasticIds.bushCoralRedID_Default).getInt();
		FantasticIds.bushCoralYellowID = config.get(config.CATEGORY_BLOCK, "Yellow Bush ID", FantasticIds.bushCoralYellowID_Default).getInt();
		
		FantasticIds.leafyCoralBlueID = config.get(config.CATEGORY_BLOCK, "Blue Leafy ID", FantasticIds.leafyCoralBlueID_Default).getInt();
		FantasticIds.leafyCoralCreeperID = config.get(config.CATEGORY_BLOCK, "Creeper Coral ID", FantasticIds.leafyCoralCreeperID_Default).getInt();
		FantasticIds.leafyCoralCyanID = config.get(config.CATEGORY_BLOCK, "Cyan Leafy ID", FantasticIds.leafyCoralCyanID_Default).getInt();
		FantasticIds.leafyCoralRedID = config.get(config.CATEGORY_BLOCK, "Red Leafy ID", FantasticIds.leafyCoralRedID_Default).getInt();
		
		FantasticIds.snakeCoralBlueID = config.get(config.CATEGORY_BLOCK, "Blue Snake ID", FantasticIds.snakeCoralBlueID_Default).getInt();
		FantasticIds.snakeCoralPinkID = config.get(config.CATEGORY_BLOCK, "Pink Snake ID", FantasticIds.snakeCoralPinkID_Default).getInt();
		
		FantasticIds.kelpBlockID = config.get(config.CATEGORY_BLOCK, "Kelp Block ID", FantasticIds.kelpBlockID_Default).getInt();
		FantasticIds.seaweedBlockID = config.get(config.CATEGORY_BLOCK, "Seaweed Block ID", FantasticIds.seaweedBlockID_Default).getInt();
		
		FantasticIds.brainCoralNormalID = config.get(config.CATEGORY_BLOCK, "Normal Brain ID", FantasticIds.brainCoralNormalID_Default).getInt();
		FantasticIds.brainCoralPurpleID = config.get(config.CATEGORY_BLOCK, "Purple Brain ID", FantasticIds.brainCoralPurpleID_Default).getInt();
		FantasticIds.brainCoralRedID = config.get(config.CATEGORY_BLOCK, "Red Brain ID", FantasticIds.brainCoralRedID_Default).getInt();
		FantasticIds.brainCoralYellowID = config.get(config.CATEGORY_BLOCK, "Yellow Coral ID", FantasticIds.brainCoralYellowID_Default).getInt();
		FantasticIds.spongeGreenID = config.get(config.CATEGORY_BLOCK, "Green Sponge ID", FantasticIds.spongeGreenID_Default).getInt();
		FantasticIds.spongeOrangeID = config.get(config.CATEGORY_BLOCK, "Orange Sponge ID", FantasticIds.spongeOrangeID_Default).getInt();
		FantasticIds.spongePinkID = config.get(config.CATEGORY_BLOCK, "Pink Sponge ID", FantasticIds.spongePinkID_Default).getInt();
		
		FantasticIds.fishingNetID = config.get(config.CATEGORY_ITEM, "Fishing Net ID", FantasticIds.fishingNetID_Default).getInt();
		
		FantasticIds.filletRawID = config.get(config.CATEGORY_ITEM, "Raw Fish Fillet ID", FantasticIds.filletRawID_Default).getInt();

		FantasticIds.filletCookedID = config.get(config.CATEGORY_ITEM, "Cooked Fish Fillet ID", FantasticIds.filletCookedID_Default).getInt();
		
		FantasticIds.clawRawID = config.get(config.CATEGORY_ITEM, "Raw Lobster Claw ID", FantasticIds.clawRawID_Default).getInt();

		FantasticIds.clawCookedID = config.get(config.CATEGORY_ITEM, "Cooked Lobster Claw ID", FantasticIds.clawCookedID_Default).getInt();
		
		FantasticIds.tailRawID = config.get(config.CATEGORY_ITEM, "Raw Lobster Tail ID", FantasticIds.tailRawID_Default).getInt();

		FantasticIds.tailCookedID = config.get(config.CATEGORY_ITEM, "Cooked Lobster Tail ID", FantasticIds.tailCookedID_Default).getInt();

		FantasticIds.sushiID = config.get(config.CATEGORY_ITEM, "Sushi ID", FantasticIds.sushiID_Default).getInt();

		FantasticIds.seaweedID = config.get(config.CATEGORY_ITEM, "Seaweed ID", FantasticIds.seaweedID_Default).getInt();
		
		FantasticIds.kelpID = config.get(config.CATEGORY_ITEM, "Kelp ID", FantasticIds.kelpID_Default).getInt();
		
		FantasticIds.pearlID = config.get(config.CATEGORY_ITEM, "Pearl ID", FantasticIds.pearlID_Default).getInt();

		FantasticIds.gogglesID = config.get(config.CATEGORY_ITEM, "Goggles ID", FantasticIds.gogglesID_Default).getInt();

		
		
		
		
		FantasticIds.tinyFishID = config.get(config.CATEGORY_ITEM, "Tiny Fish ID", FantasticIds.tinyFishID_Default).getInt();
		FantasticIds.smallFishID = config.get(config.CATEGORY_ITEM, "Small Fish ID", FantasticIds.smallFishID_Default).getInt();
		FantasticIds.mediumFishID = config.get(config.CATEGORY_ITEM, "Medium Fish ID", FantasticIds.mediumFishID_Default).getInt();
		FantasticIds.bigFishID = config.get(config.CATEGORY_ITEM, "Big Fish ID", FantasticIds.bigFishID_Default).getInt();
		FantasticIds.largeFishID = config.get(config.CATEGORY_ITEM, "Large Fish ID", FantasticIds.largeFishID_Default).getInt();
		FantasticIds.legendaryFishID = config.get(config.CATEGORY_ITEM, "Legendary Fish ID", FantasticIds.legendaryFishID_Default).getInt();
		FantasticIds.clamID = config.get(config.CATEGORY_ITEM, "Live Clam ID", FantasticIds.clamID_Default).getInt();
		FantasticIds.starfishID = config.get(config.CATEGORY_ITEM, "Starfish ID", FantasticIds.starfishID_Default).getInt();
		FantasticIds.smallCrabID = config.get(config.CATEGORY_ITEM, "Small Crab ID", FantasticIds.smallCrabID_Default).getInt();
		
		FantasticIds.clamShellID = config.get(config.CATEGORY_ITEM, "Clam Shell ID", FantasticIds.clamShellID_Default).getInt();
		
		FantasticIds.lobsterID = config.get(config.CATEGORY_ITEM, "Lobster ID", FantasticIds.lobsterID_Default).getInt();
		
		FantasticIds.fishermanID = config.get(config.CATEGORY_GENERAL, "Fisherman Villager ID", FantasticIds.fishermanID_Default).getInt();
		config.save();
		
		
	}

}
