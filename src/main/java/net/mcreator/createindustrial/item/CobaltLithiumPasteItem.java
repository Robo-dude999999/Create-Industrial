package net.mcreator.createindustrial.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class CobaltLithiumPasteItem extends BucketItem {
	public CobaltLithiumPasteItem() {
		super(CreateIndustrialModFluids.COBALT_LITHIUM_PASTE.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}