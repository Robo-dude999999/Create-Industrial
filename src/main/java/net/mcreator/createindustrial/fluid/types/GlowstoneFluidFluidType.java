package net.mcreator.createindustrial.fluid.types;

import org.joml.Vector3f;

import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.Camera;

import net.mcreator.createindustrial.init.CreateIndustrialModFluidTypes;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.shaders.FogShape;

@EventBusSubscriber
public class GlowstoneFluidFluidType extends FluidType {
	public GlowstoneFluidFluidType() {
		super(FluidType.Properties.create().canSwim(false).canDrown(false).pathType(PathType.LAVA).adjacentPathType(null).motionScale(0.007D).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL)
				.sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
	}

	@SubscribeEvent
	public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
		event.registerFluidType(new IClientFluidTypeExtensions() {
			private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("create_industrial:block/glowstonefluid");
			private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("create_industrial:block/glowstonefluidflow");

			@Override
			public ResourceLocation getStillTexture() {
				return STILL_TEXTURE;
			}

			@Override
			public ResourceLocation getFlowingTexture() {
				return FLOWING_TEXTURE;
			}

			@Override
			public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
				return new Vector3f(0.4156862745f, 0.4117647059f, 0f);
			}

			@Override
			public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
				Entity entity = camera.getEntity();
				Level world = entity.level();
				RenderSystem.setShaderFogShape(FogShape.SPHERE);
				RenderSystem.setShaderFogStart(0f);
				RenderSystem.setShaderFogEnd(Math.min(48f, renderDistance));
			}
		}, CreateIndustrialModFluidTypes.GLOWSTONE_FLUID_TYPE.get());
	}
}