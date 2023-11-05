package com.r3charged.createcobblemon.group;

import com.r3charged.createcobblemon.CreateCobblemon;
import com.simibubi.create.AllBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModGroup {
	public static final CreativeModeTab MAIN= FabricItemGroup.builder().icon(ModGroup::makeIcon).title(Component.translatable("itemGroup.createaddition.main")).build();
	public static final ResourceKey<CreativeModeTab> MAIN_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(CreateCobblemon.ID,"main"));
	public static ItemStack makeIcon() {
		return new ItemStack(AllBlocks.ANALOG_LEVER.get());
	}


	public static void register(){

		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, MAIN_KEY, MAIN);
		ItemGroupEvents.modifyEntriesEvent(MAIN_KEY).register(content -> {
			CreateCobblemon.REGISTRATE.getAll(Registries.ITEM).forEach(entry->{
				content.accept(entry.get());
			});
		});
	}
}
