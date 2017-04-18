package com.shadowhawk.spectrum.tools;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModMaterials;

import net.minecraft.item.ItemHoe;

public class SpectriumHoe extends ItemHoe{

	public SpectriumHoe(String name) {
		super(ModMaterials.SPECTRIUM);
		setUnlocalizedName(name);
		setCreativeTab(SpectrumCraft.modtab);
	}

}
