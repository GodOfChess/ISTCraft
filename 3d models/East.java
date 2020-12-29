Stream.of(
Block.makeCuboidShape(0, 0, 0, 16, 2, 16),
Block.makeCuboidShape(5, 2, 6, 8, 9, 10),
Block.makeCuboidShape(4, 9, 0, 10, 10, 16),
Block.makeCuboidShape(4, 10, 15, 10, 18, 16),
Block.makeCuboidShape(4, 10, 0, 10, 18, 1),
Block.makeCuboidShape(1, 10, 1, 7, 18, 15),
Block.makeCuboidShape(7, 10, 1, 10, 18, 15),
Block.makeCuboidShape(4, 18, 0, 10, 19, 16)
).reduce((v1, v2) -> {return VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR);});