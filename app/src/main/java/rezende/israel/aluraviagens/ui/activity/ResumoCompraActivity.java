package rezende.israel.aluraviagens.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

    public static final String TITULO_APPBAR = "Resumo Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(TITULO_APPBAR);

        Pacote pacoteSaoPaulo = new Pacote("São Paulo", "sao_paulo_sp", 2, new BigDecimal("243.99"));

        mostraImagem(pacoteSaoPaulo);
        mostraLocal(pacoteSaoPaulo);
        mostraData(pacoteSaoPaulo);
        mostraPreco(pacoteSaoPaulo);

    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String moedaBr = MoedaUtil.formataParaMoedaBr(pacote.getPreco());
        preco.setText(moedaBr);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatada = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(dataFormatada);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_local);
        Drawable drawable = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }
}