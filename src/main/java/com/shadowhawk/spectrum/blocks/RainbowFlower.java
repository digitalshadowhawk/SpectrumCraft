package com.shadowhawk.spectrum.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.shadowhawk.spectrum.registry.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RainbowFlower extends Flower{

	public RainbowFlower(Material material, String name) {
		super(material, name);
	}

	@Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.rainbowRose);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.rainbowRose);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.rainbowRose);
    }
}
