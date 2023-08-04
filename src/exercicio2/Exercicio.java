package exercicio2;

public class Exercicio {
	
	public void executar() {
		Semaforo s1 = new Semaforo(1, true );
		Semaforo s2 = new Semaforo(2, false);
		Semaforo s3 = new Semaforo(3, false);
		Semaforo s4 = new Semaforo(4, false);
		s1.start();
		s2.start();
		s3.start();
		s4.start();
	}

}
