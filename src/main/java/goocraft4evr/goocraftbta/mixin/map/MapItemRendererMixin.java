package goocraft4evr.goocraftbta.mixin.map;

import goocraft4evr.goocraftbta.GoocraftBTA;
import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.render.FontRenderer;
import net.minecraft.client.render.MapItemRenderer;
import net.minecraft.client.render.RenderEngine;
import net.minecraft.client.render.Tessellator;
import net.minecraft.core.block.material.MaterialColor;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import net.minecraft.core.world.saveddata.maps.ItemMapSavedData;
import net.minecraft.core.world.saveddata.maps.MapWaypoint;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(value= MapItemRenderer.class, remap=false)
public abstract class MapItemRendererMixin {
    @Shadow
    private int[] mapImageData;
    @Shadow
    private int mapTexture;

    //TODO: Replace this shitty overwrite
    @Overwrite
    public void renderMap(RenderEngine renderengine, ItemMapSavedData mapdata) {
        float f4;
        float f3;
        float f2;
        float f1;
        for (int i = 0; i < 16384; ++i) {
            byte colorIndex = mapdata.colors[i];
            if (colorIndex / 4 == 0) {
                mapImageData[i] = (i + i / 128 & 1) * 8 + 16 << 24;
                continue;
            }
            int col = MaterialColor.materialColors[colorIndex / 4].col;
            int i1 = colorIndex & 3;
            int shade = 220;
            if (i1 == 2) {
                shade = 255;
            }
            if (i1 == 0) {
                shade = 180;
            }
            int red = (col >> 16 & 0xFF) * shade / 255;
            int green = (col >> 8 & 0xFF) * shade / 255;
            int blue = (col & 0xFF) * shade / 255;
            mapImageData[i] = 0xFF000000 | red << 16 | green << 8 | blue;
        }
        renderengine.updateTextureData(mapImageData, 128, 128, mapTexture);
        int j = 0;
        int k = 0;
        Tessellator tessellator = Tessellator.instance;
        float f = 0.0f;
        GL11.glBindTexture(3553, mapTexture);
        GL11.glEnable(3042);
        GL11.glDisable(3008);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV((float)(j + 0) + f, (float)(k + 128) - f, -0.01f, 0.0, 1.0);
        tessellator.addVertexWithUV((float)(j + 128) - f, (float)(k + 128) - f, -0.01f, 1.0, 1.0);
        tessellator.addVertexWithUV((float)(j + 128) - f, (float)(k + 0) + f, -0.01f, 1.0, 0.0);
        tessellator.addVertexWithUV((float)(j + 0) + f, (float)(k + 0) + f, -0.01f, 0.0, 0.0);
        tessellator.draw();
        GL11.glEnable(3008);
        GL11.glDisable(3042);
        renderengine.bindTexture(renderengine.getTexture("/misc/mapicons.png"));
        for (MapWaypoint mapWaypoint : mapdata.mapWaypoints) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)j + (float)mapWaypoint.mapCoordX / 2.0f + 64.0f, (float)k + (float)mapWaypoint.mapCoordZ / 2.0f + 64.0f, -0.02f);
            GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            double zIndex = 0.0;
            f1 = 0.25f;
            f2 = 0.25f;
            f3 = 0.5f;
            f4 = 0.5f;
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-1.0, 1.0, zIndex, f1, f2);
            tessellator.addVertexWithUV(1.0, 1.0, zIndex, f3, f2);
            tessellator.addVertexWithUV(1.0, -1.0, zIndex, f3, f4);
            tessellator.addVertexWithUV(-1.0, -1.0, zIndex, f1, f4);
            tessellator.draw();
            GL11.glPopMatrix();
        }
        renderengine.bindTexture(renderengine.getTexture("/misc/mapicons.png"));
        for (ItemMapSavedData.MapDecoration mapcoord : mapdata.decorations) {
            GL11.glPushMatrix();
            GL11.glTranslatef((float)j + (float)mapcoord.x / 2.0f + 64.0f, (float)k + (float)mapcoord.y / 2.0f + 64.0f, -0.02f);
            GL11.glRotatef((float)(mapcoord.rot * 360) / 16.0f, 0.0f, 0.0f, 1.0f);
            GL11.glScalef(4.0f, 4.0f, 3.0f);
            GL11.glTranslatef(-0.125f, 0.125f, 0.0f);
            double zIndex = -1.0;
            f1 = (float)(mapcoord.type % 4) / 4.0f;
            f2 = (float)(mapcoord.type / 4) / 4.0f;
            f3 = (float)(mapcoord.type % 4 + 1) / 4.0f;
            f4 = (float)(mapcoord.type / 4 + 1) / 4.0f;
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-1.0, 1.0, zIndex, f1, f2);
            tessellator.addVertexWithUV(1.0, 1.0, zIndex, f3, f2);
            tessellator.addVertexWithUV(1.0, -1.0, zIndex, f3, f4);
            tessellator.addVertexWithUV(-1.0, -1.0, zIndex, f1, f4);
            tessellator.draw();
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            GL11.glPopMatrix();
        }
        GL11.glPushMatrix();
        renderengine.bindTexture(renderengine.getTexture("/misc/flagicon.png"));
        for (MapWaypoint mapWaypoint : mapdata.mapWaypoints) {
            GL11.glPushMatrix();
            for (int y = 0; y < 3; ++y) {
                for (int x = 0; x < 3; ++x) {
                    GL11.glColor4f((float) getCorrectColor(15 - mapWaypoint.colors[x * 3 + y]).getRed() / 255.0f, (float)getCorrectColor(15 - mapWaypoint.colors[x * 3 + y]).getGreen() / 255.0f, (float)getCorrectColor(15 - mapWaypoint.colors[x * 3 + y]).getBlue() / 255.0f, 1.0f);
                    GL11.glPushMatrix();
                    GL11.glTranslatef((float)(j + x % 3) + (float)mapWaypoint.mapCoordX / 2.0f + 64.0f, (float)(k + y % 3) + (float)mapWaypoint.mapCoordZ / 2.0f + 64.0f, -0.0f);
                    GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
                    GL11.glScalef(0.5f, 0.5f, 0.5f);
                    GL11.glTranslatef(0.0f, 4.0f, 0.0f);
                    double zIndex = -0.1;
                    float flagXMin = (float)((x + y) % 4) / 4.0f;
                    float flagYMin = (float)((x + y) / 4) / 4.0f;
                    float flagXMax = (float)((x + y) % 4 + 1) / 4.0f;
                    float flagYMax = (float)((x + y) / 4 + 1) / 4.0f;
                    tessellator.startDrawingQuads();
                    tessellator.addVertexWithUV(-1.0, 1.0, zIndex, flagXMin, flagYMin);
                    tessellator.addVertexWithUV(1.0, 1.0, zIndex, flagXMax, flagYMin);
                    tessellator.addVertexWithUV(1.0, -1.0, zIndex, flagXMax, flagYMax);
                    tessellator.addVertexWithUV(-1.0, -1.0, zIndex, flagXMin, flagYMax);
                    tessellator.draw();
                    GL11.glPopMatrix();
                }
            }
            GL11.glPopMatrix();
        }
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glTranslatef(0.0f, 0.0f, -0.04f);
        GL11.glScalef(1.0f, 1.0f, 1.0f);
        GL11.glPopMatrix();
    }
    
    private static Color getCorrectColor(int index) {
        index = 15 - index;
        if (index < 16) return Colors.allChatColors[15 - index];
        return ModColors.modFlagColors[index-16];
    }
}
