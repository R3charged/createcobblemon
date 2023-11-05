package com.r3charged.createcobblemon.blocks.burner;

import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;

import net.minecraft.world.level.block.state.BlockState;

public class SlugmaBurnerBlock extends BlazeBurnerBlock {
	public SlugmaBurnerBlock(Properties properties) {
		super(properties);
	}

	public static int getLight(BlockState state) {
		return 8;
	}
}
