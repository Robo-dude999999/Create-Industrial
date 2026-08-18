/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.createindustrial.block.*;
import net.mcreator.createindustrial.CreateIndustrialMod;

public class CreateIndustrialModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CreateIndustrialMod.MODID);
	public static final DeferredBlock<Block> LITHIUM_ORE;
	public static final DeferredBlock<Block> COBALT_ORE;
	public static final DeferredBlock<Block> LIQUID_SLIME;
	public static final DeferredBlock<Block> COBALT_LITHIUM_PASTE;
	public static final DeferredBlock<Block> STICKY_GRAPHITE;
	public static final DeferredBlock<Block> REFINED_GRAPHITE_PASTE;
	public static final DeferredBlock<Block> MOLTEN_PLASTIC;
	public static final DeferredBlock<Block> HEAVY_OIL;
	public static final DeferredBlock<Block> LIGHT_OIL;
	public static final DeferredBlock<Block> PROPYLINE;
	public static final DeferredBlock<Block> SEALED_VACCUM_CHAMBER;
	public static final DeferredBlock<Block> GLOWSTONE_FLUID;
	public static final DeferredBlock<Block> SILICON_ORE;
	public static final DeferredBlock<Block> LIQUID_SILICON;
	public static final DeferredBlock<Block> PURER_MOLTEN_SILICON;
	public static final DeferredBlock<Block> PUREST_MOLTEN_SILICON;
	public static final DeferredBlock<Block> MOLTEN_BORON;
	public static final DeferredBlock<Block> CONTROLLED_SLOT_INSERTER;
	public static final DeferredBlock<Block> CONTROLLED_SLOT_EXPORTER;
	static {
		LITHIUM_ORE = REGISTRY.register("lithium_ore", LithiumOreBlock::new);
		COBALT_ORE = REGISTRY.register("cobalt_ore", CobaltOreBlock::new);
		LIQUID_SLIME = REGISTRY.register("liquid_slime", LiquidSlimeBlock::new);
		COBALT_LITHIUM_PASTE = REGISTRY.register("cobalt_lithium_paste", CobaltLithiumPasteBlock::new);
		STICKY_GRAPHITE = REGISTRY.register("sticky_graphite", StickyGraphiteBlock::new);
		REFINED_GRAPHITE_PASTE = REGISTRY.register("refined_graphite_paste", RefinedGraphitePasteBlock::new);
		MOLTEN_PLASTIC = REGISTRY.register("molten_plastic", MoltenPlasticBlock::new);
		HEAVY_OIL = REGISTRY.register("heavy_oil", HeavyOilBlock::new);
		LIGHT_OIL = REGISTRY.register("light_oil", LightOilBlock::new);
		PROPYLINE = REGISTRY.register("propyline", PropylineBlock::new);
		SEALED_VACCUM_CHAMBER = REGISTRY.register("sealed_vaccum_chamber", SealedVaccumChamberBlock::new);
		GLOWSTONE_FLUID = REGISTRY.register("glowstone_fluid", GlowstoneFluidBlock::new);
		SILICON_ORE = REGISTRY.register("silicon_ore", SiliconOreBlock::new);
		LIQUID_SILICON = REGISTRY.register("liquid_silicon", LiquidSiliconBlock::new);
		PURER_MOLTEN_SILICON = REGISTRY.register("purer_molten_silicon", PurerMoltenSiliconBlock::new);
		PUREST_MOLTEN_SILICON = REGISTRY.register("purest_molten_silicon", PurestMoltenSiliconBlock::new);
		MOLTEN_BORON = REGISTRY.register("molten_boron", MoltenBoronBlock::new);
		CONTROLLED_SLOT_INSERTER = REGISTRY.register("controlled_slot_inserter", ControlledSlotInserterBlock::new);
		CONTROLLED_SLOT_EXPORTER = REGISTRY.register("controlled_slot_exporter", ControlledSlotExporterBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}