package com.ilcheese2.jack_in_the_box.client.renderers;

import com.ilcheese2.jack_in_the_box.JackInTheBox;
import com.ilcheese2.jack_in_the_box.JackInTheBoxBlockItem;
import com.ilcheese2.jack_in_the_box.blocks.JackInTheBoxBlockEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.base.GeoRenderState;

public class JackInTheBoxItemModel extends DefaultedBlockGeoModel<JackInTheBoxBlockItem> {

    public JackInTheBoxItemModel() {
        super(Identifier.of(JackInTheBox.MOD_ID, "jack_in_the_box"));
    }

    @Override
    public void addAdditionalStateData(JackInTheBoxBlockItem animatable, GeoRenderState renderState) {
        // renderState.addGeckolibData(JackInTheBoxBlockEntity.TYPE, animatable.type);
    }



    @Override
    public Identifier getTextureResource(GeoRenderState renderState) {
        return Identifier.of(JackInTheBox.MOD_ID, "textures/block/white_jack_in_the_box.png");
    }
}
