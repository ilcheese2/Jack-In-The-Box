package com.ilcheese2.jack_in_the_box;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.SimpleRegistry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.Map;

public record JackInTheBoxType(Item item, Identifier texture) {
    public static final RegistryKey<Registry<JackInTheBoxType>> JACK_IN_THE_BOX_REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.of(JackInTheBox.MOD_ID, "jack_in_the_box_types"));
    public static final Registry<JackInTheBoxType> JACK_IN_THE_BOX_REGISTRY = FabricRegistryBuilder.createSimple(
            JACK_IN_THE_BOX_REGISTRY_KEY).attribute(RegistryAttribute.SYNCED).buildAndRegister();

    public static final Codec<JackInTheBoxType> CODEC = JACK_IN_THE_BOX_REGISTRY.getCodec();

    public static final JackInTheBoxType BLACK = register("black", new JackInTheBoxType(
            Items.BLACK_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/black_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType BLUE = register("blue", new JackInTheBoxType(
            Items.BLUE_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/blue_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType BROWN = register("brown", new JackInTheBoxType(
            Items.BROWN_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/brown_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType CYAN = register("cyan", new JackInTheBoxType(
            Items.CYAN_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/cyan_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType GRAY = register("gray", new JackInTheBoxType(
            Items.GRAY_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/gray_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType GREEN = register("green", new JackInTheBoxType(
            Items.GREEN_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/green_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType LIGHT_BLUE = register("light_blue", new JackInTheBoxType(
            Items.LIGHT_BLUE_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/light_blue_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType LIGHT_GRAY = register("light_gray", new JackInTheBoxType(
            Items.LIGHT_GRAY_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/light_gray_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType LIME = register("lime", new JackInTheBoxType(
            Items.LIME_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/lime_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType MAGENTA = register("magenta", new JackInTheBoxType(
            Items.MAGENTA_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/magenta_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType ORANGE = register("orange", new JackInTheBoxType(
            Items.ORANGE_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/orange_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType PINK = register("pink", new JackInTheBoxType(
            Items.PINK_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/pink_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType PURPLE = register("purple", new JackInTheBoxType(
            Items.PURPLE_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/purple_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType RED = register("red", new JackInTheBoxType(
            Items.RED_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/red_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType WHITE = register("white", new JackInTheBoxType(
            Items.WHITE_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/white_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType YELLOW = register("yellow", new JackInTheBoxType(
            Items.YELLOW_DYE,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/yellow_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType CREEPER = register("creeper", new JackInTheBoxType(
            Items.CREEPER_HEAD,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/creeper_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType SKELETON = register("skeleton", new JackInTheBoxType(
            Items.SKELETON_SKULL,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/skeleton_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType ZOMBIE = register("zombie", new JackInTheBoxType(
            Items.ZOMBIE_HEAD,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/zombie_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType WITHER_SKELETON = register("wither_skeleton", new JackInTheBoxType(
            Items.WITHER_SKELETON_SKULL,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/wither_skeleton_jack_in_the_box.png")
    ));
    public static final JackInTheBoxType PLAYER = register("player", new JackInTheBoxType(
            Items.PLAYER_HEAD,
            Identifier.of(JackInTheBox.MOD_ID, "textures/block/player_jack_in_the_box.png")
    ));

    public static final Supplier<Map<Item, JackInTheBoxType>> itemMapping = Suppliers.memoize(() -> JACK_IN_THE_BOX_REGISTRY.streamEntries()
            .collect(java.util.stream.Collectors.toMap(
                    entry -> entry.value().item(),
                    RegistryEntry.Reference::value
            )));  // hack

    public static JackInTheBoxType register(String id, JackInTheBoxType type) {
        return Registry.register(JackInTheBoxType.JACK_IN_THE_BOX_REGISTRY, Identifier.of(JackInTheBox.MOD_ID, id), type);
    }
}