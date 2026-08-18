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

public abstract class GlowstoneFluidFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.GLOWSTONE_FLUID_TYPE.get(), () -> CreateIndustrialModFluids.GLOWSTONE_FLUID.get(),
			() -> CreateIndustrialModFluids.FLOWING_GLOWSTONE_FLUID.get()).explosionResistance(100f).tickRate(3).levelDecreasePerBlock(2).bucket(() -> CreateIndustrialModItems.GLOWSTONE_FLUID_BUCKET.get())
			.block(() -> (LiquidBlock) CreateIndustrialModBlocks.GLOWSTONE_FLUID.get());

	private GlowstoneFluidFluid() {
		super(PROPERTIES);
	}

	public static class Source extends GlowstoneFluidFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends GlowstoneFluidFluid {
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