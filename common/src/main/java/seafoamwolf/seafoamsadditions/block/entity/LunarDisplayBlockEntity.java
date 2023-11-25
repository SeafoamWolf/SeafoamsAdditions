package seafoamwolf.seafoamsadditions.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import seafoamwolf.seafoamsadditions.block.AdditionsBlocks;

public class LunarDisplayBlockEntity extends BlockEntity {
    public LunarDisplayBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(AdditionsBlocks.LUNAR_DISPLAY_BLOCK_ENTITY, blockPos, blockState);
    }
}
