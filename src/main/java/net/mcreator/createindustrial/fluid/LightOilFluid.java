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

public abstract class LightOilFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.LIGHT_OIL_TYPE.get(), () -> CreateIndustrialModFluids.LIGHT_OIL.get(),
			() -> CreateIndustrialModFluids.FLOWING_LIGHT_OIL.get()).explosionResistance(100f).tickRate(6).bucket(() -> CreateIndustrialModItems.LIGHT_OIL_BUCKET.get()).block(() -> (LiquidBlock) CreateIndustrialModBlocks.LIGHT_OIL.get());

	private LightOilFluid() {
		super(PROPERTIES);
	}

	public static class Source extends LightOilFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends LightOilFluid {
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