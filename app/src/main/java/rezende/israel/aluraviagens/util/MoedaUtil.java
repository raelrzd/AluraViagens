package rezende.israel.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";

    public static String formataParaMoedaBr(BigDecimal valor) {
        NumberFormat moedaBr = DecimalFormat
                .getCurrencyInstance(new Locale(PORTUGUES, BRASIL));
        return moedaBr.format(valor);
    }
}
