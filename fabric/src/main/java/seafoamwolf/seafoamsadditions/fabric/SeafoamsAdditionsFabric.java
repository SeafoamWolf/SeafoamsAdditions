package seafoamwolf.seafoamsadditions.fabric;

import net.fabricmc.api.ModInitializer;

import seafoamwolf.seafoamsadditions.SeafoamsAdditions;

public class SeafoamsAdditionsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SeafoamsAdditions.init();
    }
}