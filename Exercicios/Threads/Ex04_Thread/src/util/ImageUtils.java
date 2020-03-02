package util;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {

	public static Image resizeImage(String path, int width, int height) {
		try {
			Image img = ImageIO.read(new File(path));
	        
			Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        
	        return tmp;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Image resizeImage(Image originalImage, int width, int height) {
		try {
			Image tmp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        
	        return tmp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Image getTile(String path, int x, int y, int width, int height) {
		try {
			BufferedImage img = ImageIO.read(new File(path));
			Image tile = img.getSubimage(x, y, width, height);
			return tile;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
