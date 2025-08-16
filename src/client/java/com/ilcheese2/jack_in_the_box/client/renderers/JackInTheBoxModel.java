package com.ilcheese2.jack_in_the_box.client.renderers;

import com.ilcheese2.jack_in_the_box.JackInTheBox;
import com.ilcheese2.jack_in_the_box.blocks.JackInTheBoxBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class JackInTheBoxModel extends DefaultedBlockGeoModel<JackInTheBoxBlockEntity> {

    public JackInTheBoxModel() {
        super(Identifier.of(JackInTheBox.MOD_ID, "jack_in_the_box"));
    }

    @Override
    public void addAdditionalStateData(JackInTheBoxBlockEntity animatable, GeoRenderState renderState) {
        renderState.addGeckolibData(JackInTheBoxBlockEntity.TYPE, animatable.type);
    }

    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return renderState.getGeckolibData(JackInTheBoxBlockEntity.TYPE).texture();
    }
}
