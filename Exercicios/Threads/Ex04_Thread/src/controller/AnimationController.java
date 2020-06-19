package controller;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import model.Animation;

public class AnimationController {

	private List<Animation> animations;
	private Animation currentAnimation;
	
	private int totalAnimations = 0;
	
	public AnimationController() {
		animations = new ArrayList<Animation>();
	}
	
	public void createAnimation(String animationName, int totalFrames, Rectangle initialFrame) {
		Animation anim = new Animation(animationName, totalFrames, initialFrame);
		animations.add(anim);
		if (totalAnimations == 0) {
			currentAnimation = anim;
		}
		totalAnimations++;
	}
	
	public void setAnimation(String animationName) {
		if (totalAnimations > 0) {
			for (Animation animation : animations) {
				if (animation.getAnimationName().equals(animationName)) {
					currentAnimation = animation;
				}
			}
		}
	}
	
	public void jumpToNextAnimationFrame() {
		if (totalAnimations > 0) {
			currentAnimation.jumpToNextFrame();
		}	
	}
	
	public int getAnimationDelay() {
		return currentAnimation.getDelay();
	}
	
	public Image getCurrentAnimationFrame() {
		return currentAnimation.getFrame();
	}
}
