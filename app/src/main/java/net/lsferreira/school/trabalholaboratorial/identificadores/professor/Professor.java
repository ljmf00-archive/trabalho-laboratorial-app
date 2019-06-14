package net.lsferreira.school.trabalholaboratorial.identificadores.professor;

import net.lsferreira.school.trabalholaboratorial.aulas.Aula;
import net.lsferreira.school.trabalholaboratorial.aulas.Sala;
import net.lsferreira.school.trabalholaboratorial.horario.Horario;
import net.lsferreira.school.trabalholaboratorial.identificadores.Aluno;
import net.lsferreira.school.trabalholaboratorial.identificadores.Funcionario;
import net.lsferreira.school.trabalholaboratorial.identificadores.pessoas.PessoaComAulas;

import java.util.LinkedList;

public class Professor extends PessoaComAulas implements Funcionario {
	public Professor(String nome, long numero)
	{
		this(nome, numero, null);
	}

	public Professor(String nome, long numero, GabineteProfessor gabinete){
		super(nome, numero);
		this.gabinete = gabinete;
		this.horarios = new LinkedList<>();
	}

	@Override public void preencherSumario(Aula aula) {
		super.preencherSumario(aula);

		aula.adicionarLinhaSumario(aula.getNome());
		aula.adicionarLinhaSumario(String.valueOf(aula.getNumero()));
		for(Aluno aluno : aula.getAlunos()){
			aluno.preencherSumario(aula);
		}
	}

	@Override public void adicionar(Aula aula) {
		super.adicionar(aula);
		aula.setProfessor(this);
	}

	@Override public void remover(Aula aula){
		super.remover(aula);
		aula.desassociarProfessor();
	}

	public void associar(Aula aula)
	{
		aula.setProfessor(this);
	}

	public void desassociar(Aula aula)
	{
		aula.desassociarProfessor();
	}

	public void atribuir(GabineteProfessor gabinete)
	{
		this.gabinete = gabinete;
	}

	public void desassociarGabinete()
	{
		this.gabinete = null;
	}

	public void abrirGabinete()
	{
		gabinete.abrir();
	}

	public void fecharGabinete()
	{
		gabinete.fechar();
	}

	public void adicionar(Horario horario)
	{
		if(horarios.contains(horario))
			return;
		horarios.add(horario);
	}

	public void remover(Horario horario)
	{
		if(!horarios.contains(horario))
			return;
		horarios.remove(horario);
	}

	public LinkedList<Horario> getHorarios()
	{
		return new LinkedList<>(horarios);
	}

	public GabineteProfessor getGabinete()
	{
		return this.gabinete;
	}

	public void abrir(Sala sala)
	{
		sala.abrir();
	}

	public void fechar(Sala sala)
	{
		sala.fechar();
	}

	private GabineteProfessor gabinete;
	private LinkedList<Horario> horarios;
}
