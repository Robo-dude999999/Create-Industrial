package net.mcreator.createindustrial.block;

import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class LithiumOreBlock extends Block {
	public LithiumOreBlock() {
		super(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().instrument(NoteBlockInstrument.BASEDRUM));
	}
}