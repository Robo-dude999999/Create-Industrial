package net.mcreator.createindustrial.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.createindustrial.jei_recipes.VaccumChamberRecipeTypeRecipe;
import net.mcreator.createindustrial.init.CreateIndustrialModFluids;

import java.util.stream.Collectors;
import java.util.List;

public class SealedVaccumChamberOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (8000 > getFluidTankLevel(world, BlockPos.containing(x, y, z), 1, null)) {
			{
				if (world instanceof Level _lvl) {
					net.minecraft.world.item.crafting.RecipeManager rm = _lvl.getRecipeManager();
					List<VaccumChamberRecipeTypeRecipe> recipes = rm.getAllRecipesFor(VaccumChamberRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
					for (VaccumChamberRecipeTypeRecipe recipe : recipes) {
						List<Ingredient> ingredients = recipe.getIngredients();
						
						boolean recipeMatches = true;
						
						// 1. Gather the ItemStacks currently inside your machine's input slots (Slots 0, 1, and 2)
						List<ItemStack> inputSlots = java.util.List.of(
						    itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0),
						    itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1),
						    itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2)
						);
						
						// 2. Track which slots we have already matched so we don't accidentally match one item twice
						boolean[] slotUsed = new boolean[inputSlots.size()];
						
						// 3. Check every ingredient required by the recipe
						for (Ingredient ingredient : ingredients) {
						    // Skip empty ingredients (like air/empty slots in some recipe types)
						    if (ingredient.isEmpty()) continue; 
						    
						    boolean foundMatchForIngredient = false;
						    
						    // Look through all available input slots to find an item that satisfies this ingredient
						    for (int i = 0; i < inputSlots.size(); i++) {
						        if (!slotUsed[i] && ingredient.test(inputSlots.get(i))) {
						            slotUsed[i] = true; // Mark this slot as consumed by this ingredient
						            foundMatchForIngredient = true;
						            break; // Found a match, move to the next required ingredient
						        }
						    }
						    
						    // If even one ingredient can't be fulfilled by the current inventory, this recipe fails
						    if (!foundMatchForIngredient) {
						        recipeMatches = false;
						        break; 
						    }
						}
						
						// 4. If all recipe ingredients were successfully matched, execute the recipe craft!
						if (recipeMatches) {
						    List<ItemStack> reciperesult = recipe.getResultItems();
						    
						    // Clear input slots (Slots 0, 1, 2)
						    if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						        _itemHandlerModifiable.setStackInSlot(0, ItemStack.EMPTY);
						        _itemHandlerModifiable.setStackInSlot(1, ItemStack.EMPTY);
						        _itemHandlerModifiable.setStackInSlot(2, ItemStack.EMPTY);
						    }
						    
						    // Output the results starting at slot 3
						    int outputSlot = 3;
						    for (ItemStack itemstack : reciperesult) {
						        if (world instanceof ILevelExtension _ext && _ext.getCapability(Capabilities.ItemHandler.BLOCK, BlockPos.containing(x, y, z), null) instanceof IItemHandlerModifiable _itemHandlerModifiable) {
						            ItemStack _setstack = itemstack.copy();
						            // Note: Minecraft recipes usually dictate counts directly, but keeping your count reset logic here
						            _setstack.setCount(1); 
						            _itemHandlerModifiable.setStackInSlot(outputSlot, _setstack);
						        }
						        outputSlot++;
						    }
							if (world instanceof ILevelExtension _ext) {
								IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
								if (_fluidHandler != null)
									_fluidHandler.fill(new FluidStack(CreateIndustrialModFluids.COMPRESSED_AIR.get(), (int) (Mth.nextDouble(RandomSource.create(), 1, 8) * 1000)), IFluidHandler.FluidAction.EXECUTE);
							}
							break;
						}
					}
				}
			}
		}
	}
	private static int getFluidTankLevel(LevelAccessor level, BlockPos pos, int tank, Direction direction) {
		if (level instanceof ILevelExtension levelExtension) {
			IFluidHandler fluidHandler = levelExtension.getCapability(Capabilities.FluidHandler.BLOCK, pos, direction);
			if (fluidHandler != null)
				return fluidHandler.getFluidInTank(tank).getAmount();
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
}