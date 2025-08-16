package com.ilcheese2.jack_in_the_box.client;

import com.ilcheese2.jack_in_the_box.JackInTheBox;
import com.ilcheese2.jack_in_the_box.JackInTheBoxBlockItem;
import com.ilcheese2.jack_in_the_box.client.renderers.JackInTheBoxBlockEntityRenderer;
import com.ilcheese2.jack_in_the_box.client.renderers.JackInTheBoxItemRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class JackInTheBoxClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(JackInTheBox.JACK_IN_THE_BOX_BLOCK_ENTITY,
            JackInTheBoxBlockEntityRenderer::new);
        JackInTheBox.JACK_IN_THE_BOX_ITEM.renderProviderHolder.setValue(new GeoRenderProvider() {
            private JackInTheBoxItemRenderer renderer;

            @Override
            public GeoItemRenderer<JackInTheBoxBlockItem> getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new JackInTheBoxItemRenderer();

                return this.renderer;
            }
        });

    }
}
