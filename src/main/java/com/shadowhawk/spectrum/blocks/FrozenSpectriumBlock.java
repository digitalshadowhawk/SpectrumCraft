package com.shadowhawk.spectrum.blocks;

import java.util.Random;

import javax.annotation.Nullable;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModBlocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class FrozenSpectriumBlock extends BaseBlock {

    public FrozenSpectriumBlock(Material material, String name) {
        super(material, name);
        this.slipperiness = 1.0F;
        this.setTickRandomly(true);
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.frozenSpectriumBlock);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.frozenSpectriumBlock);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.frozenSpectriumBlock);
    }
    
    @SuppressWarnings("deprecation")
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if ((worldIn.getLightFor(EnumSkyBlock.BLOCK, pos) > 11 - this.getDefaultState().getLightOpacity()) && SpectrumCraft.allowFrozenThaw)
        {
            this.thawBlock(worldIn, pos);
        }
    }

    protected void thawBlock(World worldIn, BlockPos pos)
    {
        worldIn.setBlockState(pos, ModBlocks.icedSpectriumBlock.getDefaultState());
        worldIn.neighborChanged(pos, ModBlocks.icedSpectriumBlock, pos);
    }
}