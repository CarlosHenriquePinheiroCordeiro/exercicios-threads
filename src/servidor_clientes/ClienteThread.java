package servidor_clientes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteThread implements Runnable {

	private Socket         socket;
	private BufferedReader entrada;
	
	public ClienteThread(Socket cliente) throws IOException {
		this.socket = cliente;
		this.entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				System.out.println(entrada.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				entrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}