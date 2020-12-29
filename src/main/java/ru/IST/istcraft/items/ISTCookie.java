package ru.IST.istcraft.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import ru.IST.istcraft.ISTCraft;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ISTCookie extends Item {

    public ISTCookie() {
        super(new Item.Properties().group(ISTCraft.ISTTAB)
                .food(new Food.Builder().hunger(4).saturation(1.2f).effect(new EffectInstance(Effects.SPEED, 1000, 2), 1f)
                        .setAlwaysEdible()
                        .build()));
    }
}
