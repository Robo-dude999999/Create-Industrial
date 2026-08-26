package net.mcreator.createindustrial.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.Containers;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.createindustrial.world.inventory.SealedVaccumChamberGUIMenu;
import net.mcreator.createindustrial.procedures.SealedVaccumChamberRedstoneOnProcedure;
import net.mcreator.createindustrial.procedures.SealedVaccumChamberRedstoneOffProcedure;
import net.mcreator.createindustrial.procedures.SealedVaccumChamberOnTickUpdate2Procedure;
import net.mcreator.createindustrial.procedures.SealedVaccumChamberBlockIsPlacedByProcedure;
import net.mcreator.createindustrial.block.entity.SealedVaccumChamberBlockEntity;

import io.netty.buffer.Unpooled;

import com.google.common.collect.ImmutableMap;

public class SealedVaccumChamberBlock extends Block implements EntityBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final IntegerProperty TICK = IntegerProperty.create("tick", 0, 80);
	public static final EnumProperty<ProcessingProperty> PROCESSING = EnumProperty.create("processing", ProcessingProperty.class);
	private final ImmutableMap<BlockState, VoxelShape> shapes = this.makeShapes();

	public SealedVaccumChamberBlock() {
		super(BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).sound(SoundType.METAL).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false).instrument(NoteBlockInstrument.IRON_XYLOPHONE));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(TICK, 0).setValue(PROCESSING, ProcessingProperty.REGULAR));
	}

	private ImmutableMap<BlockState, VoxelShape> makeShapes() {
		return this.getShapeForEachState(state -> {
			return switch (state.getValue(FACING)) {
				default -> Shapes.or(box(14, 2, 0, 16, 16, 16), box(2, 0, 2, 14, 2, 14), box(11, 2, 14, 14, 16, 16), box(5, 2, 14, 11, 10, 16), box(2, 2, 14, 5, 16, 16), box(2, 2, 0, 14, 16, 2), box(0, 2, 0, 2, 16, 16), box(14, 16, 0, 16, 28, 16),
						box(0, 16, 0, 2, 28, 16), box(2, 17, 14, 14, 28, 16), box(2, 16, 14, 5, 17, 16), box(11, 16, 14, 14, 17, 16), box(2, 16, 0, 14, 28, 2), box(2, 27, 2, 14, 29, 14));
				case NORTH -> Shapes.or(box(0, 2, 0, 2, 16, 16), box(2, 0, 2, 14, 2, 14), box(2, 2, 0, 5, 16, 2), box(5, 2, 0, 11, 10, 2), box(11, 2, 0, 14, 16, 2), box(2, 2, 14, 14, 16, 16), box(14, 2, 0, 16, 16, 16), box(0, 16, 0, 2, 28, 16),
						box(14, 16, 0, 16, 28, 16), box(2, 17, 0, 14, 28, 2), box(11, 16, 0, 14, 17, 2), box(2, 16, 0, 5, 17, 2), box(2, 16, 14, 14, 28, 16), box(2, 27, 2, 14, 29, 14));
				case EAST -> Shapes.or(box(0, 2, 0, 16, 16, 2), box(2, 0, 2, 14, 2, 14), box(14, 2, 2, 16, 16, 5), box(14, 2, 5, 16, 10, 11), box(14, 2, 11, 16, 16, 14), box(0, 2, 2, 2, 16, 14), box(0, 2, 14, 16, 16, 16), box(0, 16, 0, 16, 28, 2),
						box(0, 16, 14, 16, 28, 16), box(14, 17, 2, 16, 28, 14), box(14, 16, 11, 16, 17, 14), box(14, 16, 2, 16, 17, 5), box(0, 16, 2, 2, 28, 14), box(2, 27, 2, 14, 29, 14));
				case WEST -> Shapes.or(box(0, 2, 14, 16, 16, 16), box(2, 0, 2, 14, 2, 14), box(0, 2, 11, 2, 16, 14), box(0, 2, 5, 2, 10, 11), box(0, 2, 2, 2, 16, 5), box(14, 2, 2, 16, 16, 14), box(0, 2, 0, 16, 16, 2), box(0, 16, 14, 16, 28, 16),
						box(0, 16, 0, 16, 28, 2), box(0, 17, 2, 2, 28, 14), box(0, 16, 2, 2, 17, 5), box(0, 16, 11, 2, 17, 14), box(14, 16, 2, 16, 28, 14), box(2, 27, 2, 14, 29, 14));
			};
		});
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return shapes.get(state);
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(FACING, TICK, PROCESSING);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		return super.getStateForPlacement(context).setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(TICK, 0).setValue(PROCESSING, ProcessingProperty.REGULAR);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			SealedVaccumChamberRedstoneOnProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		} else {
			SealedVaccumChamberRedstoneOffProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		}
	}

	@Override
	public void tick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
		super.tick(blockstate, world, pos, random);
		SealedVaccumChamberOnTickUpdate2Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
		world.scheduleTick(pos, this, 1);
	}

	@Override
	public void setPlacedBy(Level world, BlockPos pos, BlockState blockstate, LivingEntity entity, ItemStack itemstack) {
		super.setPlacedBy(world, pos, blockstate, entity, itemstack);
		SealedVaccumChamberBlockIsPlacedByProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		if (entity instanceof ServerPlayer player) {
			player.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Sealed Vaccum Chamber");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new SealedVaccumChamberGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(pos));
				}
			}, pos);
		}
		return InteractionResult.SUCCESS;
	}

	@Override
	public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
		BlockEntity tileEntity = worldIn.getBlockEntity(pos);
		return tileEntity instanceof MenuProvider menuProvider ? menuProvider : null;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new SealedVaccumChamberBlockEntity(pos, state);
	}

	@Override
	public boolean triggerEvent(BlockState state, Level world, BlockPos pos, int eventID, int eventParam) {
		super.triggerEvent(state, world, pos, eventID, eventParam);
		BlockEntity blockEntity = world.getBlockEntity(pos);
		return blockEntity != null && blockEntity.triggerEvent(eventID, eventParam);
	}

	@Override
	public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
		if (state.getBlock() != newState.getBlock()) {
			BlockEntity blockEntity = world.getBlockEntity(pos);
			if (blockEntity instanceof SealedVaccumChamberBlockEntity be) {
				Containers.dropContents(world, pos, be);
				world.updateNeighbourForOutputSignal(pos, this);
			}
			super.onRemove(state, world, pos, newState, isMoving);
		}
	}

	public enum ProcessingProperty implements StringRepresentable {
		DEPLOYER("deployer"), DEPLOYERPROCESSING("deployerprocessing"), REGULAR("regular"), REGULARPROCESSING("regularprocessing");

		private final String name;

		private ProcessingProperty(String name) {
			this.name = name;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
}