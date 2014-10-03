package fantastic.events;

import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import cpw.mods.fml.common.registry.VillagerRegistry.IVillageTradeHandler;
import fantastic.armor.FantasticArmor;
import fantastic.items.FantasticItems;

public class VillagerTradeHandler implements IVillageTradeHandler {

	Random rand = new Random();
	String[] FishNames = {"Bertha","Henrietta","Eugene","Agatha", "Sir Reginald", "Lord Timberton", "Mr. Wiggles", 
			"Maurice", "Agnes", "Millicent", "Beatrice", "Gertrude", "Mildred", "Myrtle", "Byron", "Luther", "Hugo", 
			"Thaddeus", "Wilfred", "Helga", "Walder", "Waldo", "Madge", "Ethel", "Granny Stumps"};
	String[] MossyNames = {"Mossette","Mossingsly","Cookie Mosster","Mossbert", "Sir Mossly", "Mossybottom"};
	@Override
	public void manipulateTradesForVillager(EntityVillager villager, MerchantRecipeList recipeList, Random random) 
	{
		ItemStack Larry = new ItemStack(FantasticItems.lobster, 1, 1);
		Larry.setStackDisplayName("Larry");
		ItemStack Mossy = new ItemStack(FantasticItems.bigFish, 1, 8);
		Mossy.setStackDisplayName(MossyNames[rand.nextInt(6)]);
		ItemStack Patrick = new ItemStack(FantasticItems.starfish, 1, 6);
		Patrick.setStackDisplayName("Patrick");
		ItemStack Fish1 = new ItemStack(FantasticItems.largeFish, 1, rand.nextInt(8));
		Fish1.setStackDisplayName(FishNames[rand.nextInt(25)]);
		ItemStack CaveFish = new ItemStack(FantasticItems.bigFish, 1, 5 + rand.nextInt(2));
		CaveFish.setStackDisplayName(FishNames[rand.nextInt(25)]);
		ItemStack Guppy = new ItemStack(FantasticItems.tinyFish, 1, rand.nextInt(9));
		Guppy.setStackDisplayName("Goobie");
		ItemStack Goggles = new ItemStack(FantasticArmor.goggles, 1, 1);
		
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 16), Larry));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 16), Mossy));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 16), Fish1));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 16), CaveFish));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 16), Guppy));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 32), Patrick));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 5), new ItemStack(Items.boat, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 3), new ItemStack(Items.fishing_rod, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 4), new ItemStack(FantasticItems.filletRaw, 10)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.legendaryFish, 1, 5 + rand.nextInt(6)), new ItemStack(Items.emerald, 25)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.legendaryFish, 1, rand.nextInt(5)), new ItemStack(Items.emerald, 20)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 2), new ItemStack(FantasticItems.pearl, 8)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 6), new ItemStack(FantasticItems.filletCooked, 8)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 4), new ItemStack(FantasticItems.clawCooked, 8)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.pearl, 6), new ItemStack(FantasticItems.tailRaw, 8)));
		recipeList.add(new MerchantRecipe(new ItemStack(FantasticItems.clamShell, 8, rand.nextInt(4)),new ItemStack(FantasticItems.pearl, 2)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.emerald, 4), new ItemStack(FantasticItems.pearl, 4), new ItemStack(FantasticItems.randomFish, rand.nextInt(5))));
		recipeList.add(new MerchantRecipe(new ItemStack(Blocks.glass, 4), new ItemStack(Items.emerald, 7), new ItemStack(FantasticArmor.goggles, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.leather_chestplate, 1), new ItemStack(Items.emerald, 7), new ItemStack(FantasticArmor.wetsuit, 1)));
		recipeList.add(new MerchantRecipe(new ItemStack(Items.leather, 4), new ItemStack(Items.emerald, 7), new ItemStack(FantasticArmor.flippers, 1)));
		
		
		
	}

}