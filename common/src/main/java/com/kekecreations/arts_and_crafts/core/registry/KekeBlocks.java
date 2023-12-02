package com.kekecreations.arts_and_crafts.core.registry;

import com.kekecreations.arts_and_crafts.common.block.ChalkDustBlock;
import com.kekecreations.arts_and_crafts.common.block.CustomFlowerPotBlock;
import com.kekecreations.arts_and_crafts.common.block.CustomStairBlock;
import com.kekecreations.arts_and_crafts.core.platform.RegistryHelper;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

import java.util.HashMap;
import java.util.function.Supplier;

public class KekeBlocks {

    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLES = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_TERRACOTTA_SHINGLE_STAIRS = new HashMap<>();

    public static final HashMap<DyeColor, Supplier<Block>> CHALK = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_SLAB = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_WALL = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_STAIRS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> CHALK_DUST = new HashMap<>();

    //public static final Supplier<ChalkDustBlock> WHITE_CHALK_DUST = RegistryHelper.registerBlock("white_chalk_dust", () -> new ChalkDustBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).sound(SoundType.CALCITE).noCollission().instabreak()));

    public static final HashMap<DyeColor, Supplier<Block>> DYED_FLOWER_POTS = new HashMap<>();
    public static final HashMap<DyeColor, Supplier<Block>> DYED_POTTED_OAK_SAPLING = new HashMap<>();

