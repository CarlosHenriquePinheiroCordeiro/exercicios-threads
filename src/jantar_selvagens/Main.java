package jantar_selvagens;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Caldeirao  caldeirao = new Caldeirao();
		
		new Thread(new Selvagem(caldeirao), "Selvagem 1").start();
		new Thread(new Selvagem(caldeirao), "Selvagem 2").start();
		new Thread(new Selvagem(caldeirao), "Selvagem 3").start();

		new Thread(new Cozinheiro(caldeirao)).start();
		
		
	}


}