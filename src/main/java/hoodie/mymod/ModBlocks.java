package hoodie.mymod;

import hoodie.mymod.furnace.BlockFastFurnace;
import hoodie.mymod.furnace.TileFastFurnace;
import hoodie.mymod.generator.BlockGenerator;
import hoodie.mymod.generator.TileGenerator;
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


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockFastFurnace.initModel();
        blockGenerator.initModel();
        blockFancyOre.initModel();
    }

    public static void register(IForgeRegistry<Block> registry) {
        registry.register(new BlockFastFurnace());
        GameRegistry.registerTileEntity(TileFastFurnace.class, MyMod.MODID + "_fast_furnace");

        registry.register(new BlockGenerator());
        GameRegistry.registerTileEntity(TileGenerator.class, MyMod.MODID + "_generator");

        registry.register(new BlockFancyOre());
    }

}

