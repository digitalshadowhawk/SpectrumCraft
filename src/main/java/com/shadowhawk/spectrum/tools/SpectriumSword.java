package com.shadowhawk.spectrum.tools;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModMaterials;

import net.minecraft.item.ItemSword;

public class SpectriumSword extends ItemSword {

	public SpectriumSword(String name) {
		super(ModMaterials.SPECTRIUM);
		setUnlocalizedName(name);
		setCreativeTab(SpectrumCraft.modtab);
	}

}
