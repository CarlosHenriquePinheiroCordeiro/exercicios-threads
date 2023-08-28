package agendador_tarefas;

import java.util.concurrent.TimeUnit;

public class Tarefa implements Runnable {

	private String nome;
	private int tempo;
	private TimeUnit tipoTempo = null;
	private boolean executada  = false;
	private boolean agendada   = false;
	
	public Tarefa(int n) {
		this.nome = "Tarefa "+n;
	}
	
	@Override
	public void run() {
		executada = true;
		System.out.println(nome+" executada.");
	}
	
	@Override
	public String toString() {
		String unidade = "";
		switch (tipoTempo) {
			case MILLISECONDS: {
				unidade = "Milisegundos";
			}
			case SECONDS: {
				unidade = "Segundos";
			}
			case MINUTES: {
				unidade = "Minutos";
			}
		}
		return nome+": Executada - "+isExecutada()+", Unidade - "+unidade+", Quantidade - "+tempo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public TimeUnit getTipoTempo() {
		return tipoTempo;
	}

	public void setTipoTempo(TimeUnit tipoTempo) {
		this.tipoTempo = tipoTempo;
	}

	public boolean isExecutada() {
		return executada;
	}

	public void setExecutada(boolean executada) {
		this.executada = executada;
	}

	public boolean isAgendada() {
		return agendada;
	}

	public void setAgendada(boolean agendada) {
		this.agendada = agendada;
	}
	

}