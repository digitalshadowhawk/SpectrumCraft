package com.shadowhawk.spectrum.registry;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.items.ItemSpectriumDust;
import com.shadowhawk.spectrum.tools.SpectriumAxe;
import com.shadowhawk.spectrum.tools.SpectriumHoe;
import com.shadowhawk.spectrum.tools.SpectriumPickaxe;
import com.shadowhawk.spectrum.tools.SpectriumSpade;
import com.shadowhawk.spectrum.tools.SpectriumSword;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	public static Item spectriumDust;
	public static ItemPickaxe spectriumPickaxe;
	public static ItemSword spectriumSword;
	public static ItemSpade spectriumSpade;
	public static ItemHoe spectriumHoe;
	public static ItemAxe spectriumAxe;
	//public static ItemArmor spectriumHelmet;
	//public static ItemArmor spectriumChestplate;
	//public static ItemArmor spectriumLeggings;
	//public static ItemArmor spectriumBoots;

    public static void preInit(){
    	spectriumDust = new ItemSpectriumDust("spectrium_dust");
    	spectriumPickaxe = new SpectriumPickaxe("spectrium_pickaxe");
    	spectriumSword = new SpectriumSword("spectrium_sword");
    	spectriumSpade = new SpectriumSpade("spectrium_shovel");
    	spectriumHoe = new SpectriumHoe("spectrium_hoe");
    	spectriumAxe = new SpectriumAxe("spectrium_axe");
    	//spectriumHelmet = new SpectriumArmor("spectrium_helmet", 0, EntityEquipmentSlot.HEAD);
    	//spectriumChestplate = new SpectriumArmor("spectrium_chestplate", 0, EntityEquipmentSlot.CHEST);
    	//spectriumLeggings = new SpectriumArmor("spectrium_leggings", 1, EntityEquipmentSlot.LEGS);
    	//spectriumBoots = new SpectriumArmor("spectrium_boots", 0, EntityEquipmentSlot.FEET);

        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(spectriumDust, new ResourceLocation(SpectrumCraft.MODID, "spectrium_dust"));
        GameRegistry.register(spectriumPickaxe, new ResourceLocation(SpectrumCraft.MODID, "spectrium_pickaxe"));
        GameRegistry.register(spectriumSword, new ResourceLocation(SpectrumCraft.MODID, "spectrium_sword"));
        GameRegistry.register(spectriumSpade, new ResourceLocation(SpectrumCraft.MODID, "spectrium_shovel"));
        GameRegistry.register(spectriumHoe, new ResourceLocation(SpectrumCraft.MODID, "spectrium_hoe"));
        GameRegistry.register(spectriumAxe, new ResourceLocation(SpectrumCraft.MODID, "spectrium_axe"));
        //GameRegistry.register(spectriumHelmet, new ResourceLocation(SpectrumCraft.MODID, "spectrium_helmet"));
        //GameRegistry.register(spectriumChestplate, new ResourceLocation(SpectrumCraft.MODID, "spectrium_chestplate"));
        //GameRegistry.register(spectriumLeggings, new ResourceLocation(SpectrumCraft.MODID, "spectrium_leggings"));
        //GameRegistry.register(spectriumBoots, new ResourceLocation(SpectrumCraft.MODID, "spectrium_boots"));
    }

    public static void registerRenders() {
        registerRender(spectriumDust);
        registerRender(spectriumPickaxe);
        registerRender(spectriumSword);
        registerRender(spectriumSpade);
        registerRender(spectriumHoe);
        registerRender(spectriumAxe);
        //registerRender(spectriumHelmet);
        //registerRender(spectriumChestplate);
        //registerRender(spectriumLeggings);
        //registerRender(spectriumBoots);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(SpectrumCraft.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}
