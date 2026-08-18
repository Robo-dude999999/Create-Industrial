package net.mcreator.createindustrial.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.createindustrial.init.CreateIndustrialModItems;
import net.mcreator.createindustrial.init.CreateIndustrialModFluids;
import net.mcreator.createindustrial.init.CreateIndustrialModFluidTypes;
import net.mcreator.createindustrial.init.CreateIndustrialModBlocks;

public abstract class StickyGraphiteFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.STICKY_GRAPHITE_TYPE.get(), () -> CreateIndustrialModFluids.STICKY_GRAPHITE.get(),
			() -> CreateIndustrialModFluids.FLOWING_STICKY_GRAPHITE.get()).explosionResistance(100f).tickRate(17).bucket(() -> CreateIndustrialModItems.STICKY_GRAPHITE_BUCKET.get())
			.block(() -> (LiquidBlock) CreateIndustrialModBlocks.STICKY_GRAPHITE.get());

	private StickyGraphiteFluid() {
		super(PROPERTIES);
	}

	public static class Source extends StickyGraphiteFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends StickyGraphiteFluid {
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