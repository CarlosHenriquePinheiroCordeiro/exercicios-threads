package jantar_selvagens;

public class Jantar {

	private static Caldeirao  caldeirao;
	
	public Jantar(Caldeirao caldeirao) throws InterruptedException {
		Jantar.caldeirao  = caldeirao;
	}
	
	public void jantar() throws InterruptedException {
		while (true) {
			System.out.println(Thread.currentThread().getName()+" está comendo...");
			Thread.yield();
			System.out.println("\n"+Thread.currentThread().getName()+" está se servindo...");
			caldeirao.servir();
		}
	}

	public static Caldeirao getCaldeirao() {
		return caldeirao;
	}
	
	
}