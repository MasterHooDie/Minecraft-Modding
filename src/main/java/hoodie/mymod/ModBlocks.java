package hoodie.mymod;

import hoodie.mymod.fload.BlockFload;
import hoodie.mymod.floader.BlockFloader;
import hoodie.mymod.floader.TileFloader;
import hoodie.mymod.furnace.BlockFastFurnace;
import hoodie.mymod.furnace.TileFastFurnace;
import hoodie.mymod.generator.BlockGenerator;
import hoodie.mymod.generator.TileGenerator;
import hoodie.mymod.puzzle.BlockPuzzle;
import hoodie.mymod.puzzle.TilePuzzle;
import hoodie.mymod.tank.BlockTank;
import hoodie.mymod.tank.TileTank;
import hoodie.mymod.worldgen.BlockFancyOre;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

    @GameRegistry.ObjectHolder("mymod:fast_furnace")
    public static BlockFastFurnace blockFastFurnace;

    @GameRegistry.ObjectHolder("mymod:generator")
    public static BlockGenerator blockGenerator;

    @GameRegistry.ObjectHolder("mymod:fancy_ore")
    public static BlockFancyOre blockFancyOre;

    @GameRegistry.ObjectHolder("mymod:puzzle")
    public static BlockPuzzle blockPuzzle;

    @GameRegistry.ObjectHolder("mymod:fload")
    public static BlockFload blockFload;

    @GameRegistry.ObjectHolder("mymod:tank")
    public static BlockTank blockTank;

    @GameRegistry.ObjectHolder("mymod:floader")
    public static BlockFloader blockFloader;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockFastFurnace.initModel();
        blockGenerator.initModel();
        blockFancyOre.initModel();
        blockPuzzle.initModel();
        blockFload.initModel();
        blockTank.initModel();
        blockFloader.initModel();
    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(new BlockFastFurnace());
        GameRegistry.registerTileEntity(TileFastFurnace.class, MyMod.MODID + "_fast_furnace");

        registry.register(new BlockGenerator());
        GameRegistry.registerTileEntity(TileGenerator.class, MyMod.MODID + "_generator");

        registry.register(new BlockPuzzle());
        GameRegistry.registerTileEntity(TilePuzzle.class, MyMod.MODID + "_puzzle");

        registry.register(new BlockTank());
        GameRegistry.registerTileEntity(TileTank.class, MyMod.MODID + "_tank");

        registry.register(new BlockFloader());
        GameRegistry.registerTileEntity(TileFloader.class, MyMod.MODID + "_floader");

        registry.register(new BlockFancyOre());
        registry.register(new BlockFload());
    }

}

