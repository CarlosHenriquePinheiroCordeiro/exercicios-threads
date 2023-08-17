package jantar_selvagens;

public class Selvagem {

	private int numero;
	private Caldeirao caldeirao;
	
	public Selvagem(Caldeirao caldeirao, int n) {
		this.caldeirao = caldeirao;
		this.numero = n;
	}
	
	public synchronized boolean servir() throws InterruptedException {
		System.out.println("Selvagem "+numero+" está se servindo...");
		return caldeirao.servir();
	}
	
	public void comer() throws InterruptedException {
		System.out.println("Selvagem "+numero+" está comendo...\n");
		Thread.sleep(3000);
	}
	
	
}
