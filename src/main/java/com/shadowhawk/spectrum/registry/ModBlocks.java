package com.shadowhawk.spectrum.registry;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.blocks.FrostedSpectriumBlock;
import com.shadowhawk.spectrum.blocks.FrozenSpectriumBlock;
import com.shadowhawk.spectrum.blocks.IcedSpectriumBlock;
import com.shadowhawk.spectrum.blocks.SpectriumBlock;
import com.shadowhawk.spectrum.blocks.SpectriumOre;
import com.shadowhawk.spectrum.blocks.SpectriumTorch;

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
    public static FrostedSpectriumBlock frostedSpectriumBlock;
    public static IcedSpectriumBlock icedSpectriumBlock;
    public static FrozenSpectriumBlock frozenSpectriumBlock;
    public static SpectriumTorch spectriumTorch;

    public static void preInit(){
    	spectriumBlock = new SpectriumBlock(Material.ROCK, "spectrium_block");
    	spectriumOre = new SpectriumOre(Material.ROCK, "spectrium_ore");
    	frostedSpectriumBlock = new FrostedSpectriumBlock(Material.PACKED_ICE, "frosted_spectrium_block");
    	icedSpectriumBlock = new IcedSpectriumBlock(Material.PACKED_ICE, "iced_spectrium_block");
    	frozenSpectriumBlock = new FrozenSpectriumBlock(Material.PACKED_ICE, "frozen_spectrium_block");
    	spectriumTorch = new SpectriumTorch(Material.CIRCUITS, "spectrium_torch");

        registerBlocks();
    }

    public static void registerBlocks() {
        registerBlock(spectriumBlock, "spectrium_block");
        registerBlock(spectriumOre, "spectrium_ore");
        registerBlock(frostedSpectriumBlock, "frosted_spectrium_block");
        registerBlock(icedSpectriumBlock, "iced_spectrium_block");
        registerBlock(frozenSpectriumBlock, "frozen_spectrium_block");
        registerBlock(spectriumTorch, "spectrium_torch");
    }

    public static void registerBlock(Block block, String name) {
        GameRegistry.register(block, new ResourceLocation(SpectrumCraft.MODID, name));
        GameRegistry.register(new ItemBlock(block), new ResourceLocation(SpectrumCraft.MODID, name));
    }

    public static void registerRenders() {
        registerRender(spectriumBlock);
        registerRender(spectriumOre);
        registerRender(frostedSpectriumBlock);
        registerRender(icedSpectriumBlock);
        registerRender(frozenSpectriumBlock);
        registerRender(spectriumTorch);
    }

    private static void registerRender(Block block) {
        Item item = Item.getItemFromBlock(block);
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}

}
