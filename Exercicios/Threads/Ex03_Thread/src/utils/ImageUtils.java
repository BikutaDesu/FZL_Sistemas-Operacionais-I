package utils;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtils {
	
	public static Image resizeImage(String path, int width, int height) {
		try {
			Image img = ImageIO.read(new File(path));
			final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        
			Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	        
	        return tmp;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
