package jantar_selvagens;

public class Caldeirao {
	
	private static int maximoPorcoes = 5;
	private static int porcoes = 0;
	
	public Caldeirao() {
		encher();
	}
	
	public synchronized boolean servir() throws InterruptedException {
		boolean servir = porcoes > 0;
		if (servir) {
			Thread.sleep(1000);
			porcoes--;
			System.out.println("Restam "+porcoes+" porções no caldeirão.");
			Thread.sleep(1000);
		}
		return servir;
	}
	
	public void encher() {
		porcoes = maximoPorcoes;
	}

	public int getPorcoes() {
		return porcoes;
	}


}