    //NORMAL TERRACOTTA SHINGLES
    public static final Supplier<Block> TERRACOTTA_SHINGLES = RegistryHelper.registerBlockWithItem("terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));
    public static final Supplier<SlabBlock> TERRACOTTA_SHINGLE_SLAB = RegistryHelper.registerBlockWithItem("terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));
    public static final Supplier<WallBlock> TERRACOTTA_SHINGLE_WALL = RegistryHelper.registerBlockWithItem("terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));
    public static final Supplier<CustomStairBlock> TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.registerBlockWithItem("terracotta_shingle_stairs", () -> new CustomStairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f)));


    static {
        for (DyeColor colours : DyeColor.values()) {
            //DYED TERRACOTTA SHINGLES
            DYED_TERRACOTTA_SHINGLES.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            DYED_TERRACOTTA_SHINGLE_SLAB.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            DYED_TERRACOTTA_SHINGLE_WALL.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            DYED_TERRACOTTA_SHINGLE_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_terracotta_shingle_stairs", () -> new CustomStairBlock(getDyedTerracottaShingles(colours).defaultBlockState(), BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(1.1f, 4.2f))));

            //CHALK
            CHALK.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_SLAB.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_WALL.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_STAIRS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_chalk_stairs", () -> new CustomStairBlock(getChalk(colours).defaultBlockState(), BlockBehaviour.Properties.of().mapColor(colours).instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.CALCITE).requiresCorrectToolForDrops().strength(0.9f))));

            CHALK_DUST.put(colours, RegistryHelper.registerBlock(colours + "_chalk_dust", () -> new ChalkDustBlock(colours, BlockBehaviour.Properties.of().mapColor(colours).sound(SoundType.CALCITE).noCollission().instabreak())));


            DYED_FLOWER_POTS.put(colours, RegistryHelper.registerBlockWithItem(colours + "_flower_pot", () -> new CustomFlowerPotBlock(colours, BlockBehaviour.Properties.of().mapColor(colours).instabreak().noOcclusion().pushReaction(PushReaction.DESTROY))));
        }
    }
    public static Block getDyedTerracottaShingles(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLES.get(colours).get();
    }
    public static Block getDyedTerracottaShingleSlab(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLE_SLAB.get(colours).get();
    }
    public static Block getDyedTerracottaShingleWall(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLE_WALL.get(colours).get();
    }
    public static Block getDyedTerracottaShingleStairs(DyeColor colours){
        return DYED_TERRACOTTA_SHINGLE_STAIRS.get(colours).get();
    }

    public static Block getChalk(DyeColor colours){
        return CHALK.get(colours).get();
    }
    public static Block getChalkSlab(DyeColor colours){
        return CHALK_SLAB.get(colours).get();
    }
    public static Block getChalkWall(DyeColor colours){
        return CHALK_WALL.get(colours).get();
    }
    public static Block getChalkStairs(DyeColor colours){
        return CHALK_STAIRS.get(colours).get();
    }
    public static Block getChalkDust(DyeColor colours){
        return CHALK_DUST.get(colours).get();
    }
    public static Block getDyedFlowerPot(DyeColor colours){
        return DYED_FLOWER_POTS.get(colours).get();
    }
    public static Block getDyedPottedOakSapling(DyeColor colours){
        return DYED_POTTED_OAK_SAPLING.get(colours).get();
    }




    /*


    //TERRACOTTA SHINGLES
    public static final RegistrySupplier<Block> TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("terracotta_shingles", () -> new BlockItem(TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.BUILDING_BLOCKS)));

    public static final RegistrySupplier<Block> BLACK_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("black_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("black_terracotta_shingles", () -> new BlockItem(BLACK_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> BLUE_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("blue_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("blue_terracotta_shingles", () -> new BlockItem(BLUE_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> BROWN_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("brown_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("brown_terracotta_shingles", () -> new BlockItem(BROWN_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> CYAN_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("cyan_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("cyan_terracotta_shingles", () -> new BlockItem(CYAN_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> GRAY_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("gray_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("gray_terracotta_shingles", () -> new BlockItem(GRAY_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> GREEN_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("green_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("green_terracotta_shingles", () -> new BlockItem(GREEN_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_BLUE_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("light_blue_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("light_blue_terracotta_shingles", () -> new BlockItem(LIGHT_BLUE_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_GRAY_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("light_gray_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("light_gray_terracotta_shingles", () -> new BlockItem(LIGHT_GRAY_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIME_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("lime_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("lime_terracotta_shingles", () -> new BlockItem(LIME_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> MAGENTA_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("magenta_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("magenta_terracotta_shingles", () -> new BlockItem(MAGENTA_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> ORANGE_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("orange_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("orange_terracotta_shingles", () -> new BlockItem(ORANGE_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PINK_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("pink_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("pink_terracotta_shingles", () -> new BlockItem(PINK_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PURPLE_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("purple_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("purple_terracotta_shingles", () -> new BlockItem(PURPLE_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> RED_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("red_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("red_terracotta_shingles", () -> new BlockItem(RED_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> WHITE_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("white_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("white_terracotta_shingles", () -> new BlockItem(WHITE_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> YELLOW_TERRACOTTA_SHINGLES = RegistryHelper.BLOCKS.register("yellow_terracotta_shingles", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_TERRACOTTA_SHINGLES_ITEM = RegistryHelper.ITEMS.register("yellow_terracotta_shingles", () -> new BlockItem(YELLOW_TERRACOTTA_SHINGLES.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    //TERRACOTTA SHINGLES SLABS
    public static final RegistrySupplier<SlabBlock> TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("terracotta_shingle_slab", () -> new BlockItem(TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.BUILDING_BLOCKS)));

    public static final RegistrySupplier<SlabBlock> BLACK_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("black_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("black_terracotta_shingle_slab", () -> new BlockItem(BLACK_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> BLUE_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("blue_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("blue_terracotta_shingle_slab", () -> new BlockItem(BLUE_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> BROWN_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("brown_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("brown_terracotta_shingle_slab", () -> new BlockItem(BROWN_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> CYAN_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("cyan_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("cyan_terracotta_shingle_slab", () -> new BlockItem(CYAN_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> GRAY_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("gray_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("gray_terracotta_shingle_slab", () -> new BlockItem(GRAY_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> GREEN_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("green_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("green_terracotta_shingle_slab", () -> new BlockItem(GREEN_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> LIGHT_BLUE_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("light_blue_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("light_blue_terracotta_shingle_slab", () -> new BlockItem(LIGHT_BLUE_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> LIGHT_GRAY_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("light_gray_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("light_gray_terracotta_shingle_slab", () -> new BlockItem(LIGHT_GRAY_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> LIME_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("lime_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("lime_terracotta_shingle_slab", () -> new BlockItem(LIME_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> MAGENTA_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("magenta_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("magenta_terracotta_shingle_slab", () -> new BlockItem(MAGENTA_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> ORANGE_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("orange_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("orange_terracotta_shingle_slab", () -> new BlockItem(ORANGE_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> PINK_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("pink_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("pink_terracotta_shingle_slab", () -> new BlockItem(PINK_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> PURPLE_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("purple_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("purple_terracotta_shingle_slab", () -> new BlockItem(PURPLE_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> RED_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("red_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("red_terracotta_shingle_slab", () -> new BlockItem(RED_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> WHITE_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("white_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("white_terracotta_shingle_slab", () -> new BlockItem(WHITE_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> YELLOW_TERRACOTTA_SHINGLE_SLAB = RegistryHelper.BLOCKS.register("yellow_terracotta_shingle_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_TERRACOTTA_SHINGLE_SLAB_ITEM = RegistryHelper.ITEMS.register("yellow_terracotta_shingle_slab", () -> new BlockItem(YELLOW_TERRACOTTA_SHINGLE_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    //TERRACOTTA SHINGLE WALL
    public static final RegistrySupplier<WallBlock> TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("terracotta_shingle_wall", () -> new BlockItem(TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.BUILDING_BLOCKS)));

    public static final RegistrySupplier<WallBlock> BLACK_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("black_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("black_terracotta_shingle_wall", () -> new BlockItem(BLACK_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> BLUE_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("blue_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("blue_terracotta_shingle_wall", () -> new BlockItem(BLUE_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> BROWN_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("brown_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("brown_terracotta_shingle_wall", () -> new BlockItem(BROWN_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> CYAN_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("cyan_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("cyan_terracotta_shingle_wall", () -> new BlockItem(CYAN_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> GRAY_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("gray_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("gray_terracotta_shingle_wall", () -> new BlockItem(GRAY_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> GREEN_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("green_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("green_terracotta_shingle_wall", () -> new BlockItem(GREEN_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> LIGHT_BLUE_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("light_blue_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("light_blue_terracotta_shingle_wall", () -> new BlockItem(LIGHT_BLUE_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> LIGHT_GRAY_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("light_gray_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("light_gray_terracotta_shingle_wall", () -> new BlockItem(LIGHT_GRAY_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> LIME_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("lime_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("lime_terracotta_shingle_wall", () -> new BlockItem(LIME_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> MAGENTA_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("magenta_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("magenta_terracotta_shingle_wall", () -> new BlockItem(MAGENTA_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> ORANGE_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("orange_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("orange_terracotta_shingle_wall", () -> new BlockItem(ORANGE_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> PINK_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("pink_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("pink_terracotta_shingle_wall", () -> new BlockItem(PINK_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> PURPLE_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("purple_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("purple_terracotta_shingle_wall", () -> new BlockItem(PURPLE_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> RED_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("red_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("red_terracotta_shingle_wall", () -> new BlockItem(RED_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> WHITE_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("white_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("white_terracotta_shingle_wall", () -> new BlockItem(WHITE_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> YELLOW_TERRACOTTA_SHINGLE_WALL = RegistryHelper.BLOCKS.register("yellow_terracotta_shingle_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_TERRACOTTA_SHINGLE_WALL_ITEM = RegistryHelper.ITEMS.register("yellow_terracotta_shingle_wall", () -> new BlockItem(YELLOW_TERRACOTTA_SHINGLE_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    //TERRACOTTA SHINGLE STAIRS
    public static final RegistrySupplier<StairBlock> TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("terracotta_shingle_stairs", () -> new StairBlock(TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("terracotta_shingle_stairs", () -> new BlockItem(TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.BUILDING_BLOCKS)));

    public static final RegistrySupplier<StairBlock> BLACK_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("black_terracotta_shingle_stairs", () -> new StairBlock(BLACK_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("black_terracotta_shingle_stairs", () -> new BlockItem(BLACK_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> BLUE_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("blue_terracotta_shingle_stairs", () -> new StairBlock(BLUE_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("blue_terracotta_shingle_stairs", () -> new BlockItem(BLUE_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> BROWN_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("brown_terracotta_shingle_stairs", () -> new StairBlock(BROWN_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("brown_terracotta_shingle_stairs", () -> new BlockItem(BROWN_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> CYAN_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("cyan_terracotta_shingle_stairs", () -> new StairBlock(CYAN_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("cyan_terracotta_shingle_stairs", () -> new BlockItem(CYAN_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> GRAY_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("gray_terracotta_shingle_stairs", () -> new StairBlock(GRAY_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("gray_terracotta_shingle_stairs", () -> new BlockItem(GRAY_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> GREEN_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("green_terracotta_shingle_stairs", () -> new StairBlock(GREEN_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("green_terracotta_shingle_stairs", () -> new BlockItem(GREEN_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> LIGHT_BLUE_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("light_blue_terracotta_shingle_stairs", () -> new StairBlock(LIGHT_BLUE_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("light_blue_terracotta_shingle_stairs", () -> new BlockItem(LIGHT_BLUE_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> LIGHT_GRAY_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("light_gray_terracotta_shingle_stairs", () -> new StairBlock(LIGHT_GRAY_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("light_gray_terracotta_shingle_stairs", () -> new BlockItem(LIGHT_GRAY_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> LIME_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("lime_terracotta_shingle_stairs", () -> new StairBlock(LIME_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("lime_terracotta_shingle_stairs", () -> new BlockItem(LIME_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> MAGENTA_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("magenta_terracotta_shingle_stairs", () -> new StairBlock(MAGENTA_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("magenta_terracotta_shingle_stairs", () -> new BlockItem(MAGENTA_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> ORANGE_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("orange_terracotta_shingle_stairs", () -> new StairBlock(ORANGE_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("orange_terracotta_shingle_stairs", () -> new BlockItem(ORANGE_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> PINK_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("pink_terracotta_shingle_stairs", () -> new StairBlock(PINK_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("pink_terracotta_shingle_stairs", () -> new BlockItem(PINK_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> PURPLE_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("purple_terracotta_shingle_stairs", () -> new StairBlock(PURPLE_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("purple_terracotta_shingle_stairs", () -> new BlockItem(PURPLE_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> RED_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("red_terracotta_shingle_stairs", () -> new StairBlock(RED_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("red_terracotta_shingle_stairs", () -> new BlockItem(RED_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> WHITE_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("white_terracotta_shingle_stairs", () -> new StairBlock(WHITE_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("white_terracotta_shingle_stairs", () -> new BlockItem(WHITE_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> YELLOW_TERRACOTTA_SHINGLE_STAIRS = RegistryHelper.BLOCKS.register("yellow_terracotta_shingle_stairs", () -> new StairBlock(YELLOW_TERRACOTTA_SHINGLES.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_TERRACOTTA_SHINGLE_STAIRS_ITEM = RegistryHelper.ITEMS.register("yellow_terracotta_shingle_stairs", () -> new BlockItem(YELLOW_TERRACOTTA_SHINGLE_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

















    //CHALK BLOCKS - BLOCKS ARE IN ORDER WITH TEXTURE FILE NAMES
    public static final RegistrySupplier<Block> BLACK_CHALK = RegistryHelper.BLOCKS.register("black_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_CHALK_ITEM = RegistryHelper.ITEMS.register("black_chalk", () -> new BlockItem(BLACK_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> BLUE_CHALK = RegistryHelper.BLOCKS.register("blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("blue_chalk", () -> new BlockItem(BLUE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> BROWN_CHALK = RegistryHelper.BLOCKS.register("brown_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_CHALK_ITEM = RegistryHelper.ITEMS.register("brown_chalk", () -> new BlockItem(BROWN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> CYAN_CHALK = RegistryHelper.BLOCKS.register("cyan_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_CHALK_ITEM = RegistryHelper.ITEMS.register("cyan_chalk", () -> new BlockItem(CYAN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> GRAY_CHALK = RegistryHelper.BLOCKS.register("gray_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_CHALK_ITEM = RegistryHelper.ITEMS.register("gray_chalk", () -> new BlockItem(GRAY_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> GREEN_CHALK = RegistryHelper.BLOCKS.register("green_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_CHALK_ITEM = RegistryHelper.ITEMS.register("green_chalk", () -> new BlockItem(GREEN_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_BLUE_CHALK = RegistryHelper.BLOCKS.register("light_blue_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk", () -> new BlockItem(LIGHT_BLUE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIGHT_GRAY_CHALK = RegistryHelper.BLOCKS.register("light_gray_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_CHALK_ITEM = RegistryHelper.ITEMS.register("light_gray_chalk", () -> new BlockItem(LIGHT_GRAY_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> LIME_CHALK = RegistryHelper.BLOCKS.register("lime_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_CHALK_ITEM = RegistryHelper.ITEMS.register("lime_chalk", () -> new BlockItem(LIME_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> MAGENTA_CHALK = RegistryHelper.BLOCKS.register("magenta_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_CHALK_ITEM = RegistryHelper.ITEMS.register("magenta_chalk", () -> new BlockItem(MAGENTA_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> ORANGE_CHALK = RegistryHelper.BLOCKS.register("orange_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_CHALK_ITEM = RegistryHelper.ITEMS.register("orange_chalk", () -> new BlockItem(ORANGE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PINK_CHALK = RegistryHelper.BLOCKS.register("pink_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_CHALK_ITEM = RegistryHelper.ITEMS.register("pink_chalk", () -> new BlockItem(PINK_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> PURPLE_CHALK = RegistryHelper.BLOCKS.register("purple_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_CHALK_ITEM = RegistryHelper.ITEMS.register("purple_chalk", () -> new BlockItem(PURPLE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> RED_CHALK = RegistryHelper.BLOCKS.register("red_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_CHALK_ITEM = RegistryHelper.ITEMS.register("red_chalk", () -> new BlockItem(RED_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> WHITE_CHALK = RegistryHelper.BLOCKS.register("white_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_ITEM = RegistryHelper.ITEMS.register("white_chalk", () -> new BlockItem(WHITE_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<Block> YELLOW_CHALK = RegistryHelper.BLOCKS.register("yellow_chalk", () -> new Block(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_CHALK_ITEM = RegistryHelper.ITEMS.register("yellow_chalk", () -> new BlockItem(YELLOW_CHALK.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    //CHALK SLABS
    public static final RegistrySupplier<SlabBlock> BLACK_CHALK_SLAB = RegistryHelper.BLOCKS.register("black_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("black_chalk_slab", () -> new BlockItem(BLACK_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> BLUE_CHALK_SLAB = RegistryHelper.BLOCKS.register("blue_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("blue_chalk_slab", () -> new BlockItem(BLUE_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> BROWN_CHALK_SLAB = RegistryHelper.BLOCKS.register("brown_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("brown_chalk_slab", () -> new BlockItem(BROWN_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> CYAN_CHALK_SLAB = RegistryHelper.BLOCKS.register("cyan_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("cyan_chalk_slab", () -> new BlockItem(CYAN_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> GRAY_CHALK_SLAB = RegistryHelper.BLOCKS.register("gray_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("gray_chalk_slab", () -> new BlockItem(GRAY_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> GREEN_CHALK_SLAB = RegistryHelper.BLOCKS.register("green_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("green_chalk_slab", () -> new BlockItem(GREEN_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> LIGHT_BLUE_CHALK_SLAB = RegistryHelper.BLOCKS.register("light_blue_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk_slab", () -> new BlockItem(LIGHT_BLUE_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> LIGHT_GRAY_CHALK_SLAB = RegistryHelper.BLOCKS.register("light_gray_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("light_gray_chalk_slab", () -> new BlockItem(LIGHT_GRAY_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> LIME_CHALK_SLAB = RegistryHelper.BLOCKS.register("lime_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("lime_chalk_slab", () -> new BlockItem(LIME_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> MAGENTA_CHALK_SLAB = RegistryHelper.BLOCKS.register("magenta_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("magenta_chalk_slab", () -> new BlockItem(MAGENTA_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> ORANGE_CHALK_SLAB = RegistryHelper.BLOCKS.register("orange_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("orange_chalk_slab", () -> new BlockItem(ORANGE_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> PINK_CHALK_SLAB = RegistryHelper.BLOCKS.register("pink_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("pink_chalk_slab", () -> new BlockItem(PINK_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> PURPLE_CHALK_SLAB = RegistryHelper.BLOCKS.register("purple_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("purple_chalk_slab", () -> new BlockItem(PURPLE_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> RED_CHALK_SLAB = RegistryHelper.BLOCKS.register("red_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("red_chalk_slab", () -> new BlockItem(RED_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> WHITE_CHALK_SLAB = RegistryHelper.BLOCKS.register("white_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("white_chalk_slab", () -> new BlockItem(WHITE_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<SlabBlock> YELLOW_CHALK_SLAB = RegistryHelper.BLOCKS.register("yellow_chalk_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_CHALK_SLAB_ITEM = RegistryHelper.ITEMS.register("yellow_chalk_slab", () -> new BlockItem(YELLOW_CHALK_SLAB.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    //CHALK WALL
    public static final RegistrySupplier<WallBlock> BLACK_CHALK_WALL = RegistryHelper.BLOCKS.register("black_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("black_chalk_wall", () -> new BlockItem(BLACK_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> BLUE_CHALK_WALL = RegistryHelper.BLOCKS.register("blue_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("blue_chalk_wall", () -> new BlockItem(BLUE_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> BROWN_CHALK_WALL = RegistryHelper.BLOCKS.register("brown_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("brown_chalk_wall", () -> new BlockItem(BROWN_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> CYAN_CHALK_WALL = RegistryHelper.BLOCKS.register("cyan_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("cyan_chalk_wall", () -> new BlockItem(CYAN_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> GRAY_CHALK_WALL = RegistryHelper.BLOCKS.register("gray_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("gray_chalk_wall", () -> new BlockItem(GRAY_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> GREEN_CHALK_WALL = RegistryHelper.BLOCKS.register("green_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("green_chalk_wall", () -> new BlockItem(GREEN_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> LIGHT_BLUE_CHALK_WALL = RegistryHelper.BLOCKS.register("light_blue_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk_wall", () -> new BlockItem(LIGHT_BLUE_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> LIGHT_GRAY_CHALK_WALL = RegistryHelper.BLOCKS.register("light_gray_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("light_gray_chalk_wall", () -> new BlockItem(LIGHT_GRAY_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> LIME_CHALK_WALL = RegistryHelper.BLOCKS.register("lime_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("lime_chalk_wall", () -> new BlockItem(LIME_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> MAGENTA_CHALK_WALL = RegistryHelper.BLOCKS.register("magenta_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("magenta_chalk_wall", () -> new BlockItem(MAGENTA_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> ORANGE_CHALK_WALL = RegistryHelper.BLOCKS.register("orange_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("orange_chalk_wall", () -> new BlockItem(ORANGE_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> PINK_CHALK_WALL = RegistryHelper.BLOCKS.register("pink_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("pink_chalk_wall", () -> new BlockItem(PINK_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> PURPLE_CHALK_WALL = RegistryHelper.BLOCKS.register("purple_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("purple_chalk_wall", () -> new BlockItem(PURPLE_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> RED_CHALK_WALL = RegistryHelper.BLOCKS.register("red_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("red_chalk_wall", () -> new BlockItem(RED_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> WHITE_CHALK_WALL = RegistryHelper.BLOCKS.register("white_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("white_chalk_wall", () -> new BlockItem(WHITE_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<WallBlock> YELLOW_CHALK_WALL = RegistryHelper.BLOCKS.register("yellow_chalk_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_CHALK_WALL_ITEM = RegistryHelper.ITEMS.register("yellow_chalk_wall", () -> new BlockItem(YELLOW_CHALK_WALL.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));

    //CHALK STAIRS
    public static final RegistrySupplier<StairBlock> BLACK_CHALK_STAIRS = RegistryHelper.BLOCKS.register("black_chalk_stairs", () -> new StairBlock(BLACK_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLACK_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("black_chalk_stairs", () -> new BlockItem(BLACK_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> BLUE_CHALK_STAIRS = RegistryHelper.BLOCKS.register("blue_chalk_stairs", () -> new StairBlock(BLUE_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BLUE_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("blue_chalk_stairs", () -> new BlockItem(BLUE_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> BROWN_CHALK_STAIRS = RegistryHelper.BLOCKS.register("brown_chalk_stairs", () -> new StairBlock(BROWN_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> BROWN_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("brown_chalk_stairs", () -> new BlockItem(BROWN_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> CYAN_CHALK_STAIRS = RegistryHelper.BLOCKS.register("cyan_chalk_stairs", () -> new StairBlock(CYAN_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> CYAN_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("cyan_chalk_stairs", () -> new BlockItem(CYAN_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> GRAY_CHALK_STAIRS = RegistryHelper.BLOCKS.register("gray_chalk_stairs", () -> new StairBlock(GRAY_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GRAY_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("gray_chalk_stairs", () -> new BlockItem(GRAY_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> GREEN_CHALK_STAIRS = RegistryHelper.BLOCKS.register("green_chalk_stairs", () -> new StairBlock(GREEN_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> GREEN_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("green_chalk_stairs", () -> new BlockItem(GREEN_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> LIGHT_BLUE_CHALK_STAIRS = RegistryHelper.BLOCKS.register("light_blue_chalk_stairs", () -> new StairBlock(LIGHT_BLUE_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_BLUE_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("light_blue_chalk_stairs", () -> new BlockItem(LIGHT_BLUE_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> LIGHT_GRAY_CHALK_STAIRS = RegistryHelper.BLOCKS.register("light_gray_chalk_stairs", () -> new StairBlock(LIGHT_GRAY_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIGHT_GRAY_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("light_gray_chalk_stairs", () -> new BlockItem(LIGHT_GRAY_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> LIME_CHALK_STAIRS = RegistryHelper.BLOCKS.register("lime_chalk_stairs", () -> new StairBlock(LIME_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.LIME).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> LIME_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("lime_chalk_stairs", () -> new BlockItem(LIME_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> MAGENTA_CHALK_STAIRS = RegistryHelper.BLOCKS.register("magenta_chalk_stairs", () -> new StairBlock(MAGENTA_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> MAGENTA_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("magenta_chalk_stairs", () -> new BlockItem(MAGENTA_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> ORANGE_CHALK_STAIRS = RegistryHelper.BLOCKS.register("orange_chalk_stairs", () -> new StairBlock(ORANGE_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> ORANGE_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("orange_chalk_stairs", () -> new BlockItem(ORANGE_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> PINK_CHALK_STAIRS = RegistryHelper.BLOCKS.register("pink_chalk_stairs", () -> new StairBlock(PINK_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.PINK).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PINK_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("pink_chalk_stairs", () -> new BlockItem(PINK_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> PURPLE_CHALK_STAIRS = RegistryHelper.BLOCKS.register("purple_chalk_stairs", () -> new StairBlock(PURPLE_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> PURPLE_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("purple_chalk_stairs", () -> new BlockItem(PURPLE_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> RED_CHALK_STAIRS = RegistryHelper.BLOCKS.register("red_chalk_stairs", () -> new StairBlock(RED_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.RED).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> RED_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("red_chalk_stairs", () -> new BlockItem(RED_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> WHITE_CHALK_STAIRS = RegistryHelper.BLOCKS.register("white_chalk_stairs", () -> new StairBlock(WHITE_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> WHITE_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("white_chalk_stairs", () -> new BlockItem(WHITE_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));
    public static final RegistrySupplier<StairBlock> YELLOW_CHALK_STAIRS = RegistryHelper.BLOCKS.register("yellow_chalk_stairs", () -> new StairBlock(YELLOW_CHALK.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(0.8f)));
    public static final RegistrySupplier<BlockItem> YELLOW_CHALK_STAIRS_ITEM = RegistryHelper.ITEMS.register("yellow_chalk_stairs", () -> new BlockItem(YELLOW_CHALK_STAIRS.get(), new Item.Properties().arch$tab(CreativeModeTabs.COLORED_BLOCKS)));



     */
    public static void register() {
    }

}
