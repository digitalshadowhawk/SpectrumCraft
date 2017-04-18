package com.shadowhawk.spectrum.tools;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModMaterials;

import net.minecraft.item.ItemSpade;

public class SpectriumSpade extends ItemSpade{

	public SpectriumSpade(String name) {
		super(ModMaterials.SPECTRIUM);
		setUnlocalizedName(name);
		setCreativeTab(SpectrumCraft.modtab);
	}

}
