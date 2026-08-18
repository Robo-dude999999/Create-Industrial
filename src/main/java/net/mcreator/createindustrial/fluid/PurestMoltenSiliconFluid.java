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

public abstract class PurestMoltenSiliconFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.PUREST_MOLTEN_SILICON_TYPE.get(), () -> CreateIndustrialModFluids.PUREST_MOLTEN_SILICON.get(),
			() -> CreateIndustrialModFluids.FLOWING_PUREST_MOLTEN_SILICON.get()).explosionResistance(100f).bucket(() -> CreateIndustrialModItems.PUREST_MOLTEN_SILICON_BUCKET.get())
			.block(() -> (LiquidBlock) CreateIndustrialModBlocks.PUREST_MOLTEN_SILICON.get());

	private PurestMoltenSiliconFluid() {
		super(PROPERTIES);
	}

	public static class Source extends PurestMoltenSiliconFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends PurestMoltenSiliconFluid {
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