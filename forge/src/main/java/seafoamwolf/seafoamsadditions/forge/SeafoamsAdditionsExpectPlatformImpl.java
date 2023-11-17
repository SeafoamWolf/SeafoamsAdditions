package seafoamwolf.seafoamsadditions.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class SeafoamsAdditionsExpectPlatformImpl {
    /**
     * This is our actual method to {@link ExampleExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
