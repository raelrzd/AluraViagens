package rezende.israel.aluraviagens.ui.activity;

import static rezende.israel.aluraviagens.util.DataUtil.periodoEmTexto;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.model.Pacote;
import rezende.israel.aluraviagens.util.DiasUtil;
import rezende.israel.aluraviagens.util.MoedaUtil;
import rezende.israel.aluraviagens.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);
        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        if (intent.hasExtra("pacote")) {
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraDias(pacote);
            mostraPreco(pacote);
            mostraData(pacote);

            Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_botao_realiza_pagamento);
            botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });

        }

    }

    private void mostraData(Pacote pacoteSaoPaulo) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataViagemFormatada = periodoEmTexto(pacoteSaoPaulo.getDias());
        data.setText(dataViagemFormatada);
    }


    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaBr = MoedaUtil.formataParaMoedaBr(pacote.getPreco());
        preco.setText(moedaBr);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasFormatado = DiasUtil.formataDiasEmTexto(pacote.getDias());
        dias.setText(diasFormatado);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_imagem);
        Drawable drawableDoPacote = ResourceUtil.devolveDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoPacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}