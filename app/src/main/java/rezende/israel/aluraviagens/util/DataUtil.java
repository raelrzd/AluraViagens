package rezende.israel.aluraviagens.util;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DATA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTexto(int dias) {
        SimpleDateFormat formatoEsperado = new SimpleDateFormat(DATA_E_MES);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        String dataIdaFormatada = formatoEsperado.format(dataIda.getTime());
        String dataVoltaFormatada = formatoEsperado.format(dataVolta.getTime());
        return dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
    }

}
