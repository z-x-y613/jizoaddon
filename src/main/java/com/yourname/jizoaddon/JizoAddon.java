package com.yourname.jizoaddon;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(JizoAddon.MOD_ID)
public class JizoAddon {
    public static final String MOD_ID = "jizoaddon";

    public JizoAddon() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}