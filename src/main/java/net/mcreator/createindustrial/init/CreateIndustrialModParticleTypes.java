/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.createindustrial.CreateIndustrialMod;

public class CreateIndustrialModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, CreateIndustrialMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> LIQUID_SLIME_DRIP = REGISTRY.register("liquid_slime_drip", () -> new SimpleParticleType(false));
}