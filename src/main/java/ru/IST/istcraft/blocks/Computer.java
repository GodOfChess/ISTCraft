package ru.IST.istcraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;
import java.io.DataInput;
import java.util.stream.Stream;

public class Computer extends Block {

    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(6, 2, 8, 10, 9, 11),
            Block.makeCuboidShape(0, 9, 6, 16, 10, 12),
            Block.makeCuboidShape(15, 10, 6, 16, 18, 12),
            Block.makeCuboidShape(0, 10, 6, 1, 18, 12),
            Block.makeCuboidShape(1, 10, 9, 15, 18, 15),
            Block.makeCuboidShape(1, 10, 6, 15, 18, 9),
            Block.makeCuboidShape(0, 18, 6, 16, 19, 12)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(6, 2, 5, 10, 9, 8),
            Block.makeCuboidShape(0, 9, 4, 16, 10, 10),
            Block.makeCuboidShape(0, 10, 4, 1, 18, 10),
            Block.makeCuboidShape(15, 10, 4, 16, 18, 10),
            Block.makeCuboidShape(1, 10, 1, 15, 18, 7),
            Block.makeCuboidShape(1, 10, 7, 15, 18, 10),
            Block.makeCuboidShape(0, 18, 4, 16, 19, 10)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(8, 2, 6, 11, 9, 10),
            Block.makeCuboidShape(6, 9, 0, 12, 10, 16),
            Block.makeCuboidShape(6, 10, 0, 12, 18, 1),
            Block.makeCuboidShape(6, 10, 15, 12, 18, 16),
            Block.makeCuboidShape(9, 10, 1, 15, 18, 15),
            Block.makeCuboidShape(6, 10, 1, 9, 18, 15),
            Block.makeCuboidShape(6, 18, 0, 12, 19, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
            Block.makeCuboidShape(5, 2, 6, 8, 9, 10),
            Block.makeCuboidShape(4, 9, 0, 10, 10, 16),
            Block.makeCuboidShape(4, 10, 15, 10, 18, 16),
            Block.makeCuboidShape(4, 10, 0, 10, 18, 1),
            Block.makeCuboidShape(1, 10, 1, 7, 18, 15),
            Block.makeCuboidShape(7, 10, 1, 10, 18, 15),
            Block.makeCuboidShape(4, 18, 0, 10, 19, 16)
    ).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);}).get();

    public Computer() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(3.5f,4.0f)
                .sound(SoundType.ANVIL)
                .harvestLevel(0)
                .harvestTool(ToolType.PICKAXE)
        );
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context){
        switch(state.get(FACING)){
            case NORTH:
                return SHAPE_S;
            case SOUTH:
                return SHAPE_N;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context){
        return this.getDefaultState().with(FACING,context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot){
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn){
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder){
        builder.add(FACING);
    }

    @Override
    public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos){
        return 0.6f;
    }
}
