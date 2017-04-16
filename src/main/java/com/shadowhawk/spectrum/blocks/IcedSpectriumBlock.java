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

public class IcedSpectriumBlock extends BaseBlock {

    public IcedSpectriumBlock(Material material, String name) {
        super(material, name);
        this.slipperiness = 0.98F;
        this.setTickRandomly(true);
    }

    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.icedSpectriumBlock);
    }

    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
        return new ItemStack(ModBlocks.icedSpectriumBlock);
    }

    protected ItemStack createStackedBlock(IBlockState state)
    {
        return new ItemStack(ModBlocks.icedSpectriumBlock);
    }
    
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
    	if ((worldIn.getLightFor(EnumSkyBlock.BLOCK, pos) > 11 - this.getDefaultState().getLightOpacity()) && SpectrumCraft.allowIcedThaw)
        {
            this.thawBlock(worldIn, pos);
        }
    }

    protected void thawBlock(World worldIn, BlockPos pos)
    {
        worldIn.setBlockState(pos, ModBlocks.frostedSpectriumBlock.getDefaultState());
        worldIn.neighborChanged(pos, ModBlocks.frostedSpectriumBlock, pos);
    }
}