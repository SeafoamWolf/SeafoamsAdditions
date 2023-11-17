package seafoamwolf.seafoamsadditions.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import seafoamwolf.seafoamsadditions.SeafoamsAdditions;
import seafoamwolf.seafoamsadditions.item.AdditionsItems;

@Mod(SeafoamsAdditions.MOD_ID)
public class SeafoamsAdditionsForge {
    public SeafoamsAdditionsForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(SeafoamsAdditions.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        SeafoamsAdditions.init();
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    private class ClientRegisterHandler {
        @SubscribeEvent
        public static void onRegisterItems(final RegisterEvent event) {
            if (event.getRegistryKey().equals(ForgeRegistries.Keys.ITEMS)) {
                AdditionsItems.registerItemModels();
            }
        }
    }
}
