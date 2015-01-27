package fantastic;

import java.io.File;

import net.minecraftforge.common.config.Configuration;


public class ConfigHandler 
{
	public static void init(File configFile)
	{
		Configuration config = new Configuration(configFile);
		
		config.load();
		
		
		
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
