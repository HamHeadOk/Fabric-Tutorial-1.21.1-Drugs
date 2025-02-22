package net.ham.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
//import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.ham.tutorialmod.TutorialMod;
import net.ham.tutorialmod.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item WEED = registerItem("weed", new Item(new Item.Settings()));

    public static final Item WEED_SEEDS = registerItem("weed_seeds",
            new AliasedBlockItem(ModBlocks.WEED_CROP, new Item.Settings()));

    ///public static final Item WEED_SEEDS = registerItem("weed_seeds",
            ///new AliasedBlockItem(ModBlocks.WEED_CROP, new Item.Settings()));
    ///public static final Item WEED = registerItem("weed",
            ///new Item(new Item.Settings()));

    public static final Item BLUNT = registerItem("blunt", new Item(new Item.Settings().food(ModFoodComponents.BLUNT).maxCount(16)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TutorialMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TutorialMod.LOGGER.info("Registering Mod Items for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(WEED);
            entries.add(BLUNT);

        });
    }
}