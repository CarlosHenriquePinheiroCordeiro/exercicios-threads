package thread_socket_servidor;

public class ComandoVerSequencia implements IComando{

	public String executa(Servico servico) {
		return servico.comandoVerSequencia();
	}
	
	
}
