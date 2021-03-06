package fantastic.entities;

import com.sun.imageio.spi.InputStreamImageInputStreamSpi;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import fantastic.FantasticMod;
import fantastic.Names;
import fantastic.animations.common.EntitySerpentBoss;
import fantastic.entities.sharks.EntityWhiteTipShark;


public class FantasticEntities 

{
	

	
	
	public static void init()
	{
		int _id = 1;
		
		

		//Reinforced Fishing Hook
		EntityRegistry.registerModEntity(EntityReinforcedFishingHook.class, Names.ReinforcedFishingRod_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//*** FISH ***
		
		//Basic Fish
		EntityRegistry.registerModEntity(EntityBasicFish.class, Names.Colorfish_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//Salmon
		EntityRegistry.registerModEntity(EntitySalmon.class, Names.Salmon_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//Trout
		EntityRegistry.registerModEntity(EntityTrout.class, Names.Trout_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		//EntityRegistry.addSpawn(EntitySalmon.class, 6, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river,BiomeGenBase.coldTaigaHills,BiomeGenBase.extremeHills,BiomeGenBase.iceMountains,BiomeGenBase.megaTaigaHills,BiomeGenBase.taigaHills});
		_id++;

		//Pike
		EntityRegistry.registerModEntity(EntityPike.class, Names.Pike_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//Musky Fish
		EntityRegistry.registerModEntity(EntityMusky.class, Names.Musky_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//Catfish
		EntityRegistry.registerModEntity(EntityCatfish.class, Names.Catfish_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Tuna
		EntityRegistry.registerModEntity(EntityTuna.class, Names.Tuna_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//Fungus
		EntityRegistry.registerModEntity(EntityFungus.class, Names.Fungus_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Mossy
		EntityRegistry.registerModEntity(EntityMossy.class, Names.Mossy_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Feeder
		EntityRegistry.registerModEntity(EntityFeeder.class, Names.Feeder_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		
		//Sailfish
		EntityRegistry.registerModEntity(EntitySailfish.class, Names.Sailfish_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Manta Ray
		EntityRegistry.registerModEntity(EntityMantaRay.class, Names.MantaRay_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Barracuda
		EntityRegistry.registerModEntity(EntityBarracuda.class, Names.Barracuda_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;
		

		//*** SHARKS ***

		//White Tip Shark
		EntityRegistry.registerModEntity(EntityWhiteTipShark.class, Names.WhiteTipShark_UnlocalizedName, _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//*** Crabs and lobsters ***
		
		
		//Hermit_Crab
		EntityRegistry.registerModEntity(EntityHermitCrab.class, "hermit_crab", _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Lobster
		EntityRegistry.registerModEntity(EntityLobster.class, "lobster", _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Small Crab
		EntityRegistry.registerModEntity(EntitySmallCrab.class, "smallcrab", _id, FantasticMod.instance, 64, 2, true);
		_id++;

		//Clam
		EntityRegistry.registerModEntity(EntityClam.class, "clam", _id, FantasticMod.instance, 64, 2, true);
		_id++;

		
		//Init the spawning
		//initSpawning();
		
		//EntityRegistry.addSpawn(EntityCatfish.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.swampland});


		
		//EntityRegistry.registerGlobalEntityID(EntitySalmon.class, "Salmon", EntityRegistry.findGlobalUniqueEntityId(), 0xA3A3A3, 0xFF9999);

		
		
		//Fish
		//EntityRegistry.registerGlobalEntityID(EntityBasicFish.class, "Trout", EntityRegistry.findGlobalUniqueEntityId(), 0x3366CC, 0x3300CC);
		//EntityRegistry.addSpawn(EntityBasicFish.class, 8, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.deepOcean, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore});
		
		//Cave Fish
		//EntityRegistry.registerGlobalEntityID(EntityCaveFish.class, "Cave", EntityRegistry.findGlobalUniqueEntityId(), 0x5E742E, 0xB8B800);
		//EntityRegistry.addSpawn(EntityCaveFish.class, 8, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains});
		
		//Lobster
		//EntityRegistry.registerGlobalEntityID(EntityLobster.class, "Lobster", EntityRegistry.findGlobalUniqueEntityId(), 0x800000, 0x5A0000);
		//EntityRegistry.addSpawn(EntityLobster.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Clam
		//EntityRegistry.registerGlobalEntityID(EntityClam.class, "Clam", EntityRegistry.findGlobalUniqueEntityId(), 0x6E2E83, 0xB84DDB);
		//EntityRegistry.addSpawn(EntityClam.class, 7, 1, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.deepOcean});
		
		//Salmon
		//EntityRegistry.registerGlobalEntityID(EntitySalmon.class, "Salmon", EntityRegistry.findGlobalUniqueEntityId(), 0xA3A3A3, 0xFF9999);
		//EntityRegistry.addSpawn(EntitySalmon.class, 6, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river});
		
		//Starfish
		//EntityRegistry.registerGlobalEntityID(EntityStarfish.class, "Starfish", EntityRegistry.findGlobalUniqueEntityId(), 0xD11919, 0xE88C8C);
		//EntityRegistry.addSpawn(EntityStarfish.class, 6, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.beach});
		
		//Bottom Feeder
		//EntityRegistry.registerGlobalEntityID(EntityFeeder.class, "Feeder", EntityRegistry.findGlobalUniqueEntityId(), 0x2E1F0F, 0x82796F);
		//EntityRegistry.addSpawn(EntityFeeder.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.swampland});
		
		//Mossy Feeder
		//EntityRegistry.registerGlobalEntityID(EntityMossy.class, "Mossy", EntityRegistry.findGlobalUniqueEntityId(), 0x2E5C00, 0x007C00);
		//EntityRegistry.addSpawn(EntityMossy.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.swampland});
		
		//Tuna
		//EntityRegistry.registerGlobalEntityID(EntityTuna.class, "Tuna", EntityRegistry.findGlobalUniqueEntityId(), 0x2EB8E6, 0xFFFF66);
		//EntityRegistry.addSpawn(EntityTuna.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Fungus Fish
		//EntityRegistry.registerGlobalEntityID(EntityFungus.class, "Fungus", EntityRegistry.findGlobalUniqueEntityId(), 0x006666, 0xCC5200);
		//EntityRegistry.addSpawn(EntityFungus.class, 1, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore});
				
		//Small Crab
		//EntityRegistry.registerGlobalEntityID(EntitySmallCrab.class, "SmallCrab", EntityRegistry.findGlobalUniqueEntityId(), 0xFF7519, 0xFFC8A3);
		//EntityRegistry.addSpawn(EntitySmallCrab.class, 15, 4, 8, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.beach});
				
		//Sailfish
		//EntityRegistry.registerGlobalEntityID(EntitySailfish.class, "Sailfish", EntityRegistry.findGlobalUniqueEntityId(), 0x3366CC, 0xFFF0F0);
		//EntityRegistry.addSpawn(EntitySailfish.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Catfish
		//EntityRegistry.registerGlobalEntityID(EntityCatfish.class, "Catfish", EntityRegistry.findGlobalUniqueEntityId(), 0x2B1A00, 0x002952);
		//EntityRegistry.addSpawn(EntityCatfish.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.swampland});
					
		//Nurse Shark
		//EntityRegistry.registerGlobalEntityID(EntityNurseShark.class, "Nurse", EntityRegistry.findGlobalUniqueEntityId(), 0x50506C, 0x9696A7);
		//EntityRegistry.addSpawn(EntityNurseShark.class, 1, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		
		//Manta Ray
		//EntityRegistry.registerGlobalEntityID(EntityMantaRay.class, "Manta", EntityRegistry.findGlobalUniqueEntityId(), 0x000060, 0x5E7E9E);
		//EntityRegistry.addSpawn(EntityMantaRay.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
			
//		//Sand Striker
//		EntityRegistry.registerGlobalEntityID(EntitySandStriker.class, "Sand", EntityRegistry.findGlobalUniqueEntityId(), 0x3366CC, 0x3300CC);
//		EntityRegistry.addSpawn(EntitySandStriker.class, 2, 1, 3, EnumCreatureType.monster, new BiomeGenBase[]{BiomeGenBase.desert, BiomeGenBase.desertHills});
		
		
		//Great White Shark
		//EntityRegistry.registerGlobalEntityID(EntityGreatWhite.class, "GWShark", EntityRegistry.findGlobalUniqueEntityId(), 0x6585E6, 0xE6E6FF);
		//EntityRegistry.addSpawn(EntityGreatWhite.class, 1, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.deepOcean});
				
		//Bull Shark
		//EntityRegistry.registerGlobalEntityID(EntityBullShark.class, "BullShark", EntityRegistry.findGlobalUniqueEntityId(), 0x7C6496, 0x8686A2);
		//EntityRegistry.addSpawn(EntityBullShark.class, 1, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Bull Shark
		//EntityRegistry.registerGlobalEntityID(EntityTigerShark.class, "TigerShark", EntityRegistry.findGlobalUniqueEntityId(), 0x966C43, 0xB26B24);
		//EntityRegistry.addSpawn(EntityTigerShark.class, 1, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Hammerhead Shark
		//EntityRegistry.registerGlobalEntityID(EntityHammerHead.class, "HammerShark", EntityRegistry.findGlobalUniqueEntityId(), 0x6E538A, 0x6B6BB2);
		//EntityRegistry.addSpawn(EntityHammerHead.class, 1, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Blooper
		//EntityRegistry.registerGlobalEntityID(EntityBlooper.class, "Blooper", EntityRegistry.findGlobalUniqueEntityId());
				
		//Patrick
		//EntityRegistry.registerGlobalEntityID(EntityPatrick.class, "Patrick", EntityRegistry.findGlobalUniqueEntityId());
		
		//Creepedo
		//EntityRegistry.registerGlobalEntityID(EntityCreepedo.class, "Creepedo", EntityRegistry.findGlobalUniqueEntityId());
								
		
	}
	
	private static void initSpawning()
	{
		
		//*** Fish ***
		EntityRegistry.addSpawn(EntityBasicFish.class, 3, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.deepOcean, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.ocean, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.frozenOcean, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore});
		EntityRegistry.addSpawn(EntitySalmon.class, 8, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.river,BiomeGenBase.coldTaigaHills,BiomeGenBase.extremeHills,BiomeGenBase.iceMountains,BiomeGenBase.megaTaigaHills,BiomeGenBase.taigaHills,BiomeGenBase.frozenRiver,BiomeGenBase.icePlains});
		EntityRegistry.addSpawn(EntityTrout.class, 10, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.beach, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.stoneBeach, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.frozenRiver, BiomeGenBase.icePlains, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore});
		EntityRegistry.addSpawn(EntityPike.class, 8, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,BiomeGenBase.swampland});
		EntityRegistry.addSpawn(EntityMusky.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.plains, BiomeGenBase.river, BiomeGenBase.roofedForest, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore,BiomeGenBase.swampland});
		EntityRegistry.addSpawn(EntityCatfish.class, 10, 1, 3, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.desert,BiomeGenBase.desertHills,BiomeGenBase.jungle,BiomeGenBase.jungleEdge,BiomeGenBase.jungleHills,BiomeGenBase.mesa,BiomeGenBase.mesaPlateau,BiomeGenBase.mesaPlateau_F,BiomeGenBase.mushroomIsland,BiomeGenBase.mushroomIslandShore,BiomeGenBase.plains,BiomeGenBase.roofedForest,BiomeGenBase.savanna,BiomeGenBase.savannaPlateau,BiomeGenBase.swampland});
		EntityRegistry.addSpawn(EntityTuna.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		EntityRegistry.addSpawn(EntityFungus.class, 5, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore});
		EntityRegistry.addSpawn(EntityMossy.class, 3, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.swampland});
		EntityRegistry.addSpawn(EntityFeeder.class, 5, 3, 1, EnumCreatureType.waterCreature, new BiomeGenBase[]{BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.roofedForest, BiomeGenBase.swampland, BiomeGenBase.jungle,BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills,BiomeGenBase.plains, BiomeGenBase.roofedForest});
		EntityRegistry.addSpawn(EntitySailfish.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		EntityRegistry.addSpawn(EntityMantaRay.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		EntityRegistry.addSpawn(EntityBarracuda.class, 2, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});

		//*** Sharks ***
		EntityRegistry.addSpawn(EntityWhiteTipShark.class, 1, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		
		//Other critters
		EntityRegistry.addSpawn(EntityLobster.class, 5, 1, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		EntityRegistry.addSpawn(EntityHermitCrab.class, 5, 1, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.beach,BiomeGenBase.coldBeach,BiomeGenBase.stoneBeach, BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		EntityRegistry.addSpawn(EntitySmallCrab.class, 5, 1, 4, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.beach,BiomeGenBase.coldBeach,BiomeGenBase.stoneBeach, BiomeGenBase.ocean, BiomeGenBase.deepOcean});
		EntityRegistry.addSpawn(EntityClam.class, 7, 1, 5, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.deepOcean});
		

	}
	


}
