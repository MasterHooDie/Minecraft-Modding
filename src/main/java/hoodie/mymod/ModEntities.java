package hoodie.mymod;

import hoodie.mymod.guard.EntityGuard;
import hoodie.mymod.guard.RenderGuard;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModEntities {

    public static void init() {
        int id = 1;

        EntityRegistry.registerModEntity(new ResourceLocation(MyMod.MODID, "mymod_guard"), EntityGuard.class, "mymod_guard", id++,
                MyMod.instance, 64, 3, true, 0x222222, 0x555555);
    }

    @SideOnly(Side.CLIENT)
    public static void initModels() {
        RenderingRegistry.registerEntityRenderingHandler(EntityGuard.class, RenderGuard.FACTORY);
    }
}