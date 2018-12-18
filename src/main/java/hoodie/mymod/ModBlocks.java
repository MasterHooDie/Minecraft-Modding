package hoodie.mymod;

import hoodie.mymod.furnace.BlockFastFurnace;
import hoodie.mymod.worldgen.BlockFancyOre;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModBlocks {

    @GameRegistry.ObjectHolder("mymod:fast_furnace")
    public static BlockFastFurnace blockFastFurnace;

    @GameRegistry.ObjectHolder("mymod:fancy_ore")
    public static BlockFancyOre blockFancyOre;

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        blockFastFurnace.initModel();
        blockFancyOre.initModel();
    }
}
