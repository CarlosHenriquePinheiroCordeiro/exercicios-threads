package jantar_selvagens;

public class Jantar {

	private static Caldeirao  caldeirao;
	
	public Jantar(Caldeirao caldeirao) throws InterruptedException {
		Jantar.caldeirao  = caldeirao;
	}
	
	public void jantar() throws InterruptedException {
		while (true) {
			System.out.println(Thread.currentThread().getName()+" está comendo...");
			Thread.sleep(1000);
			System.out.println("\n"+Thread.currentThread().getName()+" está se servindo...");
			if (caldeirao.getPorcoes() == 0) {
				wait();
			}
			servir();
		}
	}
	
	public synchronized void servir() throws InterruptedException {
		caldeirao.servir();
		System.out.println("\n"+Thread.currentThread().getName()+" se serviu...");
		Thread.sleep(1000);
	}

	public static Caldeirao getCaldeirao() {
		return caldeirao;
	}
	
	
}