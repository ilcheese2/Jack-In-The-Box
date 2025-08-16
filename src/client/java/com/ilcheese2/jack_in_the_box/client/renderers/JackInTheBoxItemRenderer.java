package com.ilcheese2.jack_in_the_box.client.renderers;

import com.ilcheese2.jack_in_the_box.JackInTheBoxBlockItem;
import com.ilcheese2.jack_in_the_box.blocks.JackInTheBoxBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class JackInTheBoxItemRenderer extends GeoItemRenderer<JackInTheBoxBlockItem> {
    public JackInTheBoxItemRenderer() {
        super(new JackInTheBoxItemModel());
    }
}
