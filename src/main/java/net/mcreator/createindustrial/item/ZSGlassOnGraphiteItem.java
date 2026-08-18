package net.mcreator.createindustrial.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.createindustrial.init.CreateIndustrialModItems;

public class ZSGlassOnGraphiteItem extends Item {
	public ZSGlassOnGraphiteItem() {
		super(new Item.Properties());
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(CreateIndustrialModItems.GRAPHITE_INGOT.get());
	}
}