package exercicio1;
import java.util.Random;

public class Corredor extends Thread {

	private int numeroCorredor;
	private String nome;
	private int distancia = 1000;
	
	@Override
	public void run() {
		
		int percorrido = 0;
		Random r = new Random();
		while (percorrido < this.distancia) {
			Thread.currentThread();
			Thread.yield();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			percorrido += r.nextInt(1, 10);
			if (percorrido % 100 == 0) {
				System.out.println(this.nome+" ("+(this.numeroCorredor+1)+") alcançou os "+percorrido+"m de distância!");
			}
		}
	}

	public Corredor(int numeroCorredor, String nome) {
		setNumeroCorredor(numeroCorredor);
		setNome(nome);
	}

	public int getNumeroCorredor() {
		return numeroCorredor;
	}

	public void setNumeroCorredor(int numeroCorredor) {
		this.numeroCorredor = numeroCorredor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}