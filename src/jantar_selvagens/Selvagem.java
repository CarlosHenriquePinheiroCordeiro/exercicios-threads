package jantar_selvagens;

public class Selvagem implements Runnable {

	private static Jantar jantar;
	
	public Selvagem(Jantar j, int n) {
		jantar = j;
		new Thread(this, "Selvagem "+n).start();;
	}
	
	@Override
	public void run() {
		try {
			jantar.jantar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void tchan() {
		
	}
	
	
}