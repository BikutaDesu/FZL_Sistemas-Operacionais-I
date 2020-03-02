package view;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CharacterCheckBoxController;
import controller.ConfirmCharactersButtonController;
import util.ImageUtils;

public class SelectCharactersWindow extends JFrame {

	private JPanel contentPane;

	private JLabel[] charactersPortraits = new JLabel[7];
	private JLabel[] lblCharactersNames = new JLabel[7];
	private String[] charactersNames = { "Ayla", "Crono", "Frog", "Lucca", "Magus", "Marle", "Robo" };

	private JCheckBox[] charactersCheckBoxes = new JCheckBox[7];

	private JLabel lblTitle;

	private JButton btnStartRace;
	private JButton btnConfirmCharacters;

	public SelectCharactersWindow(JButton btnStartRace, Principal mainWindow) {
		this.btnStartRace = btnStartRace;

		setTitle("Select Characters");
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		WindowListener exitListener = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Are You Sure to Close this Application?",
						"Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == JOptionPane.YES_OPTION) {
					mainWindow.setVisible(true);
					dispose();
				}
			}
		};

		this.addWindowListener(exitListener);

		lblTitle = new JLabel("Select 3 Characters");
		lblTitle.setBounds(200, 20, 400, 40);
		lblTitle.setFont(new Font("Pixeled", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(JLabel.CENTER);

		btnConfirmCharacters = new JButton("Confirm Characters");
		btnConfirmCharacters.setBounds(300, 450, 200, 50);
		btnConfirmCharacters.setEnabled(false);
		ConfirmCharactersButtonController confirmCharactersButtonController = new ConfirmCharactersButtonController(mainWindow, btnStartRace, charactersCheckBoxes, this);
		btnConfirmCharacters.addActionListener(confirmCharactersButtonController);
		contentPane.add(btnConfirmCharacters);
		
		loadCharactersPortraits();

		contentPane.add(lblTitle);
	}

	public void loadCharactersPortraits() {
		CharacterCheckBoxController characterCheckBoxController = new CharacterCheckBoxController(charactersCheckBoxes, btnConfirmCharacters);
		for (int i = 0; i < charactersNames.length; i++) {
			String spriteSheetPath = "src/imgs/chrono trigger characters sprite sheet.png";
			Image characterPortrait = ImageUtils.getTile(spriteSheetPath, 0, i * 48, 48, 48);
			charactersPortraits[i] = new JLabel(new ImageIcon(characterPortrait));
			lblCharactersNames[i] = new JLabel(charactersNames[i]);

			lblCharactersNames[i].setFont(new Font("Pixeled", Font.BOLD, 12));
			lblCharactersNames[i].setBounds(30, 1 + (i * 80), 100, 30);
			charactersPortraits[i].setBounds(30, 30 + (i * 80), 48, 48);

			charactersCheckBoxes[i] = new JCheckBox();
			charactersCheckBoxes[i].setBounds(100, 3 + (i * 80), 100, 100);
			charactersCheckBoxes[i].addItemListener(characterCheckBoxController);

			contentPane.add(charactersCheckBoxes[i]);
			contentPane.add(lblCharactersNames[i]);
			contentPane.add(charactersPortraits[i]);
		}
	}

}
