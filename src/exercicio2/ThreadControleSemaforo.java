package exercicio2;

public class ThreadControleSemaforo extends Thread {

	private Semaforo[] semaforos;
	
	@Override
	public void run() {
		while (true) {
			for (Semaforo semaforo : semaforos) {
				semaforo.trocaEstado();
				semaforo.printEstado();
				try {
					Thread.sleep(3000);
					semaforo.trocaEstado();
					semaforo.printEstado();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.print("\n");
		}
	}
	
	public ThreadControleSemaforo(Semaforo[] semaforos) {
		this.semaforos = semaforos;
	}
	
	
}