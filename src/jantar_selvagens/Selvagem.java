package jantar_selvagens;
import java.security.SecureRandom;

public class Selvagem implements Runnable {

	private Caldeirao caldeirao;
	
	
	public Selvagem(Caldeirao caldeirao) {
		this.caldeirao = caldeirao;
	}
	
	@Override
	public void run() {
		SecureRandom generator = new SecureRandom();
		while (true) {
			try {
				System.out.println(Thread.currentThread().getName()+" está comendo...");
				Thread.sleep(generator.nextInt(5000));
				synchronized (caldeirao) {
					System.out.println(Thread.currentThread().getName()+" está indo se servir");
					Thread.sleep(1000);
					if (caldeirao.getPorcoes() <= 0) {
						caldeirao.wait();
					}
					caldeirao.servir();
					System.out.println(Thread.currentThread().getName()+" se serviu");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}