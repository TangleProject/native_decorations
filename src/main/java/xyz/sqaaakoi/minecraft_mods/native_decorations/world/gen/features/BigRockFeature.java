package xyz.sqaaakoi.minecraft_mods.native_decorations.world.gen.features;

import java.util.HashSet;

import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.util.math.random.Random;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BigRockFeature extends Feature<BigRockFeatureConfig> {
    public BigRockFeature(Codec<BigRockFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(FeatureContext<BigRockFeatureConfig> context) {
        BigRockFeatureConfig conf = context.getConfig();
        BlockPos pos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        for (int x = -1; x < 2; x++) {
          for (int y = -3; y < 2; y++) {
            for (int z = -1; z < 2; z++) {
              BlockPos setPos = pos.add(x, y, z);
              world.setBlockState(setPos, (random.nextFloat() < conf.chance().get(random) ? conf.block() : conf.alt_block()).getBlockState(random, setPos), Block.NOTIFY_LISTENERS);
            }
          }
        }
        world.setBlockState(pos.add(1, 2, 0), (random.nextFloat() < conf.chance().get(random) ? conf.block() : conf.alt_block()).getBlockState(random, pos.add(1, 2, 0)), Block.NOTIFY_LISTENERS);
        world.setBlockState(pos.add(-1, 2, 0), (random.nextFloat() < conf.chance().get(random) ? conf.block() : conf.alt_block()).getBlockState(random, pos.add(-1, 2, 0)), Block.NOTIFY_LISTENERS);
        world.setBlockState(pos.add(0, 2, 1), (random.nextFloat() < conf.chance().get(random) ? conf.block() : conf.alt_block()).getBlockState(random, pos.add(0, 2, 1)), Block.NOTIFY_LISTENERS);
        world.setBlockState(pos.add(0, 2, -1), (random.nextFloat() < conf.chance().get(random) ? conf.block() : conf.alt_block()).getBlockState(random, pos.add(0, 2, -1)), Block.NOTIFY_LISTENERS);
        world.setBlockState(pos.add(0, 2, 0), (random.nextFloat() < conf.chance().get(random) ? conf.block() : conf.alt_block()).getBlockState(random, pos.add(0, 2, 0)), Block.NOTIFY_LISTENERS);
        return true;
    }

}

