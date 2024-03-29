package moe.ingstar.meforge.registry;

import moe.ingstar.meforge.Me;
import moe.ingstar.meforge.enchantment.HealthBoostEnchant;
import moe.ingstar.meforge.enchantment.LifeStealEnchant;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, Me.MODID);
    public static final RegistryObject<Enchantment> LIFE_STEAL = ENCHANTMENTS.register(
            "life_steal",
            () -> new LifeStealEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND})
    );

    public static final RegistryObject<Enchantment> HEALTH_BOOST = ENCHANTMENTS.register(
            "health_boost",
            () -> new HealthBoostEnchant(Enchantment.Rarity.RARE, EnchantmentCategory.ARMOR, new EquipmentSlot[]{EquipmentSlot.CHEST, EquipmentSlot.LEGS})
    );

    public ModEnchantments() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENCHANTMENTS.register(modEventBus);
    }
}
