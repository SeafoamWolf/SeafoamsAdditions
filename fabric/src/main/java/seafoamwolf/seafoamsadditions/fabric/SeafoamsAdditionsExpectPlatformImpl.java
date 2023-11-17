package seafoamwolf.seafoamsadditions.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class SeafoamsAdditionsExpectPlatformImpl {
    /**
     * This is our actual method to {@link ExampleExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
