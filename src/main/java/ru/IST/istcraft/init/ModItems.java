package ru.IST.istcraft.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.IST.istcraft.ISTCraft;
import ru.IST.istcraft.init.enums.BlockItemBase;
import ru.IST.istcraft.init.enums.ModArmorMaterial;
import ru.IST.istcraft.items.ISTCoin;
import ru.IST.istcraft.items.ISTCoin_white;
import ru.IST.istcraft.items.ISTCookie;
import ru.IST.istcraft.items.ISTDiamond;
import ru.IST.istcraft.init.enums.ModItemTier;

public class ModItems {
    //Lists
    public static final DeferredRegister<Item> Items = DeferredRegister.create(ForgeRegistries.ITEMS, ISTCraft.MOD_ID);

    //Items
    public static final RegistryObject<Item> ISTCOIN = Items.register("istcoin", ISTCoin::new);
    public static final RegistryObject<Item> ISTCOIN_WHITE = Items.register("istcoin_white", ISTCoin_white::new);
    public static final RegistryObject<Item> ISTDIAMOND = Items.register("istdiamond", ISTDiamond::new);
    public static final RegistryObject<ISTCookie> IST_COOKIE = Items.register("istcookie", ISTCookie::new);

    //Tools
    public static final RegistryObject<SwordItem> IST_SWORD = Items.register("ist_sword", ()->
            new SwordItem(ModItemTier.ISTDIAMOND, 4, -2.0F, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<PickaxeItem> IST_PICKAXE = Items.register("ist_pickaxe", ()->
            new PickaxeItem(ModItemTier.ISTDIAMOND, 0, -2.5F, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<AxeItem> IST_AXE = Items.register("ist_axe", ()->
            new AxeItem(ModItemTier.ISTDIAMOND, 2, -2.3F, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<ShovelItem> IST_SHOVEL = Items.register("ist_shovel", ()->
            new ShovelItem(ModItemTier.ISTDIAMOND, 0, -3.0F, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<HoeItem> IST_HOE = Items.register("ist_hoe", ()->
            new HoeItem(ModItemTier.ISTDIAMOND, -1, -3.0F, new Item.Properties().group(ISTCraft.ISTTAB)));

    //Armor
    public static final RegistryObject<ArmorItem> IST_HELMET = Items.register("ist_helmet",()->
            new ArmorItem(ModArmorMaterial.ISTDIAMOND, EquipmentSlotType.HEAD, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<ArmorItem> IST_CHEST = Items.register("ist_chest",()->
            new ArmorItem(ModArmorMaterial.ISTDIAMOND, EquipmentSlotType.CHEST, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<ArmorItem> IST_LEGS = Items.register("ist_legs",()->
            new ArmorItem(ModArmorMaterial.ISTDIAMOND, EquipmentSlotType.LEGS, new Item.Properties().group(ISTCraft.ISTTAB)));
    public static final RegistryObject<ArmorItem> IST_BOOTS = Items.register("ist_boots",()->
            new ArmorItem(ModArmorMaterial.ISTDIAMOND, EquipmentSlotType.FEET, new Item.Properties().group(ISTCraft.ISTTAB)));

    //Block Items
    public static final RegistryObject<Item> ISTBLOCK_ITEM=Items.register("istblock",()->new BlockItemBase(ModBlocks.ISTBLOCK.get()));
    public static final RegistryObject<Item> ISTBLOCK_WHITE_ITEM=Items.register("istblock_white",()->new BlockItemBase(ModBlocks.ISTBLOCK_WHITE.get()));
    public static final RegistryObject<Item> ISTBLOCK_ORE=Items.register("istore",()->new BlockItemBase(ModBlocks.IST_ORE.get()));
    public static final RegistryObject<Item> COMPUTER_ITEM=Items.register("computer",()->new BlockItemBase(ModBlocks.COMPUTER.get()));

}
