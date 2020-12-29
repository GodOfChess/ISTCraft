package ru.IST.istcraft.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ru.IST.istcraft.ISTCraft;
import ru.IST.istcraft.blocks.Computer;
import ru.IST.istcraft.blocks.ISTBlock;
import ru.IST.istcraft.blocks.ISTBlock_white;
import ru.IST.istcraft.blocks.ISTOre;

public class ModBlocks {

    public static final DeferredRegister<Block> Blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, ISTCraft.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> ISTBLOCK = Blocks.register("istblock", ISTBlock::new);
    public static final RegistryObject<Block> ISTBLOCK_WHITE = Blocks.register("istblock_white", ISTBlock_white::new);
    public static final RegistryObject<Block> IST_ORE = Blocks.register("istore", ISTOre::new);
    public static final RegistryObject<Block> COMPUTER = Blocks.register("computer", Computer::new);
}
