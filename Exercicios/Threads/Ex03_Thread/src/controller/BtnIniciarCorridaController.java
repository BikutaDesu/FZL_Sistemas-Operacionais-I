package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class BtnIniciarCorridaController implements ActionListener {

	private JButton btnIniciarCorrida;
	private JLabel lblTempoCorrida; 
	private JLabel[] lblListaColocados;
	private JLabel[] lblSapos;
	private ThreadSapo[] threadSapos;
	
	public BtnIniciarCorridaController(JLabel lblTempoCorrida, JLabel[] lblListaColocados, JLabel[] lblSapos, JButton btnIniciarCorrida) {
		this.lblListaColocados = lblListaColocados;
		this.lblSapos = lblSapos;
		this.lblTempoCorrida = lblTempoCorrida;
		this.btnIniciarCorrida = btnIniciarCorrida;
		threadSapos = new ThreadSapo[lblSapos.length];
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		lblTempoCorrida.setText("Tempo: ");
		btnIniciarCorrida.setEnabled(false);
		for (int i = 0; i < threadSapos.length; i++) {
			lblSapos[i].setBounds(20,420 + (i * 25),50,50);
			lblListaColocados[i].setText("");
			threadSapos[i] = new ThreadSapo(i, lblTempoCorrida, lblListaColocados, lblSapos[i], btnIniciarCorrida);
			threadSapos[i].start();
		}
	}

}
