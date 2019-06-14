package net.lsferreira.school.trabalholaboratorial.identificadores.professor;

import net.lsferreira.school.trabalholaboratorial.Gabinete;

import java.util.LinkedList;

public class GabineteProfessor extends Gabinete<Professor> {
	public GabineteProfessor(String nome, boolean porta)
	{
		super(nome, porta, new LinkedList<Professor>());
	}

	public GabineteProfessor(String nome, boolean porta, LinkedList<Professor> professores)
	{
		super(nome, porta, professores);
	}
}
