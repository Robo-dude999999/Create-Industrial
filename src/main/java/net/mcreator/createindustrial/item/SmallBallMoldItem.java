package net.mcreator.createindustrial.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class SmallBallMoldItem extends Item {
	public SmallBallMoldItem() {
		super(new Item.Properties());
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}
}