package seafoamwolf.seafoamsadditions.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import seafoamwolf.seafoamsadditions.SeafoamsAdditions;
import seafoamwolf.seafoamsadditions.block.entity.LunarDisplayBlockEntity;

public class AdditionsBlocks {
    public static final Block LUNAR_DISPLAY = new LunarDisplayBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK));
    public static final BlockItem LUNAR_DISPLAY_ITEM = new BlockItem(LUNAR_DISPLAY, new Item.Properties().arch$tab(SeafoamsAdditions.ITEM_TAB));

    public static final BlockEntityType<LunarDisplayBlockEntity> LUNAR_DISPLAY_BLOCK_ENTITY = BlockEntityType.Builder.of(LunarDisplayBlockEntity::new, LUNAR_DISPLAY).build(null);

    public static void init() {
        SeafoamsAdditions.BLOCKS.register("lunar_display", () -> LUNAR_DISPLAY);
        SeafoamsAdditions.ITEMS.register("lunar_display", () -> LUNAR_DISPLAY_ITEM);
        SeafoamsAdditions.BLOCK_ENTITY_TYPE.register("lunar_display_entity", () -> LUNAR_DISPLAY_BLOCK_ENTITY);
        
        SeafoamsAdditions.BLOCKS.register();
        SeafoamsAdditions.BLOCK_ENTITY_TYPE.register();
    }
}
