package net.lsferreira.school.trabalholaboratorial.aulas.gestor;

import net.lsferreira.school.trabalholaboratorial.aulas.AssociavelAulas;
import net.lsferreira.school.trabalholaboratorial.aulas.Aula;
import net.lsferreira.school.trabalholaboratorial.horario.Horario;

import java.util.LinkedList;

public abstract class GestorAulas {

	protected final AssociavelAulas associavelAulas;
	protected LinkedList<Aula> aulas;


	public GestorAulas(AssociavelAulas associavelAulas, LinkedList<Aula> aulas)
	{
		this.associavelAulas = associavelAulas;
		this.aulas = aulas;
	}


	public LinkedList<Aula> getAulas()
	{
		return new LinkedList<Aula>(aulas);
	}


	final public LinkedList<Aula> getAulas(Horario horario){
		LinkedList<Aula> ret = new LinkedList<>();
		for(Aula aula : aulas) {
			if(horario.isDentro(aula.getHorario())) {
				ret.add(aula);
			}
		}
		return ret;
	}


	public void adicionar(Aula aula) {
		if(this.aulas.contains(aula)){
			return;
		}
		aulas.add(aula);

		associavelAulas.associar(aula);
	}


	public void remover(Aula aula) {
		if(aula == null || !aulas.contains(aula)){
			return;
		}

		aulas.remove(aula);
		associavelAulas.desassociar(aula);
	}
}
