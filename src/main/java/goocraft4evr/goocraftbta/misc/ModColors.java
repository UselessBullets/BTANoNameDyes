package goocraft4evr.goocraftbta.misc;

import goocraft4evr.goocraftbta.mixin.EntitySheepAccessor;
import net.minecraft.client.render.texturepack.TexturePackBase;
import net.minecraft.core.entity.animal.EntitySheep;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public abstract class ModColors {
    private static final int NUM_COLORS = 2;
    public static final Color[] modPlankColors = new Color[NUM_COLORS];
    public static final Color[] modLampColors = new Color[NUM_COLORS];
    public static final Color[] modFlagColors = new Color[NUM_COLORS];
    public static void loadColors(TexturePackBase texturePack) {
        fillColorArray(texturePack, "assets/goocraft/misc/colors_planks.png", modPlankColors);
        fillColorArray(texturePack, "assets/goocraft/misc/colors_lamps.png", modLampColors);
        fillColorArray(texturePack, "assets/goocraft/misc/colors_lamps.png", modFlagColors);
        initializeFleeceArray();
    }

    public static void fillColorArray(TexturePackBase texturePack, String path, Color[] colors) {
        try {
            InputStream stream = texturePack != null ? texturePack.getResourceAsStream(path) : Colors.class.getResourceAsStream(path);
            BufferedImage image = ImageIO.read(stream);
            stream.close();
            fillColorArray(colors, image);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load colors from image: " + path);
        }
    }

    public static Color[] fillColorArray(Color[] colors, BufferedImage image) {
        for (int i = 0; i < colors.length; ++i) {
            colors[i] = new Color().setARGB(image.getRGB(i, 0));
        }
        return colors;
    }

    public static float[] getRGBAsFloatArr(Color c) {
        return new float[]{c.getRed()/255f,c.getGreen()/255f,c.getBlue()/255f};
    }

    private static void initializeFleeceArray() {
        float[][] vanillaRGB = EntitySheep.fleeceColorTable;
        Color[] fleeceColors = modPlankColors;
        float[][] modRGB = new float[vanillaRGB.length+fleeceColors.length][];
        System.arraycopy(vanillaRGB, 0, modRGB, 0, vanillaRGB.length);
        for (int i=0;i<fleeceColors.length;i++) {
            modRGB[vanillaRGB.length+i] = getRGBAsFloatArr(fleeceColors[i]);
        }
        EntitySheepAccessor.setFleeceColorTable(modRGB);
    }
}
