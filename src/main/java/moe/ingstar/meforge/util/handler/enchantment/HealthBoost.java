package moe.ingstar.meforge.util.handler.enchantment;

import moe.ingstar.meforge.Me;

import moe.ingstar.meforge.registry.ModEnchantments;

import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;
import java.util.UUID;

@Mod.EventBusSubscriber(modid = Me.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HealthBoost {

    private static final UUID HEALTH_BOOST_CHEST_UUID = UUID.fromString("d84924da-50b1-4f7f-98c8-4878cbe27395");
    private static final UUID HEALTH_BOOST_LEGS_UUID = UUID.fromString("8d5a0ad0-f38c-4a20-9efc-cd48db625075");
    @SubscribeEvent
    public static void onEquipmentChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {

            EquipmentSlot slot = event.getSlot();
            ItemStack previousItem = event.getFrom();
            ItemStack newItem = event.getTo();

            AttributeModifier healthBoostChest = new AttributeModifier(HEALTH_BOOST_CHEST_UUID,
                    Me.MODID + ":" + "health_boost_chest", 10, AttributeModifier.Operation.ADDITION);

            AttributeModifier healthBoostLegs = new AttributeModifier(HEALTH_BOOST_LEGS_UUID,
                    Me.MODID + ":" + "health_boost_legs", 10, AttributeModifier.Operation.ADDITION);

            if (slot == EquipmentSlot.CHEST) {
                if (hasHealthBoostEnchant(previousItem) && !hasHealthBoostEnchant(newItem)) {
                    Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).removeModifier(healthBoostChest);
                } else {
                    Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).addPermanentModifier(healthBoostChest);
                }
            }

            if (slot == EquipmentSlot.LEGS) {
                if (hasHealthBoostEnchant(previousItem) && !hasHealthBoostEnchant(newItem)) {
                    Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).removeModifier(healthBoostLegs);
                } else {
                    Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH)).addPermanentModifier(healthBoostLegs);
                }
            }
        }
    }

    private static boolean hasHealthBoostEnchant(ItemStack stack) {
        return EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.HEALTH_BOOST.get(), stack) > 0;
    }
}
