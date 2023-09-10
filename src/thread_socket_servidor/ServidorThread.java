package thread_socket_servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Hashtable;

public class ServidorThread extends Thread {
	
	private Socket socket;
	private PrintWriter saida;
	
	public ServidorThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			saida                  = new PrintWriter(socket.getOutputStream(), true);
			Servico servico        = new Servico();
			while (true) {
				String inputCliente = entrada.readLine();
				if (inputCliente.equals("sair")) {
					break;
				}
				String[] input = inputCliente.split(",");
				saida.println("Executando "+input[0]);
				saida.println(servico.executaComando(input[0], Integer.parseInt(input[1])));
			}
		} catch (IOException e) {
			saida.println(e.getMessage());
		}
	}
	

}