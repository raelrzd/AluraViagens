package rezende.israel.aluraviagens.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private Context context;
    private List<Pacote> listaPacotes;

    public ListaPacotesAdapter(Context context, List<Pacote> listaPacotes ) {
        this.context = context;
        this.listaPacotes = listaPacotes;
    }

    @Override
    public int getCount() {
        return listaPacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return listaPacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);
        return viewCriada;
    }
}
