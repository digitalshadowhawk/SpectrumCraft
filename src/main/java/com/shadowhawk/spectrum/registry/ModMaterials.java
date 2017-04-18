package com.shadowhawk.spectrum.registry;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModMaterials {
	public static ToolMaterial SPECTRIUM = EnumHelper.addToolMaterial("spectrium", 3, 1000, 8F, 3F, 20);
	public static ArmorMaterial SPECTRIUM_ARMOR = EnumHelper.addArmorMaterial("spectrium_armor", "spectrum:spectrium_armor", 1500, new int[]{2,5,7,2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8F);
}
