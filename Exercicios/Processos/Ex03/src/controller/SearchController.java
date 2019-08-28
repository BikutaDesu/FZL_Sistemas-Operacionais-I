package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SearchController implements ActionListener {
	
	private String processPath;
	private JTextField txtProcess;
	
	public SearchController(JTextField txtProcess) {
		this.txtProcess = txtProcess;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Buscar arquivo
	}
}
