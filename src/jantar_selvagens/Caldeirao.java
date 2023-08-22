package jantar_selvagens;

public class Caldeirao {
	
	private static int maximoPorcoes = 5;
	private static int porcoes;
	
	public Caldeirao() {
		encher();
	}
	
	public boolean servir() throws InterruptedException {
		boolean serviu = porcoes > 0;
		if (serviu) {
			Thread.sleep(3000);
			porcoes--;
//			System.out.println("Restam "+porcoes+" porções no caldeirão.");
		}
		return serviu;
	}
	
	public void encher() {
		porcoes = maximoPorcoes;
	}

	public int getPorcoes() {
		return porcoes;
	}


}
