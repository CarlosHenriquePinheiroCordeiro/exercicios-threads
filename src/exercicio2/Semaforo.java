package exercicio2;

public class Semaforo {

	private int numero;
	private boolean aberto = false;
	
	public void printEstado() {
		String mensagem = "Semáforo "+getNumero()+" está aberto";
		if (!isAberto()) 
			mensagem = "Semáforo "+getNumero()+" está fechado";
		System.out.println(mensagem);
	}
	
	public Semaforo(int numero) {
		setNumero(numero);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public synchronized void trocaEstado() {
		setAberto(!isAberto());
		notifyAll();
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	
}