package rezende.israel.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import rezende.israel.aluraviagens.R;
import rezende.israel.aluraviagens.dao.PacoteDAO;
import rezende.israel.aluraviagens.model.Pacote;
import rezende.israel.aluraviagens.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacotes_listview);
        List<Pacote> pacote = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(this, pacote));

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);

    }
}