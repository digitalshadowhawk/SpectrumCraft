package com.shadowhawk.spectrum.armor;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.registry.ModMaterials;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class SpectriumArmor extends ItemArmor{

	public SpectriumArmor(String name, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(ModMaterials.SPECTRIUM_ARMOR, renderIndexIn, equipmentSlotIn);
		setUnlocalizedName(name);
		setCreativeTab(SpectrumCraft.modtab);
	}
}
