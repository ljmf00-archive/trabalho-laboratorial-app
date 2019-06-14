package net.lsferreira.school.trabalholaboratorial.identificadores;

import net.lsferreira.school.trabalholaboratorial.Descritor;

abstract public class Identificador extends Descritor {
	protected long numero;

	public Identificador(String nome, long numero){
		super(nome);
		this.numero = numero;
	}

	final public long getNumero()
	{
		return numero;
	}

	final public void setNumero(long numero)
	{
		this.numero = numero;
	}

	public String toString()
	{

		return super.toString() + " (" + numero + ")";

	}
}
