package thread_socket_servidor;

public class ThreadFibonacci extends Thread {

	private Fibonacci fb;
	private int comando = 0;
	
	public ThreadFibonacci(Fibonacci fb) {
		this.fb = fb;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				fb.avancaSequencia();
				if (comando > 0) {
					synchronized (fb) {
						switch (comando) {
							case 1: {
								Thread.sleep(5000);
								break;
							}
							case 2: {
								fb.wait();
								break;
							}
							case 3: {
								fb.notifyAll();
								break;
							}
							default:
								comando = 0;
								break;
							}
						comando = 0;
					}
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void dorme() throws InterruptedException {
		comando = 1;
	}
	
	public void espera() throws InterruptedException {
		comando = 2;
	}
	
	public void notifica() {
		comando = 3;
	}
	
	public int getSequencia() {
		return this.fb.getSequencia();
	}
	
	
	
}
