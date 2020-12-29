Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
Block.makeCuboidShape(6, 2, 8, 10, 9, 11),
Block.makeCuboidShape(0, 9, 6, 16, 10, 12),
Block.makeCuboidShape(15, 10, 6, 16, 18, 12),
Block.makeCuboidShape(0, 10, 6, 1, 18, 12),
Block.makeCuboidShape(1, 10, 9, 15, 18, 15),
Block.makeCuboidShape(1, 10, 6, 15, 18, 9),
Block.makeCuboidShape(0, 18, 6, 16, 19, 12)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});