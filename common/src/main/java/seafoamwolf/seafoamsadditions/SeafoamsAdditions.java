package seafoamwolf.seafoamsadditions;

import com.google.common.base.Suppliers;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import seafoamwolf.seafoamsadditions.item.AdditionsItems;

import java.util.function.Supplier;

public class SeafoamsAdditions {
    public static final String MOD_ID = "seafoamsadditions";
    // We can use this if we don't want to use DeferredRegister
    public static final Supplier<RegistrarManager> REGISTRIES = Suppliers.memoize(() -> RegistrarManager.get(MOD_ID));

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registries.ITEM);

    // Registering a new creative tab
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);
    public static final RegistrySupplier<CreativeModeTab> ITEM_TAB = TABS.register("item_tab", () ->
            CreativeTabRegistry.create(Component.translatable("itemGroup." + MOD_ID + ".item_tab"),
                    () -> new ItemStack(AdditionsItems.MOON_PHASE_CLOCK.get())));
    
    public static void init() {
        AdditionsItems.init();

        TABS.register();
        
        System.out.println(SeafoamsAdditionsExpectPlatform.getConfigDirectory().toAbsolutePath().normalize().toString());
    }
}
