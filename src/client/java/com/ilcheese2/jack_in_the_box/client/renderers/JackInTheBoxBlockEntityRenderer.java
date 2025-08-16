package com.ilcheese2.jack_in_the_box.client.renderers;

import com.ilcheese2.jack_in_the_box.blocks.JackInTheBoxBlockEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Vec3d;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class JackInTheBoxBlockEntityRenderer extends GeoBlockRenderer<JackInTheBoxBlockEntity> {
    public JackInTheBoxBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(new JackInTheBoxModel());
    }
}
