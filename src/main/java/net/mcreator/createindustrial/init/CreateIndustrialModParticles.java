/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.createindustrial.client.particle.LiquidSlimeDripParticle;

@EventBusSubscriber(Dist.CLIENT)
public class CreateIndustrialModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(CreateIndustrialModParticleTypes.LIQUID_SLIME_DRIP.get(), LiquidSlimeDripParticle::provider);
	}
}