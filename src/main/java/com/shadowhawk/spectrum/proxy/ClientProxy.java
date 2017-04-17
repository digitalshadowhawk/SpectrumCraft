package com.shadowhawk.spectrum.proxy;

import com.shadowhawk.spectrum.particles.RainbowFlame;
import com.shadowhawk.spectrum.registry.ModBlocks;
import com.shadowhawk.spectrum.registry.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
        ModItems.registerRenders();
        ModBlocks.registerRenders();
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }
    
    public void generateRainbowFlames(World worldIn, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed) {
    	Particle particle = new RainbowFlame(worldIn, xCoord, yCoord, zCoord, xSpeed, ySpeed, zSpeed);
    	Minecraft.getMinecraft().effectRenderer.addEffect(particle);
    }
}