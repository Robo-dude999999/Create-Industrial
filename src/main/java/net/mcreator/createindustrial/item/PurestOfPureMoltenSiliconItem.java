package net.mcreator.createindustrial.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

public class PurestOfPureMoltenSiliconItem extends BucketItem {
	public PurestOfPureMoltenSiliconItem() {
		super(CreateIndustrialModFluids.PUREST_OF_PURE_MOLTEN_SILICON.get(), new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}