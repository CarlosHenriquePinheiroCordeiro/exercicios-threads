package exercicio2;

public class Exercicio {
	
	public void executar() throws InterruptedException {
		Semaforo s1 = new Semaforo(1);
		Semaforo s2 = new Semaforo(2);
		Semaforo s3 = new Semaforo(3);
		Semaforo s4 = new Semaforo(4);
		Semaforo[] semaforos = {s1, s2, s3, s4};
		new ThreadControleSemaforo(semaforos).start();
	}

}
