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

public abstract class MoltenBoronFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CreateIndustrialModFluidTypes.MOLTEN_BORON_TYPE.get(), () -> CreateIndustrialModFluids.MOLTEN_BORON.get(),
			() -> CreateIndustrialModFluids.FLOWING_MOLTEN_BORON.get()).explosionResistance(100f).tickRate(13).bucket(() -> CreateIndustrialModItems.MOLTEN_BORON_BUCKET.get()).block(() -> (LiquidBlock) CreateIndustrialModBlocks.MOLTEN_BORON.get());

	private MoltenBoronFluid() {
		super(PROPERTIES);
	}

	public static class Source extends MoltenBoronFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends MoltenBoronFluid {
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