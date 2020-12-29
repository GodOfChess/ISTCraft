package ru.IST.istcraft.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.IST.istcraft.ISTCraft;

@Mod.EventBusSubscriber(modid = ISTCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

    @SubscribeEvent
    public static void onServerChat(){}

}
