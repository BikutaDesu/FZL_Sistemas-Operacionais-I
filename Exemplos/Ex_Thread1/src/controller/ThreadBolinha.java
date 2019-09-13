package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadBolinha extends Thread {

	private JLabel lblBolinha;
	private JButton btnIniciar;

	public ThreadBolinha(JLabel lblBolinha, JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
		this.lblBolinha = lblBolinha;
	}

	private void mexeBolinha() {
		btnIniciar.setEnabled(false);

		Rectangle posicao;
		posicao = lblBolinha.getBounds();
		lblBolinha.setBounds(posicao);
		int contadorMov = 0;
		while (contadorMov <= 12) {
			if (contadorMov <= 2) {
				posicao.y += 10;
			} else if (contadorMov <= 6) {
				posicao.x += 20;
			} else if (contadorMov <= 9) {
				posicao.y -= 10;
			} else if (contadorMov <= 12) {
				posicao.x -= 20;
			}
			lblBolinha.setBounds(posicao);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			contadorMov++;
		}
		btnIniciar.setEnabled(true);
	}
	
	@Override
	public void run() {
		mexeBolinha();
	}

}
