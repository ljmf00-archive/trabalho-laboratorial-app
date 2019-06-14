package net.lsferreira.school.trabalholaboratorial.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import net.lsferreira.school.trabalholaboratorial.aulas.Aula;
import net.lsferreira.school.trabalholaboratorial.aulas.gestor.GestorSemanaAulas;
import net.lsferreira.school.trabalholaboratorial.identificadores.Aluno;

import java.util.LinkedList;

public class AdicionarAlunoActivity extends AppCompatActivity {
    private static final String INDICE_AULA = "INDICE_AULA";
    private int indiceAula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_aluno);

        indiceAula = getIntent().getIntExtra(INDICE_AULA, -1);

        final Aula aula = GestorSemanaAulas.INSTANCIA.getAula(indiceAula);

        final EditText editTextNome = findViewById(R.id.editTextNome);
        final EditText editTextNumero = findViewById(R.id.editTextNumero);

        Button buttonAdicionar = findViewById(R.id.buttonAdicionar);
        buttonAdicionar.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String textNome = editTextNome.getText().toString().trim();
                String textNumero = editTextNumero.getText().toString().trim();

                if(textNome.isEmpty())
                {
                    editTextNome.setError("Introduza um nome");
                    return;
                }

                if(textNumero.isEmpty())
                {
                    editTextNumero.setError("Introduza um numero");
                    return;
                }
                else {
                    for(Aluno aluno : aula.getAlunos())
                    {
                        if(aluno.getNumero() == Long.parseLong(textNumero))
                        {
                            editTextNome.setError("Numero existente");
                        }
                    }
                }



                finish();
            }
        });
    }

    public static Intent createIntent(Context context, int indiceAula)
    {
        Intent intent = new Intent(context, AdicionarAlunoActivity.class);
        intent.putExtra(INDICE_AULA, indiceAula);

        return intent;
    }
}
