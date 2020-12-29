package ru.IST.istcraft.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import ru.IST.istcraft.ISTCraft;
import ru.IST.istcraft.client.render.AlbaRenderer;

@Mod.EventBusSubscriber(modid = ISTCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event){
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.ALBA.get(), AlbaRenderer::new);
    }
}
