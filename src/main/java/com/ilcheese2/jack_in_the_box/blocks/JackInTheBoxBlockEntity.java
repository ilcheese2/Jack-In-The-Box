package com.ilcheese2.jack_in_the_box.blocks;

import com.ilcheese2.jack_in_the_box.JackInTheBox;
import com.ilcheese2.jack_in_the_box.JackInTheBoxType;
import net.minecraft.block.BlockState;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.DyeColor;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.manager.AnimatableManager;
import software.bernie.geckolib.animatable.processing.AnimationController;
import software.bernie.geckolib.animatable.processing.AnimationTest;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.dataticket.DataTicket;
import software.bernie.geckolib.util.GeckoLibUtil;

public class JackInTheBoxBlockEntity extends BlockEntity implements GeoBlockEntity {
    protected static final RawAnimation IDLE_ANIM = RawAnimation.begin().then("closed idle/item model", Animation.LoopType.HOLD_ON_LAST_FRAME);
    protected static final RawAnimation CHEST_OPENING_ANIM = RawAnimation.begin().then("chest opening", Animation.LoopType.PLAY_ONCE).then("open idle", Animation.LoopType.PLAY_ONCE);

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public static final DataTicket<JackInTheBoxType> TYPE = DataTicket.create("jack_in_the_box_type", JackInTheBoxType.class);

    public JackInTheBoxType type = JackInTheBoxType.WHITE;

    public JackInTheBoxBlockEntity(BlockPos pos, BlockState state) {
        super(JackInTheBox.JACK_IN_THE_BOX_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this::idleAnimController))
                .add(new AnimationController<>("open_controller", anim_test -> PlayState.STOP).triggerableAnim("chest opening", CHEST_OPENING_ANIM));
    }

    protected PlayState idleAnimController(final AnimationTest<JackInTheBoxBlockEntity> animTest) {
        return animTest.setAndContinue(IDLE_ANIM);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    protected void writeData(WriteView view) {
        view.put("type", JackInTheBoxType.CODEC, this.type);
        super.writeData(view);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.type = view.read("type", JackInTheBoxType.CODEC).orElseGet(() -> JackInTheBoxType.WHITE);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registries) {
        return createComponentlessNbt(registries);
    }
}
