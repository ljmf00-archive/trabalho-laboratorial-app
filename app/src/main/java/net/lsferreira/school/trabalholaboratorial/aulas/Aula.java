package net.lsferreira.school.trabalholaboratorial.aulas;

import net.lsferreira.school.trabalholaboratorial.horario.Horario;
import net.lsferreira.school.trabalholaboratorial.identificadores.Aluno;
import net.lsferreira.school.trabalholaboratorial.identificadores.Identificador;
import net.lsferreira.school.trabalholaboratorial.identificadores.professor.Professor;

import java.util.LinkedList;

public class Aula extends Identificador {
	private String sumario;
	private Professor professor;
	private LinkedList<Aluno> alunos;
	private Horario horario;
	private Sala sala;

	public Aula(String nome, long numero, Horario horario, Sala sala)
	{
		this(nome, numero, horario, sala, null, new LinkedList<Aluno>());
	}

	public Aula(String nome, long numero, Horario horario, Sala sala, Professor professor, LinkedList<Aluno> alunos)
	{
		super(nome, numero);
		sumario = "";
		setProfessor(professor);
		this.alunos = new LinkedList<>();
		this.horario = horario;
		this.sala = sala;
		for(Aluno aluno : alunos){
			adicionar(aluno);
		}
	}

	public void setSala(Sala sala)
	{
		this.sala = sala;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void desassociarSala()
	{
		this.sala = null;
	}

	public void adicionar(Aluno aluno) {
		if(this.alunos.contains(aluno)){
			return;
		}
		alunos.add(aluno);
		aluno.adicionar(this);
	}

	public void remover(Aluno aluno){
		if(this.alunos == null || !alunos.contains(aluno)){
			return;
		}
		alunos.remove(aluno);
	}

	public void adicionarLinhaSumario(String linha){
		StringBuilder sb = new StringBuilder(sumario);
		sb.append(linha).append("\n");
		sumario = sb.toString();
	}

	public String getSumario(){
		return sumario;
	}

	public Professor getProfessor(){
		return professor;
	}

	public LinkedList<Aluno> getAlunos(){
		return new LinkedList<>(alunos);
	}

	public void setProfessor(Professor professor){
		if(professor==null || this.professor == professor) {
			return;
		}
		if (this.professor != null){
		 desassociarProfessor();
		}

		this.professor = professor;
		this.professor.adicionar(this);
	}

	public void desassociarProfessor(){
	//Verificar se a aula tem professor
		if(professor == null){
			return;
		}

		professor.remover(this);
	}

	public Horario getHorario() {
		return horario;
	}

	public String toString() {
		return "\n" + super.toString() + "\n" + sala + "\n";
	}
}
