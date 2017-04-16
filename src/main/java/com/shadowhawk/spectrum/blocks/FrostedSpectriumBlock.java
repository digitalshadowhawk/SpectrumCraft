package com.shadowhawk.spectrum.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

public class FrostedSpectriumBlock extends BaseBlock {

    public FrostedSpectriumBlock(Material material, String name) {
        super(material, name);
        this.slipperiness = 0.98F;
        this.setTickRandomly(true);
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.frostedSpectriumBlock);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.frostedSpectriumBlock);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.frostedSpectriumBlock);
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if ((worldIn.getLightFor(EnumSkyBlock.BLOCK, pos) > 11 - this.getDefaultState().getLightOpacity()) && SpectrumCraft.allowFrostedThaw)
        {
            this.thawBlock(worldIn, pos);
        }
    }

    protected void thawBlock(World worldIn, BlockPos pos)
    {
        worldIn.setBlockState(pos, ModBlocks.spectriumBlock.getDefaultState());
        worldIn.neighborChanged(pos, ModBlocks.spectriumBlock, pos);
    }
}