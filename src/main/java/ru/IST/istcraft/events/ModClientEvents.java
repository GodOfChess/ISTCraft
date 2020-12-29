package ru.IST.istcraft.events;

import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ru.IST.istcraft.ISTCraft;
import ru.IST.istcraft.init.ModBlocks;
import ru.IST.istcraft.init.ModItems;

@Mod.EventBusSubscriber(modid = ISTCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    @SubscribeEvent // func_233580_cy_() == getPosition
    public static void RightClickCoin(PlayerInteractEvent.RightClickEmpty event){
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == ModItems.ISTCOIN.get()){
            World world = player.getEntityWorld();
            world.setBlockState(player.func_233580_cy_().add(0,-1,0), ModBlocks.ISTBLOCK.get().getDefaultState());
        }
        if (player.getHeldItemMainhand().getItem() == ModItems.ISTCOIN_WHITE.get()){
            World world = player.getEntityWorld();
            world.setBlockState(player.func_233580_cy_().add(0,-1,0), ModBlocks.ISTBLOCK_WHITE.get().getDefaultState());
        }
    }

    @SubscribeEvent
    public static void DamageEvent(AttackEntityEvent event){
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.IST_COOKIE.get()){
            if(event.getTarget().isAlive()){
                LivingEntity target = (LivingEntity) event.getTarget();
                target.addPotionEffect(new EffectInstance(Effects.SPEED, 10*20));
                target.setGlowing(true);
            }
            if (!event.getPlayer().getEntityWorld().isRemote){
                PlayerEntity player = event.getPlayer();
                String message = TextFormatting.GREEN+"You give this creature super-speed";
                player.sendMessage(new StringTextComponent(message),player.getUniqueID());
            }
        }
    }

    //@SubscribeEvent //запретитель ивентов
    //public static void onCraftingTableOpen(GuiOpenEvent event){
        //if (event.isCancelable()){
           // if (event.getGui() instanceof CraftingScreen){
      //          event.setCanceled(true);
      //      }
      //  }
   // }
}
