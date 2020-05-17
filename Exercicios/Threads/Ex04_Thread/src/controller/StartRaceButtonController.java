package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class StartRaceButtonController implements ActionListener{

	private JButton btnStartRace;
	private JButton btnSelectCharacters;
	private ThreadCharacterController[] charactersInRace;
	private JPanel contentPane;
	
	public StartRaceButtonController(JButton btnStartRace, JButton btnSelectCharacters,
			ThreadCharacterController[] charactersInRace, JPanel contentPane) {
		super();
		this.btnStartRace = btnStartRace;
		this.btnSelectCharacters = btnSelectCharacters;
		this.charactersInRace = charactersInRace;
		this.contentPane = contentPane;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		btnStartRace.setEnabled(false);
		btnSelectCharacters.setEnabled(false);
		for (int i = 0; i < charactersInRace.length; i++) {
			charactersInRace[i].setPlace(0);
			charactersInRace[i].start();
		}
	}

}
