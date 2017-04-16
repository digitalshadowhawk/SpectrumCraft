package com.shadowhawk.spectrum.world;

import java.util.Random;

import com.shadowhawk.spectrum.registry.ModBlocks;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

    private WorldGenerator gen_oreSpectrium;
    private boolean s;

    public ModWorldGen(boolean s) {
        //The int is vein size
        gen_oreSpectrium = new WorldGenMinable(ModBlocks.spectriumOre.getDefaultState(), 3);
        this.s = s;
    }

    private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chances, int minHeight, int maxHeight) {
        if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
           throw new IllegalArgumentException("Illegal Height Arguments for WorldGen");

        int heightDiff = maxHeight - minHeight + 1;
        for (int i = 0; i < chances; i++) {
            int x = chunk_X * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDiff);
            int z = chunk_Z * 16 + rand.nextInt(16);
            generator.generate(world, rand, new BlockPos(x,y,z));
            String debug = world.getBlockState(new BlockPos(x, y, z)).getBlock().getUnlocalizedName();
        }
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.getDimension()) {
            case 0: //Overworld
                if(this.s)
                    runGenerator(gen_oreSpectrium, world, random, chunkX, chunkZ, 5, 0, 16);
                break;
            case -1: /*Nether*/ break;
            case 1: /*End*/ break;
        }
    }
}
