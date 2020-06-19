package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class CharacterCheckBoxController implements ItemListener {

	private final int MAX_SELECTIONS = 3;

	private int selectionCounter = 0;

	private JCheckBox[] charactersCheckBoxes;

	private JButton btnConfirmCharacters;
	
	public CharacterCheckBoxController(JCheckBox[] charactersCheckBoxes, JButton btnConfirmCharacters) {
		this.charactersCheckBoxes = charactersCheckBoxes;
		this.btnConfirmCharacters = btnConfirmCharacters;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		JCheckBox source = (JCheckBox) e.getSource();

		if (source.isSelected()) {
			selectionCounter++;
			if (selectionCounter == MAX_SELECTIONS) {
				for (JCheckBox box : charactersCheckBoxes) {
					if (!box.isSelected()) {
						box.setEnabled(false);
					}
				}
				btnConfirmCharacters.setEnabled(true);
			}
		} else {
			selectionCounter--;
			if (selectionCounter < MAX_SELECTIONS) {
				for (JCheckBox box : charactersCheckBoxes) {
					box.setEnabled(true);
				}
				btnConfirmCharacters.setEnabled(false);
			}

		}
	}

}
