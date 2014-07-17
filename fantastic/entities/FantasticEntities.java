package fantastic.entities;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.VillagerRegistry;
import fantastic.FantasticInfo;
import fantastic.events.VillagerTradeHandler;
import fantastic.world.FishermanHandler;

public class FantasticEntities 

{
	
	public static void init()
	{
		//Fish
		EntityRegistry.registerGlobalEntityID(EntityBasicFish.class, "Trout", EntityRegistry.findGlobalUniqueEntityId(), 0x3366CC, 0x3300CC);
		EntityRegistry.addSpawn(EntityBasicFish.class, 8, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga});
		
		//Cave Fish
		EntityRegistry.registerGlobalEntityID(EntityCaveFish.class, "Cave", EntityRegistry.findGlobalUniqueEntityId(), 0x5E742E, 0xB8B800);
		EntityRegistry.addSpawn(EntityCaveFish.class, 8, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.jungle, BiomeGenBase.jungleHills, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.swampland, BiomeGenBase.taiga});
		
		//Lobster
		EntityRegistry.registerGlobalEntityID(EntityLobster.class, "Lobster", EntityRegistry.findGlobalUniqueEntityId(), 0x800000, 0x5A0000);
		EntityRegistry.addSpawn(EntityLobster.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		
		//Clam
		EntityRegistry.registerGlobalEntityID(EntityClam.class, "Clam", EntityRegistry.findGlobalUniqueEntityId(), 0x6E2E83, 0xB84DDB);
		EntityRegistry.addSpawn(EntityClam.class, 7, 1, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		
		//Salmon
		EntityRegistry.registerGlobalEntityID(EntitySalmon.class, "Salmon", EntityRegistry.findGlobalUniqueEntityId(), 0xA3A3A3, 0xFF9999);
		EntityRegistry.addSpawn(EntitySalmon.class, 6, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river});
		
		//Starfish
		EntityRegistry.registerGlobalEntityID(EntityStarfish.class, "Starfish", EntityRegistry.findGlobalUniqueEntityId(), 0xD11919, 0xE88C8C);
		EntityRegistry.addSpawn(EntityStarfish.class, 6, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.beach});
		
		//Bottom Feeder
		EntityRegistry.registerGlobalEntityID(EntityFeeder.class, "Feeder", EntityRegistry.findGlobalUniqueEntityId(), 0x2E1F0F, 0x82796F);
		EntityRegistry.addSpawn(EntityFeeder.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.swampland});
		
		//Mossy Feeder
		EntityRegistry.registerGlobalEntityID(EntityMossy.class, "Mossy", EntityRegistry.findGlobalUniqueEntityId(), 0x2E5C00, 0x007C00);
		EntityRegistry.addSpawn(EntityMossy.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.swampland});
		
		//Tuna
		EntityRegistry.registerGlobalEntityID(EntityTuna.class, "Tuna", EntityRegistry.findGlobalUniqueEntityId(), 0x2EB8E6, 0xFFFF66);
		EntityRegistry.addSpawn(EntityTuna.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		
		//Small Crab
		EntityRegistry.registerGlobalEntityID(EntitySmallCrab.class, "SmallCrab", EntityRegistry.findGlobalUniqueEntityId(), 0x007C00, 0x2EB8E6);
		EntityRegistry.addSpawn(EntitySmallCrab.class, 7, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {BiomeGenBase.beach});
				
		//Sailfish
		EntityRegistry.registerGlobalEntityID(EntitySailfish.class, "Sailfish", EntityRegistry.findGlobalUniqueEntityId(), 0x3366CC, 0x007C00);
		EntityRegistry.addSpawn(EntitySailfish.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
				
		//Patrick
		EntityRegistry.registerGlobalEntityID(EntityPatrick.class, "Patrick", EntityRegistry.findGlobalUniqueEntityId());
						
		//Arrows
		
		
		
		
		
	}
	
	
	public static void addNames()
	{
		LanguageRegistry.instance().addStringLocalization("entity.Trout.name", "Fish");

		LanguageRegistry.instance().addStringLocalization("entity.Cave.name", "Cave Fish");
		
		LanguageRegistry.instance().addStringLocalization("entity.Lobster.name", "Lobster");

		LanguageRegistry.instance().addStringLocalization("entity.Clam.name", "Clam");
		
		LanguageRegistry.instance().addStringLocalization("entity.Salmon.name", "Salmon");
		
		LanguageRegistry.instance().addStringLocalization("entity.Starfish.name", "Starfish");

		LanguageRegistry.instance().addStringLocalization("entity.Feeder.name", "Spotted Bottom Feeder");
		
		LanguageRegistry.instance().addStringLocalization("entity.Mossy.name", "Mossy Bottom Feeder");
		
		LanguageRegistry.instance().addStringLocalization("entity.Tuna.name", "Tuna");

		LanguageRegistry.instance().addStringLocalization("entity.SmallCrab.name", "Small Crab");
		
		LanguageRegistry.instance().addStringLocalization("entity.Patrick.name", "Patrick Star");
	}

}
