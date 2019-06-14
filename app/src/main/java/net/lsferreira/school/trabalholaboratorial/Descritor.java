package net.lsferreira.school.trabalholaboratorial;

public class Descritor {
	protected String nome;

	public Descritor(String nome)
	{
		this.nome = nome;
	}

	final public String getNome()
	{
		return this.nome;
	}

	public String toString() {
		return nome;
	}
}
