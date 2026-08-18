package net.mcreator.createindustrial.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.createindustrial.jei_recipes.VaccumChamberRecipeTypeRecipe;

import java.util.stream.Collectors;
import java.util.List;

public class SealedVaccumChamberOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double i = 0;
		if ((BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock()).toString()).equals("create:deployer")) {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("deployerabove") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
			}
		} else {
			{
				BlockPos _pos = BlockPos.containing(x, y, z);
				BlockState _bs = world.getBlockState(_pos);
				if (_bs.getBlock().getStateDefinition().getProperty("deployerabove") instanceof BooleanProperty _booleanProp)
					world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
			}
		}
		{
			if (world instanceof Level _lvl) {
				net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
				List<VaccumChamberRecipeTypeRecipe> recipes = rm.getAllRecipesFor(VaccumChamberRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
				for (VaccumChamberRecipeTypeRecipe recipe : recipes) {
					List<Ingredient> ingredients = recipe.getIngredients();
					if (!ingredients.get(0).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy())))
						continue;
					if (!ingredients.get(1).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy())))
						continue;
					if (!ingredients.get(2).test((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy())))
						continue;
					List<ItemStack> reciperesult = recipe.getResultItems();
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
						_itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
						_itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
					if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable)
						_itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
					i = 3;
					for (ItemStack itemstack : reciperesult) {
						ItemStack itemstackiterator = itemstack.copy();
						if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
							ItemStack _setstack = itemstackiterator.copy();
							_setstack.setCount(1);
							_itemHandlerModifiable.setStackInSlot((int) i, _setstack);
						}
						i = i + 1;
					}
					break;
				}
			}
		}
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