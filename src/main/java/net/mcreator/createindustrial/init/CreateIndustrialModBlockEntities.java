/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.createindustrial.block.entity.SealedVaccumChamberBlockEntity;
import net.mcreator.createindustrial.block.entity.ControlledSlotInserterBlockEntity;
import net.mcreator.createindustrial.block.entity.ControlledSlotExporterBlockEntity;
import net.mcreator.createindustrial.CreateIndustrialMod;

@EventBusSubscriber
public class CreateIndustrialModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CreateIndustrialMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SealedVaccumChamberBlockEntity>> SEALED_VACCUM_CHAMBER = register("sealed_vaccum_chamber", CreateIndustrialModBlocks.SEALED_VACCUM_CHAMBER,
			SealedVaccumChamberBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ControlledSlotInserterBlockEntity>> CONTROLLED_SLOT_INSERTER = register("controlled_slot_inserter", CreateIndustrialModBlocks.CONTROLLED_SLOT_INSERTER,
			ControlledSlotInserterBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ControlledSlotExporterBlockEntity>> CONTROLLED_SLOT_EXPORTER = register("controlled_slot_exporter", CreateIndustrialModBlocks.CONTROLLED_SLOT_EXPORTER,
			ControlledSlotExporterBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SEALED_VACCUM_CHAMBER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.FluidHandler.BLOCK, SEALED_VACCUM_CHAMBER.get(), (blockEntity, side) -> blockEntity.getFluidTank());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONTROLLED_SLOT_INSERTER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CONTROLLED_SLOT_EXPORTER.get(), SidedInvWrapper::new);
	}
}