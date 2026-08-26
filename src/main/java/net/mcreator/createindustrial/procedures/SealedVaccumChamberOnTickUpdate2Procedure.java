package net.mcreator.createindustrial.procedures;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

public class SealedVaccumChamberOnTickUpdate2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		boolean hasFoundRecipe = false;
		double i = 0;
		double one = 0;
		double two = 0;
		double three = 0;
		{
			int _value = (getPropertyByName(blockstate, "tick") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) + 1;
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("tick") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if (0 < itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).getCount() && 0 < itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).getCount()
				&& 0 < itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).getCount()
				&& !((getPropertyByName(blockstate, "processing") instanceof EnumProperty _getep7 ? blockstate.getValue(_getep7).toString() : "").equals("deployerprocessing")
						|| (getPropertyByName(blockstate, "processing") instanceof EnumProperty _getep9 ? blockstate.getValue(_getep9).toString() : "").equals("regularprocessing"))) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("tick") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if ((getPropertyByName(blockstate, "processing") instanceof EnumProperty _getep12 ? blockstate.getValue(_getep12).toString() : "").equals("deployer")) {
				{
					String _value = "deployerprocessing";
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("processing") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			} else {
				{
					String _value = "regularprocessing";
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("processing") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			}
		}
		if ((getPropertyByName(blockstate, "tick") instanceof IntegerProperty _getip16 ? blockstate.getValue(_getip16) : -1) == 80) {
			{
				int _value = 0;
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("tick") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
					world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
			}
			if ((getPropertyByName(blockstate, "processing") instanceof EnumProperty _getep19 ? blockstate.getValue(_getep19).toString() : "").equals("deployerprocessing")) {
				{
					String _value = "deployer";
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("processing") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			} else {
				{
					String _value = "regular";
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("processing") instanceof EnumProperty _enumProp && _enumProp.getValue(_value).isPresent())
						world.setBlock(_pos, _bs.setValue(_enumProp, (Enum) _enumProp.getValue(_value).get()), 3);
				}
			}
			SealedVaccumChamberOnTickUpdateProcedure.execute(world, x, y, z);
		}
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			IItemHandler itemHandler = ext.getCapability(Capabilities.ItemHandler.BLOCK, pos, null);
			if (itemHandler != null)
				return itemHandler.getStackInSlot(slot);
		}
		return ItemStack.EMPTY;
	}
}