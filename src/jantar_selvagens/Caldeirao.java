package jantar_selvagens;

public class Caldeirao {
	
	private int maximoPorcoes = 5;
	private int porcoes;
	
	public Caldeirao() {
		encher();
	}
	
	public synchronized boolean servir() throws InterruptedException {
		boolean serviu = porcoes > 0;
		if (serviu) {
			porcoes--;
		}
		Thread.sleep(1000);
		System.out.println("Restam "+porcoes+" porções no caldeirão.");
		return serviu;
	}
	
	public void encher() {
		porcoes = maximoPorcoes;
	}

}
