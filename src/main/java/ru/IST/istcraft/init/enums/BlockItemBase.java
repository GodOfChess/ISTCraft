package ru.IST.istcraft.init.enums;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import ru.IST.istcraft.ISTCraft;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(ISTCraft.ISTTAB));
    }
}
