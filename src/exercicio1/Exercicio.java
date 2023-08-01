package exercicio1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio {

	public void executar() throws InterruptedException {
		System.out.println("################################# Corrida de Threads #################################");
		System.out.print("Informe quantos corredores estão participando da corrida: ");
		Scanner sc        = new Scanner(System.in);
		int qtdCorredores = sc.nextInt();
		List<Corredor> corredores = new ArrayList<Corredor>();
		for (int i = 0; i < qtdCorredores; i++) {
			System.out.print("\nInforme o nome do corredor "+(i+1)+": ");
			Corredor corredor = new Corredor(i, sc.next());
			corredores.add(corredor);
		}
		sc.close();
		System.out.print("\nCorrida iniciando em 3...");
		Thread.sleep(1000);
		System.out.print(" 2...");
		Thread.sleep(1000);
		System.out.print(" 1...\n");
		Thread.sleep(1000);
		System.out.println("Corrida iniciada!");
		for (Corredor corredor : corredores) {
			corredor.start();
		}
		for (Corredor corredor : corredores) {
			corredor.run();
		}
	}
	
	
}
