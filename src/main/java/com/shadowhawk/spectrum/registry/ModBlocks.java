package com.shadowhawk.spectrum.registry;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.blocks.SpectriumBlock;
import com.shadowhawk.spectrum.blocks.SpectriumOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

    public static SpectriumBlock spectriumBlock;
    public static SpectriumOre spectriumOre;

    public static void preInit(){
    	spectriumBlock = new SpectriumBlock(Material.ROCK, "spectrium_block");
    	spectriumOre = new SpectriumOre(Material.ROCK, "spectrium_ore");

        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(spectriumBlock, "spectrium_block");
        registerBlock(spectriumOre, "spectrium_ore");
    }

    public static void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation(SpectrumCraft.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(SpectrumCraft.MODID, name));
    }

    public static void registerRenders() {
        registerRender(spectriumBlock);
        registerRender(spectriumOre);
    }

    private static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
