package com.shadowhawk.spectrum.blocks;

import com.shadowhawk.spectrum.SpectrumCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BaseBlock extends Block {

    protected BaseBlock(Material material, String name) {
        super(material);
        this.setUnlocalizedName(name);
        this.setCreativeTab(SpectrumCraft.modtab);
        this.setResistance(100F);
        this.setHardness(0.5F);
    }
}
