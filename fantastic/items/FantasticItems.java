package fantastic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fantastic.FantasticIds;
import fantastic.Names;
import fantastic.blocks.FantasticBlocks;

public class FantasticItems 
{
	public static Item fishingNet;
	public static Item tinyFish;
	public static Item smallFish;
	public static Item mediumFish;
	public static Item bigFish;
	public static Item largeFish;
	public static Item legendaryFish;
	public static Item filletRaw;
	public static Item filletCooked;
	public static Item clawRaw;
	public static Item clawCooked;
	public static Item tailRaw;
	public static Item tailCooked;
	public static Item pearl;
	public static Item clamShell;
	public static Item clam;
	public static Item lobster;
	public static Item starfish;
	public static Item seaweed;
	public static Item kelp;
	public static Item sushi;
	public static Item smallCrab;
	
	public static final CreativeTabs tabFantastic = new CreativeTabs("Fantastic Fish Mod")
	{
		@SideOnly(Side.CLIENT)
		public int getTabIconItemIndex()
		{
			return Item.fishingRod.itemID;
		}
		
		public String getTranslatedTabLabel()
		{
			return "Fantastic Fish Mod";
		}
	};

	public static final CreativeTabs tabFish = new CreativeTabs("Captured Critters")
	{
		@SideOnly(Side.CLIENT)
		public int getTabIconItemIndex()
		{
			return FantasticItems.tinyFish.itemID;
		}
		
		public String getTranslatedTabLabel()
		{
			return "Captured Critters";
		}
	};
	
	
	public static void init()
	{
		fishingNet = new ItemFishingNet(FantasticIds.fishingNetID);
		tinyFish = new ItemTinyFish(FantasticIds.tinyFishID);
		smallFish = new ItemSmallFish(FantasticIds.smallFishID);
		mediumFish = new ItemMediumFish(FantasticIds.mediumFishID);
		bigFish = new ItemBigFish(FantasticIds.bigFishID);
		largeFish = new ItemLargeFish(FantasticIds.largeFishID);
		legendaryFish = new ItemLegendaryFish(FantasticIds.legendaryFishID);
		filletRaw = (new ItemFishFood(FantasticIds.filletRawID, 1, 0.2F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(Names.RawFillet_UnlocalizedName);
		filletCooked = (new ItemFishFood(FantasticIds.filletCookedID, 5, 0.6F, true)).setUnlocalizedName(Names.CookedFillet_UnlocalizedName);
		clawRaw = (new ItemFishFood(FantasticIds.clawRawID, 1, 0.2F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(Names.RawClaw_UnlocalizedName);
		clawCooked = (new ItemFishFood(FantasticIds.clawCookedID, 4, 0.6F, true)).setUnlocalizedName(Names.CookedClaw_UnlocalizedName);
		tailRaw = (new ItemFishFood(FantasticIds.tailRawID, 1, 0.2F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(Names.RawTail_UnlocalizedName);
		tailCooked = (new ItemFishFood(FantasticIds.tailCookedID, 8, 0.8F, true)).setUnlocalizedName(Names.CookedTail_UnlocalizedName);
		sushi = (new ItemFishFood(FantasticIds.sushiID, 6, 0.6F, true)).setUnlocalizedName(Names.Sushi_UnlocalizedName);
		kelp = new ItemKelp(FantasticIds.kelpID, FantasticBlocks.plantKelp);
		seaweed = new ItemSeaweed(FantasticIds.seaweedID, FantasticBlocks.plantSeaweed);
		pearl = new ItemPearl(FantasticIds.pearlID);
		clamShell = new ItemClamShell(FantasticIds.clamShellID);
		clam = new ItemClam(FantasticIds.clamID);
		lobster = new ItemLobster(FantasticIds.lobsterID);
		starfish = new ItemStarfish(FantasticIds.starfishID);
		smallCrab = new ItemSmallCrab(FantasticIds.smallCrabID);

	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(pearl, Names.Pearl_Name);
		LanguageRegistry.addName(fishingNet, Names.FishingNet_Name);
		LanguageRegistry.addName(filletRaw, Names.RawFillet_Name);
		LanguageRegistry.addName(filletCooked, Names.CookedFillet_Name);
		LanguageRegistry.addName(clawRaw, Names.RawClaw_Name);
		LanguageRegistry.addName(clawCooked, Names.CookedClaw_Name);
		LanguageRegistry.addName(tailRaw, Names.RawTail_Name);
		LanguageRegistry.addName(tailCooked, Names.CookedTail_Name);
		LanguageRegistry.addName(sushi, Names.Sushi_Name);
		LanguageRegistry.addName(seaweed, Names.Seaweed_Name);
		LanguageRegistry.addName(kelp, Names.Kelp_Name);
		
		for(int i = 0; i < Names.TinyFish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(tinyFish, 1, i), Names.TinyFish_Name[i]);
		}
		for(int i = 0; i < Names.SmallFish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(smallFish, 1, i), Names.SmallFish_Name[i]);
		}
		for(int i = 0; i < Names.MediumFish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(mediumFish, 1, i), Names.MediumFish_Name[i]);
		}
		for(int i = 0; i < Names.BigFish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(bigFish, 1, i), Names.BigFish_Name[i]);
		}
		for(int i = 0; i < Names.LargeFish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(largeFish, 1, i), Names.LargeFish_Name[i]);
		}
		for(int i = 0; i < Names.LegendaryFish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(legendaryFish, 1, i), Names.LegendaryFish_Name[i]);
		}
		
		for(int i = 0; i < Names.ClamShell_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(clamShell, 1, i), Names.ClamShell_Name[i]);
		}
		for(int i = 0; i < Names.Lobster_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(lobster, 1, i), Names.Lobster_Name[i]);
		}
		for(int i = 0; i < Names.Clam_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(clam, 1, i), Names.Clam_Name[i]);
		}
		for(int i = 0; i < Names.Starfish_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(starfish, 1, i), Names.Starfish_Name[i]);
		}
		for(int i = 0; i < Names.SmallCrab_Name.length; i++)
		{
			LanguageRegistry.addName(new ItemStack(smallCrab, 1, i), Names.SmallCrab_Name[i]);
		}
		
	}

}
