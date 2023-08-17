package jantar_selvagens;

public class Cozinheiro {
	
	private Caldeirao caldeirao;
	private boolean dormindo = true;
	
	public Cozinheiro(Caldeirao c) {
		this.caldeirao = c;
	}
	
	public synchronized boolean encherCaldeirao() throws InterruptedException {
		acordar();
		encher();
		dormir();
		return true;
	}
	
	protected void acordar() throws InterruptedException {
		System.out.println("O cozinheiro está acordando");
		Thread.sleep(1000);
		System.out.println("O cozinheiro acordou.");
		dormindo = false;
	}
	
	protected void encher() throws InterruptedException {
		System.out.println("O cozinheiro está preparando as porções enchendo o caldeirão");
		Thread.sleep(5000);
		caldeirao.encher();
	}
	
	protected void dormir() throws InterruptedException {
		dormindo = true;
		System.out.println("O cozinheiro voltou a dormir.");
		Thread.sleep(1000);
	}

}
