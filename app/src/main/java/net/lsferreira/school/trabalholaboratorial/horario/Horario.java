package net.lsferreira.school.trabalholaboratorial.horario;

public class Horario {
	private DiaSemana diaSemana;
	private int horaInicio;
	private int duracao;

	public Horario(DiaSemana diaSemana, int horaInicio, int duracao) {
		this.diaSemana = diaSemana;
		this.horaInicio = horaInicio;
		this.duracao = duracao;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public int getDuracao() {
		return duracao;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public boolean isDentro(Horario horario){
		return this.diaSemana == horario.diaSemana && ((this.horaInicio <= horario.horaInicio && horario.horaInicio > this.horaInicio+this.duracao)
				|| this.horaInicio+this.duracao > horario.horaInicio+horario.duracao);
	}

	public String toString() {
		return duracao + " horas";
	}
}

