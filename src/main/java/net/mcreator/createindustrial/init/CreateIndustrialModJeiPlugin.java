package net.mcreator.createindustrial.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.createindustrial.jei_recipes.VaccumChamberRecipeTypeRecipeCategory;
import net.mcreator.createindustrial.jei_recipes.VaccumChamberRecipeTypeRecipe;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.stream.Collectors;
import java.util.Objects;
import java.util.List;

@JeiPlugin
public class CreateIndustrialModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<VaccumChamberRecipeTypeRecipe> VaccumChamberRecipeType_Type = new mezz.jei.api.recipe.RecipeType<>(VaccumChamberRecipeTypeRecipeCategory.UID, VaccumChamberRecipeTypeRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("create_industrial:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new VaccumChamberRecipeTypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<VaccumChamberRecipeTypeRecipe> VaccumChamberRecipeTypeRecipes = recipeManager.getAllRecipesFor(VaccumChamberRecipeTypeRecipe.Type.INSTANCE).stream().map(RecipeHolder::value).collect(Collectors.toList());
		registration.addRecipes(VaccumChamberRecipeType_Type, VaccumChamberRecipeTypeRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(CreateIndustrialModBlocks.SEALED_VACCUM_CHAMBER.get().asItem()), VaccumChamberRecipeType_Type);
	}
}