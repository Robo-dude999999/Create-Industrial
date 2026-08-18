package net.mcreator.createindustrial.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.createindustrial.jei_recipes.VaccumChamberRecipeTypeRecipe;

@EventBusSubscriber
public class CreateIndustrialModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "create_industrial");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "create_industrial");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("create_industrial").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("vaccum_chamber_recipe_type", () -> VaccumChamberRecipeTypeRecipe.Type.INSTANCE);
			SERIALIZERS.register("vaccum_chamber_recipe_type", () -> VaccumChamberRecipeTypeRecipe.Serializer.INSTANCE);
		});
	}
}