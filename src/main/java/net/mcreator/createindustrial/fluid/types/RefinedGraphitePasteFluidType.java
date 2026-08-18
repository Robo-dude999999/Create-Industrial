package net.mcreator.createindustrial.fluid.types;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.createindustrial.init.CreateIndustrialModFluidTypes;

@EventBusSubscriber
public class RefinedGraphitePasteFluidType extends FluidType {
	public RefinedGraphitePasteFluidType() {
		super(FluidType.Properties.create().fallDistanceModifier(0F).canExtinguish(true).supportsBoating(true).canHydrate(true).motionScale(0.007D).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("create_industrial:block/refinedgraphitepastestill");
			private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("create_industrial:block/refinedgraphitepaste");
			private static final ResourceLocation RENDER_OVERLAY_TEXTURE = ResourceLocation.parse("create_industrial:textures/refinedgraphitepaste.png");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}

			@Override
			public ResourceLocation getRenderOverlayTexture(Minecraft mc) {
				return RENDER_OVERLAY_TEXTURE;
			}
		}, CreateIndustrialModFluidTypes.REFINED_GRAPHITE_PASTE_TYPE.get());
	}
}