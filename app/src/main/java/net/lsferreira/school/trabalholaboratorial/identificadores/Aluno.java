package net.lsferreira.school.trabalholaboratorial.identificadores;

import net.lsferreira.school.trabalholaboratorial.aulas.Aula;
import net.lsferreira.school.trabalholaboratorial.identificadores.pessoas.PessoaComAulas;

import java.util.LinkedList;

public class Aluno extends PessoaComAulas {
	public Aluno(String nome, long numero)
	{
		super(nome, numero);
	}
	public Aluno(String nome, long numero, LinkedList<Aula> aulas)
	{
		super(nome, numero, aulas);
	}

	@Override public void adicionar(Aula aula)
	{
		super.adicionar(aula);
	}

	@Override public void remover(Aula aula)
	{
		super.remover(aula);
		aula.remover(this);
	}

	@Override
	public void associar(Aula aula)
	{
		aula.adicionar(this);
	}

	@Override
	public void desassociar(Aula aula) {
		aula.remover(this);
	}
}


