package com.ilcheese2.jack_in_the_box;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import org.apache.commons.lang3.mutable.MutableObject;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class JackInTheBoxBlockItem extends BlockItem implements GeoItem {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("closed idle/item model", Animation.LoopType.HOLD_ON_LAST_FRAME);
    public final MutableObject<GeoRenderProvider> renderProviderHolder = new MutableObject<>();
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public JackInTheBoxBlockItem(Block block, Settings settings) {
        super(block, settings);
        GeoItem.registerSyncedAnimatable(this);
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        //consumer.accept(this.renderProviderHolder.getValue());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>("idle", animTest -> animTest.setAndContinue(IDLE_ANIM)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
