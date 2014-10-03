package fantastic.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import cpw.mods.fml.common.registry.GameRegistry;
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
	public static Item smallclaw;
	public static Item smallcookedclaw;
	public static Item crableg;
	public static Item cookedcrableg;
	public static Item smallCrab;
	public static Item squid;
	public static Item swordfishSword;
	public static Item creeperFish;
	//public static Item woodenRod;
	public static Item randomFish;
	public static Item harpoon;
	
	public static final CreativeTabs tabFantastic = new CreativeTabs("Fantastic Fish Mod")
	{
		
		
		public String getTranslatedTabLabel()
		{
			return "Fantastic Fish Mod";
		}

		@SideOnly(Side.CLIENT)
		@Override
		public Item getTabIconItem() 
		{
			return Items.fishing_rod;
		}
	};

	public static final CreativeTabs tabFish = new CreativeTabs("Captured Critters")
	{
		@SideOnly(Side.CLIENT)
		@Override
		public Item getTabIconItem() 
		{
			return FantasticItems.tinyFish;
		}
		
		public String getTranslatedTabLabel()
		{
			return "Captured Critters";
		}
	};
	
	
	public static void init()
	{
	
		fishingNet = new ItemFishingNet().setTextureName("fantastic:" + Names.FishingNet_UnlocalizedName);
		tinyFish = new ItemTinyFish().setTextureName("fantastic:" + Names.TinyFish_UnlocalizedName);
		smallFish = new ItemSmallFish().setTextureName("fantastic:" + Names.SmallFish_UnlocalizedName);
		mediumFish = new ItemMediumFish().setTextureName("fantastic:" + Names.MediumFish_UnlocalizedName);
		bigFish = new ItemBigFish().setTextureName("fantastic:" + Names.BigFish_UnlocalizedName);
		largeFish = new ItemLargeFish().setTextureName("fantastic:" + Names.LargeFish_UnlocalizedName);
		legendaryFish = new ItemLegendaryFish().setTextureName("fantastic:" + Names.LegendaryFish_UnlocalizedName);
		filletRaw = (new ItemFishFood(1, 0.2F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(Names.RawFillet_UnlocalizedName).setTextureName("fantastic:" + Names.RawFillet_UnlocalizedName);
		filletCooked = (new ItemFishFood(5, 0.6F, true)).setUnlocalizedName(Names.CookedFillet_UnlocalizedName).setTextureName("fantastic:" + Names.CookedFillet_UnlocalizedName);
		clawRaw = (new ItemFishFood(1, 0.2F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(Names.RawClaw_UnlocalizedName).setTextureName("fantastic:" + Names.RawClaw_UnlocalizedName);
		clawCooked = (new ItemFishFood(4, 0.6F, true)).setUnlocalizedName(Names.CookedClaw_UnlocalizedName).setTextureName("fantastic:" + Names.CookedClaw_UnlocalizedName);
		tailRaw = (new ItemFishFood(1, 0.2F, true)).setPotionEffect(Potion.hunger.id, 30, 0, 0.3F).setUnlocalizedName(Names.RawTail_UnlocalizedName).setTextureName("fantastic:" + Names.RawTail_UnlocalizedName);
		tailCooked = (new ItemFishFood(8, 0.8F, true)).setUnlocalizedName(Names.CookedTail_UnlocalizedName).setTextureName("fantastic:" + Names.CookedTail_UnlocalizedName);
		sushi = (new ItemFishFood(6, 0.6F, true)).setUnlocalizedName(Names.Sushi_UnlocalizedName).setTextureName("fantastic:" + Names.Sushi_UnlocalizedName);
		smallclaw = (new ItemFishFood(1, 0.2F, true)).setUnlocalizedName(Names.SmallClaw_UnlocalizedName).setTextureName("fantastic:" + Names.SmallClaw_UnlocalizedName);
		smallcookedclaw = (new ItemFishFood(2, 0.4F, true)).setUnlocalizedName(Names.CookedSmallClaw_UnlocalizedName).setTextureName("fantastic:" + Names.CookedSmallClaw_UnlocalizedName);
		crableg = (new ItemFishFood(1, 0.2F, true)).setUnlocalizedName(Names.CrabLeg_UnlocalizedName).setTextureName("fantastic:" + Names.CrabLeg_UnlocalizedName);
		cookedcrableg = (new ItemFishFood(3, 0.5F, true)).setUnlocalizedName(Names.CookedCrabLeg_UnlocalizedName).setTextureName("fantastic:" + Names.CookedCrabLeg_UnlocalizedName);
		kelp = new ItemKelp(FantasticBlocks.plantKelp).setTextureName("fantastic:" + Names.Kelp_UnlocalizedName);
		seaweed = new ItemSeaweed(FantasticBlocks.plantSeaweed).setTextureName("fantastic:" + Names.Seaweed_UnlocalizedName);
		pearl = new ItemPearl().setTextureName("fantastic:" + Names.Pearl_UnlocalizedName);
		clamShell = new ItemClamShell().setTextureName("fantastic:" + Names.ClamShell_UnlocalizedName);
		clam = new ItemClam().setTextureName("fantastic:" + Names.Clam_UnlocalizedNam);
		lobster = new ItemLobster().setTextureName("fantastic:" + Names.Lobster_UnlocalizedName);
		starfish = new ItemStarfish().setTextureName("fantastic:" + Names.Starfish_UnlocalizedName);
		smallCrab = new ItemSmallCrab().setTextureName("fantastic:" + Names.SmallCrab_UnlocalizedName);
		squid = new ItemSquid().setTextureName("fantastic:" + Names.Squid_UnlocalizedName);
		swordfishSword = new ItemFishSword(ToolMaterial.IRON).setUnlocalizedName(Names.SwordfishSword_UnlocalizedName).setCreativeTab(tabFantastic).setTextureName("fantastic:" + Names.SwordfishSword_UnlocalizedName);
		creeperFish = new ItemCreeperFish().setTextureName("fantastic:" + Names.CreeperFish_UnlocalizedName);
		//woodenRod = new ItemWoodenRod().setTextureName("fantastic:" + Names.Wooden_Rod_UnlocalizedName);
		randomFish = new ItemRandomFish().setTextureName("fantastic:" + Names.RandomFish_UnlocalizedName);
		harpoon = new ItemHarpoon().setTextureName("fantastic:harpoon");
		
		
		
		GameRegistry.registerItem(fishingNet, Names.FishingNet_Name);
		GameRegistry.registerItem(tinyFish, Names.TinyFish_Name[1]); 
		GameRegistry.registerItem(smallFish , Names.SmallFish_Name[1]);
		GameRegistry.registerItem(mediumFish, Names.MediumFish_Name[1]);
		GameRegistry.registerItem(bigFish, Names.BigFish_Name[1]);
		GameRegistry.registerItem(largeFish, Names.LargeFish_Name[1]);
		GameRegistry.registerItem(legendaryFish, Names.LegendaryFish_Name[1]);
		GameRegistry.registerItem(filletRaw , Names.RawFillet_Name);
		GameRegistry.registerItem(filletCooked , Names.CookedFillet_Name);
		GameRegistry.registerItem(clawRaw , Names.RawClaw_Name);
		GameRegistry.registerItem(clawCooked, Names.CookedClaw_Name);
		GameRegistry.registerItem(tailRaw , Names.RawTail_Name);
		GameRegistry.registerItem(tailCooked , Names.CookedTail_Name);
		GameRegistry.registerItem(sushi , Names.Sushi_Name);
		GameRegistry.registerItem(smallclaw , Names.SmallClaw_Name);
		GameRegistry.registerItem(smallcookedclaw , Names.CookedSmallClaw_Name);
		GameRegistry.registerItem(crableg , Names.CrabLeg_Name);
		GameRegistry.registerItem(cookedcrableg, Names.CookedCrabLeg_Name);
		GameRegistry.registerItem(kelp, Names.Kelp_Name);
		GameRegistry.registerItem(seaweed , Names.Seaweed_Name);
		GameRegistry.registerItem(pearl, Names.Pearl_Name);
		GameRegistry.registerItem(clamShell , Names.ClamShell_Name[1]);
		GameRegistry.registerItem(clam, Names.Clam_Name[1]);
		GameRegistry.registerItem(lobster , Names.Lobster_Name[1]);
		GameRegistry.registerItem(starfish , Names.Starfish_Name[1]);
		GameRegistry.registerItem(smallCrab , Names.SmallCrab_Name[1]);
		GameRegistry.registerItem(squid , Names.Squid_Name);
		GameRegistry.registerItem(swordfishSword, Names.SwordfishSword_Name); 
		GameRegistry.registerItem(creeperFish, "Creepedo");
		//GameRegistry.registerItem(woodenRod, "Rod");
		GameRegistry.registerItem(randomFish , "Fish");
		GameRegistry.registerItem(harpoon, "Harpoon");
				
	}
	
	

}
