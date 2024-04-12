package moe.ingstar.meforge.item;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ContainerOfHeart extends Item {
    public ContainerOfHeart(Properties p_41383_) {
        super(p_41383_);
    }


    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);

        if (hand == InteractionHand.MAIN_HAND || hand == InteractionHand.OFF_HAND) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 3, 8, false, false));
            heldItem.shrink(1);

            player.getCooldowns().addCooldown(heldItem.getItem(), 10);
            return InteractionResultHolder.consume(heldItem);
        }

        return InteractionResultHolder.pass(heldItem);
    }

}
