/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.capability.wrappers.FluidBucketWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.createindustrial.item.*;
import net.mcreator.createindustrial.CreateIndustrialMod;

@EventBusSubscriber
public class CreateIndustrialModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CreateIndustrialMod.MODID);
	public static final DeferredItem<Item> INDUSTRIAL_IRON_ALLOY;
	public static final DeferredItem<Item> UNFIRED_CRUCIBLE;
	public static final DeferredItem<Item> FIRED_CRUCIBLE;
	public static final DeferredItem<Item> FIRED_CRUCIBLE_WITH_IRON;
	public static final DeferredItem<Item> FIRED_CRUCIBLE_WITH_ZINC;
	public static final DeferredItem<Item> FIRED_CRUCIBLE_WITH_MOLTEN_ZINC;
	public static final DeferredItem<Item> FIRED_CRUCIBLE_WITH_MOLTEN_IRON;
	public static final DeferredItem<Item> SMALL_BALL_MOLD;
	public static final DeferredItem<Item> IRON_BALL;
	public static final DeferredItem<Item> IRON_RING;
	public static final DeferredItem<Item> BALL_BEARING;
	public static final DeferredItem<Item> LITHIUM_DUST;
	public static final DeferredItem<Item> LITHIUM_ORE;
	public static final DeferredItem<Item> COBALT_ORE;
	public static final DeferredItem<Item> COBALT_CRUMBLES;
	public static final DeferredItem<Item> LIQUID_SLIME_BUCKET;
	public static final DeferredItem<Item> COBALT_LITHIUM_PASTE_BUCKET;
	public static final DeferredItem<Item> STICKY_GRAPHITE_BUCKET;
	public static final DeferredItem<Item> GRAPHITE_INGOT;
	public static final DeferredItem<Item> REFINED_GRAPHITE_INGOT;
	public static final DeferredItem<Item> REFINED_GRAPHITE_PASTE_BUCKET;
	public static final DeferredItem<Item> COBALT_LITHIUM_PASTE_COVERED_ZINC_SHEET;
	public static final DeferredItem<Item> REFINED_GRAPHITE_PASTE_COVERED_COPPER_SHEET;
	public static final DeferredItem<Item> LITHIUM_ION_CATHODE_ANODE_ASSEMBLY;
	public static final DeferredItem<Item> COMPRESSED_LITHIUM_ION_CATHODE_ANODE_ASSEMBLY;
	public static final DeferredItem<Item> PURIFIED_CLAY_BALL;
	public static final DeferredItem<Item> MOLTEN_PLASTIC_BUCKET;
	public static final DeferredItem<Item> HEAVY_OIL_BUCKET;
	public static final DeferredItem<Item> LIGHT_OIL_BUCKET;
	public static final DeferredItem<Item> PROPYLINE_BUCKET;
	public static final DeferredItem<Item> PLASTIC_INGOT;
	public static final DeferredItem<Item> PLASTIC_SHEET;
	public static final DeferredItem<Item> INCOMPLETE_BATTERY_CELL;
	public static final DeferredItem<Item> BATTERY_CELL;
	public static final DeferredItem<Item> SELENIDE_MUD_BYPRODUCT;
	public static final DeferredItem<Item> SEALED_VACCUM_CHAMBER;
	public static final DeferredItem<Item> SELENIDE_POWDER;
	public static final DeferredItem<Item> ZS_GLASS_ON_GRAPHITE;
	public static final DeferredItem<Item> ZS_GLASS;
	public static final DeferredItem<Item> PURIFIED_ZS_GLASS;
	public static final DeferredItem<Item> GLOWSTONE_FLUID_BUCKET;
	public static final DeferredItem<Item> PHOSPHORUS_PELLETS;
	public static final DeferredItem<Item> SILICON_ORE;
	public static final DeferredItem<Item> RAW_SILICON;
	public static final DeferredItem<Item> SILICON_SEED;
	public static final DeferredItem<Item> LIQUID_SILICON_BUCKET;
	public static final DeferredItem<Item> PURER_MOLTEN_SILICON_BUCKET;
	public static final DeferredItem<Item> PUREST_MOLTEN_SILICON_BUCKET;
	public static final DeferredItem<Item> MOLTEN_BORON_BUCKET;
	public static final DeferredItem<Item> CONTROLLED_SLOT_INSERTER;
	public static final DeferredItem<Item> CONTROLLED_SLOT_EXPORTER;
	static {
		INDUSTRIAL_IRON_ALLOY = REGISTRY.register("industrial_iron_alloy", IndustrialIronAlloyItem::new);
		UNFIRED_CRUCIBLE = REGISTRY.register("unfired_crucible", UnfiredCrucibleItem::new);
		FIRED_CRUCIBLE = REGISTRY.register("fired_crucible", FiredCrucibleItem::new);
		FIRED_CRUCIBLE_WITH_IRON = REGISTRY.register("fired_crucible_with_iron", FiredCrucibleWithIronItem::new);
		FIRED_CRUCIBLE_WITH_ZINC = REGISTRY.register("fired_crucible_with_zinc", FiredCrucibleWithZincItem::new);
		FIRED_CRUCIBLE_WITH_MOLTEN_ZINC = REGISTRY.register("fired_crucible_with_molten_zinc", FiredCrucibleWithMoltenZincItem::new);
		FIRED_CRUCIBLE_WITH_MOLTEN_IRON = REGISTRY.register("fired_crucible_with_molten_iron", FiredCrucibleWithMoltenIronItem::new);
		SMALL_BALL_MOLD = REGISTRY.register("small_ball_mold", SmallBallMoldItem::new);
		IRON_BALL = REGISTRY.register("iron_ball", IronBallItem::new);
		IRON_RING = REGISTRY.register("iron_ring", IronRingItem::new);
		BALL_BEARING = REGISTRY.register("ball_bearing", BallBearingItem::new);
		LITHIUM_DUST = REGISTRY.register("lithium_dust", LithiumDustItem::new);
		LITHIUM_ORE = block(CreateIndustrialModBlocks.LITHIUM_ORE);
		COBALT_ORE = block(CreateIndustrialModBlocks.COBALT_ORE);
		COBALT_CRUMBLES = REGISTRY.register("cobalt_crumbles", CobaltCrumblesItem::new);
		LIQUID_SLIME_BUCKET = REGISTRY.register("liquid_slime_bucket", LiquidSlimeItem::new);
		COBALT_LITHIUM_PASTE_BUCKET = REGISTRY.register("cobalt_lithium_paste_bucket", CobaltLithiumPasteItem::new);
		STICKY_GRAPHITE_BUCKET = REGISTRY.register("sticky_graphite_bucket", StickyGraphiteItem::new);
		GRAPHITE_INGOT = REGISTRY.register("graphite_ingot", GraphiteIngotItem::new);
		REFINED_GRAPHITE_INGOT = REGISTRY.register("refined_graphite_ingot", RefinedGraphiteIngotItem::new);
		REFINED_GRAPHITE_PASTE_BUCKET = REGISTRY.register("refined_graphite_paste_bucket", RefinedGraphitePasteItem::new);
		COBALT_LITHIUM_PASTE_COVERED_ZINC_SHEET = REGISTRY.register("cobalt_lithium_paste_covered_zinc_sheet", CobaltLithiumPasteCoveredZincSheetItem::new);
		REFINED_GRAPHITE_PASTE_COVERED_COPPER_SHEET = REGISTRY.register("refined_graphite_paste_covered_copper_sheet", RefinedGraphitePasteCoveredCopperSheetItem::new);
		LITHIUM_ION_CATHODE_ANODE_ASSEMBLY = REGISTRY.register("lithium_ion_cathode_anode_assembly", LithiumIonCathodeAnodeAssemblyItem::new);
		COMPRESSED_LITHIUM_ION_CATHODE_ANODE_ASSEMBLY = REGISTRY.register("compressed_lithium_ion_cathode_anode_assembly", CompressedLithiumIonCathodeAnodeAssemblyItem::new);
		PURIFIED_CLAY_BALL = REGISTRY.register("purified_clay_ball", PurifiedClayBallItem::new);
		MOLTEN_PLASTIC_BUCKET = REGISTRY.register("molten_plastic_bucket", MoltenPlasticItem::new);
		HEAVY_OIL_BUCKET = REGISTRY.register("heavy_oil_bucket", HeavyOilItem::new);
		LIGHT_OIL_BUCKET = REGISTRY.register("light_oil_bucket", LightOilItem::new);
		PROPYLINE_BUCKET = REGISTRY.register("propyline_bucket", PropylineItem::new);
		PLASTIC_INGOT = REGISTRY.register("plastic_ingot", PlasticIngotItem::new);
		PLASTIC_SHEET = REGISTRY.register("plastic_sheet", PlasticSheetItem::new);
		INCOMPLETE_BATTERY_CELL = REGISTRY.register("incomplete_battery_cell", IncompleteBatteryCellItem::new);
		BATTERY_CELL = REGISTRY.register("battery_cell", BatteryCellItem::new);
		SELENIDE_MUD_BYPRODUCT = REGISTRY.register("selenide_mud_byproduct", SelenideMudByproductItem::new);
		SEALED_VACCUM_CHAMBER = block(CreateIndustrialModBlocks.SEALED_VACCUM_CHAMBER);
		SELENIDE_POWDER = REGISTRY.register("selenide_powder", SelenidePowderItem::new);
		ZS_GLASS_ON_GRAPHITE = REGISTRY.register("zs_glass_on_graphite", ZSGlassOnGraphiteItem::new);
		ZS_GLASS = REGISTRY.register("zs_glass", ZSGlassItem::new);
		PURIFIED_ZS_GLASS = REGISTRY.register("purified_zs_glass", PurifiedZSGlassItem::new);
		GLOWSTONE_FLUID_BUCKET = REGISTRY.register("glowstone_fluid_bucket", GlowstoneFluidItem::new);
		PHOSPHORUS_PELLETS = REGISTRY.register("phosphorus_pellets", PhosphorusPelletsItem::new);
		SILICON_ORE = block(CreateIndustrialModBlocks.SILICON_ORE);
		RAW_SILICON = REGISTRY.register("raw_silicon", RawSiliconItem::new);
		SILICON_SEED = REGISTRY.register("silicon_seed", SiliconSeedItem::new);
		LIQUID_SILICON_BUCKET = REGISTRY.register("liquid_silicon_bucket", LiquidSiliconItem::new);
		PURER_MOLTEN_SILICON_BUCKET = REGISTRY.register("purer_molten_silicon_bucket", PurerMoltenSiliconItem::new);
		PUREST_MOLTEN_SILICON_BUCKET = REGISTRY.register("purest_molten_silicon_bucket", PurestMoltenSiliconItem::new);
		MOLTEN_BORON_BUCKET = REGISTRY.register("molten_boron_bucket", MoltenBoronItem::new);
		CONTROLLED_SLOT_INSERTER = block(CreateIndustrialModBlocks.CONTROLLED_SLOT_INSERTER);
		CONTROLLED_SLOT_EXPORTER = block(CreateIndustrialModBlocks.CONTROLLED_SLOT_EXPORTER);
	}

	// Start of user code block custom items
	// End of user code block custom items
	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), LIQUID_SLIME_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), COBALT_LITHIUM_PASTE_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), STICKY_GRAPHITE_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), REFINED_GRAPHITE_PASTE_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), MOLTEN_PLASTIC_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), HEAVY_OIL_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), LIGHT_OIL_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), PROPYLINE_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), GLOWSTONE_FLUID_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), LIQUID_SILICON_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), PURER_MOLTEN_SILICON_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), PUREST_MOLTEN_SILICON_BUCKET.get());
		event.registerItem(Capabilities.FluidHandler.ITEM, (stack, context) -> new FluidBucketWrapper(stack), MOLTEN_BORON_BUCKET.get());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}