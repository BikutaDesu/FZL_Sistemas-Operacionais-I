package controller;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JLabel;

import utils.MathUtils;

public class ThreadSapo extends Thread{

	private JLabel lblTempoCorrida;
	private JLabel[] lblListaColocados;
	private JLabel lblSapo;
	private JButton btnIniciarCorrida;
	
	private int idSapo;
	private int distanciaPulo;
	private int distanciaPercorrida;
	private int distanciaMaxima;
	
	public static int posicao;
	
	public ThreadSapo(int idSapo, JLabel lblTempoCorrida, JLabel[] lblListaColocados, JLabel lblSapo, JButton btnIniciarCorrida) {
		this.lblListaColocados = lblListaColocados;
		this.lblSapo = lblSapo;
		this.lblTempoCorrida = lblTempoCorrida;
		this.btnIniciarCorrida = btnIniciarCorrida;
		distanciaPercorrida = 0;
		distanciaMaxima = 750;
		this.idSapo = idSapo;
		posicao = 1;
	}
	
	@Override
	public void run() {
		iniciar();
	}
	
	private void iniciar() {
		float tempoCorrida = 0;
		
		int sapoY = lblSapo.getBounds().y;
		
		while (distanciaPercorrida < distanciaMaxima) {
			tempoCorrida += System.currentTimeMillis();
			lblTempoCorrida.setText("Tempo: " + tempoCorrida + "s");
			
			distanciaPulo = (int)(Math.random() * 100);
			distanciaPercorrida += distanciaPulo;
			
			System.out.printf("O Sapo %d, pulou %d metros, distancia percorrida: %d\n", idSapo, distanciaPulo, distanciaPercorrida);
			
			pular(lblSapo.getBounds().x, sapoY, distanciaPercorrida, sapoY);
			
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		
		System.out.printf("O Sapo %d chegou ao final! %dº colocado\n", idSapo, posicao);
		lblListaColocados[idSapo].setText(posicao + "º");
		posicao++;
		if (posicao > 5 ) {
			btnIniciarCorrida.setEnabled(true);
		}
	}
	
	private void pular(int xA, int yA, int xF, int yF) {
		int xC = (xF + xA) / 2;
		int yC = yA - 100;
		
		int[] xPointList = {xA, xC, xF};
		int[] yPointList = {yA, yC, yF};
		
		Rectangle posicaoSapo = lblSapo.getBounds();
		
		for (float t = 0; t <= 1; t+=0.01f) {
			posicaoSapo.x = MathUtils.Bezier(t, xPointList);
			posicaoSapo.y = MathUtils.Bezier(t, yPointList);
			lblSapo.setBounds(posicaoSapo);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
