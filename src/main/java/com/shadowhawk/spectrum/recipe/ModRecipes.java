package com.shadowhawk.spectrum.recipe;

import com.shadowhawk.spectrum.registry.ModBlocks;
import com.shadowhawk.spectrum.registry.ModItems;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class ModRecipes {
	public static void init() {
		OreDictionary.registerOre("blockIce", Blocks.ICE);
		OreDictionary.registerOre("blockIce", Blocks.PACKED_ICE);
		addShapedRecipes();
        addShapelessRecipes();
        addSmelting();
    }

	private static void addSmelting() {
		GameRegistry.addSmelting(ModBlocks.spectriumOre, new ItemStack(ModItems.spectriumDust, 2),  5.0F);
		GameRegistry.addSmelting(ModBlocks.frostedSpectriumBlock, new ItemStack(ModBlocks.spectriumBlock, 1),  0.0F);
		GameRegistry.addSmelting(ModBlocks.icedSpectriumBlock, new ItemStack(ModBlocks.frostedSpectriumBlock, 1),  0.0F);
		GameRegistry.addSmelting(ModBlocks.frozenSpectriumBlock, new ItemStack(ModBlocks.icedSpectriumBlock, 1),  0.0F);
	}

	private static void addShapelessRecipes() {
		//Spectrium Block
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.spectriumBlock), ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust, ModItems.spectriumDust);
		
		//Spectrium Dust
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.spectriumDust, 9), ModBlocks.spectriumBlock);
		
		//Frosted Spectrium Block
		ShapelessOreRecipe frostedRecipe = new ShapelessOreRecipe(new ItemStack(ModBlocks.frostedSpectriumBlock), ModBlocks.spectriumBlock, "blockIce");
		GameRegistry.addRecipe(frostedRecipe);
		
	}

	private static void addShapedRecipes() {
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
		
	}
}
