package hoodie.mymod;

import hoodie.mymod.furnace.BlockFastFurnace;
import hoodie.mymod.generator.BlockGenerator;
import hoodie.mymod.items.ItemFancyIngot;
import hoodie.mymod.worldgen.BlockFancyOre;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

    @GameRegistry.ObjectHolder("mymod:fancy_ingot")
    public static ItemFancyIngot itemFancyIngot;


    @SideOnly(Side.CLIENT)
    public static void initModels() {
        itemFancyIngot.initModel();
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.register(new ItemBlock(ModBlocks.blockFastFurnace).setRegistryName(BlockFastFurnace.FAST_FURNACE));
        registry.register(new ItemBlock(ModBlocks.blockGenerator).setRegistryName(BlockGenerator.GENERATOR));
        registry.register(
                new ItemBlock(ModBlocks.blockFancyOre) {
                    @Override
                    public int getMetadata(int damage) {
                        return damage;
                    }
                }
                        .setHasSubtypes(true)
                        .setRegistryName(BlockFancyOre.FANCY_ORE));
        registry.register(new ItemFancyIngot());
    }

}
