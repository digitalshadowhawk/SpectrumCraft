package com.shadowhawk.spectrum.particles;

import java.util.Random;

import com.shadowhawk.spectrum.SpectrumCraft;
import com.shadowhawk.spectrum.blocks.SpectriumTorch;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RainbowFlame extends ParticleFlame{

	Random rg = new Random();
	
	
	public RainbowFlame(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn,
			double ySpeedIn, double zSpeedIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);
		setRBGColorF(rg.nextFloat(), rg.nextFloat() + 0.5F, rg.nextFloat() + 0.5F);
		//setRBGColorF(0.7F, 0.8F, 1.0F);
		//particleAlpha = 1F;
		//this.particleTexture = SpectriumTorch.textureAtlas;
		//setParticleTextureIndex(0);
	}
	
	public void renderParticle(VertexBuffer buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
	
}
