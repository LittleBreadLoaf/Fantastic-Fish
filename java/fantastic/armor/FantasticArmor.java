package fantastic.armor;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fantastic.FantasticMod;
import fantastic.Names;

public class FantasticArmor 
{

	public static Item goggles;
	public static Item singleTank;
	public static Item scubaTank;
	public static Item wetsuit;
	public static Item flippers;
	public static Item diverHelm;
	public static Item diverChest;
	public static Item diverPants;
	public static Item diverBoots;
	
	public static Item blueShellHelm;
	public static Item yellowShellHelm;
	public static Item greenShellHelm;
	public static Item purpleShellHelm;
	
	public static Item blueShellChest;
	public static Item yellowShellChest;
	public static Item greenShellChest;
	public static Item purpleShellChest;

	public static Item blueShellLegs;
	public static Item yellowShellLegs;
	public static Item greenShellLegs;
	public static Item purpleShellLegs;

	public static Item blueShellBoots;
	public static Item yellowShellBoots;
	public static Item greenShellBoots;
	public static Item purpleShellBoots;
	

	public static void init()
	{
		goggles = new ItemGoggles(FantasticTools.SCUBA, FantasticMod.proxy.addArmor("goggles"), 0);
		singleTank = new ItemSingleTank(FantasticTools.STANK, FantasticMod.proxy.addArmor("single"), 1);
		scubaTank = new ItemScubaTank(FantasticTools.TANK, FantasticMod.proxy.addArmor("scuba"), 1);
		wetsuit = new ItemWetsuit(FantasticTools.SCUBA, FantasticMod.proxy.addArmor("wetsuit"), 2);
		flippers = new ItemFlippers(FantasticTools.SCUBA, FantasticMod.proxy.addArmor("flippers"), 3);
		
		diverHelm = new ItemDiverHelmet(ArmorMaterial.IRON, FantasticMod.proxy.addArmor("brass_helm"), 0);
		diverChest = new ItemDiverChest(ArmorMaterial.IRON, FantasticMod.proxy.addArmor("brass_chest"), 1);
		diverPants = new ItemDiverPants(ArmorMaterial.IRON, FantasticMod.proxy.addArmor("brass_pants"), 2);
		diverBoots = new ItemDiverBoots(ArmorMaterial.IRON, FantasticMod.proxy.addArmor("brass_boots"), 3);
		
		blueShellHelm = new ItemBlueShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("blue_helm"), 0).setUnlocalizedName("shellhelmet_blue");
		blueShellChest = new ItemBlueShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("blue_chest"), 1).setUnlocalizedName("shellarmor_blue");
		blueShellLegs = new ItemBlueShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("blue_legs"), 2).setUnlocalizedName("shellbottom_blue");
		blueShellBoots = new ItemBlueShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("blue_boots"), 3).setUnlocalizedName("shellboots_blue");
		
		greenShellHelm = new ItemGreenShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("green_helm"), 0).setUnlocalizedName("shellhelmet_green");
		greenShellChest = new ItemGreenShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("green_chest"), 1).setUnlocalizedName("shellarmor_green");
		greenShellLegs = new ItemGreenShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("green_legs"), 2).setUnlocalizedName("shellbottom_green");
		greenShellBoots = new ItemGreenShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("green_boots"), 3).setUnlocalizedName("shellboots_green");
		
		yellowShellHelm = new ItemYellowShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("yellow_helm"), 0).setUnlocalizedName("shellhelmet_yellow");
		yellowShellChest = new ItemYellowShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("yellow_chest"), 1).setUnlocalizedName("shellarmor_yellow");
		yellowShellLegs = new ItemYellowShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("yellow_legs"), 2).setUnlocalizedName("shellbottom_yellow");
		yellowShellBoots = new ItemYellowShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("yellow_boots"), 3).setUnlocalizedName("shellboots_yellow");
		
		purpleShellHelm = new ItemPurpleShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("purple_helm"), 0).setUnlocalizedName("shellhelmet_purple");
		purpleShellChest = new ItemPurpleShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("purple_chest"), 1).setUnlocalizedName("shellarmor_purple");
		purpleShellLegs = new ItemPurpleShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("purple_legs"), 2).setUnlocalizedName("shellbottom_purple");
		purpleShellBoots = new ItemPurpleShellArmor(FantasticTools.SHELL, FantasticMod.proxy.addArmor("purple_boots"), 3).setUnlocalizedName("shellboots_purple");
		
		GameRegistry.registerItem(goggles, Names.Goggles_Name);
		GameRegistry.registerItem(singleTank, "Single Tank");
		GameRegistry.registerItem(scubaTank, "Scuba Tank");
		GameRegistry.registerItem(wetsuit, "Wet Suit");
		GameRegistry.registerItem(flippers, "Flippers");
		GameRegistry.registerItem(diverHelm, "Diver's Helmet");
		GameRegistry.registerItem(diverChest, "Diver's Suit");
		GameRegistry.registerItem(diverPants, "Diver's Pants");
		GameRegistry.registerItem(diverBoots, "Diver's Boots");
		
		GameRegistry.registerItem(blueShellBoots, "Blue Shell Boots");
		GameRegistry.registerItem(blueShellLegs, "Blue Shell Leggings");
		GameRegistry.registerItem(blueShellChest, "Blue Shell Chestplate");
		GameRegistry.registerItem(blueShellHelm, "Blue Shell Helm");
		
		GameRegistry.registerItem(greenShellBoots, "Green Shell Boots");
		GameRegistry.registerItem(greenShellLegs, "Green Shell Leggings");
		GameRegistry.registerItem(greenShellChest, "Green Shell Chestplate");
		GameRegistry.registerItem(greenShellHelm, "Green Shell Helm");
		
		GameRegistry.registerItem(yellowShellBoots, "Yellow Shell Boots");
		GameRegistry.registerItem(yellowShellLegs, "Yellow Shell Leggings");
		GameRegistry.registerItem(yellowShellChest, "Yellow Shell Chestplate");
		GameRegistry.registerItem(yellowShellHelm, "Yellow Shell Helm");
		
		GameRegistry.registerItem(purpleShellBoots, "Purple Shell Boots");
		GameRegistry.registerItem(purpleShellLegs, "Purple Shell Leggings");
		GameRegistry.registerItem(purpleShellChest, "Purple Shell Chestplate");
		GameRegistry.registerItem(purpleShellHelm, "Purple Shell Helm");
	}
	

	
}
