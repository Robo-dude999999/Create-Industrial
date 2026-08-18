package net.mcreator.createindustrial.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.createindustrial.init.CreateIndustrialModParticleTypes;
import net.mcreator.createindustrial.init.CreateIndustrialModItems;
import net.mcreator.createindustrial.init.CreateIndustrialModFluids;
import net.mcreator.createindustrial.init.CreateIndustrialModFluidTypes;
import net.mcreator.createindustrial.init.CreateIndustrialModBlocks;

public abstract class LiquidSlimeFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.LIQUID_SLIME_TYPE.get(), () -> CreateIndustrialModFluids.LIQUID_SLIME.get(),
			() -> CreateIndustrialModFluids.FLOWING_LIQUID_SLIME.get()).explosionResistance(200f).tickRate(40).bucket(() -> CreateIndustrialModItems.LIQUID_SLIME_BUCKET.get()).block(() -> (LiquidBlock) CreateIndustrialModBlocks.LIQUID_SLIME.get());

	private LiquidSlimeFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return (SimpleParticleType) (CreateIndustrialModParticleTypes.LIQUID_SLIME_DRIP.get());
	}

	public static class Source extends LiquidSlimeFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LiquidSlimeFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}