package rezende.israel.aluraviagens.ui.adapter;

import static rezende.israel.aluraviagens.util.DiasUtil.formataDiasEmTexto;
import static rezende.israel.aluraviagens.util.MoedaUtil.formataParaMoedaBr;
import static rezende.israel.aluraviagens.util.ResourceUtil.devolveDrawable;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final Context context;
    private final List<Pacote> pacotes;

    public ListaPacotesAdapter(Context context, List<Pacote> listaPacotes) {
        this.context = context;
        this.pacotes = listaPacotes;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {

        View viewCriada = inflaLayoutDeItem(parent);
        Pacote pacote = pacotes.get(posicao);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private View inflaLayoutDeItem(ViewGroup parent) {
        return LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String valorPacote = formataParaMoedaBr(pacote.getPreco());
        preco.setText(valorPacote);
    }


    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String quantDias = formataDiasEmTexto(pacote.getDias());
        dias.setText(quantDias);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = devolveDrawable(context, pacote.getImagem());
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
