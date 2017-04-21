package com.shadowhawk.spectrum.recipe;

import java.util.List;

import com.shadowhawk.spectrum.registry.ModBlocks;
import com.shadowhawk.spectrum.registry.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
	public static void init() {
		OreDictionary.registerOre("blockIce", Blocks.ICE);
		OreDictionary.registerOre("blockIce", Blocks.PACKED_ICE);
		removeRecipe(new ItemStack(Items.DYE, 2, EnumDyeColor.RED.getDyeDamage()));
		addShapedRecipes();
        addShapelessRecipes();
        addSmelting();
        addBrewing();
    }
	
	public static void removeRecipe(ItemStack resultItem) {
	    List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
	    for(int i = 0; i < recipes.size(); i++) {
	      IRecipe tmpRecipe = recipes.get(i);
	      ItemStack recipeResult = tmpRecipe.getRecipeOutput();
	      if(ItemStack.areItemStacksEqual(resultItem, recipeResult)) {
	        recipes.remove(i--);
	      }
	    }
	  }

	private static void addBrewing() {

		//IBrewingRecipe recipe = new BrewingRecipe(new ItemStack(Items.POTIONITEM), new ItemStack(ModItems.spectriumDust), new ItemStack(PotionType.getPotionTypeForName("rainbow")));
		//Predicate<ItemStack> predicate = new PotionHelper.ItemPredicateInstance(ModItems.spectriumDust);
		//System.out.println(predicate.toString());
		//PotionHelper.registerPotionTypeConversion(PotionTypes.AWKWARD, predicate, PotionType.getPotionTypeForName("rainnbow"));
		//BrewingRecipeRegistry.addRecipe(recipe);
	}

	private static void addSmelting() {
		GameRegistry.addSmelting(ModBlocks.spectriumOre, new ItemStack(ModItems.spectriumDust, 2),  5.0F);
		GameRegistry.addSmelting(ModBlocks.frostedSpectriumBlock, new ItemStack(ModBlocks.spectriumBlock, 1),  0.0F);
		GameRegistry.addSmelting(ModBlocks.icedSpectriumBlock, new ItemStack(ModBlocks.spectriumBlock, 1),  0.0F);
		GameRegistry.addSmelting(ModBlocks.frozenSpectriumBlock, new ItemStack(ModBlocks.spectriumBlock, 1),  0.0F);
	}

	private static void addShapelessRecipes() {
		//Spectrium Block
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.spectriumBlock), ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust);
		
		//Spectrium Dust
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.spectriumDust, 9), ModBlocks.spectriumBlock);
		
		//Frosted Spectrium Block
		ShapelessOreRecipe frostedRecipe = new ShapelessOreRecipe(new ItemStack(ModBlocks.frostedSpectriumBlock), ModBlocks.spectriumBlock, "blockIce");
		GameRegistry.addRecipe(frostedRecipe);
		
		
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.rose, 2), new ItemStack(Blocks.DOUBLE_PLANT, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.rainbowRose), ModBlocks.rose, ModItems.spectriumDust);
		GameRegistry.addShapelessRecipe(new ItemStack(Items.DYE, 1, 1),ModBlocks.rose);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.spectriumDust), ModBlocks.rainbowRose);
		
	}

	private static void addShapedRecipes() {
		//Rainbow Torch
		ShapedOreRecipe spectriumTorch = new ShapedOreRecipe(ModBlocks.spectriumTorch, "A", "B", 'A', ModItems.spectriumDust, 'B', Items.STICK);
		
		GameRegistry.addRecipe(spectriumTorch);
		
		//Iced Spectrium Block		
		ShapedOreRecipe icedFromNormal = new ShapedOreRecipe(ModBlocks.icedSpectriumBlock, " B ", "BAB", " B ", 'A', ModBlocks.spectriumBlock, 'B', "blockIce");
		ShapedOreRecipe icedFromFrosted1 = new ShapedOreRecipe(ModBlocks.icedSpectriumBlock, "AB", "BB", 'A', ModBlocks.frostedSpectriumBlock, 'B', "blockIce");
		ShapedOreRecipe icedFromFrosted2 = new ShapedOreRecipe(ModBlocks.icedSpectriumBlock, "BA", "BB", 'A', ModBlocks.frostedSpectriumBlock, 'B', "blockIce");
		ShapedOreRecipe icedFromFrosted3 = new ShapedOreRecipe(ModBlocks.icedSpectriumBlock, "BB", "AB", 'A', ModBlocks.frostedSpectriumBlock, 'B', "blockIce");
		ShapedOreRecipe icedFromFrosted4 = new ShapedOreRecipe(ModBlocks.icedSpectriumBlock, "BB", "BA", 'A', ModBlocks.frostedSpectriumBlock, 'B', "blockIce");
		
		GameRegistry.addRecipe(icedFromNormal);
		GameRegistry.addRecipe(icedFromFrosted1);
		GameRegistry.addRecipe(icedFromFrosted2);
		GameRegistry.addRecipe(icedFromFrosted3);
		GameRegistry.addRecipe(icedFromFrosted4);
		
		//Frozen Spectrium Block
		ShapedOreRecipe frozenFromNormal = new ShapedOreRecipe(ModBlocks.frozenSpectriumBlock, "BBB", "BAB", "BBB", 'A', ModBlocks.spectriumBlock, 'B', "blockIce");
		ShapedOreRecipe frozenFromIced = new ShapedOreRecipe(ModBlocks.frozenSpectriumBlock, " B ", "BAB", " B ", 'A', ModBlocks.icedSpectriumBlock, 'B', "blockIce");
		
		GameRegistry.addRecipe(frozenFromNormal);
		GameRegistry.addRecipe(frozenFromIced);
		
		//Armor Recipes
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumHelmet), "AAA", "A A", 'A', ModItems.spectriumDust);
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumChestplate), "A A", "AAA", "AAA", 'A', ModItems.spectriumDust);
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumLeggings), "AAA", "A A", "A A", 'A', ModItems.spectriumDust);
		//GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumBoots), "A A", "A A", 'A', ModItems.spectriumDust);
		
		//Tools
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumPickaxe), "AAA", " B ", " B ", 'A', ModItems.spectriumDust, 'B', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumSword), "A", "A", "B",  'A', ModItems.spectriumDust, 'B', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumSpade), "A", "B", "B",  'A', ModItems.spectriumDust, 'B', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumHoe), "AA", " B", " B", 'A', ModItems.spectriumDust, 'B', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumHoe), "AA", "B ", "B ", 'A', ModItems.spectriumDust, 'B', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumAxe), "AA", "AB", " B", 'A', ModItems.spectriumDust, 'B', Items.STICK);
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.spectriumAxe), "AA", "BA", "B ", 'A', ModItems.spectriumDust, 'B', Items.STICK);
	}
}
