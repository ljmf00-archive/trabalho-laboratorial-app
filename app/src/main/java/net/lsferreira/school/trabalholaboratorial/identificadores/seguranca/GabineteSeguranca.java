package net.lsferreira.school.trabalholaboratorial.identificadores.seguranca;

import net.lsferreira.school.trabalholaboratorial.Gabinete;

import java.util.LinkedList;

public class GabineteSeguranca extends Gabinete<Seguranca> {
	public GabineteSeguranca(String nome, boolean porta)
	{
		super(nome, porta, new LinkedList<Seguranca>());
	}

	public GabineteSeguranca(String nome, boolean porta, LinkedList<Seguranca> segurancas)
	{
		super(nome, porta, segurancas);
	}
}