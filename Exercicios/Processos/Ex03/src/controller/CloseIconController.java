package controller;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class CloseIconController implements MouseListener {

	private JFrame frame;
	
	public CloseIconController(JFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		frame.dispose();
	}

	 @Override
     public void mouseEntered(MouseEvent e) {
         frame.setCursor(new Cursor(Cursor.HAND_CURSOR));
     }

     @Override
     public void mouseExited(MouseEvent e) {
         frame.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
     }

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
