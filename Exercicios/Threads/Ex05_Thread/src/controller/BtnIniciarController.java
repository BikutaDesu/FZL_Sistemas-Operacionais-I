package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BtnIniciarController implements ActionListener{

	private JTextField txtNumeros[];
	private JButton btnIniciar;
	private ThreadNumero[] numerosThread;
	
	public BtnIniciarController(JTextField txtNumeros[], JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
		this.txtNumeros = txtNumeros;
		
		numerosThread = new ThreadNumero[3];
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		btnIniciar.setEnabled(false);
		
		for (int i = 0; i < numerosThread.length; i++) {
			numerosThread[i] = new ThreadNumero(txtNumeros[i], btnIniciar, i);
			numerosThread[i].start();
		}
	}
	
}
