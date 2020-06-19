package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import view.Principal;
import view.SelectCharactersWindow;

public class SelectCharacterButtonController implements ActionListener{

	private JButton btnStartRace;
	private Principal mainWindow;
	
	public SelectCharacterButtonController(JButton btnStartRace, Principal mainWindow) {
		this.btnStartRace = btnStartRace;
		this.mainWindow = mainWindow;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		SelectCharactersWindow selectCharactersWindow = new SelectCharactersWindow(btnStartRace, mainWindow);
		mainWindow.setVisible(false);
		mainWindow.getContentPane().revalidate();
		mainWindow.getContentPane().repaint();
		selectCharactersWindow.setVisible(true);
	}

	
	
}
