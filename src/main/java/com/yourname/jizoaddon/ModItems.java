package com.yourname.jizoaddon;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, JizoAddon.MOD_ID);

    public static final RegistryObject<Item> HALF_TOTEM =
            ITEMS.register("half_totem",
                    () -> new Item(new Item.Properties()
                            .stacksTo(1)
                            .rarity(Rarity.RARE)
                    ));
}