package thread_socket_servidor;

import java.util.ArrayList;
import java.util.Hashtable;

public class Servico {

	private ArrayList<ThreadFibonacci> th = new ArrayList<ThreadFibonacci>();
	
	public String executaComando(String comando) {
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
		String retorno = "";
		for (int i = 0; i < this.th.size(); i++) {
			retorno += "Sequência "+i+": "+th.get(i).getSequencia()+".\n";
		}
		return retorno;
	}
	
	public void comandoNew() {
		ThreadFibonacci t = new ThreadFibonacci();
		th.add(t);
		t.start();
	}
	
	public void comandoSleep() throws InterruptedException {
		for (ThreadFibonacci t : th) {
			t.sleep(10000);
		}
	}
	
	public void comandoWait() throws InterruptedException {
		for (ThreadFibonacci t : th) {
			t.wait();
		}
	}
	
	public void comandoNotify() {
		for (ThreadFibonacci t : th) {
			t.notify();
		}
	}
	
	
}
