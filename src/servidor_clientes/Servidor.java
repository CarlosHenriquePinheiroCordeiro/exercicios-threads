package servidor_clientes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {

	public static void main(String[] agrs) throws IOException {
		ServerSocket 			  servidor = null;
		ArrayList<ServidorThread> ls       = new ArrayList<ServidorThread>();
		try {
			servidor = new ServerSocket(7000);
			while (true) {
				Socket conexao        = servidor.accept();
				ServidorThread server = new ServidorThread(conexao, ls);
				ls.add(server);
				server.start();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 

}