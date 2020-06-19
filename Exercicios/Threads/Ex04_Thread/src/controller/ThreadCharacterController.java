package controller;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ThreadCharacterController extends Thread {

	private AnimationController animationController;
	private JLabel lblCharacter;
	private JButton btnStartRace;
	private JButton btnSelectCharacters;
	private String name;
	private String[] places = { "st", "nd", "rd" };

	private int distance;
	private int maxDistance;

	private static int place;

	public ThreadCharacterController(String name, JLabel lblCharacter, JButton btnStartRace, JButton btnSelectCharacters) {
		this.name = name;
		this.lblCharacter = lblCharacter;
		this.btnStartRace = btnStartRace;
		this.btnSelectCharacters = btnSelectCharacters;
		this.place = 0;
		this.distance = 80;
		this.maxDistance = 1200;
		animationController = new AnimationController();

	}

	public void createAnimation(String animationName, int totalFrames, Rectangle initialFrame) {
		animationController.createAnimation(animationName, totalFrames, initialFrame);
	}

	@Override
	public void run() {
		startRun();
	}

	private void startRun() {
		float raceTime = 0;

		animationController.setAnimation("run");

		Rectangle characterRectangle;
		characterRectangle = lblCharacter.getBounds();
		lblCharacter.setBounds(characterRectangle);
		
		while (distance < maxDistance) {
			raceTime += System.currentTimeMillis();

			int randonDistance = (int) (Math.random() * 11) + 10;
			distance += randonDistance;

			System.out.printf("%s ran %d meters, total distance: %d\n", name, randonDistance, distance);

			characterRectangle.x += randonDistance;
			lblCharacter.setBounds(characterRectangle);

			updateAnimation();
		}
		place++;
		System.out.printf("%s finished the race in %d%s place!!\n", name, place, places[place - 1]);
		if (place == 1) {
			animationController.setAnimation("win");
			int i = 0;
			while (i < 10) {
				updateAnimation();
				i++;
			}
		} else {
			animationController.setAnimation("lose");
			int i = 0;
			while (i < 10) {
				updateAnimation();
				i++;
			}
		}

		if (place >= 3) {
//			btnStartRace.setEnabled(true);
			btnSelectCharacters.setEnabled(true);
		}		
		animationController.setAnimation("idle");
		updateAnimation();
		lblCharacter.setVisible(false);
	}

	public void updateAnimation() {
		animationController.jumpToNextAnimationFrame();
		updateLabel();
		try {
			Thread.sleep(animationController.getAnimationDelay());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void updateLabel() {
		lblCharacter.setIcon(new ImageIcon(animationController.getCurrentAnimationFrame()));
	}
	
	public void setPlace(int place) {
		this.place = place;
	}
}
