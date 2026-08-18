package net.mcreator.createindustrial.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class MoltenBoronItem extends BucketItem {
	public MoltenBoronItem() {
		super(CreateIndustrialModFluids.MOLTEN_BORON.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}