package ru.IST.istcraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class ISTOre extends Block {
    public ISTOre() {
        super(Block.Properties.create(Material.IRON).hardnessAndResistance(3.0f,4.0f)
        .sound(SoundType.STONE).harvestLevel(2).harvestTool(ToolType.PICKAXE));
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader reader, BlockPos pos, int fortune, int silktouch){
        return 1;
    }
}
