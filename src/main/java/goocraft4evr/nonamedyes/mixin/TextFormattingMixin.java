package goocraft4evr.nonamedyes.mixin;

import net.minecraft.core.net.command.TextFormatting;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value= TextFormatting.class,remap = false)
public abstract class TextFormattingMixin {

    @Final
    private static final TextFormatting[] FORMATTINGS = new TextFormatting[31];
    @Unique
    private static final TextFormatting[] modColours = {
            new TextFormatting(22).setNames("Crimson"),
            new TextFormatting(23).setNames("Maroon"),
            new TextFormatting(24).setNames("Ash Gray", "Ash Grey"),
            new TextFormatting(25).setNames("Olive"),
            new TextFormatting(26).setNames("Ochre"),
            new TextFormatting(27).setNames("Buff"),
            new TextFormatting(28).setNames("Verdigris"),
            new TextFormatting(29).setNames("Light Yellow"),
            new TextFormatting(30).setNames("Indigo")
    };

    static {
        FORMATTINGS[0] = TextFormatting.WHITE;
        FORMATTINGS[1] = TextFormatting.ORANGE;
        FORMATTINGS[2] = TextFormatting.MAGENTA;
        FORMATTINGS[3] = TextFormatting.LIGHT_BLUE;
        FORMATTINGS[4] = TextFormatting.YELLOW;
        FORMATTINGS[5] = TextFormatting.LIME;
        FORMATTINGS[6] = TextFormatting.PINK;
        FORMATTINGS[7] = TextFormatting.GRAY;
        FORMATTINGS[8] = TextFormatting.LIGHT_GRAY;
        FORMATTINGS[9] = TextFormatting.CYAN;
        FORMATTINGS[10] = TextFormatting.PURPLE;
        FORMATTINGS[11] = TextFormatting.BLUE;
        FORMATTINGS[12] = TextFormatting.BROWN;
        FORMATTINGS[13] = TextFormatting.GREEN;
        FORMATTINGS[14] = TextFormatting.RED;
        FORMATTINGS[15] = TextFormatting.BLACK;
        FORMATTINGS[16] = TextFormatting.OBFUSCATED;
        FORMATTINGS[17] = TextFormatting.BOLD;
        FORMATTINGS[18] = TextFormatting.STRIKETHROUGH;
        FORMATTINGS[19] = TextFormatting.UNDERLINE;
        FORMATTINGS[20] = TextFormatting.ITALIC;
        FORMATTINGS[21] = TextFormatting.RESET;
        System.arraycopy(modColours, 0, FORMATTINGS, 22, modColours.length);
    }

    @ModifyConstant(method="<init>", constant = @Constant(stringValue = "0123456789abcdefklmnor"))
    private String methodName(String variable) {
        return variable + "ɏɐɑɒɓɔɕɖɗɘəɚɛɜɝɞɟɠɡɢɣɤɥɦɧɨɩɪɫɬɭɮɯɰɱɲɳɴɵɶɷɸɹɺɻɼɽɾɿʀʁʂʃʄʅʆʇʈʉʊʋʌʍʎʏʐʑʒʓʔʕʖʗʘʙʚʛʜʝʞʟʠʡʢʣʤʥʦʧʨʩʪʫʬʭʮʯʰʱʲʳʴʵʶʷʸʹʺʻʼʽʾʿˀˁ˂˃˄˅ˆˇˈˉˊˋˌˍˎ";
    }
}
