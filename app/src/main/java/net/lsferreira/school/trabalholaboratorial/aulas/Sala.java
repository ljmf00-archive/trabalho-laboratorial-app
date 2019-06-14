package net.lsferreira.school.trabalholaboratorial.aulas;

import net.lsferreira.school.trabalholaboratorial.Divisao;
import net.lsferreira.school.trabalholaboratorial.aulas.gestor.GestorAulasSala;
import net.lsferreira.school.trabalholaboratorial.horario.Horario;

import java.util.LinkedList;

public class Sala extends Divisao implements RepositorioAulas, AssociavelAulasSala {
	private GestorAulasSala gestorAulasSala;

	public Sala(String nome, boolean porta)
	{
		this(nome, porta, new LinkedList<Aula>());
	}

	public Sala(String nome, boolean porta, LinkedList<Aula> aulas)
	{
		super(nome, porta);
		gestorAulasSala = new GestorAulasSala(this, aulas);
	}

	public LinkedList<Aula> getAulas()
	{
		return gestorAulasSala.getAulas();
	}

	public LinkedList<Aula> getAulas(Horario horario)
	{
		return gestorAulasSala.getAulas(horario);
	}

	public void adicionar(Aula aula)
	{
		gestorAulasSala.adicionar(aula);
	}

	public void remover(Aula aula)
	{
		gestorAulasSala.remover(aula);
	}

	public void associar(Aula aula)
	{
		aula.setSala(this);
	}

	public void desassociar(Aula aula)
	{
		aula.desassociarSala();
	}
}
