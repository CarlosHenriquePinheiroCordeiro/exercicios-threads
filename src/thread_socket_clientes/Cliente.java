package thread_socket_clientes;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
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
				System.out.println("\n---------------------------------------------------------------------------");
				System.out.println("Informe um comando:");
				System.out.println("verSequencia (Visualiza o número atual da(s) sequência(s) de Fibonacci)");
				System.out.println("new");
				System.out.println("sleep");
				System.out.println("wait");
				System.out.println("notify");
				System.out.println("---------------------------------------------------------------------------\n");
				texto = sc.next();
				String comando = texto+",";
				if (!getComandosSemIndice().contains(texto)) {
					System.out.println("Informe o ID da sequência para executar o comando");
					texto = ""+(sc.nextInt()-1);
				} else {
					texto = ""+0;
				}
				comando += texto;
				saida.println(comando);
			} while (!"sair".equals(texto));
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static ArrayList<String> getComandosSemIndice() {
		ArrayList<String> cmSemIndice = new ArrayList<String>();
		cmSemIndice.add("verSequencia");
		cmSemIndice.add("new");
		return cmSemIndice;
	}
	

}