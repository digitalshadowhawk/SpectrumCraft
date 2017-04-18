package com.shadowhawk.spectrum.tools;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModMaterials;

import net.minecraft.item.ItemPickaxe;

public class SpectriumPickaxe extends ItemPickaxe{

	public SpectriumPickaxe(String name) {
		super(ModMaterials.SPECTRIUM);
		setUnlocalizedName(name);
		setCreativeTab(SpectrumCraft.modtab);
	}

}
