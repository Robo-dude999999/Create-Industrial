package net.mcreator.createindustrial.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.createindustrial.init.CreateIndustrialModBlocks;

public class ControlledSlotExporterOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!((world.getBlockState(BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ())))
				.getBlock() == CreateIndustrialModBlocks.CONTROLLED_SLOT_EXPORTER.get())
				&& (getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip11 ? blockstate.getValue(_getip11) : -1) <= getBlockInventorySlotCount(world, BlockPos.containing(x, y, z)) - 1) {
			if (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount() == 0
					&& itemFromBlockInventory(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()),
							getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip23 ? blockstate.getValue(_getip23) : -1).getCount() > 0
					&& canInsertInBlockInventory(world, BlockPos.containing(x, y, z), 0,
							itemFromBlockInventory(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()),
									getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip34 ? blockstate.getValue(_getip34) : -1).getCount(),
							(itemFromBlockInventory(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()),
									getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip45 ? blockstate.getValue(_getip45) : -1).copy()))) {
				if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
					ItemStack _setstack = (itemFromBlockInventory(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()),
							getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip68 ? blockstate.getValue(_getip68) : -1).copy()).copy();
					_setstack.setCount(itemFromBlockInventory(world, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()),
							getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip57 ? blockstate.getValue(_getip57) : -1).getCount());
					_itemHandlerModifiable.setStackInSlot(0, _setstack);
				}
				if (world instanceof ILevelExtension _ext
						&& _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepX(), y, z + ((getDirectionFromBlockState(blockstate)).getOpposite()).getStepZ()),
								null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
					_itemHandlerModifiable.setStackInSlot(getPropertyByName(blockstate, "slotselect") instanceof IntegerProperty _getip80 ? blockstate.getValue(_getip80) : -1, ItemStack.EMPTY);
			}
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		Property<?> prop = getPropertyByName(blockState, "facing");
		if (prop instanceof DirectionProperty dp)
			return blockState.getValue(dp);
		prop = getPropertyByName(blockState, "axis");
		return prop instanceof EnumProperty ep && ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}

	private static int getBlockInventorySlotCount(LevelAccessor world, BlockPos pos) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getSlots();
		}
		return 0;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}

	public static boolean canInsertInBlockInventory(LevelAccessor world, BlockPos pos, int slotId, int amount, ItemStack itemstack) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null && slotId >= 0 && slotId < itemHandler.getSlots()) {
				itemstack.setCount(amount);
				return itemHandler.isItemValid(slotId, itemstack);
			}
		}
		return false;
	}
}