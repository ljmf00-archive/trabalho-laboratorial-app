package net.lsferreira.school.trabalholaboratorial;

import net.lsferreira.school.trabalholaboratorial.Divisao;
import net.lsferreira.school.trabalholaboratorial.identificadores.Funcionario;

import java.util.LinkedList;

public class Gabinete<T extends Funcionario> extends Divisao {
	private LinkedList<T> pessoas;

	public Gabinete(String nome, boolean porta)
	{
		this(nome, porta, new LinkedList<T>());
	}

	public Gabinete(String nome, boolean porta, LinkedList<T> pessoas)
	{
		super(nome, porta);
		this.pessoas = pessoas;
	}

	public LinkedList<T> getpessoas()
	{
		return new LinkedList<T>(pessoas);
	}

	public void adicionar(T pessoa)
	{
		if(this.pessoas.contains(pessoa)) {
			return;
		}

		pessoas.add(pessoa);
	}

	public void remover(T pessoa)
	{
		if(pessoa == null || !pessoas.contains(pessoa)) {
			return;
		}

		pessoas.remove(pessoa);
	}
}
