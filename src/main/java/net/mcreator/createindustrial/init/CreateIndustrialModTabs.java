/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.createindustrial.CreateIndustrialMod;

public class CreateIndustrialModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateIndustrialMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_INDUSTRIAL = REGISTRY.register("create_industrial",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.create_industrial.create_industrial")).icon(() -> new ItemStack(CreateIndustrialModItems.INDUSTRIAL_IRON_ALLOY.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CreateIndustrialModItems.INDUSTRIAL_IRON_ALLOY.get());
				tabData.accept(CreateIndustrialModItems.UNFIRED_CRUCIBLE.get());
				tabData.accept(CreateIndustrialModItems.FIRED_CRUCIBLE.get());
				tabData.accept(CreateIndustrialModItems.FIRED_CRUCIBLE_WITH_IRON.get());
				tabData.accept(CreateIndustrialModItems.FIRED_CRUCIBLE_WITH_ZINC.get());
				tabData.accept(CreateIndustrialModItems.FIRED_CRUCIBLE_WITH_MOLTEN_ZINC.get());
				tabData.accept(CreateIndustrialModItems.FIRED_CRUCIBLE_WITH_MOLTEN_IRON.get());
				tabData.accept(CreateIndustrialModItems.SMALL_BALL_MOLD.get());
				tabData.accept(CreateIndustrialModItems.IRON_BALL.get());
				tabData.accept(CreateIndustrialModItems.IRON_RING.get());
				tabData.accept(CreateIndustrialModItems.BALL_BEARING.get());
				tabData.accept(CreateIndustrialModItems.LITHIUM_DUST.get());
				tabData.accept(CreateIndustrialModBlocks.LITHIUM_ORE.get().asItem());
				tabData.accept(CreateIndustrialModBlocks.COBALT_ORE.get().asItem());
				tabData.accept(CreateIndustrialModItems.COBALT_CRUMBLES.get());
				tabData.accept(CreateIndustrialModItems.LIQUID_SLIME_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.COBALT_LITHIUM_PASTE_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.STICKY_GRAPHITE_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.GRAPHITE_INGOT.get());
				tabData.accept(CreateIndustrialModItems.REFINED_GRAPHITE_INGOT.get());
				tabData.accept(CreateIndustrialModItems.REFINED_GRAPHITE_PASTE_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.COBALT_LITHIUM_PASTE_COVERED_ZINC_SHEET.get());
				tabData.accept(CreateIndustrialModItems.REFINED_GRAPHITE_PASTE_COVERED_COPPER_SHEET.get());
				tabData.accept(CreateIndustrialModItems.LITHIUM_ION_CATHODE_ANODE_ASSEMBLY.get());
				tabData.accept(CreateIndustrialModItems.COMPRESSED_LITHIUM_ION_CATHODE_ANODE_ASSEMBLY.get());
				tabData.accept(CreateIndustrialModItems.PURIFIED_CLAY_BALL.get());
				tabData.accept(CreateIndustrialModItems.MOLTEN_PLASTIC_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.HEAVY_OIL_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.LIGHT_OIL_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.PROPYLINE_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.PLASTIC_INGOT.get());
				tabData.accept(CreateIndustrialModItems.PLASTIC_SHEET.get());
				tabData.accept(CreateIndustrialModItems.INCOMPLETE_BATTERY_CELL.get());
				tabData.accept(CreateIndustrialModItems.BATTERY_CELL.get());
				tabData.accept(CreateIndustrialModItems.SELENIDE_MUD_BYPRODUCT.get());
				tabData.accept(CreateIndustrialModBlocks.SEALED_VACCUM_CHAMBER.get().asItem());
				tabData.accept(CreateIndustrialModItems.SELENIDE_POWDER.get());
				tabData.accept(CreateIndustrialModItems.ZS_GLASS_ON_GRAPHITE.get());
				tabData.accept(CreateIndustrialModItems.ZS_GLASS.get());
				tabData.accept(CreateIndustrialModItems.PURIFIED_ZS_GLASS.get());
				tabData.accept(CreateIndustrialModItems.GLOWSTONE_FLUID_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.PHOSPHORUS_PELLETS.get());
				tabData.accept(CreateIndustrialModBlocks.SILICON_ORE.get().asItem());
				tabData.accept(CreateIndustrialModItems.RAW_SILICON.get());
				tabData.accept(CreateIndustrialModItems.SILICON_SEED.get());
				tabData.accept(CreateIndustrialModItems.LIQUID_SILICON_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.PURER_MOLTEN_SILICON_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.PUREST_MOLTEN_SILICON_BUCKET.get());
				tabData.accept(CreateIndustrialModItems.MOLTEN_BORON_BUCKET.get());
				tabData.accept(CreateIndustrialModBlocks.CONTROLLED_SLOT_INSERTER.get().asItem());
				tabData.accept(CreateIndustrialModBlocks.CONTROLLED_SLOT_EXPORTER.get().asItem());
			}).build());
}