package rezende.israel.aluraviagens.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private Context context;
    private List<Pacote> pacotes;

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

        View viewCriada = LayoutInflater.from(context)
                .inflate(R.layout.item_pacote, parent, false);
        Pacote pacote = pacotes.get(posicao);

        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());

        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImagem()
                , "drawable", context.getPackageName());
        Drawable drawableImagemPacote = resources.getDrawable(idDoDrawable);
        imagem.setImageDrawable(drawableImagemPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String quantDias = "";
        if (pacote.getDias() > 1){
            quantDias = pacote.getDias() + " dias";
        } else {
            quantDias = pacote.getDias() + " dia";
        }
        dias.setText(quantDias);

        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        BigDecimal precoDoPacote = pacote.getPreco();
        NumberFormat moedaBr = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        String valorPacote = moedaBr.format(precoDoPacote);
        preco.setText(valorPacote);

        return viewCriada;
    }
}