package view;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.CloseIconController;
import controller.MinimizeIconController;
import utils.Utils;

public class TopBar extends JPanel {

	private Point initialClick;
	private JFrame frame;

	public TopBar(final JFrame frame) {
		this.frame = frame;

		setBounds(0, 0, 495, 28);
		setBackground(new Color(30,30,30));
		setLayout(null);
		
		CloseIconController closeIconController = new CloseIconController(frame);
		JLabel lblClose = new JLabel("close");
		lblClose.setBounds(467, 0, 28, 28);
		Utils.getCustomIconForLabel(lblClose, "/imgs/vaporwave_close_icon.png");
		lblClose.addMouseListener(closeIconController);
		add(lblClose);
		
		MinimizeIconController minimizeIconController = new MinimizeIconController(frame);
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(429, 0, 28, 28);
		Utils.getCustomIconForLabel(lblMin, "/imgs/vaporwave_min_icon.png");
		lblMin.addMouseListener(minimizeIconController);
		add(lblMin);
		
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				initialClick = e.getPoint();
				getComponentAt(initialClick);
			}
		});

		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {

				// get location of Window
				int thisX = frame.getLocation().x;
				int thisY = frame.getLocation().y;

				// Determine how much the mouse moved since the initial click
				int xMoved = e.getX() - initialClick.x;
				int yMoved = e.getY() - initialClick.y;

				// Move window to this position
				int X = thisX + xMoved;
				int Y = thisY + yMoved;
				frame.setLocation(X, Y);
			}
		});
	}
}
