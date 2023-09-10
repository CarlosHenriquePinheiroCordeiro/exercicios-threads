package thread_socket_servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] agrs) throws IOException {
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(7000);
			while (true) {
				Socket conexao        = servidor.accept();
				ServidorThread server = new ServidorThread(conexao);
				server.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 

}