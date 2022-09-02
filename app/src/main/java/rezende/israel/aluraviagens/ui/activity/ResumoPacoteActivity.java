package rezende.israel.aluraviagens.ui.activity;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.dao.PacoteDAO;
import rezende.israel.aluraviagens.model.Pacote;
import rezende.israel.aluraviagens.util.DiasUtil;
import rezende.israel.aluraviagens.util.MoedaUtil;
import rezende.israel.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle("Resumo do Pacote");

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteSaoPaulo.getLocal());

        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawableDoPacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasFormatado = DiasUtil.formataDiasEmTexto(pacoteSaoPaulo.getDias());
        dias.setText(diasFormatado);

        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBr = MoedaUtil.formataParaMoedaBr(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBr);


        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacoteSaoPaulo.getDias());

        TextView data = findViewById(R.id.resumo_pacote_data);
        SimpleDateFormat formatoEsperado = new SimpleDateFormat("dd/MM");
        String dataIdaFormatada = formatoEsperado.format(dataIda.getTime());
        String dataVoltaFormatada = formatoEsperado.format(dataVolta.getTime());
        String dataViagemFormatada = dataIdaFormatada + " - " + dataVoltaFormatada + " de " + dataVolta.get(Calendar.YEAR);
        data.setText(dataViagemFormatada);

    }
}