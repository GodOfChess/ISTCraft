Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
Block.makeCuboidShape(8, 2, 6, 11, 9, 10),
Block.makeCuboidShape(6, 9, 0, 12, 10, 16),
Block.makeCuboidShape(6, 10, 0, 12, 18, 1),
Block.makeCuboidShape(6, 10, 15, 12, 18, 16),
Block.makeCuboidShape(9, 10, 1, 15, 18, 15),
Block.makeCuboidShape(6, 10, 1, 9, 18, 15),
Block.makeCuboidShape(6, 18, 0, 12, 19, 16)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});