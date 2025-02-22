package net.ham.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.ham.tutorialmod.block.ModBlocks;
//import net.ham.tutorialmod.block.custom.CauliflowerCropBlock;
import net.ham.tutorialmod.block.custom.WeedCropBlock;
import net.ham.tutorialmod.item.ModItems;
import net.minecraft.data.client.*;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        blockStateModelGenerator.registerCrop(ModBlocks.WEED_CROP, WeedCropBlock.AGE, 0, 1, 2, 3, 4, 5);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {


        itemModelGenerator.register(ModItems.WEED, Models.GENERATED);

    }
}
