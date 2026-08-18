package net.mcreator.createindustrial.block;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class SiliconOreBlock extends Block {
	public SiliconOreBlock() {
		super(BlockBehaviour.Properties.of().strength(1f, 10f));
	}
}