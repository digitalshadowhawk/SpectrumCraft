package com.shadowhawk.spectrum.tools;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModMaterials;

import net.minecraft.item.ItemAxe;

public class SpectriumAxe extends ItemAxe {

	public SpectriumAxe(String name) {
		super(ModMaterials.SPECTRIUM, 8, -3);
		setUnlocalizedName(name);
		setCreativeTab(SpectrumCraft.modtab);
	}
}
