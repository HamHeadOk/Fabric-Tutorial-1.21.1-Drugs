package net.ham.tutorialmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.ham.tutorialmod.block.ModBlocks;
//import net.ham.tutorialmod.block.custom.CauliflowerCropBlock;
import net.ham.tutorialmod.block.custom.WeedCropBlock;
import net.ham.tutorialmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.AnyOfLootCondition;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {


        //BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP)
                //.properties(StatePredicate.Builder.create().exactMatch(WeedCropBlock.AGE, 5));
        //this.addDrop(ModBlocks.WEED_CROP, this.cropDrops(ModBlocks.WEED_CROP, ModItems.WEED, ModItems.WEED_SEEDS, builder2));


        //AnyOfLootCondition.Builder builder2 =
                //BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP).properties(StatePredicate.Builder.create()
                                //.exactMatch(WeedCropBlock.AGE, 4))
                        //.or(BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP).properties(StatePredicate.Builder.create()
                                //.exactMatch(WeedCropBlock.AGE, 5)));

         BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.WEED_CROP).properties(StatePredicate.Builder.create()
                 .exactMatch(WeedCropBlock.AGE, 5));

        this.addDrop(ModBlocks.WEED_CROP, this.cropDrops(ModBlocks.WEED_CROP, ModItems.WEED, ModItems.WEED_SEEDS, builder2));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }




}
