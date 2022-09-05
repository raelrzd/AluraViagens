package rezende.israel.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.model.Pacote;
import rezende.israel.aluraviagens.util.DataUtil;
import rezende.israel.aluraviagens.util.MoedaUtil;
import rezende.israel.aluraviagens.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle("Resumo Compra");

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        ImageView imagem = findViewById(R.id.resumo_compra_imagem_local);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacoteSaoPaulo.getImagem());
        imagem.setImageDrawable(drawable);

        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacoteSaoPaulo.getLocal());

        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatada = DataUtil.periodoEmTexto(pacoteSaoPaulo.getDias());
        data.setText(dataFormatada);

        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moedaBr = MoedaUtil.formataParaMoedaBr(pacoteSaoPaulo.getPreco());
        preco.setText(moedaBr);

    }
}