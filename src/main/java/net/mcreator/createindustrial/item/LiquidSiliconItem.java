package net.mcreator.createindustrial.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class LiquidSiliconItem extends BucketItem {
	public LiquidSiliconItem() {
		super(CreateIndustrialModFluids.LIQUID_SILICON.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}