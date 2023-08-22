package jantar_selvagens;

public class Cozinheiro implements Runnable {
	
	private static Jantar jantar;
	
	public Cozinheiro(Jantar j) {
		Cozinheiro.jantar = j;
		new Thread(this).start();
	}

	@Override
	public void run() {
		Thread.currentThread();
		while (true) {
//			if (jantar.getCaldeirao().getPorcoes() == 0) {
//				try {
//					encherCaldeirao();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
			System.out.println("PORÇÕES: "+jantar.getCaldeirao().getPorcoes());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public synchronized boolean encherCaldeirao() throws InterruptedException {
		acordar();
		preparar();
		encher();
		dormir();
		return true;
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
		jantar.getCaldeirao().encher();
	}
	
	protected void dormir() throws InterruptedException {
		System.out.println("O cozinheiro está saindo do caldeirão e voltando a dormir.");
		Thread.sleep(3000);
	}


}
