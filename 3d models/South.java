Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
Block.makeCuboidShape(6, 2, 5, 10, 9, 8),
Block.makeCuboidShape(0, 9, 4, 16, 10, 10),
Block.makeCuboidShape(0, 10, 4, 1, 18, 10),
Block.makeCuboidShape(15, 10, 4, 16, 18, 10),
Block.makeCuboidShape(1, 10, 1, 15, 18, 7),
Block.makeCuboidShape(1, 10, 7, 15, 18, 10),
Block.makeCuboidShape(0, 18, 4, 16, 19, 10)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});