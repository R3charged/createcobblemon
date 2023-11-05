package com.r3charged.createcobblemon;

import com.r3charged.createcobblemon.blocks.burner.SlugmaBurnerBlock;
import com.r3charged.createcobblemon.blocks.burner.SlugmaBurnerBlockItem;
import com.r3charged.createcobblemon.group.ModGroup;
import com.simibubi.create.AllTags;

import com.simibubi.create.content.processing.burner.BlazeBurnerBlock;
import com.simibubi.create.content.processing.burner.BlazeBurnerInteractionBehaviour;
import com.simibubi.create.content.processing.burner.BlazeBurnerMovementBehaviour;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

import static com.simibubi.create.AllInteractionBehaviours.interactionBehaviour;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

public class CCBlocks {

	static {
		CreateCobblemon.REGISTRATE.useCreativeTab(ModGroup.MAIN_KEY);
	}

	public static final BlockEntry<SlugmaBurnerBlock> SLUGMA_BURNER_BLOCK =
			CreateCobblemon.REGISTRATE.block("slugma_burner", SlugmaBurnerBlock::new)
					.initialProperties(SharedProperties::softMetal)
					.properties(p -> p.mapColor(MapColor.COLOR_GRAY))
					.properties(p -> p.lightLevel((d)->8))
					.transform(pickaxeOnly())
					.addLayer(() -> RenderType::cutoutMipped)
					.tag(AllTags.AllBlockTags.FAN_TRANSPARENT.tag, AllTags.AllBlockTags.PASSIVE_BOILER_HEATERS.tag)
					.loot((lt, block) -> lt.add(block, SlugmaBurnerBlock.buildLootTable()))
					.blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
					.onRegister(movementBehaviour(new BlazeBurnerMovementBehaviour()))
					.onRegister(interactionBehaviour(new BlazeBurnerInteractionBehaviour()))
					.item()
					.model(AssetLookup.customBlockItemModel("slugma_burner", "block_with_slugma"))
					.build()
					.register();

	public static void register() {
		System.out.println("Adgdfhsdf");
	}
}
