package servidor_clientes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorThread extends Thread {
	
	private Socket socket;
	private ArrayList<ServidorThread> servidores;
	private PrintWriter saida;
	
	public ServidorThread(Socket socket, ArrayList<ServidorThread> servidores) {
		this.socket     = socket;
		this.servidores = servidores;
	}
	
	@Override
	public void run() {
		try {
			BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			saida                  = new PrintWriter(socket.getOutputStream(), true);
			
			while (true) {
				String inputCliente = entrada.readLine();
				if (inputCliente.equals("sair")) {
					break;
				}
				for (ServidorThread servidor : servidores) {
					servidor.saida.println(inputCliente);
				}
				System.out.println("Servidor recebeu: "+inputCliente);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}