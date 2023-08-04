package exercicio3;

import javax.swing.JLabel;

public class Marcador extends Thread {
	
	private JLabel labelTela;
	private int valor = 0;
	private boolean continua = true;
	private boolean iniciado = false;
	
	@Override
	public synchronized void start() {
		setIniciado(true);
		super.start();
	}
	
	@Override
	public void run() {
		Thread.currentThread();
		Thread.yield();
		while (true) {
			Thread.yield();
			while (continua) {
				Thread.yield();
				this.valor++;
				atualizaValor(this.valor);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Marcador(JLabel label) {
		this.labelTela = label;
	}
	
	protected void atualizaValor(int valor) {
		this.labelTela.setText(String.valueOf(valor));
	}
	
	public void retomaContagem() {
		this.continua = true;
	}
	
	public void pausaContagem() {
		this.continua = false;
	}
	
	public void paraContagem() {
		this.valor = 0;
		atualizaValor(0);
		this.continua = false;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public boolean isContinua() {
		return continua;
	}

	public void setContinua(boolean continua) {
		this.continua = continua;
	}

	public boolean isIniciado() {
		return iniciado;
	}

	public void setIniciado(boolean iniciado) {
		this.iniciado = iniciado;
	}
	

}