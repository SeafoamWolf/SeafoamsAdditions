package seafoamwolf.seafoamsadditions.item;

import dev.architectury.platform.Platform;
import dev.architectury.registry.item.ItemPropertiesRegistry;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import seafoamwolf.seafoamsadditions.SeafoamsAdditions;

public class AdditionsItems {
    public static final RegistrySupplier<Item> MOON_PHASE_CLOCK = SeafoamsAdditions.ITEMS.register("moon_phase_clock", () ->
            new Item(new Item.Properties().arch$tab(SeafoamsAdditions.ITEM_TAB).stacksTo(1)));

    public static void init() {
        SeafoamsAdditions.ITEMS.register();

        if (Platform.isFabric()) {
            registerItemModels();
        }

    }

    public static void registerItemModels() {
        ItemPropertiesRegistry.register(MOON_PHASE_CLOCK.get(), new ResourceLocation(SeafoamsAdditions.MOD_ID, "moon_phase"), (itemStack, clientLevel, livingEntity, i) -> {
            return (float)clientLevel.getMoonPhase() / 8.0f;
        });
    }
}
