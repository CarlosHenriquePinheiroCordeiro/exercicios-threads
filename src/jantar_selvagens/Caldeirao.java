package jantar_selvagens;

public class Caldeirao {
	
	private int maximoPorcoes = 5;
	private int porcoes;
	
	public Caldeirao() {
		encher();
	}
	
	public boolean comePorcao() {
		boolean comeu = porcoes > 0;
		if (comeu) {
			porcoes--;
		}
		return comeu;
	}
	
	public void encher() {
		porcoes = maximoPorcoes;
	}

}
