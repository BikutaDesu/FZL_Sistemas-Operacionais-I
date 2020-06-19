package model;

import java.awt.Image;

import util.ImageUtils;

public class Sprite {

	private Image image;

	private final float SPRITE_SCALE = 1.5f;

	public Sprite(Image image, int width, int height) {
		this.image = ImageUtils.resizeImage(image, (int) (width * SPRITE_SCALE), (int) (height * SPRITE_SCALE));
	}

	public Image getImage() {
		return image;
	}

}
