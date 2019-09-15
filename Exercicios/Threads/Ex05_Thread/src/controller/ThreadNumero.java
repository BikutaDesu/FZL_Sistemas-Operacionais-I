package controller;

import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ThreadNumero extends Thread {

	private int id;
	private static int numeroGerado;
	
	private JTextField txtNumero;
	private JButton btnIniciar;

	private Random random;
	
	private static int[] numerosSorteados = new int[3];
	
	
	public ThreadNumero(JTextField txtNumero, JButton btnIniciar, int id) {
		this.txtNumero = txtNumero;
		this.btnIniciar = btnIniciar;
		this.id = id;
		random = new Random();
		numerosSorteados[id] = 0;
		numeroGerado = 0;
	}

	@Override
	public void run() {
		gerarNumero();
	}

	public void gerarNumero() {
		for (int i = 0; i < 150; i++) {
			numerosSorteados[id] = random.nextInt(7) + 1;
			txtNumero.setText(Integer.toString(numerosSorteados[id]));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		numeroGerado++;
		
		if ((numeroGerado == 3) &&(numerosSorteados[0] != 0 && numerosSorteados[1] != 0 && numerosSorteados[2] != 0)) {
			btnIniciar.setEnabled(true);
			int ni = 0;
			for (int i = 0; i < numerosSorteados.length-1; i++) {
				if (numerosSorteados[i] == numerosSorteados[i+1]) {
					ni++;
				}
			}
			if (ni == 2) {
				System.out.println("Venceu!");
			}
		}
		

	}

}
