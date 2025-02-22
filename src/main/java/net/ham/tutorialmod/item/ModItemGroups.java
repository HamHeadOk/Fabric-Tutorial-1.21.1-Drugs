package net.ham.tutorialmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.ham.tutorialmod.TutorialMod;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DRUGS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TutorialMod.MOD_ID, "drugs"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.WEED))
                    .displayName(Text.translatable("itemgroup.tutorialmod.drugs"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.WEED);
                        entries.add(ModItems.BLUNT);
                        entries.add(ModItems.WEED_SEEDS);


                    }).build());



    public static void registerItemGroups() {
        TutorialMod.LOGGER.info("Registering Item Groups for " + TutorialMod.MOD_ID);
    }

}
