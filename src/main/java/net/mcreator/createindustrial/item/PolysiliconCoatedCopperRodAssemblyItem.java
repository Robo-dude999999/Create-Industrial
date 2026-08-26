package net.mcreator.createindustrial.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

import net.mcreator.createindustrial.init.CreateIndustrialModItems;

public class PolysiliconCoatedCopperRodAssemblyItem extends Item {
	public PolysiliconCoatedCopperRodAssemblyItem() {
		super(new Item.Properties());
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(CreateIndustrialModItems.COPPER_ROD_ASSEMBLY.get());
	}
}