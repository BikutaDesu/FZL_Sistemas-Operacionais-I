package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class ProgressBarController implements ActionListener{

	private JLabel lblPalavra;
	private JProgressBar progressBar;
	private JButton btnIniciar;
	
	public ProgressBarController(JLabel lblPalavra, 
			JProgressBar progressBar, 
			JButton btnIniciar) {
		this.btnIniciar = btnIniciar;
		this.lblPalavra = lblPalavra;
		this.progressBar = progressBar;
	}
	
	public void acaoBarra() {
		btnIniciar.setEnabled(false);
		Thread tBanner = new ThreadBanner(lblPalavra, progressBar, btnIniciar);
		tBanner.start();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		acaoBarra();
	}

	
	
}
