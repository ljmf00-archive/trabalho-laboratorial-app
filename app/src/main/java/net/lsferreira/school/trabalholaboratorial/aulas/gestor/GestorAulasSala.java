package net.lsferreira.school.trabalholaboratorial.aulas.gestor;

import net.lsferreira.school.trabalholaboratorial.aulas.AssociavelAulasSala;
import net.lsferreira.school.trabalholaboratorial.aulas.Aula;

import java.util.LinkedList;

public class GestorAulasSala extends GestorAulas {
	public GestorAulasSala(AssociavelAulasSala associavelAulasSala, LinkedList<Aula> aulas)
	{
		super(associavelAulasSala, aulas);
	}
}
