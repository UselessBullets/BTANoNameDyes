package goocraft4evr.goocraftbta.mixin;

import goocraft4evr.goocraftbta.misc.ModColors;
import net.minecraft.client.option.GameSettings;
import net.minecraft.client.render.FontRenderer;
import net.minecraft.client.render.RenderEngine;
import net.minecraft.core.util.helper.Color;
import net.minecraft.core.util.helper.Colors;
import org.lwjgl.opengl.GL11;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Random;

@Mixin(value = FontRenderer.class, remap = false)
public abstract class FontRendererMixin {
    @Final
    private int[] colorCode = new int[32+ModColors.MOD_COLORS<<1];

    @Inject(method="<init>",at=@At("TAIL"))
    private void injected(GameSettings gameSettings, String fontPath, RenderEngine renderEngine, CallbackInfo ci) {
        for (int i = 0; i < ModColors.MOD_COLORS<<1; ++i) {
            Color color = Colors.allChatColors[16+i%ModColors.MOD_COLORS];
            int r = color.getRed();
            int g = color.getGreen();
            int b = color.getBlue();
            if (i >= ModColors.MOD_COLORS) {
                r /= 4;
                g /= 4;
                b /= 4;
            }
            this.colorCode[32+i] = (r & 0xFF) << 16 | (g & 0xFF) << 8 | b & 0xFF;
        }
    }

    @Shadow
    private boolean obfuscatedStyle;
    @Shadow
    private boolean boldStyle;
    @Shadow
    private boolean italicStyle;
    @Shadow
    private boolean underlineStyle;
    @Shadow
    private boolean strikethroughStyle;
    @Shadow
    private int textColor;
    @Shadow
    private float alpha;

    @Inject(method="renderStringAtPos",at=@At(value="INVOKE_ASSIGN",ordinal=0,target="Ljava/lang/String;indexOf(I)I"),locals = LocalCapture.CAPTURE_FAILHARD)
    private void injected(String text, boolean flag, CallbackInfo ci, int i, char c, int formatCode) {
        if (formatCode > 21) {
            this.obfuscatedStyle = false;
            this.boldStyle = false;
            this.strikethroughStyle = false;
            this.underlineStyle = false;
            this.italicStyle = false;
            if (flag) {
                formatCode += ModColors.MOD_COLORS;
            }
            this.textColor = this.colorCode[10+formatCode];
            GL11.glColor4f((float)(this.textColor >> 16) / 255.0f, (float)(this.textColor >> 8 & 0xFF) / 255.0f, (float)(this.textColor & 0xFF) / 255.0f, this.alpha);
        }
    }

    @ModifyConstant(method = "renderStringAtPos",constant = @Constant(stringValue = "0123456789abcdefklmnor"))
    private String modify(String code) {
        return code+"ɏɐɑɒɓɔɕɖɗɘəɚɛɜɝɞɟɠɡɢɣɤɥɦɧɨɩɪɫɬɭɮɯɰɱɲɳɴɵɶɷɸɹɺɻɼɽɾɿʀʁʂʃʄʅʆʇʈʉʊʋʌʍʎʏʐʑʒʓʔʕʖʗʘʙʚʛʜʝʞʟʠʡʢʣʤʥʦʧʨʩʪʫʬʭʮʯʰʱʲʳʴʵʶʷʸʹʺʻʼʽʾʿˀˁ˂˃˄˅ˆˇˈˉˊˋˌˍˎ";
    }
}
