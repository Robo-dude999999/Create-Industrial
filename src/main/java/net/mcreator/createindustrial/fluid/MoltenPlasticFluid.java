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

public abstract class MoltenPlasticFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.MOLTEN_PLASTIC_TYPE.get(), () -> CreateIndustrialModFluids.MOLTEN_PLASTIC.get(),
			() -> CreateIndustrialModFluids.FLOWING_MOLTEN_PLASTIC.get()).explosionResistance(100f).tickRate(12).bucket(() -> CreateIndustrialModItems.MOLTEN_PLASTIC_BUCKET.get())
			.block(() -> (LiquidBlock) CreateIndustrialModBlocks.MOLTEN_PLASTIC.get());

	private MoltenPlasticFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MoltenPlasticFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MoltenPlasticFluid {
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