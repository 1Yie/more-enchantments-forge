package moe.ingstar.meforge.registry;

import moe.ingstar.meforge.Me;
import moe.ingstar.meforge.item.ContainerOfHeart;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Me.MODID);
    public static final RegistryObject<Item> CONTAINER_OF_HEART = ITEMS.register("container_of_heart", () ->
            new ContainerOfHeart(new Item.Properties()));

    public ModItems() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modEventBus);
        modEventBus.register(this);
    }
}
