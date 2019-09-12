package controller;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ThreadBanner extends Thread {

	private JLabel lblPalavra;
	private JProgressBar progressBar;
	private JButton btnInicar;

	public ThreadBanner(JLabel lblPalavra, JProgressBar progressBar, JButton btnIniciar) {
		this.lblPalavra = lblPalavra;
		this.progressBar = progressBar;
		this.btnInicar = btnIniciar;
	}

	private void gerarBanner() {
		btnInicar.setEnabled(false);
		Thread tBarra = new ThreadProgressBar(progressBar);
		tBarra.start();

		int contador = 1;
		String txt = "";

		while (tBarra.isAlive()) {
			switch (contador) {
			case 1:
				txt = "Eu";
				break;
			case 2:
				txt = "Gosto de";
				break;
			case 3:
				txt = "Batata";
				break;
			}
			lblPalavra.setText(txt);
			contador++;
			if (contador == 4) contador = 1;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		btnInicar.setEnabled(true);
	}
	
	@Override
	public void run() {
		gerarBanner();
	}
}
