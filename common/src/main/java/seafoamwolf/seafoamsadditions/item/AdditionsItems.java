package seafoamwolf.seafoamsadditions.item;

import dev.architectury.registry.item.ItemPropertiesRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import seafoamwolf.seafoamsadditions.SeafoamsAdditions;

public class AdditionsItems {
    public static final Item LUNAR_CLOCK = new Item(new Item.Properties().arch$tab(SeafoamsAdditions.ITEM_TAB).stacksTo(1));

    public static void init() {
        SeafoamsAdditions.ITEMS.register("lunar_clock", () -> LUNAR_CLOCK);
        
        SeafoamsAdditions.ITEMS.register();

        registerItemModels();
    }

    public static void registerItemModels() {
        ItemPropertiesRegistry.register(LUNAR_CLOCK, new ResourceLocation(SeafoamsAdditions.MOD_ID, "moon_phase"), (itemStack, clientLevel, livingEntity, i) -> {
            // Offset for signal strength
            return (float)((clientLevel.getMoonPhase() + 4) % 8) / 8.0f;
        });
    }
}
