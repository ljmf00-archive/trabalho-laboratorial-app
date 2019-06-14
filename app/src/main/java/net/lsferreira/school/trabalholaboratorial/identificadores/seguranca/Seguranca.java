package net.lsferreira.school.trabalholaboratorial.identificadores.seguranca;

import net.lsferreira.school.trabalholaboratorial.Divisao;
import net.lsferreira.school.trabalholaboratorial.identificadores.Funcionario;
import net.lsferreira.school.trabalholaboratorial.identificadores.pessoas.Pessoa;
import net.lsferreira.school.trabalholaboratorial.horario.Horario;
import java.util.LinkedList;

public class Seguranca extends Pessoa implements Funcionario {
	public Seguranca(String nome, long numero)
	{
		this(nome, numero, null);
	}

	public Seguranca(String nome, long numero, GabineteSeguranca gabinete) {

		super(nome, numero);
		this.gabinete = gabinete;
		this.horarios = new LinkedList<>();
	}

	public void associar(GabineteSeguranca gabinete) {
		if(gabinete != this.gabinete)
			this.gabinete = gabinete;
	}

	public void atribuir(GabineteSeguranca gabinete) {
		this.gabinete = gabinete;
	}

	public void desassociarGabinete() {
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

	public void abrir(Divisao divisao)
	{
		divisao.abrir();
	}

	public void fechar(Divisao divisao)
	{
		divisao.fechar();
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

	public GabineteSeguranca getGabinete()
	{
		return this.gabinete;
	}

	private GabineteSeguranca gabinete;
	private LinkedList<Horario> horarios;
}