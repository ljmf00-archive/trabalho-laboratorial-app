package net.lsferreira.school.trabalholaboratorial.aulas.gestor;

import net.lsferreira.school.trabalholaboratorial.aulas.AssociavelAulasPessoa;
import net.lsferreira.school.trabalholaboratorial.aulas.Aula;

import java.util.LinkedList;

public class GestorAulasPessoa extends GestorAulas {

	public GestorAulasPessoa(AssociavelAulasPessoa associavelAulasPessoa, LinkedList<Aula> aulas)
	{
		super(associavelAulasPessoa, aulas);
	}


	public boolean contem(Aula aula)
	{
		return aulas.contains(aula);
	}
}
