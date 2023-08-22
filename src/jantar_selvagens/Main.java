package jantar_selvagens;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Caldeirao  caldeirao = new Caldeirao();
		Jantar 	   jantar    = new Jantar(caldeirao);
		new Cozinheiro(jantar);
		new Selvagem(jantar, 1);
		new Selvagem(jantar, 2);
		new Selvagem(jantar, 3);
		
	}


}