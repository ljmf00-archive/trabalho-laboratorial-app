package net.lsferreira.school.trabalholaboratorial.identificadores.pessoas;

import net.lsferreira.school.trabalholaboratorial.aulas.*;
import net.lsferreira.school.trabalholaboratorial.aulas.RepositorioAulas;
import net.lsferreira.school.trabalholaboratorial.aulas.gestor.GestorAulasPessoa;
import net.lsferreira.school.trabalholaboratorial.horario.Horario;
import net.lsferreira.school.trabalholaboratorial.identificadores.Identificador;

import java.util.LinkedList;

public abstract class PessoaComAulas extends Identificador implements RepositorioAulas, AssociavelAulasPessoa {
	private GestorAulasPessoa gestorAulasPessoa;
	protected LinkedList<Aula> aulas;

	public PessoaComAulas(String nome, long numero)
	{
		this(nome, numero, new LinkedList<Aula>());
	}

	public PessoaComAulas(String nome, long numero, LinkedList<Aula> aulas)
	{
		super(nome, numero);
		this.aulas = aulas;
		gestorAulasPessoa = new GestorAulasPessoa(this, aulas);
	}

	public void adicionar(Aula aula) {
		gestorAulasPessoa.adicionar(aula);
	}

	public void remover(Aula aula) {
		gestorAulasPessoa.remover(aula);
	}

	public LinkedList<Aula> getAulas()
	{
		return gestorAulasPessoa.getAulas();
	}

	public LinkedList<Aula> getAulas(Horario horario)
	{
		return gestorAulasPessoa.getAulas(horario);
	}

	public void preencherSumario(Aula aula){
		if(!aulas.contains(aula)){
			return;
		}
		aula.adicionarLinhaSumario(nome);
	}

	abstract public void associar(Aula aula);
	abstract public void desassociar(Aula aula);
}
