package com.aetherteam.aether.block.construction;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WallSide;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.EnumMap;
import java.util.Map;

public class AerogelWallBlock extends WallBlock {
    private static final Map<Direction, EnumProperty<WallSide>> WALL_SIDES_BY_DIRECTION = new EnumMap<>(Direction.class);

    static {
        WALL_SIDES_BY_DIRECTION.put(Direction.NORTH, NORTH_WALL);
        WALL_SIDES_BY_DIRECTION.put(Direction.SOUTH, SOUTH_WALL);
        WALL_SIDES_BY_DIRECTION.put(Direction.EAST, EAST_WALL);
        WALL_SIDES_BY_DIRECTION.put(Direction.WEST, WEST_WALL);
    }

    public AerogelWallBlock(Properties properties) {
        super(properties);
    }

    /**
     * Relevant to lighting checks for blocks that aren't full cubes and neighboring blocks.
     *
     * @param state The {@link BlockState} of the block.
     * @return Whether to use the shape for light occlusion, as a {@link Boolean}.
     */
    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    /**
     * [CODE COPY] - {@link net.minecraft.world.level.block.TransparentBlock#getVisualShape(BlockState, BlockGetter, BlockPos, CollisionContext)}.
     */
    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    /**
     * [CODE COPY] - {@link net.minecraft.world.level.block.HalfTransparentBlock#skipRendering(BlockState, BlockState, Direction)}.
     *
     * This prevents adjacent walls from rendering redundant faces.
     */
    protected boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
        if (adjacentBlockState.is(this)) {
            if (side.getAxis().isHorizontal()) {
                // Verify that both walls have the same height. This avoids culling a face that actually sticks out
                // above another face.
                WallSide ourHeight = state.getValue(WALL_SIDES_BY_DIRECTION.get(side));
                WallSide theirHeight = adjacentBlockState.getValue(WALL_SIDES_BY_DIRECTION.get(side.getOpposite()));
                return ourHeight.ordinal() <= theirHeight.ordinal();
            } else {
                // If we render a tall post face, the wall above must also have a tall post to skip rendering
                return !state.getValue(UP) || adjacentBlockState.getValue(UP);
            }
        }
        return super.skipRendering(state, adjacentBlockState, side);
    }
}
