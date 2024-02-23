package moe.ingstar.meforge.util.handler.enchantment;

import moe.ingstar.meforge.registry.ModEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LifeSteal {
    @SubscribeEvent
    public void onLivingDamage(LivingDamageEvent event) {
        LivingEntity target = event.getEntity();
        float damageAmount = event.getAmount();

        if (target instanceof LivingEntity && damageAmount > 0) {

            if (event.getSource().getEntity() instanceof Player) {
                Player attacker = (Player) event.getSource().getEntity();

                ItemStack weaponStack = attacker.getMainHandItem();
                int lifeStealLevel = EnchantmentHelper.getItemEnchantmentLevel(ModEnchantments.LIFE_STEAL.get(), weaponStack);

                if (lifeStealLevel > 0) {
                    float lifeStealAmount = damageAmount * (lifeStealLevel * 0.1f);

                    attacker.heal(lifeStealAmount);
                }
            }
        }
    }
}
