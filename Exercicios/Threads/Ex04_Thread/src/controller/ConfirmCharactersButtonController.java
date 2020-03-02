package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.Principal;

public class ConfirmCharactersButtonController implements ActionListener{
	
	private Principal mainWindow;
	private JFrame selectCharacterWindow;
	private JButton btnStartRace;
	private JCheckBox[] charactersCheckBoxes;
	private JLabel[] lblCharacters;
	
	
	public ConfirmCharactersButtonController(Principal mainWindow, JButton btnStartRace, JCheckBox[] charactersCheckBoxes, JFrame selectCharacterWindow) {
		this.mainWindow = mainWindow;
		this.btnStartRace = btnStartRace;
		this.charactersCheckBoxes = charactersCheckBoxes;
		this.selectCharacterWindow = selectCharacterWindow;
		this.lblCharacters = mainWindow.getCharactersLabel();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btnStartRace.setVisible(true);
		
		int[] selectedCharacters = new int[3];
		int selectedCharactersIndex = 0;
		int yLabelOffset = 0;
		
		for (int i = charactersCheckBoxes.length -1; i >= 0 ; i--) {
			if (charactersCheckBoxes[i].isSelected()) {
				selectedCharacters[selectedCharactersIndex] = i;
				selectedCharactersIndex++;
				lblCharacters[i].setBounds(80, 100 + (yLabelOffset * 30), 100, 100);
				lblCharacters[i].setVisible(true);
				yLabelOffset++;
			}
		}
		
		mainWindow.getContentPane().revalidate();
		mainWindow.getContentPane().repaint();
		mainWindow.setCharactersInRace(selectedCharacters);
		mainWindow.setVisible(true);
		btnStartRace.setEnabled(true);
		selectCharacterWindow.dispose();
	}

}
