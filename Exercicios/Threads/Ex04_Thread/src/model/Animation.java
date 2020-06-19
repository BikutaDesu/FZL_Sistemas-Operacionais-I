package model;

import java.awt.Image;
import java.awt.Rectangle;

import util.ImageUtils;

public class Animation {

	private Sprite[] frames;

	private Image currentFrame;

	private int currentFrameIndex = 0;
	private int milliDelay = 200;
	private int totalFrames;
	
	private String animationName;

	public Animation(String animationName, int totalFrames, Rectangle initialFrame) {
		String spriteSheetPath = "src/imgs/chrono trigger characters sprite sheet.png";
		this.totalFrames = totalFrames;
		this.animationName = animationName;
		
		frames = new Sprite[totalFrames];
		
		for (int i = 0; i < totalFrames; i++) {
			Image frame = ImageUtils.getTile(spriteSheetPath, initialFrame.x + (initialFrame.width * i), initialFrame.y, initialFrame.width, initialFrame.height);
			frames[i] = new Sprite(frame, initialFrame.width, initialFrame.height);
		}
		currentFrame = frames[currentFrameIndex].getImage();
	}

	public void jumpToNextFrame() {
		if (currentFrameIndex == totalFrames - 1) {
			currentFrameIndex = 0;
		} else {
			currentFrameIndex++;
		}
		currentFrame = frames[currentFrameIndex].getImage();
	}

	public Image getFrame() {
		return currentFrame;
	}

	public int getDelay() {
		return milliDelay;
	}
	
	public String getAnimationName() {
		return animationName;
	}
}
