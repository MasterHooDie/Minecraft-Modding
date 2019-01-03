package hoodie.mymod.jei;

import hoodie.mymod.ModBlocks;
import hoodie.mymod.customrecipes.CustomRecipe;
import hoodie.mymod.customrecipes.CustomRecipeRegistry;
import hoodie.mymod.floader.ContainerFloader;
import hoodie.mymod.floader.TileFloader;
import hoodie.mymod.furnace.ContainerFastFurnace;
import hoodie.mymod.furnace.TileFastFurnace;
import mezz.jei.api.*;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Collections;

@JEIPlugin
public class JeiPlugin implements IModPlugin {

    public static final String FASTFURNACE_ID = "MyMod.FastFurnace";
    public static final String FLOADER_ID = "MyMod.Floader";

    @Override
    public void register(@Nonnull IModRegistry registry) {
        registerFastFurnaceHandling(registry);
        registerFloaderHandling(registry);
    }

    private void registerFloaderHandling(@Nonnull IModRegistry registry) {
        IRecipeTransferRegistry transferRegistry = registry.getRecipeTransferRegistry();
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.blockFloader), FLOADER_ID);
        registry.addRecipes(Collections.singletonList(new FloadRecipe()), FLOADER_ID);
        registry.handleRecipes(FloadRecipe.class, recipe -> new FloadRecipeWrapper(), FLOADER_ID);

        transferRegistry.addRecipeTransferHandler(ContainerFloader.class, FLOADER_ID,
                0, TileFloader.INPUT_SLOTS, TileFloader.INPUT_SLOTS, 36);
    }

    private void registerFastFurnaceHandling(@Nonnull IModRegistry registry) {
        registry.addRecipeCatalyst(new ItemStack(ModBlocks.blockFastFurnace), FASTFURNACE_ID, VanillaRecipeCategoryUid.SMELTING);

        registry.addRecipes(CustomRecipeRegistry.getCustomRecipeList(), FASTFURNACE_ID);
        registry.handleRecipes(CustomRecipe.class, CustomRecipeWrapper::new, FASTFURNACE_ID);

        IRecipeTransferRegistry transferRegistry = registry.getRecipeTransferRegistry();
        transferRegistry.addRecipeTransferHandler(ContainerFastFurnace.class, VanillaRecipeCategoryUid.SMELTING,
                0, TileFastFurnace.INPUT_SLOTS, TileFastFurnace.INPUT_SLOTS + TileFastFurnace.OUTPUT_SLOTS, 36);
        transferRegistry.addRecipeTransferHandler(ContainerFastFurnace.class, FASTFURNACE_ID,
                0, TileFastFurnace.INPUT_SLOTS, TileFastFurnace.INPUT_SLOTS + TileFastFurnace.OUTPUT_SLOTS, 36);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        IJeiHelpers helpers = registry.getJeiHelpers();
        IGuiHelper guiHelper = helpers.getGuiHelper();

        registry.addRecipeCategories(new FloadRecipeCategory(guiHelper));
        registry.addRecipeCategories(new CustomRecipeCategory(guiHelper));
    }

}
