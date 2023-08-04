package exercicio2;

public class Semaforo extends Thread {

	private int numero;
	private boolean aberto;
	
	@Override
	public void run() {
		Thread.currentThread();
		while (true) {
			printEstado();
			trocaEstado();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void printEstado() {
		String mensagem = "Semáforo "+getNumero()+" está aberto";
		if (!isAberto()) 
			mensagem = "Semáforo "+getNumero()+" está fechado";
		System.out.println("\n"+mensagem);
	}
	
	public Semaforo(int numero, boolean isAberto) {
		setNumero(numero);
		setAberto(isAberto);
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	protected void trocaEstado() {
		setAberto(!isAberto());
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	
	
}