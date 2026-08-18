package net.mcreator.createindustrial.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class LiquidSiliconBlock extends LiquidBlock {
	public LiquidSiliconBlock() {
		super(CreateIndustrialModFluids.LIQUID_SILICON.get(), BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}