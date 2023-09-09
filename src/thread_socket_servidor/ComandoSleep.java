package thread_socket_servidor;

public class ComandoSleep implements IComando{

	public String executa(Servico servico) {
		try {
			servico.comandoSleep();
			return "Comando sleep() executado";
		} catch (InterruptedException e) {
			return "Erro ao executar comando sleep()";
		}
		
	}
	
	
}
