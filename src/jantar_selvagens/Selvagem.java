package jantar_selvagens;

public class Selvagem extends Thread {

	private int numero;
	private Caldeirao caldeirao;
	
	public Selvagem(Caldeirao caldeirao, int n) {
		this.caldeirao = caldeirao;
		this.numero = n;
	}
	
	@Override
	public void run() {
		
		super.run();
	}
	
	
}
