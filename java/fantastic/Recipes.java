package fantastic;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import fantastic.armor.FantasticArmor;
import fantastic.blocks.FantasticBlocks;
import fantastic.items.FantasticItems;

public class Recipes 
{
	public static void init()
	{
		//Shell Armors
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.blueShellHelm, 1), new Object[]{
			"$*$",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 0), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.blueShellChest, 1), new Object[]{
			"$ $",
			"$*$",
			"$$$",

			'$', new ItemStack(FantasticItems.clamShell, 1, 0), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.blueShellLegs, 1), new Object[]{
			"$*$",
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 0), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.blueShellBoots, 1), new Object[]{
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 0)
		});
		
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.greenShellHelm, 1), new Object[]{
			"$*$",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 1), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.greenShellChest, 1), new Object[]{
			"$ $",
			"$*$",
			"$$$",

			'$', new ItemStack(FantasticItems.clamShell, 1, 1), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.greenShellLegs, 1), new Object[]{
			"$*$",
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 1), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.greenShellBoots, 1), new Object[]{
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 1)
		});
		
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.yellowShellHelm, 1), new Object[]{
			"$*$",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 2), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.yellowShellChest, 1), new Object[]{
			"$ $",
			"$*$",
			"$$$",

			'$', new ItemStack(FantasticItems.clamShell, 1, 2), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.yellowShellLegs, 1), new Object[]{
			"$*$",
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 2), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.yellowShellBoots, 1), new Object[]{
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 2)
		});
		
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.purpleShellHelm, 1), new Object[]{
			"$*$",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 3), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.purpleShellChest, 1), new Object[]{
			"$ $",
			"$*$",
			"$$$",

			'$', new ItemStack(FantasticItems.clamShell, 1, 3), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.purpleShellLegs, 1), new Object[]{
			"$*$",
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 3), '*', FantasticItems.pearl
		});
		GameRegistry.addRecipe(new ItemStack(FantasticArmor.purpleShellBoots, 1), new Object[]{
			"$ $",
			"$ $",

			 '$', new ItemStack(FantasticItems.clamShell, 1, 3)
		});
		
		
		//Fishing Net
				GameRegistry.addRecipe(new ItemStack(FantasticItems.fishingNet, 1), new Object[]{
					" **",
					" **",
					"#  ",

					'#', Items.stick, '*', Items.string
				});
		//Air Compressor
				GameRegistry.addRecipe(new ItemStack(FantasticBlocks.airComp, 1), new Object[]{
					"  $",
					"*&*",
					"###",

					'#', Blocks.stone_slab, '*', Blocks.iron_block, '$', Blocks.piston, '&', Blocks.redstone_block
				});
		//Diver Suit
				GameRegistry.addRecipe(new ItemStack(FantasticArmor.diverHelm, 1), new Object[]{
					"$*$",
					"*#*",
					"$*$",

					'#', Items.iron_helmet, '$', Items.iron_ingot, '*', Blocks.glass
				});
				
				
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticArmor.diverChest, 1), new ItemStack(FantasticArmor.singleTank, 1), new ItemStack(Items.iron_chestplate, 1));
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticItems.finSoup, 1), new ItemStack(FantasticItems.seaweed, 1), new ItemStack(Items.bowl, 1), new ItemStack(Items.water_bucket, 1), new ItemStack(FantasticItems.sharkFin, 1));
				for(int i = 0; i < 8400; i++)
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticArmor.diverChest, 1, i), new ItemStack(FantasticArmor.singleTank, 1), new ItemStack(FantasticArmor.diverChest, 1, i));
				
				GameRegistry.addRecipe(new ItemStack(FantasticArmor.diverPants, 1), new Object[]{
					"$$$",
					"$#$",
					"$ $",

					'#', Items.leather_leggings, '$', Items.iron_ingot
				});
				GameRegistry.addRecipe(new ItemStack(FantasticArmor.diverBoots, 1), new Object[]{
					"$#$",
					"* *",

					'#', Items.iron_boots, '$', Items.leather, '*', Items.iron_ingot
				});
				
				//Scuba Tanks
				GameRegistry.addRecipe(new ItemStack(FantasticArmor.scubaTank, 1), new Object[]{
					"$#$",

					'#', Items.string, '$', FantasticArmor.singleTank, 
				});
				GameRegistry.addRecipe(new ItemStack(FantasticArmor.singleTank, 1), new Object[]{
					"$$$",
					"$#$",
					"$$$",

					'$', Items.iron_ingot, '#', Items.glass_bottle
				});
				
				// Harpoon
				GameRegistry.addRecipe(new ItemStack(FantasticItems.harpoon, 1), new Object[]{
					"  $",
					" #*",
					"# *",

					'#', Items.stick, '$', Items.iron_ingot, '*', Items.lead
				});
		//Ender Pearls
				GameRegistry.addShapelessRecipe(new ItemStack(Items.ender_pearl, 1), new ItemStack(Blocks.end_stone, 1), new ItemStack(FantasticItems.pearl, 1));
				
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticItems.sushi, 1), new ItemStack(FantasticItems.seaweed, 1), new ItemStack(FantasticItems.filletRaw, 1));
			//Salmon
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticItems.tinyFish, 1, 12), new ItemStack(Items.fish, 1, 1));
			//Aquarium Glass
				GameRegistry.addShapelessRecipe(new ItemStack(FantasticBlocks.aquariumGlass, 1), new ItemStack(Blocks.glass_pane, 1));
				
				
		//Fish Fillets

				ItemStack sailfish = new ItemStack(FantasticItems.randomFish, 1, 0);
				for(int i = 0; i < 14; i++)
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
				GameRegistry.addRecipe(new ItemStack(FantasticItems.creeperFish, 1, 0), new Object[]{
					"***",
					"*#*",
					"***",

					'#', tinyFish, '*', Items.gunpowder
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.creeperFish, 1, 0), new Object[]{
					"***",
					"*#*",
					"***",

					'#', smallFish, '*', Items.gunpowder
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.creeperFish, 1, 1), new Object[]{
					"***",
					"*#*",
					"***",

					'#', mediumFish, '*', Items.gunpowder
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.creeperFish, 1, 1), new Object[]{
					"***",
					"*#*",
					"***",

					'#', bigFish, '*', Items.gunpowder
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.creeperFish, 1, 2), new Object[]{
					"***",
					"*#*",
					"***",

					'#', largeFish, '*', Items.gunpowder
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.creeperFish, 1, 2), new Object[]{
					"***",
					"*#*",
					"***",

					'#', legendaryFish, '*', Items.gunpowder
				});
				

				GameRegistry.addSmelting(FantasticItems.tinyFish, new ItemStack(FantasticItems.filletCooked, 1), 0.0F);
				GameRegistry.addSmelting(FantasticItems.smallFish, new ItemStack(FantasticItems.filletCooked, 2), 0.25F);
				GameRegistry.addSmelting(FantasticItems.mediumFish, new ItemStack(FantasticItems.filletCooked, 3), 0.25F);
				GameRegistry.addSmelting(FantasticItems.bigFish, new ItemStack(FantasticItems.filletCooked, 4), 0.35F);
				GameRegistry.addSmelting(FantasticItems.largeFish, new ItemStack(FantasticItems.filletCooked, 5), 0.45F);
				GameRegistry.addSmelting(FantasticItems.legendaryFish, new ItemStack(FantasticItems.filletCooked, 10), 0.55F);
				}
				GameRegistry.addRecipe(new ItemStack(FantasticItems.filletRaw, 6), new Object[]{
					"*",

					'*', sailfish
				});
				GameRegistry.addRecipe(new ItemStack(FantasticItems.swordfishSword, 1), new Object[]{
					"*",
					"#",

					'*', sailfish, '#', Items.stick
				});
				GameRegistry.addSmelting(FantasticItems.filletRaw, new ItemStack(FantasticItems.filletCooked), 0.35F);
				GameRegistry.addSmelting(FantasticItems.tailRaw, new ItemStack(FantasticItems.tailCooked), 0.35F);
				GameRegistry.addSmelting(FantasticItems.clawRaw, new ItemStack(FantasticItems.clawCooked), 0.35F);
	}
}
