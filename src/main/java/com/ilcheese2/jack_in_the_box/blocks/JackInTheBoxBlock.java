package com.ilcheese2.jack_in_the_box.blocks;

import com.ilcheese2.jack_in_the_box.JackInTheBoxType;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class JackInTheBoxBlock extends BlockWithEntity {
    public static final MapCodec<JackInTheBoxBlock> CODEC = createCodec(JackInTheBoxBlock::new);


    public JackInTheBoxBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new JackInTheBoxBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.INVISIBLE;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof JackInTheBoxBlockEntity jackInTheBox) {
                jackInTheBox.triggerAnim("open_controller", "chest opening");
            }
        }
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof JackInTheBoxBlockEntity jackInTheBox) {
            JackInTheBoxType type = JackInTheBoxType.itemMapping.get().get(stack.getItem());
            if (type != null) {
                if (!player.isInCreativeMode()) {
                    // player.giveItemStack(new ItemStack(jackInTheBox.type.item(), 1));
                }
                jackInTheBox.type = type;
                jackInTheBox.markDirty();
                world.updateListeners(pos, state, state, 3);
                stack.decrementUnlessCreative(1, player);
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS_TO_DEFAULT_BLOCK_ACTION;
    }
}
