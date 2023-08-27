package jantar_selvagens;

public class Cozinheiro implements Runnable {
	
	private Caldeirao caldeirao;
	
	public Cozinheiro(Caldeirao caldeirao) {
		this.caldeirao = caldeirao;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (caldeirao) {
				try {
					if (caldeirao.getPorcoes() <= 0) {
						acordar();
						preparar();
						encher();
						dormir();
						caldeirao.notifyAll();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		}
	}
	
	protected void acordar() throws InterruptedException {
		System.out.println("O cozinheiro está acordando");
		Thread.sleep(3000);
		System.out.println("O cozinheiro acordou.");
	}
	
	protected void preparar() throws InterruptedException {
		System.out.println("O cozineiro está preparando 5 porções");
		Thread.sleep(6000);
	}
	
	protected void encher() throws InterruptedException {
		System.out.println("O cozinheiro está enchendo o caldeirão");
		Thread.sleep(6000);
		caldeirao.encher();
	}
	
	protected void dormir() throws InterruptedException {
		System.out.println("O cozinheiro está saindo do caldeirão e voltando a dormir.");
		Thread.sleep(3000);
	}


}
