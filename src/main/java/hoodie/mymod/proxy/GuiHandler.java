package hoodie.mymod.proxy;

import hoodie.mymod.furnace.ContainerFastFurnace;
import hoodie.mymod.furnace.GuiFastFurnace;
import hoodie.mymod.furnace.TileFastFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import javax.annotation.Nullable;

public class GuiHandler implements IGuiHandler {

    @Nullable
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileFastFurnace) {
            return new ContainerFastFurnace(player.inventory, (TileFastFurnace) te);
        }
        return null;
    }

    @Nullable
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileFastFurnace) {
            TileFastFurnace containerTileEntity = (TileFastFurnace) te;
            return new GuiFastFurnace(containerTileEntity, new ContainerFastFurnace(player.inventory, containerTileEntity));
        }
        return null;
    }
}
