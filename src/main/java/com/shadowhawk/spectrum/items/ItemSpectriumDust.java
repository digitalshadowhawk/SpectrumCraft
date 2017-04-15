package com.shadowhawk.spectrum.items;

import com.shadowhawk.spectrum.SpectrumCraft;

import net.minecraft.item.Item;

public class ItemSpectriumDust extends Item {
    public ItemSpectriumDust(String name)
    {
        setUnlocalizedName(name);
        this.maxStackSize = 64;
        this.setCreativeTab(SpectrumCraft.modtab);
    }
}
