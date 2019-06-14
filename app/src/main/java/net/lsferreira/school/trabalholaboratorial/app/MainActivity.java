package net.lsferreira.school.trabalholaboratorial.app;

import net.lsferreira.school.trabalholaboratorial.aulas.Aula;
import net.lsferreira.school.trabalholaboratorial.aulas.gestor.GestorSemanaAulas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewAulas = findViewById(R.id.listViewAulas);
        LinkedList<Aula> aulas = GestorSemanaAulas.INSTANCIA.getAulas();

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, aulas);

        listViewAulas.setAdapter(listAdapter);

        listViewAulas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(DetalhesAulaActivity.createIntent(MainActivity.this, position));
            }
        });
    }
}
