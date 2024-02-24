package com.aetherteam.aether.recipe.builder;

import com.aetherteam.nitrogen.recipe.BlockStateIngredient;
import com.aetherteam.nitrogen.recipe.BlockStateRecipeUtil;
import com.google.gson.JsonObject;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.biome.Biome;

import javax.annotation.Nullable;
import java.util.Optional;

public abstract class PlacementBanBuilder implements RecipeBuilder {
    private final BlockStateIngredient bypassBlock;
    private final Optional<ResourceKey<Biome>> biomeKey;
    private final Optional<TagKey<Biome>> biomeTag;
    private final RecipeSerializer<?> serializer;

    public PlacementBanBuilder(BlockStateIngredient bypassBlock, Optional<ResourceKey<Biome>> biomeKey, Optional<TagKey<Biome>> biomeTag, RecipeSerializer<?> serializer) {
        this.bypassBlock = bypassBlock;
        this.biomeKey = biomeKey;
        this.biomeTag = biomeTag;
        this.serializer = serializer;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        return this;
    }

    public BlockStateIngredient getBypassBlock() {
        return this.bypassBlock;
    }

    public Optional<ResourceKey<Biome>> getBiomeKey() {
        return this.biomeKey;
    }

    public Optional<TagKey<Biome>> getBiomeTag() {
        return this.biomeTag;
    }

    public RecipeSerializer<?> getSerializer() {
        return this.serializer;
    }

    @Override
    public Item getResult() {
        return Items.AIR;
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        return this;
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Optional<ResourceKey<Biome>> biomeKey;
        private final Optional<TagKey<Biome>> biomeTag;
        private final BlockStateIngredient bypassBlock;
        private final RecipeSerializer<?> serializer;

        public Result(ResourceLocation id, Optional<ResourceKey<Biome>> biomeKey, Optional<TagKey<Biome>> biomeTag, BlockStateIngredient bypassBlock, RecipeSerializer<?> serializer) {
            this.id = id;
            this.biomeKey = biomeKey;
            this.biomeTag = biomeTag;
            this.bypassBlock = bypassBlock;
            this.serializer = serializer;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            BlockStateRecipeUtil.biomeKeyToJson(json, this.biomeKey);
            BlockStateRecipeUtil.biomeTagToJson(json, this.biomeTag);
            if (!this.bypassBlock.isEmpty()) {
                json.add("bypass", this.bypassBlock.toJson(false));
            }
        }

        @Override
        public ResourceLocation id() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> type() {
            return this.serializer;
        }

        @Nullable
        @Override
        public AdvancementHolder advancement() {
            return null;
        }
    }
}
