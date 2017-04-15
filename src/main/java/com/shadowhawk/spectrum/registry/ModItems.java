package com.shadowhawk.spectrum.registry;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.items.ItemSpectriumDust;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {
	public static Item spectriumdust;

    public static void preInit(){
    	spectriumdust = new ItemSpectriumDust("spectrium_dust");

        registerItems();
    }

    public static void registerItems() {
        GameRegistry.register(spectriumdust, new ResourceLocation(SpectrumCraft.MODID, "spectrium_dust"));
    }

    public static void registerRenders() {
        registerRender(spectriumdust);
    }

    private static void registerRender(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(SpectrumCraft.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}