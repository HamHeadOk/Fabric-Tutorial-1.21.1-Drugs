package net.ham.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent BLUNT = new FoodComponent.Builder()
            .statusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 200), 1).build();

}
