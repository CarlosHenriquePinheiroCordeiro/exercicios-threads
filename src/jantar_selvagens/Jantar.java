package jantar_selvagens;

public class Jantar extends Thread {

	private Selvagem[] selvagens;
	private Cozinheiro cozinheiro;
	
	public Jantar(Selvagem[] selvagens, Cozinheiro cozinheiro) throws InterruptedException {
		this.selvagens = selvagens;
		this.cozinheiro = cozinheiro;
	}
	
	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				if (selvagens[i].servir()) {
					selvagens[i].comer();
					i++;
				} else {
					cozinheiro.encherCaldeirao();
				}
				if (i == selvagens.length)
					i = 0;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
