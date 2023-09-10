package thread_socket_servidor;

public class Fibonacci {
	
	private static int numeroAnterior = 0;
	private static int numeroAtual    = 1;
	private static int sequencia      = 0;
	
	public void avancaSequencia() {
		sequencia      = numeroAtual + numeroAnterior;
		numeroAnterior = numeroAtual;
		numeroAtual    = sequencia;
	}
	
	public int getSequencia() {
		return Fibonacci.sequencia;
	}

}
