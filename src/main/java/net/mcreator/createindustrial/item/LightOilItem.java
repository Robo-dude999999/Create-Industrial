package net.mcreator.createindustrial.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class LightOilItem extends BucketItem {
	public LightOilItem() {
		super(CreateIndustrialModFluids.LIGHT_OIL.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}