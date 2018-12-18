package hoodie.mymod.proxy;

import com.google.common.util.concurrent.ListenableFuture;
import hoodie.mymod.ModBlocks;
import hoodie.mymod.MyMod;
import hoodie.mymod.furnace.BlockFastFurnace;
import hoodie.mymod.furnace.TileFastFurnace;
import hoodie.mymod.network.Messages;
import hoodie.mymod.worldgen.BlockFancyOre;
import hoodie.mymod.worldgen.OreGenerator;
import hoodie.mymod.worldgen.WorldTickHandler;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
        Messages.registerMessages("mymod");
        GameRegistry.registerWorldGenerator(OreGenerator.instance, 5);
        MinecraftForge.EVENT_BUS.register(OreGenerator.instance);
    }

    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(MyMod.instance, new GuiHandler());
        MinecraftForge.EVENT_BUS.register(WorldTickHandler.instance);
    }

    public void postInit(FMLPostInitializationEvent e) {
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        event.getRegistry().register(new BlockFastFurnace());
        GameRegistry.registerTileEntity(TileFastFurnace.class, MyMod.MODID + "_fast_furnace");
        event.getRegistry().register(new BlockFancyOre());
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new ItemBlock(ModBlocks.blockFastFurnace).setRegistryName(ModBlocks.blockFastFurnace.getRegistryName()));
        event.getRegistry().register(new ItemBlock(ModBlocks.blockFancyOre) {
                    @Override
                    public int getMetadata(int damage) {
                        return damage;
                    }
                }
                        .setHasSubtypes(true)
                        .setRegistryName(BlockFancyOre.FANCY_ORE));
    }

    public ListenableFuture<Object> addScheduledTaskClient(Runnable runnableToSchedule) {
        throw new IllegalStateException("This should only be called from client side");
    }

    public EntityPlayer getClientPlayer() {
        throw new IllegalStateException("This should only be called from client side");
    }
}