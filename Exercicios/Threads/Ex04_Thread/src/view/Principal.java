package view;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SelectCharacterButtonController;
import controller.StartRaceButtonController;
import controller.ThreadCharacterController;
import util.ImageUtils;

public class Principal extends JFrame {

	private final int WINDOW_WIDTH = 1400;
	private final int WINDOW_HEIGHT = 390;
	private final float SPRITES_SCALE = 1.5f;

	private JPanel contentPane;

	/*
	 * 0 - ayla 1 - crono 2 - frog (glen) 3 - lucca 4 - magus 5 - marle 6 - robo
	 */
	private JLabel[] lblCharacters = new JLabel[7];

	private ThreadCharacterController[] threadCharacter = new ThreadCharacterController[7];
	private ThreadCharacterController[] threadCharactersInRace = new ThreadCharacterController[3];

	private int charactersTotalRunFrames[] = { 3, 6, 4, 6, 4, 6, 4 };
	private int charactersTotalWinFrames[] = { 4, 4, 2, 4, 2, 2, 4 };

	private String[] charactersNames = { "Ayla", "Crono", "Frog (Glen)", "Lucca", "Magus", "Marle", "Robo" };

	private JLabel lblBackgroud;

	private JButton btnStartRace;
	private JButton btnSelectCharacters;

	public Principal() {
		setTitle("Chrono Trigger Race");
		setBounds(100, 100, WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		btnStartRace = new JButton("Start race");
		btnStartRace.setBounds(10, 10, 100, 25);
		btnStartRace.setEnabled(false);

		btnSelectCharacters = new JButton("Select characters");
		btnSelectCharacters.setBounds(120, 10, 140, 25);
		btnSelectCharacters.setEnabled(true);
		SelectCharacterButtonController selectCharacterButtonController = new SelectCharacterButtonController(
				btnStartRace, this);
		btnSelectCharacters.addActionListener(selectCharacterButtonController);

		StartRaceButtonController startRaceButtonController = new StartRaceButtonController(btnStartRace,
				btnSelectCharacters, threadCharactersInRace, contentPane);
		btnStartRace.addActionListener(startRaceButtonController);
		contentPane.add(btnStartRace);
		contentPane.add(btnSelectCharacters);

		lblBackgroud = new JLabel(new ImageIcon(ImageUtils.resizeImage("src/imgs/zenan bridge.png",
				(int) (1024 * SPRITES_SCALE), (int) (240 * SPRITES_SCALE))));
		lblBackgroud.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
		lblBackgroud.setVerticalAlignment(JLabel.TOP);
		contentPane.add(lblBackgroud);
	}

	public void loadCharacters() {
		for (int i = 0; i < lblCharacters.length; i++) {
			lblCharacters[i] = new JLabel();
			contentPane.add(lblCharacters[i]);
			loadCharactersThread(i, threadCharacter[i], charactersNames[i], lblCharacters[i]);
		}
	}

	private void loadCharactersThread(int index, ThreadCharacterController threadCharacter, String characterName,
			JLabel lblCharacter) {
		threadCharacter = new ThreadCharacterController(characterName, lblCharacter, btnStartRace, btnSelectCharacters);

		threadCharacter.createAnimation("idle", 1, new Rectangle(96, 0 + (index * 32), 32, 32));
		threadCharacter.createAnimation("lose", 1, new Rectangle(544, 0 + (index * 32), 32, 32));
		threadCharacter.createAnimation("run", charactersTotalRunFrames[index],
				new Rectangle(160, 0 + (index * 32), 32, 32));
		threadCharacter.createAnimation("win", charactersTotalWinFrames[index],
				new Rectangle(384, 0 + (index * 32), 32, 32));
		threadCharacter.updateLabel();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setCharactersInRace(int[] charactersInRaceId) {
		for (int i = 0; i < charactersInRaceId.length; i++) {
			threadCharactersInRace[i] = threadCharacter[charactersInRaceId[i]];
		}
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JLabel[] getCharactersLabel() {
		return lblCharacters;
	}

}
