/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.createindustrial.fluid.types.*;
import net.mcreator.createindustrial.CreateIndustrialMod;

public class CreateIndustrialModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, CreateIndustrialMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> LIQUID_SLIME_TYPE = REGISTRY.register("liquid_slime", () -> new LiquidSlimeFluidType());
	public static final DeferredHolder<FluidType, FluidType> COBALT_LITHIUM_PASTE_TYPE = REGISTRY.register("cobalt_lithium_paste", () -> new CobaltLithiumPasteFluidType());
	public static final DeferredHolder<FluidType, FluidType> STICKY_GRAPHITE_TYPE = REGISTRY.register("sticky_graphite", () -> new StickyGraphiteFluidType());
	public static final DeferredHolder<FluidType, FluidType> REFINED_GRAPHITE_PASTE_TYPE = REGISTRY.register("refined_graphite_paste", () -> new RefinedGraphitePasteFluidType());
	public static final DeferredHolder<FluidType, FluidType> MOLTEN_PLASTIC_TYPE = REGISTRY.register("molten_plastic", () -> new MoltenPlasticFluidType());
	public static final DeferredHolder<FluidType, FluidType> HEAVY_OIL_TYPE = REGISTRY.register("heavy_oil", () -> new HeavyOilFluidType());
	public static final DeferredHolder<FluidType, FluidType> LIGHT_OIL_TYPE = REGISTRY.register("light_oil", () -> new LightOilFluidType());
	public static final DeferredHolder<FluidType, FluidType> PROPYLINE_TYPE = REGISTRY.register("propyline", () -> new PropylineFluidType());
	public static final DeferredHolder<FluidType, FluidType> GLOWSTONE_FLUID_TYPE = REGISTRY.register("glowstone_fluid", () -> new GlowstoneFluidFluidType());
	public static final DeferredHolder<FluidType, FluidType> LIQUID_SILICON_TYPE = REGISTRY.register("liquid_silicon", () -> new LiquidSiliconFluidType());
	public static final DeferredHolder<FluidType, FluidType> PURER_MOLTEN_SILICON_TYPE = REGISTRY.register("purer_molten_silicon", () -> new PurerMoltenSiliconFluidType());
	public static final DeferredHolder<FluidType, FluidType> PUREST_MOLTEN_SILICON_TYPE = REGISTRY.register("purest_molten_silicon", () -> new PurestMoltenSiliconFluidType());
	public static final DeferredHolder<FluidType, FluidType> MOLTEN_BORON_TYPE = REGISTRY.register("molten_boron", () -> new MoltenBoronFluidType());
	public static final DeferredHolder<FluidType, FluidType> COMPRESSED_AIR_TYPE = REGISTRY.register("compressed_air", () -> new CompressedAirFluidType());
	public static final DeferredHolder<FluidType, FluidType> PUREST_OF_PURE_MOLTEN_SILICON_TYPE = REGISTRY.register("purest_of_pure_molten_silicon", () -> new PurestOfPureMoltenSiliconFluidType());
}