package thread_socket_servidor;

public class ComandoNotify implements IComando{

	public String executa(Servico servico) {
		servico.comandoNotify();
		return "Comando notify() executado";
	}
	
	
}
