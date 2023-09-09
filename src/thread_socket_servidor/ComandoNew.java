package thread_socket_servidor;

public class ComandoNew implements IComando{

	public String executa(Servico servico) {
		servico.comandoNew();
		return "Comando new() executado";
	}
	
	
}
