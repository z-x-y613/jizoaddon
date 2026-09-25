package com.yourname.jizoaddon;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.common.crafting.IIngredientSerializer;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class ProtectionBookIngredient extends Ingredient {
    public static final ResourceLocation ID =
            new ResourceLocation(JizoAddon.MOD_ID, "protection_book");

    public static final IIngredientSerializer<ProtectionBookIngredient> SERIALIZER =
            new IIngredientSerializer<ProtectionBookIngredient>() {
                @Override
                public ProtectionBookIngredient parse(JsonObject json) {
                    return new ProtectionBookIngredient();
                }

                @Override
                public ProtectionBookIngredient parse(FriendlyByteBuf buf) {
                    return new ProtectionBookIngredient();
                }

                @Override
                public void write(FriendlyByteBuf buf, ProtectionBookIngredient ingredient) {
                }
            };

    private static final ItemStack[] EXAMPLES;
    static {
        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        book.enchant(Enchantments.ALL_DAMAGE_PROTECTION, 4);
        EXAMPLES = new ItemStack[]{ book };
    }

    public ProtectionBookIngredient() {
        super(Stream.of(new Ingredient.ItemValue(EXAMPLES[0])));
    }

    @Override
    public boolean test(@Nullable ItemStack stack) {
        if (stack == null || !stack.is(Items.ENCHANTED_BOOK)) {
            return false;
        }
        int level = EnchantmentHelper.getItemEnchantmentLevel(
                Enchantments.ALL_DAMAGE_PROTECTION, stack);
        return level >= 4;
    }

    @Override
    public ItemStack[] getItems() {
        return EXAMPLES.clone();
    }

    @Override
    public boolean isSimple() {
        return false;
    }

    @Override
    public IIngredientSerializer<? extends Ingredient> getSerializer() {
        return SERIALIZER;
    }

    public static void register() {
        CraftingHelper.register(ID, SERIALIZER);
    }
}
