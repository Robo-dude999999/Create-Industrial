package net.mcreator.createindustrial.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class HeavyOilItem extends BucketItem {
	public HeavyOilItem() {
		super(CreateIndustrialModFluids.HEAVY_OIL.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}