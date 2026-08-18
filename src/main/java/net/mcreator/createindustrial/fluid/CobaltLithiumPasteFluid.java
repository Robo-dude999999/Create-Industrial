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

public abstract class CobaltLithiumPasteFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.COBALT_LITHIUM_PASTE_TYPE.get(), () -> CreateIndustrialModFluids.COBALT_LITHIUM_PASTE.get(),
			() -> CreateIndustrialModFluids.FLOWING_COBALT_LITHIUM_PASTE.get()).explosionResistance(100f).tickRate(15).bucket(() -> CreateIndustrialModItems.COBALT_LITHIUM_PASTE_BUCKET.get())
			.block(() -> (LiquidBlock) CreateIndustrialModBlocks.COBALT_LITHIUM_PASTE.get());

	private CobaltLithiumPasteFluid() {
		super(PROPERTIES);
	}

	public static class Source extends CobaltLithiumPasteFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends CobaltLithiumPasteFluid {
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