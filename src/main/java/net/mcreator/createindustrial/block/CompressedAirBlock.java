package net.mcreator.createindustrial.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.createindustrial.procedures.CompressedAirBlockAddedProcedure;
import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class CompressedAirBlock extends LiquidBlock {
	public CompressedAirBlock() {
		super(CreateIndustrialModFluids.COMPRESSED_AIR.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		CompressedAirBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}