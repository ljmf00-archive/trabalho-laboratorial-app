package net.lsferreira.school.trabalholaboratorial;

public class Divisao extends Descritor {
	protected boolean porta = false;

	public Divisao(String nome)
	{
		super(nome);
	}

	public Divisao(String nome, boolean porta)
	{
		super(nome);
		this.porta = porta;
	}

	final public void abrir()
	{
		this.porta = true;
	}

	final public void fechar()
	{
		this.porta = false;
	}

	final public boolean isAberta()
	{
		return this.porta;
	}
}
