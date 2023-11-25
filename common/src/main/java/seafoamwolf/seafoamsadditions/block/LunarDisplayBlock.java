package seafoamwolf.seafoamsadditions.block;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.DaylightDetectorBlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import seafoamwolf.seafoamsadditions.block.entity.LunarDisplayBlockEntity;

public class LunarDisplayBlock extends BaseEntityBlock {
    public static final IntegerProperty MOON_PHASE = IntegerProperty.create("moon_phase", 0, 7);

    public LunarDisplayBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(MOON_PHASE, 0));
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new LunarDisplayBlockEntity(blockPos, blockState);
    }

    @Override
    public boolean isSignalSource(BlockState blockState) {
        return true;
    }

    @Override
    public int getSignal(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, Direction direction) {
        return blockState.getValue(MOON_PHASE);
    }

     @Override
    @Nullable
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        if (!level.isClientSide && level.dimensionType().hasSkyLight()) {
            return LunarDisplayBlock.createTickerHelper(blockEntityType, BlockEntityType.DAYLIGHT_DETECTOR, LunarDisplayBlock::tickEntity);
        }
        return null;
    }

    private static void tickEntity(Level level, BlockPos blockPos, BlockState blockState, DaylightDetectorBlockEntity daylightDetectorBlockEntity) {
        if (level.getGameTime() % 20L == 0L) {
            int newPhase = level.getMoonPhase();

            if (blockState.getValue(MOON_PHASE) != newPhase) {
                level.setBlock(blockPos, (BlockState)blockState.setValue(MOON_PHASE, newPhase), 3);
            }
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(MOON_PHASE);
    }
}
