package net.mcreator.createindustrial.jei_recipes;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.NonNullList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.createindustrial.init.CreateIndustrialModJeiPlugin;
import net.mcreator.createindustrial.init.CreateIndustrialModBlocks;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

import java.util.List;

public class VaccumChamberRecipeTypeRecipeCategory implements IRecipeCategory<VaccumChamberRecipeTypeRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("create_industrial:vaccum_chamber_recipe_type");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("create_industrial:textures/screens/vaccumchamberjei.png");
	private final IDrawable background;
	private final IDrawable icon;
	private final Minecraft mc = Minecraft.getInstance();

	public VaccumChamberRecipeTypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 142);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(CreateIndustrialModBlocks.SEALED_VACCUM_CHAMBER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<VaccumChamberRecipeTypeRecipe> getRecipeType() {
		return CreateIndustrialModJeiPlugin.VaccumChamberRecipeType_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Vaccum Chamber");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public boolean needsRecipeBorder() {
		return false;
	}

	@Override
	public void draw(VaccumChamberRecipeTypeRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);

		guiGraphics.drawString(mc.font, Component.translatable("gui.create_industrial.vaccum_chamber_recipe_type.label_requires_electricity_to_heat_vac"), 6, 111, -12829636, false);
		guiGraphics.drawString(mc.font, Component.translatable("gui.create_industrial.vaccum_chamber_recipe_type.label_electricity_to_heat_vaccum_chamb"), 6, 120, -12829636, false);
		guiGraphics.drawString(mc.font, Component.translatable("gui.create_industrial.vaccum_chamber_recipe_type.label_heat_vaccum_chamber"), 6, 129, -12829636, false);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, VaccumChamberRecipeTypeRecipe recipe, IFocusGroup focuses) {
		List<ItemStack> recipeOutputs = recipe.getResultItems();
		List<ItemStack> actualOutputs = NonNullList.withSize(2, ItemStack.EMPTY);
		for (int i = 0; i < recipeOutputs.size(); i++) {
			actualOutputs.set(i, recipeOutputs.get(i));
		}
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 11).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 54).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 60, 54).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 51, 88).addItemStack(actualOutputs.get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 31, 88).addItemStack(actualOutputs.get(1));
	}
}