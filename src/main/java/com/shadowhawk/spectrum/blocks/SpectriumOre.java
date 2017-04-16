package com.shadowhawk.spectrum.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.shadowhawk.spectrum.registry.ModBlocks;
import com.shadowhawk.spectrum.registry.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SpectriumOre extends BaseBlock{
	  
	public SpectriumOre(Material material, String name) {
        super(material, name);
    }
	  
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.spectriumDust;
	}

	public int quantityDropped(Random random) {
		return this == this ? 1 + random.nextInt(5) : 1;
	}
	
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.spectriumOre);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.spectriumOre);
    }
}
