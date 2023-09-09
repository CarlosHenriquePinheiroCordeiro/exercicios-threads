package thread_socket_servidor;

public class ComandoWait implements IComando{

	public String executa(Servico servico) {
		try {
			servico.comandoWait();
			return "Comando wait() executado";
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return "Erro ao executar comando wait()";
		}
		
	}
	
	
}
