package ru.IST.istcraft;

import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.IST.istcraft.entities.AlbaEntity;
import ru.IST.istcraft.init.ModBlocks;
import ru.IST.istcraft.init.ModEntityTypes;
import ru.IST.istcraft.init.ModItems;

@Mod("istcraft")
public class ISTCraft {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "istcraft";

    public ISTCraft () {

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ModBlocks.Blocks.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModItems.Items.register(FMLJavaModLoadingContext.get().getModEventBus());
        ModEntityTypes.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(()->{
            GlobalEntityTypeAttributes.put(ModEntityTypes.ALBA.get(), AlbaEntity.setCustomAttributes().func_233813_a_());
        });
    }

    private void doClientStuff(final FMLClientSetupEvent event) {}

    public static final ItemGroup ISTTAB = new ItemGroup("ISTTab") {

        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.IST_COOKIE.get());
        }
    };
}