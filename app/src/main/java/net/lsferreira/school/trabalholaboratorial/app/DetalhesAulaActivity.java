package net.lsferreira.school.trabalholaboratorial.app;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.lsferreira.school.trabalholaboratorial.aulas.Aula;
import net.lsferreira.school.trabalholaboratorial.aulas.gestor.GestorSemanaAulas;
import net.lsferreira.school.trabalholaboratorial.identificadores.Aluno;

import java.util.LinkedList;

public class DetalhesAulaActivity extends AppCompatActivity {
    private static final String INDICE_AULA = "INDICE_AULA";

    private int indiceAula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_aula);

        TextView textViewNome = findViewById(R.id.textViewNome);
        TextView textViewNumero = findViewById(R.id.textViewNumero);

        TextView textViewHorario = findViewById(R.id.textViewHorario);
        TextView textViewSala = findViewById(R.id.textViewSala);

        TextView textViewProfessor = findViewById(R.id.textViewProfessor);

        ListView listViewAlunos = findViewById(R.id.listViewAlunos);


        indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);

        Aula aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);

        textViewNome.setText(aula.getNome());
        textViewNumero.setText(Long.toString(aula.getNumero()));

        textViewHorario.setText(aula.getHorario().toString());
        textViewSala.setText(aula.getSala().toString());

        textViewProfessor.setText(aula.getProfessor().toString());

        LinkedList<Aluno> alunos = aula.getAlunos();

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);

        listViewAlunos.setAdapter(listAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detalhes_aula, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.item_adicionar_aluno)
        {
            startActivity(AdicionarAlunoActivity.createIntent(DetalhesAulaActivity.this, indiceAula));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static Intent createIntent(Context context, int indiceAula)
    {
        Intent intent = new Intent(context, DetalhesAulaActivity.class);

        intent.putExtra(INDICE_AULA, indiceAula);

        return intent;
    }
}
