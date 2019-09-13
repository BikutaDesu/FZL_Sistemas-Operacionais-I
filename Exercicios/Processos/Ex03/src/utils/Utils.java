package utils;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import view.RunWindow;

public class Utils {
	
	public static Font getCustomFont(String path, float size) {
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(font);
			font = font.deriveFont(size);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		
		return font;
	}
	
	public static void getCustomIconForLabel(JLabel label, String path) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("./src" + path));
			Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
			label.setIcon(new ImageIcon(dimg));
		} catch (IOException e) {
			label.setIcon(new ImageIcon(RunWindow.class.getResource(path)));
		}
	}
	
	
}
