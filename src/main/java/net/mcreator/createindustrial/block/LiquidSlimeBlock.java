package net.mcreator.createindustrial.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class LiquidSlimeBlock extends LiquidBlock {
	public LiquidSlimeBlock() {
		super(CreateIndustrialModFluids.LIQUID_SLIME.get(), BlockBehaviour.Properties.of().mapColor(MapColor.WATER).strength(200f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}