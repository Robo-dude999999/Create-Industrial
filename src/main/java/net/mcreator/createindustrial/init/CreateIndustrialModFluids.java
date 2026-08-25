/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.createindustrial.fluid.*;
import net.mcreator.createindustrial.CreateIndustrialMod;

public class CreateIndustrialModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, CreateIndustrialMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> LIQUID_SLIME = REGISTRY.register("liquid_slime", () -> new LiquidSlimeFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIQUID_SLIME = REGISTRY.register("flowing_liquid_slime", () -> new LiquidSlimeFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> COBALT_LITHIUM_PASTE = REGISTRY.register("cobalt_lithium_paste", () -> new CobaltLithiumPasteFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_COBALT_LITHIUM_PASTE = REGISTRY.register("flowing_cobalt_lithium_paste", () -> new CobaltLithiumPasteFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> STICKY_GRAPHITE = REGISTRY.register("sticky_graphite", () -> new StickyGraphiteFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_STICKY_GRAPHITE = REGISTRY.register("flowing_sticky_graphite", () -> new StickyGraphiteFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> REFINED_GRAPHITE_PASTE = REGISTRY.register("refined_graphite_paste", () -> new RefinedGraphitePasteFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_REFINED_GRAPHITE_PASTE = REGISTRY.register("flowing_refined_graphite_paste", () -> new RefinedGraphitePasteFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> MOLTEN_PLASTIC = REGISTRY.register("molten_plastic", () -> new MoltenPlasticFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MOLTEN_PLASTIC = REGISTRY.register("flowing_molten_plastic", () -> new MoltenPlasticFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> HEAVY_OIL = REGISTRY.register("heavy_oil", () -> new HeavyOilFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_HEAVY_OIL = REGISTRY.register("flowing_heavy_oil", () -> new HeavyOilFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> LIGHT_OIL = REGISTRY.register("light_oil", () -> new LightOilFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIGHT_OIL = REGISTRY.register("flowing_light_oil", () -> new LightOilFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> PROPYLINE = REGISTRY.register("propyline", () -> new PropylineFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PROPYLINE = REGISTRY.register("flowing_propyline", () -> new PropylineFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> GLOWSTONE_FLUID = REGISTRY.register("glowstone_fluid", () -> new GlowstoneFluidFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_GLOWSTONE_FLUID = REGISTRY.register("flowing_glowstone_fluid", () -> new GlowstoneFluidFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> LIQUID_SILICON = REGISTRY.register("liquid_silicon", () -> new LiquidSiliconFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIQUID_SILICON = REGISTRY.register("flowing_liquid_silicon", () -> new LiquidSiliconFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> PURER_MOLTEN_SILICON = REGISTRY.register("purer_molten_silicon", () -> new PurerMoltenSiliconFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PURER_MOLTEN_SILICON = REGISTRY.register("flowing_purer_molten_silicon", () -> new PurerMoltenSiliconFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> PUREST_MOLTEN_SILICON = REGISTRY.register("purest_molten_silicon", () -> new PurestMoltenSiliconFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PUREST_MOLTEN_SILICON = REGISTRY.register("flowing_purest_molten_silicon", () -> new PurestMoltenSiliconFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> MOLTEN_BORON = REGISTRY.register("molten_boron", () -> new MoltenBoronFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MOLTEN_BORON = REGISTRY.register("flowing_molten_boron", () -> new MoltenBoronFluid.Flowing());
	public static final DeferredHolder<Fluid, FlowingFluid> COMPRESSED_AIR = REGISTRY.register("compressed_air", () -> new CompressedAirFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_COMPRESSED_AIR = REGISTRY.register("flowing_compressed_air", () -> new CompressedAirFluid.Flowing());

	@EventBusSubscriber(Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(LIQUID_SLIME.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_SLIME.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(COBALT_LITHIUM_PASTE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_COBALT_LITHIUM_PASTE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(STICKY_GRAPHITE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_STICKY_GRAPHITE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(REFINED_GRAPHITE_PASTE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_REFINED_GRAPHITE_PASTE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MOLTEN_PLASTIC.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MOLTEN_PLASTIC.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(HEAVY_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_HEAVY_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LIGHT_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIGHT_OIL.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PROPYLINE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PROPYLINE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(GLOWSTONE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_GLOWSTONE_FLUID.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(LIQUID_SILICON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_LIQUID_SILICON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PURER_MOLTEN_SILICON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PURER_MOLTEN_SILICON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(PUREST_MOLTEN_SILICON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_PUREST_MOLTEN_SILICON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(MOLTEN_BORON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_MOLTEN_BORON.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(COMPRESSED_AIR.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_COMPRESSED_AIR.get(), RenderType.translucent());
		}
	}
}