package servidor_clientes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] agrs) throws IOException {
		
		try {
			Socket         cliente = new Socket("127.0.0.1", 7000);
			PrintWriter    saida   = new PrintWriter(cliente.getOutputStream(), true);
			Scanner 	   sc      = new Scanner(System.in);
			String 		   texto   = "";
			
			ClienteThread clienteThread = new ClienteThread(cliente);
			new Thread(clienteThread).start();
			do {
				System.out.println("Informe um comando:");
				System.out.println("verSequencia (Visualiza o número atual da(s) sequência(s) de Fibonacci)\\nnew\\nsleep\\nwait\\nnotify");
				texto = sc.nextLine();
				saida.println(texto);
			} while (!"sair".equals(texto));
			sc.close();
		} catch (Exception e) {
			System.out.println("Erro");
		}
		
	}
	

}