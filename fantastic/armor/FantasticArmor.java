package fantastic.armor;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.LanguageRegistry;
import fantastic.FantasticIds;
import fantastic.FantasticMod;
import fantastic.Names;

public class FantasticArmor 
{

	public static Item goggles;
	
	

	public static void init()
	{
		goggles = new ItemGoggles(FantasticIds.gogglesID, FantasticTools.SCUBA, FantasticMod.proxy.addArmor("scuba"), 0);
		
	}
	
	public static void addNames()
	{
		LanguageRegistry.addName(goggles, Names.Goggles_Name);
	}

	
}
