package thread_socket_servidor;

public class ThreadFibonacci extends Thread {

	private int numeroAnterior = 0;
	private int numeroAtual    = 1;
	private int sequencia      = 0;
	
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				sequencia      = numeroAtual + numeroAnterior;
				numeroAnterior = numeroAtual;
				numeroAtual    = sequencia;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int getSequencia() {
		return this.sequencia;
	}
	
	
	
}
