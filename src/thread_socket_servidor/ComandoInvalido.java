package thread_socket_servidor;

public class ComandoInvalido implements IComando {

	@Override
	public String executa(Servico servico) {
		return "Comando inválido informado";
	}
	
	
	

}
