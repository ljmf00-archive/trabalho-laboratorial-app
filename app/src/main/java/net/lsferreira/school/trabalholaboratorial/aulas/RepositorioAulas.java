package net.lsferreira.school.trabalholaboratorial.aulas;

import net.lsferreira.school.trabalholaboratorial.horario.Horario;

import java.util.LinkedList;

public interface RepositorioAulas {
	void adicionar(Aula aula);
	void remover(Aula aula);

	LinkedList<Aula> getAulas();
	LinkedList<Aula> getAulas(Horario horario);
}
