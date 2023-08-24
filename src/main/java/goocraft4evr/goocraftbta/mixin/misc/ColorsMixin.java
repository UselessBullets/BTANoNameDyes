package goocraft4evr.goocraftbta.mixin.misc;

import goocraft4evr.goocraftbta.item.ItemModDye;
import goocraft4evr.goocraftbta.mixin.entity.EntitySheepAccessor;
import net.minecraft.client.render.texturepack.TexturePackBase;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value= Colors.class,remap=false)
public abstract class ColorsMixin {
    @Final
    private static final Color[] allChatColors = new Color[16+ItemModDye.NUM_DYES];
    @Final
    private static final Color[] allPlankColors = new Color[16+ItemModDye.NUM_DYES];
    @Final
    private static final Color[] allLampColors = new Color[16+ItemModDye.NUM_DYES];
    @Final
    private static final Color[] allFlagColors = new Color[16+ItemModDye.NUM_DYES];
    @Final
    private static final Color[] allSignColors = new Color[16+ItemModDye.NUM_DYES];
    @Redirect(method="loadColors",at=@At(value="INVOKE",target="Lnet/minecraft/core/util/helper/Colors;fillColorArray(Lnet/minecraft/client/render/texturepack/TexturePackBase;Ljava/lang/String;[Lnet/minecraft/core/util/helper/Color;)V"))
    private static void loadColorsOrSomeShit(TexturePackBase stream, String imagePath, Color[] array) {
        //only redirect methods that would throw an exception
        if (array.length != 16+ItemModDye.NUM_DYES) {
            Colors.fillColorArray(stream, imagePath, array);
            return;
        }
        //fill each array individually to get around exception
        Color[] vanillaColors = new Color[16];
        Colors.fillColorArray(stream,imagePath,vanillaColors);
        Color[] modColors = new Color[ItemModDye.NUM_DYES];
        String modPath = "assets/goocraft/misc"+imagePath.substring(imagePath.lastIndexOf('/'));
        Colors.fillColorArray(stream,modPath,modColors);
        //copy both arrays into array to return
        System.arraycopy(vanillaColors, 0, array, 0, vanillaColors.length);
        System.arraycopy(modColors, 0, array, vanillaColors.length, modColors.length);
    }

    @Inject(method="loadColors",at=@At("TAIL"))
    private static void initializeFleeceArray(TexturePackBase texturePack, CallbackInfo ci) {
        //initialize the fleece array
        float[][] vanillaRGB = EntitySheep.fleeceColorTable;
        Color[] fleeceColors = new Color[ItemModDye.NUM_DYES];
        Colors.fillColorArray(texturePack, "assets/goocraft/misc/colors_fleece.png", fleeceColors);
        float[][] modRGB = new float[vanillaRGB.length+fleeceColors.length][];
        System.arraycopy(vanillaRGB, 0, modRGB, 0, vanillaRGB.length);
        for (int i=0;i<fleeceColors.length;i++) {
            Color c = fleeceColors[i];
            modRGB[vanillaRGB.length+i] = new float[]{c.getRed()/255f,c.getGreen()/255f,c.getBlue()/255f};
        }
        EntitySheepAccessor.setFleeceColorTable(modRGB);
    }
}
