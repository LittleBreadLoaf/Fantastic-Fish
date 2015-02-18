package fantastic;

import java.io.File;

import net.minecraftforge.common.config.Configuration;


public class ConfigHandler 
{
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		config.addCustomCategoryComment("SPAWN CONTROL", "");
		
		//COLOR FISHES
		
		FantasticIds.tinyColorFishSpawnProbability = config.getInt("Tiny Colorfish Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyColorFishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyColorFishMinDepth = config.getInt("Tiny Colorfish Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyColorFishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyColorFishMaxInstances = config.getInt("Tiny Colorfish Max Instances", "SPAWN CONTROL", FantasticIds.tinyColorFishMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallColorFishSpawnProbability = config.getInt("Small Colorfish Spawn Probability", "SPAWN CONTROL", FantasticIds.smallColorFishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallColorFishMinDepth = config.getInt("Small Colorfish Minimum Depth", "SPAWN CONTROL", FantasticIds.smallColorFishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallColorFishMaxInstances = config.getInt("Small Colorfish Max Instances", "SPAWN CONTROL", FantasticIds.smallColorFishMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumColorFishSpawnProbability = config.getInt("Medium Colorfish Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumColorFishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumColorFishMinDepth = config.getInt("Medium Colorfish Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumColorFishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumColorFishMaxInstances = config.getInt("Medium Colorfish Max Instances", "SPAWN CONTROL", FantasticIds.mediumColorFishMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigColorFishSpawnProbability = config.getInt("Big Colorfish Spawn Probability", "SPAWN CONTROL", FantasticIds.bigColorFishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigColorFishMinDepth = config.getInt("Big Colorfish Minimum Depth", "SPAWN CONTROL", FantasticIds.bigColorFishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigColorFishMaxInstances = config.getInt("Big Colorfish Max Instances", "SPAWN CONTROL", FantasticIds.bigColorFishMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeColorFishSpawnProbability = config.getInt("Large Colorfish Spawn Probability", "SPAWN CONTROL", FantasticIds.largeColorFishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeColorFishMinDepth = config.getInt("Large Colorfish Minimum Depth", "SPAWN CONTROL", FantasticIds.largeColorFishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeColorFishMaxInstances = config.getInt("Large Colorfish Max Instances", "SPAWN CONTROL", FantasticIds.largeColorFishMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legColorFishSpawnProbability = config.getInt("Legendary Colorfish Spawn Probability", "SPAWN CONTROL", FantasticIds.legColorFishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legColorFishMinDepth = config.getInt("Legendary Colorfish Minimum Depth", "SPAWN CONTROL", FantasticIds.legColorFishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legColorFishMaxInstances = config.getInt("Legendary Colorfish Max Instances", "SPAWN CONTROL", FantasticIds.legColorFishMaxInstances_Default, -1, 10, "Max number of instances");

		//SALMON
		
		FantasticIds.tinySalmonSpawnProbability = config.getInt("Tiny Salmon Spawn Probability", "SPAWN CONTROL", FantasticIds.tinySalmonSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinySalmonMinDepth = config.getInt("Tiny Salmon Minimum Depth", "SPAWN CONTROL", FantasticIds.tinySalmonMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinySalmonMaxInstances = config.getInt("Tiny Salmon Max Instances", "SPAWN CONTROL", FantasticIds.tinySalmonMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallSalmonSpawnProbability = config.getInt("Small Salmon Spawn Probability", "SPAWN CONTROL", FantasticIds.smallSalmonSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallSalmonMinDepth = config.getInt("Small Salmon Minimum Depth", "SPAWN CONTROL", FantasticIds.smallSalmonMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallSalmonMaxInstances = config.getInt("Small Salmon Max Instances", "SPAWN CONTROL", FantasticIds.smallSalmonMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumSalmonSpawnProbability = config.getInt("Medium Salmon Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumSalmonSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumSalmonMinDepth = config.getInt("Medium Salmon Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumSalmonMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumSalmonMaxInstances = config.getInt("Medium Salmon Max Instances", "SPAWN CONTROL", FantasticIds.mediumSalmonMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigSalmonSpawnProbability = config.getInt("Big Salmon Spawn Probability", "SPAWN CONTROL", FantasticIds.bigSalmonSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigSalmonMinDepth = config.getInt("Big Salmon Minimum Depth", "SPAWN CONTROL", FantasticIds.bigSalmonMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigSalmonMaxInstances = config.getInt("Big Salmon Max Instances", "SPAWN CONTROL", FantasticIds.bigSalmonMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeSalmonSpawnProbability = config.getInt("Large Salmon Spawn Probability", "SPAWN CONTROL", FantasticIds.largeSalmonSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeSalmonMinDepth = config.getInt("Large Salmon Minimum Depth", "SPAWN CONTROL", FantasticIds.largeSalmonMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeSalmonMaxInstances = config.getInt("Large Salmon Max Instances", "SPAWN CONTROL", FantasticIds.largeSalmonMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legSalmonSpawnProbability = config.getInt("Legendary Salmon Spawn Probability", "SPAWN CONTROL", FantasticIds.legSalmonSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legSalmonMinDepth = config.getInt("Legendary Salmon Minimum Depth", "SPAWN CONTROL", FantasticIds.legSalmonMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legSalmonMaxInstances = config.getInt("Legendary Salmon Max Instances", "SPAWN CONTROL", FantasticIds.legSalmonMaxInstances_Default, -1, 10, "Max number of instances");

		//Trout
		
		FantasticIds.tinyTroutSpawnProbability = config.getInt("Tiny Trout Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyTroutSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyTroutMinDepth = config.getInt("Tiny Trout Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyTroutMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyTroutMaxInstances = config.getInt("Tiny Trout Max Instances", "SPAWN CONTROL", FantasticIds.tinyTroutMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallTroutSpawnProbability = config.getInt("Small Trout Spawn Probability", "SPAWN CONTROL", FantasticIds.smallTroutSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallTroutMinDepth = config.getInt("Small Trout Minimum Depth", "SPAWN CONTROL", FantasticIds.smallTroutMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallTroutMaxInstances = config.getInt("Small Trout Max Instances", "SPAWN CONTROL", FantasticIds.smallTroutMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumTroutSpawnProbability = config.getInt("Medium Trout Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumTroutSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumTroutMinDepth = config.getInt("Medium Trout Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumTroutMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumTroutMaxInstances = config.getInt("Medium Trout Max Instances", "SPAWN CONTROL", FantasticIds.mediumTroutMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigTroutSpawnProbability = config.getInt("Big Trout Spawn Probability", "SPAWN CONTROL", FantasticIds.bigTroutSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigTroutMinDepth = config.getInt("Big Trout Minimum Depth", "SPAWN CONTROL", FantasticIds.bigTroutMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigTroutMaxInstances = config.getInt("Big Trout Max Instances", "SPAWN CONTROL", FantasticIds.bigTroutMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeTroutSpawnProbability = config.getInt("Large Trout Spawn Probability", "SPAWN CONTROL", FantasticIds.largeTroutSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeTroutMinDepth = config.getInt("Large Trout Minimum Depth", "SPAWN CONTROL", FantasticIds.largeTroutMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeTroutMaxInstances = config.getInt("Large Trout Max Instances", "SPAWN CONTROL", FantasticIds.largeTroutMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legTroutSpawnProbability = config.getInt("Legendary Trout Spawn Probability", "SPAWN CONTROL", FantasticIds.legTroutSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legTroutMinDepth = config.getInt("Legendary Trout Minimum Depth", "SPAWN CONTROL", FantasticIds.legTroutMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legTroutMaxInstances = config.getInt("Legendary Trout Max Instances", "SPAWN CONTROL", FantasticIds.legTroutMaxInstances_Default, -1, 10, "Max number of instances");
		
		
		//CAT FISH
		
		FantasticIds.tinyCatfishSpawnProbability = config.getInt("Tiny Catfish Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyCatfishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyCatfishMinDepth = config.getInt("Tiny Catfish Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyCatfishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyCatfishMaxInstances = config.getInt("Tiny Catfish Max Instances", "SPAWN CONTROL", FantasticIds.tinyCatfishMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallCatfishSpawnProbability = config.getInt("Small Catfish Spawn Probability", "SPAWN CONTROL", FantasticIds.smallCatfishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallCatfishMinDepth = config.getInt("Small Catfish Minimum Depth", "SPAWN CONTROL", FantasticIds.smallCatfishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallCatfishMaxInstances = config.getInt("Small Catfish Max Instances", "SPAWN CONTROL", FantasticIds.smallCatfishMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumCatfishSpawnProbability = config.getInt("Medium Catfish Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumCatfishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumCatfishMinDepth = config.getInt("Medium Catfish Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumCatfishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumCatfishMaxInstances = config.getInt("Medium Catfish Max Instances", "SPAWN CONTROL", FantasticIds.mediumCatfishMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigCatfishSpawnProbability = config.getInt("Big Catfish Spawn Probability", "SPAWN CONTROL", FantasticIds.bigCatfishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigCatfishMinDepth = config.getInt("Big Catfish Minimum Depth", "SPAWN CONTROL", FantasticIds.bigCatfishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigCatfishMaxInstances = config.getInt("Big Catfish Max Instances", "SPAWN CONTROL", FantasticIds.bigCatfishMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeCatfishSpawnProbability = config.getInt("Large Catfish Spawn Probability", "SPAWN CONTROL", FantasticIds.largeCatfishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeCatfishMinDepth = config.getInt("Large Catfish Minimum Depth", "SPAWN CONTROL", FantasticIds.largeCatfishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeCatfishMaxInstances = config.getInt("Large Catfish Max Instances", "SPAWN CONTROL", FantasticIds.largeCatfishMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legCatfishSpawnProbability = config.getInt("Legendary Catfish Spawn Probability", "SPAWN CONTROL", FantasticIds.legCatfishSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legCatfishMinDepth = config.getInt("Legendary Catfish Minimum Depth", "SPAWN CONTROL", FantasticIds.legCatfishMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legCatfishMaxInstances = config.getInt("Legendary Catfish Max Instances", "SPAWN CONTROL", FantasticIds.legCatfishMaxInstances_Default, -1, 10, "Max number of instances");
		
		//PIKE
		
		FantasticIds.tinyPikeSpawnProbability = config.getInt("Tiny Pike Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyPikeSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyPikeMinDepth = config.getInt("Tiny Pike Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyPikeMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyPikeMaxInstances = config.getInt("Tiny Pike Max Instances", "SPAWN CONTROL", FantasticIds.tinyPikeMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallPikeSpawnProbability = config.getInt("Small Pike Spawn Probability", "SPAWN CONTROL", FantasticIds.smallPikeSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallPikeMinDepth = config.getInt("Small Pike Minimum Depth", "SPAWN CONTROL", FantasticIds.smallPikeMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallPikeMaxInstances = config.getInt("Small Pike Max Instances", "SPAWN CONTROL", FantasticIds.smallPikeMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumPikeSpawnProbability = config.getInt("Medium Pike Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumPikeSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumPikeMinDepth = config.getInt("Medium Pike Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumPikeMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumPikeMaxInstances = config.getInt("Medium Pike Max Instances", "SPAWN CONTROL", FantasticIds.mediumPikeMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigPikeSpawnProbability = config.getInt("Big Pike Spawn Probability", "SPAWN CONTROL", FantasticIds.bigPikeSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigPikeMinDepth = config.getInt("Big Pike Minimum Depth", "SPAWN CONTROL", FantasticIds.bigPikeMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigPikeMaxInstances = config.getInt("Big Pike Max Instances", "SPAWN CONTROL", FantasticIds.bigPikeMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largePikeSpawnProbability = config.getInt("Large Pike Spawn Probability", "SPAWN CONTROL", FantasticIds.largePikeSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largePikeMinDepth = config.getInt("Large Pike Minimum Depth", "SPAWN CONTROL", FantasticIds.largePikeMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largePikeMaxInstances = config.getInt("Large Pike Max Instances", "SPAWN CONTROL", FantasticIds.largePikeMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legPikeSpawnProbability = config.getInt("Legendary Pike Spawn Probability", "SPAWN CONTROL", FantasticIds.legPikeSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legPikeMinDepth = config.getInt("Legendary Pike Minimum Depth", "SPAWN CONTROL", FantasticIds.legPikeMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legPikeMaxInstances = config.getInt("Legendary Pike Max Instances", "SPAWN CONTROL", FantasticIds.legPikeMaxInstances_Default, -1, 10, "Max number of instances");

		//MUSKY
		
		FantasticIds.tinyMuskySpawnProbability = config.getInt("Tiny Musky Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyMuskySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyMuskyMinDepth = config.getInt("Tiny Musky Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyMuskyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyMuskyMaxInstances = config.getInt("Tiny Musky Max Instances", "SPAWN CONTROL", FantasticIds.tinyMuskyMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallMuskySpawnProbability = config.getInt("Small Musky Spawn Probability", "SPAWN CONTROL", FantasticIds.smallMuskySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallMuskyMinDepth = config.getInt("Small Musky Minimum Depth", "SPAWN CONTROL", FantasticIds.smallMuskyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallMuskyMaxInstances = config.getInt("Small Musky Max Instances", "SPAWN CONTROL", FantasticIds.smallMuskyMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumMuskySpawnProbability = config.getInt("Medium Musky Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumMuskySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumMuskyMinDepth = config.getInt("Medium Musky Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumMuskyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumMuskyMaxInstances = config.getInt("Medium Musky Max Instances", "SPAWN CONTROL", FantasticIds.mediumMuskyMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigMuskySpawnProbability = config.getInt("Big Musky Spawn Probability", "SPAWN CONTROL", FantasticIds.bigMuskySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigMuskyMinDepth = config.getInt("Big Musky Minimum Depth", "SPAWN CONTROL", FantasticIds.bigMuskyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigMuskyMaxInstances = config.getInt("Big Musky Max Instances", "SPAWN CONTROL", FantasticIds.bigMuskyMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeMuskySpawnProbability = config.getInt("Large Musky Spawn Probability", "SPAWN CONTROL", FantasticIds.largeMuskySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeMuskyMinDepth = config.getInt("Large Musky Minimum Depth", "SPAWN CONTROL", FantasticIds.largeMuskyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeMuskyMaxInstances = config.getInt("Large Musky Max Instances", "SPAWN CONTROL", FantasticIds.largeMuskyMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legMuskySpawnProbability = config.getInt("Legendary Musky Spawn Probability", "SPAWN CONTROL", FantasticIds.legMuskySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legMuskyMinDepth = config.getInt("Legendary Musky Minimum Depth", "SPAWN CONTROL", FantasticIds.legMuskyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legMuskyMaxInstances = config.getInt("Legendary Musky Max Instances", "SPAWN CONTROL", FantasticIds.legMuskyMaxInstances_Default, -1, 10, "Max number of instances");

		//Tuna
		
		FantasticIds.tinyTunaSpawnProbability = config.getInt("Tiny Tuna Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyTunaSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyTunaMinDepth = config.getInt("Tiny Tuna Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyTunaMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyTunaMaxInstances = config.getInt("Tiny Tuna Max Instances", "SPAWN CONTROL", FantasticIds.tinyTunaMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallTunaSpawnProbability = config.getInt("Small Tuna Spawn Probability", "SPAWN CONTROL", FantasticIds.smallTunaSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallTunaMinDepth = config.getInt("Small Tuna Minimum Depth", "SPAWN CONTROL", FantasticIds.smallTunaMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallTunaMaxInstances = config.getInt("Small Tuna Max Instances", "SPAWN CONTROL", FantasticIds.smallTunaMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumTunaSpawnProbability = config.getInt("Medium Tuna Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumTunaSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumTunaMinDepth = config.getInt("Medium Tuna Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumTunaMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumTunaMaxInstances = config.getInt("Medium Tuna Max Instances", "SPAWN CONTROL", FantasticIds.mediumTunaMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigTunaSpawnProbability = config.getInt("Big Tuna Spawn Probability", "SPAWN CONTROL", FantasticIds.bigTunaSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigTunaMinDepth = config.getInt("Big Tuna Minimum Depth", "SPAWN CONTROL", FantasticIds.bigTunaMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigTunaMaxInstances = config.getInt("Big Tuna Max Instances", "SPAWN CONTROL", FantasticIds.bigTunaMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeTunaSpawnProbability = config.getInt("Large Tuna Spawn Probability", "SPAWN CONTROL", FantasticIds.largeTunaSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeTunaMinDepth = config.getInt("Large Tuna Minimum Depth", "SPAWN CONTROL", FantasticIds.largeTunaMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeTunaMaxInstances = config.getInt("Large Tuna Max Instances", "SPAWN CONTROL", FantasticIds.largeTunaMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legTunaSpawnProbability = config.getInt("Legendary Tuna Spawn Probability", "SPAWN CONTROL", FantasticIds.legTunaSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legTunaMinDepth = config.getInt("Legendary Tuna Minimum Depth", "SPAWN CONTROL", FantasticIds.legTunaMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legTunaMaxInstances = config.getInt("Legendary Tuna Max Instances", "SPAWN CONTROL", FantasticIds.legTunaMaxInstances_Default, -1, 10, "Max number of instances");

		//Fungus
		
		FantasticIds.tinyFungusSpawnProbability = config.getInt("Tiny Fungus Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyFungusSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyFungusMinDepth = config.getInt("Tiny Fungus Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyFungusMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyFungusMaxInstances = config.getInt("Tiny Fungus Max Instances", "SPAWN CONTROL", FantasticIds.tinyFungusMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallFungusSpawnProbability = config.getInt("Small Fungus Spawn Probability", "SPAWN CONTROL", FantasticIds.smallFungusSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallFungusMinDepth = config.getInt("Small Fungus Minimum Depth", "SPAWN CONTROL", FantasticIds.smallFungusMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallFungusMaxInstances = config.getInt("Small Fungus Max Instances", "SPAWN CONTROL", FantasticIds.smallFungusMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumFungusSpawnProbability = config.getInt("Medium Fungus Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumFungusSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumFungusMinDepth = config.getInt("Medium Fungus Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumFungusMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumFungusMaxInstances = config.getInt("Medium Fungus Max Instances", "SPAWN CONTROL", FantasticIds.mediumFungusMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigFungusSpawnProbability = config.getInt("Big Fungus Spawn Probability", "SPAWN CONTROL", FantasticIds.bigFungusSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigFungusMinDepth = config.getInt("Big Fungus Minimum Depth", "SPAWN CONTROL", FantasticIds.bigFungusMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigFungusMaxInstances = config.getInt("Big Fungus Max Instances", "SPAWN CONTROL", FantasticIds.bigFungusMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeFungusSpawnProbability = config.getInt("Large Fungus Spawn Probability", "SPAWN CONTROL", FantasticIds.largeFungusSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeFungusMinDepth = config.getInt("Large Fungus Minimum Depth", "SPAWN CONTROL", FantasticIds.largeFungusMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeFungusMaxInstances = config.getInt("Large Fungus Max Instances", "SPAWN CONTROL", FantasticIds.largeFungusMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legFungusSpawnProbability = config.getInt("Legendary Fungus Spawn Probability", "SPAWN CONTROL", FantasticIds.legFungusSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legFungusMinDepth = config.getInt("Legendary Fungus Minimum Depth", "SPAWN CONTROL", FantasticIds.legFungusMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legFungusMaxInstances = config.getInt("Legendary Fungus Max Instances", "SPAWN CONTROL", FantasticIds.legFungusMaxInstances_Default, -1, 10, "Max number of instances");

		//Mossy
		
		FantasticIds.tinyMossySpawnProbability = config.getInt("Tiny Mossy Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyMossySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyMossyMinDepth = config.getInt("Tiny Mossy Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyMossyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyMossyMaxInstances = config.getInt("Tiny Mossy Max Instances", "SPAWN CONTROL", FantasticIds.tinyMossyMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallMossySpawnProbability = config.getInt("Small Mossy Spawn Probability", "SPAWN CONTROL", FantasticIds.smallMossySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallMossyMinDepth = config.getInt("Small Mossy Minimum Depth", "SPAWN CONTROL", FantasticIds.smallMossyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallMossyMaxInstances = config.getInt("Small Mossy Max Instances", "SPAWN CONTROL", FantasticIds.smallMossyMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumMossySpawnProbability = config.getInt("Medium Mossy Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumMossySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumMossyMinDepth = config.getInt("Medium Mossy Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumMossyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumMossyMaxInstances = config.getInt("Medium Mossy Max Instances", "SPAWN CONTROL", FantasticIds.mediumMossyMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigMossySpawnProbability = config.getInt("Big Mossy Spawn Probability", "SPAWN CONTROL", FantasticIds.bigMossySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigMossyMinDepth = config.getInt("Big Mossy Minimum Depth", "SPAWN CONTROL", FantasticIds.bigMossyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigMossyMaxInstances = config.getInt("Big Mossy Max Instances", "SPAWN CONTROL", FantasticIds.bigMossyMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeMossySpawnProbability = config.getInt("Large Mossy Spawn Probability", "SPAWN CONTROL", FantasticIds.largeMossySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeMossyMinDepth = config.getInt("Large Mossy Minimum Depth", "SPAWN CONTROL", FantasticIds.largeMossyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeMossyMaxInstances = config.getInt("Large Mossy Max Instances", "SPAWN CONTROL", FantasticIds.largeMossyMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legMossySpawnProbability = config.getInt("Legendary Mossy Spawn Probability", "SPAWN CONTROL", FantasticIds.legMossySpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legMossyMinDepth = config.getInt("Legendary Mossy Minimum Depth", "SPAWN CONTROL", FantasticIds.legMossyMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legMossyMaxInstances = config.getInt("Legendary Mossy Max Instances", "SPAWN CONTROL", FantasticIds.legMossyMaxInstances_Default, -1, 10, "Max number of instances");

		//Feeder
		
		FantasticIds.tinyFeederSpawnProbability = config.getInt("Tiny Feeder Spawn Probability", "SPAWN CONTROL", FantasticIds.tinyFeederSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.tinyFeederMinDepth = config.getInt("Tiny Feeder Minimum Depth", "SPAWN CONTROL", FantasticIds.tinyFeederMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.tinyFeederMaxInstances = config.getInt("Tiny Feeder Max Instances", "SPAWN CONTROL", FantasticIds.tinyFeederMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.smallFeederSpawnProbability = config.getInt("Small Feeder Spawn Probability", "SPAWN CONTROL", FantasticIds.smallFeederSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.smallFeederMinDepth = config.getInt("Small Feeder Minimum Depth", "SPAWN CONTROL", FantasticIds.smallFeederMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.smallFeederMaxInstances = config.getInt("Small Feeder Max Instances", "SPAWN CONTROL", FantasticIds.smallFeederMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.mediumFeederSpawnProbability = config.getInt("Medium Feeder Spawn Probability", "SPAWN CONTROL", FantasticIds.mediumFeederSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.mediumFeederMinDepth = config.getInt("Medium Feeder Minimum Depth", "SPAWN CONTROL", FantasticIds.mediumFeederMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.mediumFeederMaxInstances = config.getInt("Medium Feeder Max Instances", "SPAWN CONTROL", FantasticIds.mediumFeederMaxInstances_Default, -1, 10, "Max number of instances");
		
		FantasticIds.bigFeederSpawnProbability = config.getInt("Big Feeder Spawn Probability", "SPAWN CONTROL", FantasticIds.bigFeederSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.bigFeederMinDepth = config.getInt("Big Feeder Minimum Depth", "SPAWN CONTROL", FantasticIds.bigFeederMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.bigFeederMaxInstances = config.getInt("Big Feeder Max Instances", "SPAWN CONTROL", FantasticIds.bigFeederMaxInstances_Default, -1, 10, "Max number of instances");


		FantasticIds.largeFeederSpawnProbability = config.getInt("Large Feeder Spawn Probability", "SPAWN CONTROL", FantasticIds.largeFeederSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.largeFeederMinDepth = config.getInt("Large Feeder Minimum Depth", "SPAWN CONTROL", FantasticIds.largeFeederMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.largeFeederMaxInstances = config.getInt("Large Feeder Max Instances", "SPAWN CONTROL", FantasticIds.largeFeederMaxInstances_Default, -1, 10, "Max number of instances");

		FantasticIds.legFeederSpawnProbability = config.getInt("Legendary Feeder Spawn Probability", "SPAWN CONTROL", FantasticIds.legFeederSpawnProbability_Default, -1, 1000, "Spawning on probability");
		FantasticIds.legFeederMinDepth = config.getInt("Legendary Feeder Minimum Depth", "SPAWN CONTROL", FantasticIds.legFeederMinDepth_Default, -1, 40, "Minimum spawning depth");
		FantasticIds.legFeederMaxInstances = config.getInt("Legendary Feeder Max Instances", "SPAWN CONTROL", FantasticIds.legFeederMaxInstances_Default, -1, 10, "Max number of instances");

	
		
		FantasticIds.fishermanID = config.get(config.CATEGORY_GENERAL, "Fisherman Villager ID", FantasticIds.fishermanID_Default).getInt();
		
		config.addCustomCategoryComment("Spawn Rates", "Percents are relative, decreasing from 'Tiny'. If 'Tiny' has 60% chance of spawning, and 'Small' has a 50% chance, 'Small' will only spawn 20% of the time, and so on. (100% - 60% = 40%. 40% * 50% = 20%)");
		
		FantasticIds.tinySpawnRate = config.getInt("Tiny Fish Spawn Rate", "Spawn Rates", FantasticIds.tinySpawnRate_Default, 1, 100, "");

		FantasticIds.smallSpawnRate = config.getInt("Small Fish Spawn Rate", "Spawn Rates", FantasticIds.smallSpawnRate_Default, 1, 100, "");
		
		FantasticIds.mediumSpawnRate = config.getInt("Medium Fish Spawn Rate", "Spawn Rates", FantasticIds.mediumSpawnRate_Default, 1, 100, "");
		
		FantasticIds.bigSpawnRate = config.getInt("Big Fish Spawn Rate", "Spawn Rates", FantasticIds.bigSpawnRate_Default, 1, 100, "");
		
		FantasticIds.largeSpawnRate = config.getInt("Large Fish Spawn Rate", "Spawn Rates", FantasticIds.largeSpawnRate_Default, 1, 100, "");
		
		FantasticIds.legendarySpawnRate = config.getInt("Legendary Fish Spawn Rate", "Spawn Rates", FantasticIds.legendarySpawnRate_Default, 1, 100, "");
		
		config.addCustomCategoryComment("Spawn Depths", "Each set is a minum for that size, but past their set, smaller fish can spawn.");
		
		FantasticIds.tier1Depth = config.getInt("Tiny-Small Min Spawn Depth", "Spawn Depths", FantasticIds.tier1Depth_Default, 1, 30, "");
		FantasticIds.tier2Depth = config.getInt("Medium Min Spawn Depth", "Spawn Depths", FantasticIds.tier2Depth_Default, 1, 30, "");
		FantasticIds.tier3Depth = config.getInt("Big Min Spawn Depth", "Spawn Depths", FantasticIds.tier3Depth_Default, 1, 30, "");
		FantasticIds.tier4Depth = config.getInt("Large Min Spawn Depth", "Spawn Depths", FantasticIds.tier4Depth_Default, 1, 30, "");
		FantasticIds.tier5Depth = config.getInt("Legendary Min Spawn Depth", "Spawn Depths", FantasticIds.tier5Depth_Default, 1, 30, "");
		
		config.addCustomCategoryComment("Shark Spawn Rate", "Relative to percentage. Between 1 and 100.");
		
		FantasticIds.sharkSpawnRate = config.getInt("Spawn Rate", "Shark Spawn Rate", FantasticIds.sharkSpawnRate_Default, 1, 100, "");
	
		config.addCustomCategoryComment("Air Compressor Filling Rate", "Amount of air units filled by a single redstone activation. A repeating on and off signal will be necessary to pump the air compressor. Use a lever or a repeating redstone signal. One second of air represents 20 air units. A small tank has 2400 air units and a double one has 6000 air units.");
		
		FantasticIds.airCompressorFillingRate = config.getInt("Filling Rate", "Air Compressor Filling Rate", FantasticIds.airCompressorFillingRateDefault, 1, 200, "");

		config.save();
		
		
	}

}
