package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.recipe.BleachBannerPatternsRecipe;
import com.kekecreations.arts_and_crafts.common.recipe.BleachDecoratedPotRecipe;
import com.kekecreations.arts_and_crafts.common.recipe.DyedDecoratedPotRecipe;
import com.kekecreations.arts_and_crafts.core.platform.Services;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.DecoratedPotRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;

import java.util.function.Supplier;

public class ACRecipeSerializer<T extends Recipe<?>> {



    public static final Supplier<RecipeSerializer<DecoratedPotRecipe>> DYED_DECORATED_POT_RECIPE = registerRecipe("crafting_dyed_decorated_pot",  () -> new SimpleCraftingRecipeSerializer<>(DyedDecoratedPotRecipe::new));

    public static final Supplier<RecipeSerializer<DecoratedPotRecipe>> BLEACH_BANNER_PATTERNS_RECIPE = registerRecipe("crafting_bleach_banner_patterns",  () -> new SimpleCraftingRecipeSerializer<>(BleachBannerPatternsRecipe::new));

    public static final Supplier<RecipeSerializer<DecoratedPotRecipe>> BLEACH_DECORATED_POT_RECIPE = registerRecipe("crafting_bleach_decorated_pot",  () -> new SimpleCraftingRecipeSerializer<>(BleachDecoratedPotRecipe::new));



    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> Supplier registerRecipe(String string, Supplier<S> recipeSerializer) {
        return Services.REGISTRY.register(BuiltInRegistries.RECIPE_SERIALIZER, string, recipeSerializer);
    }





    public static void register() {
    }
}
