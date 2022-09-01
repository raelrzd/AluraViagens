package rezende.israel.aluraviagens.ui.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.dao.PacoteDAO;
import rezende.israel.aluraviagens.model.Pacote;
import rezende.israel.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle("Pacotes");
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacote = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(this, pacote));

    }
}