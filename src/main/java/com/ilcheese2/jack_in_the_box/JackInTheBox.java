package com.ilcheese2.jack_in_the_box;

import com.ilcheese2.jack_in_the_box.blocks.JackInTheBoxBlock;
import com.ilcheese2.jack_in_the_box.blocks.JackInTheBoxBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

public class JackInTheBox implements ModInitializer {

    public static final String MOD_ID = "jack_in_the_box";
    public static final JackInTheBoxBlock JACK_IN_THE_BOX;
    public static final JackInTheBoxBlockItem JACK_IN_THE_BOX_ITEM;
    public static final BlockEntityType<JackInTheBoxBlockEntity> JACK_IN_THE_BOX_BLOCK_ENTITY;
    private static final JackInTheBoxType[] JACK_IN_THE_BOX_TYPES = { // force load
            JackInTheBoxType.BLACK,
            JackInTheBoxType.BLUE,
            JackInTheBoxType.BROWN,
            JackInTheBoxType.CYAN,
            JackInTheBoxType.GRAY,
            JackInTheBoxType.GREEN,
            JackInTheBoxType.LIGHT_BLUE,
            JackInTheBoxType.LIGHT_GRAY,
            JackInTheBoxType.LIME,
            JackInTheBoxType.MAGENTA,
            JackInTheBoxType.ORANGE,
            JackInTheBoxType.PINK,
            JackInTheBoxType.PURPLE,
            JackInTheBoxType.RED,
            JackInTheBoxType.WHITE,
            JackInTheBoxType.YELLOW
    };

    static {
        RegistryKey<Block> key = RegistryKey.of(Registries.BLOCK.getKey(), Identifier.of(MOD_ID, "jack_in_the_box"));
        Block block = new JackInTheBoxBlock(AbstractBlock.Settings.copy(Blocks.TRAPPED_CHEST).nonOpaque().registryKey(key));
        RegistryKey<Item> itemKey = RegistryKey.of(Registries.ITEM.getKey(), key.getValue());
        Item item = new JackInTheBoxBlockItem(block, new Item.Settings().registryKey(itemKey));
        JACK_IN_THE_BOX_ITEM = (JackInTheBoxBlockItem) Registry.register(Registries.ITEM, itemKey, item);
        JACK_IN_THE_BOX = (JackInTheBoxBlock) Registry.register(Registries.BLOCK, key, block);
        JACK_IN_THE_BOX_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MOD_ID, "jack_in_the_box"), FabricBlockEntityTypeBuilder.create(JackInTheBoxBlockEntity::new, JACK_IN_THE_BOX).build());
    }


    @Override
    public void onInitialize() {}


}
