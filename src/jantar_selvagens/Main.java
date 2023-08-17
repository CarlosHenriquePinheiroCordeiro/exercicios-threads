package jantar_selvagens;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Caldeirao caldeirao = new Caldeirao();
		Cozinheiro c = new Cozinheiro(caldeirao);
		Selvagem[] s = {new Selvagem(caldeirao, 1), new Selvagem(caldeirao, 2), new Selvagem(caldeirao, 3), new Selvagem(caldeirao, 4)};
		new Jantar(s, c).start();;
	}


}