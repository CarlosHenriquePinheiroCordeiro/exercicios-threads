package jantar_selvagens;

public class Cozinheiro {
	
	private Caldeirao caldeirao;
	private boolean dormindo = true;
	
	public Cozinheiro(Caldeirao c) {
		this.caldeirao = c;
	}
	
	public boolean encherCaldeirao() {
		acordar();
		encher();
		dormir();
		return true;
	}
	
	protected void acordar() {
		dormindo = false;
		System.out.println("O cozinheiro acordou.");
	}
	
	protected void encher() {
		System.out.println("O cozinheiro está enchendo o caldeirão");
		caldeirao.encher();
	}
	
	protected void dormir() {
		dormindo = true;
		System.out.println("O cozinheiro voltou a dormir.");
	}

}
