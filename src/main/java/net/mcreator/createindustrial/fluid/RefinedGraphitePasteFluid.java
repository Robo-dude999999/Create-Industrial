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

public abstract class RefinedGraphitePasteFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.REFINED_GRAPHITE_PASTE_TYPE.get(), () -> CreateIndustrialModFluids.REFINED_GRAPHITE_PASTE.get(),
			() -> CreateIndustrialModFluids.FLOWING_REFINED_GRAPHITE_PASTE.get()).explosionResistance(100f).tickRate(13).bucket(() -> CreateIndustrialModItems.REFINED_GRAPHITE_PASTE_BUCKET.get())
			.block(() -> (LiquidBlock) CreateIndustrialModBlocks.REFINED_GRAPHITE_PASTE.get());

	private RefinedGraphitePasteFluid() {
		super(PROPERTIES);
	}

	public static class Source extends RefinedGraphitePasteFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends RefinedGraphitePasteFluid {
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