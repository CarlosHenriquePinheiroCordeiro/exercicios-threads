package thread_socket_servidor;

import java.util.ArrayList;
import java.util.Hashtable;

public class Servico {

	private Fibonacci fb;
	private ArrayList<ThreadFibonacci> th = new ArrayList<ThreadFibonacci>();
	private int indice;
	
	public Servico() {
		this.fb = new Fibonacci();
	}
	
	public String executaComando(String comando, int indice) {
		this.indice = indice;
		return getComando(comando).executa(this);
	}
	
	private IComando getComando(String comando) {
		Hashtable<String, IComando> comandos = getTabelaComandos();
		IComando c = new ComandoInvalido();
		if (comandos.containsKey(comando))
			c = comandos.get(comando);
		return c;
	}
	
	private Hashtable<String, IComando> getTabelaComandos() {
		Hashtable<String, IComando> ht = new Hashtable<String, IComando>();
		ht.put("verSequencia", new ComandoVerSequencia());
		ht.put("new"		 , new ComandoNew());
		ht.put("sleep"		 , new ComandoSleep());
		ht.put("wait"		 , new ComandoWait());
		ht.put("notify"		 , new ComandoNotify());
		return ht;
	}
	
	public String comandoVerSequencia() {
		return ""+fb.getSequencia();
	}
	
	public void comandoNew() {
		ThreadFibonacci t = new ThreadFibonacci(fb);
		th.add(t);
		t.start();
	}
	
	public void comandoSleep() throws InterruptedException {
		th.get(indice).dorme();
	}
	
	public void comandoWait() throws InterruptedException {
		th.get(indice).espera();
	}
	
	public void comandoNotify() {
		th.get(indice).notifica();
	}
	
	
}