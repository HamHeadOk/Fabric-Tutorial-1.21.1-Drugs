package net.ham.tutorialmod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.ham.tutorialmod.block.ModBlocks;
//import net.ham.tutorialmod.component.ModDataComponentTypes;
//import net.ham.tutorialmod.effect.ModEffects;
//import net.ham.tutorialmod.enchantment.ModEnchantmentEffects;
//import net.ham.tutorialmod.enchantment.ModEnchantments;
import net.ham.tutorialmod.item.ModItemGroups;
import net.ham.tutorialmod.item.ModItems;
//import net.ham.tutorialmod.potion.ModPotions;
//import net.ham.tutorialmod.sound.ModSounds;
//import net.ham.tutorialmod.util.HammerUsageEvent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();



		//ModDataComponentTypes.registerDataComponentTypes();


		CompostingChanceRegistry.INSTANCE.add(ModItems.WEED, 0.5f);
		CompostingChanceRegistry.INSTANCE.add(ModItems.WEED_SEEDS, 0.25f);
	}
}