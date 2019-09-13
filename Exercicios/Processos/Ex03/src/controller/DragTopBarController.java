package controller;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class DragTopBarController implements MouseMotionListener {

	private JFrame frame;
	private Point mousePoint;
	
	public DragTopBarController(JFrame frame, Point mousePoint) {
		this.frame = frame;
		this.mousePoint = mousePoint;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		int thisX = frame.getLocation().x;
        int thisY = frame.getLocation().y;

        int xMoved = e.getX() - mousePoint.x;
        int yMoved = e.getY() - mousePoint.y;

        int X = thisX + xMoved;
        int Y = thisY + yMoved;
        frame.setLocation(X, Y);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
