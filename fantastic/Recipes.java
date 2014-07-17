package fantastic;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import fantastic.items.FantasticItems;

public class Recipes 
{
	public static void init()
	{
		//Fishing Net
				GameRegistry.addRecipe(new ItemStack(FantasticItems.fishingNet, 1), new Object[]{
					" **",
					" **",
					"#  ",

					'#', Item.stick, '*', Item.silk
				});
		//Ender Pearls
				GameRegistry.addShapelessRecipe(new ItemStack(Item.enderPearl, 1), new ItemStack(Block.whiteStone, 1), new ItemStack(FantasticItems.pearl, 1));
				
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticItems.sushi, 1), new ItemStack(FantasticItems.seaweed, 1), new ItemStack(FantasticItems.filletRaw, 1));
				
				
		//Fish Fillets
				
				for(int i = 0; i < 9; i++)
				{
					
					ItemStack tinyFish = new ItemStack(FantasticItems.tinyFish, 1, i);
					ItemStack smallFish = new ItemStack(FantasticItems.smallFish, 1, i);
					ItemStack mediumFish = new ItemStack(FantasticItems.mediumFish, 1, i);
					ItemStack bigFish = new ItemStack(FantasticItems.bigFish, 1, i);
					ItemStack largeFish = new ItemStack(FantasticItems.largeFish, 1, i);
					ItemStack legendaryFish = new ItemStack(FantasticItems.legendaryFish, 1, i);
					
					
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 1), new Object[]{
					"*",

					'*', tinyFish 
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 2), new Object[]{
					"*",

					'*', smallFish
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 3), new Object[]{
					"*",

					'*', mediumFish
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 4), new Object[]{
					"*",

					'*', bigFish
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 5), new Object[]{
					"*",

					'*', largeFish
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 10), new Object[]{
					"*",

					'*', legendaryFish
				});
				

				GameRegistry.addSmelting(FantasticItems.tinyFish.itemID, new ItemStack(FantasticItems.filletCooked, 1), 0.0F);
				GameRegistry.addSmelting(FantasticItems.smallFish.itemID, new ItemStack(FantasticItems.filletCooked, 2), 0.25F);
				GameRegistry.addSmelting(FantasticItems.mediumFish.itemID, new ItemStack(FantasticItems.filletCooked, 3), 0.25F);
				GameRegistry.addSmelting(FantasticItems.bigFish.itemID, new ItemStack(FantasticItems.filletCooked, 4), 0.35F);
				GameRegistry.addSmelting(FantasticItems.largeFish.itemID, new ItemStack(FantasticItems.filletCooked, 5), 0.45F);
				GameRegistry.addSmelting(FantasticItems.legendaryFish.itemID, new ItemStack(FantasticItems.filletCooked, 10), 0.55F);
				}
				GameRegistry.addSmelting(FantasticItems.filletRaw.itemID, new ItemStack(FantasticItems.filletCooked), 0.35F);
				GameRegistry.addSmelting(FantasticItems.tailRaw.itemID, new ItemStack(FantasticItems.tailCooked), 0.35F);
				GameRegistry.addSmelting(FantasticItems.clawRaw.itemID, new ItemStack(FantasticItems.clawCooked), 0.35F);
	}
}
