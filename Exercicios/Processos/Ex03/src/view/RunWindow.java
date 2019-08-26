package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class RunWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtProcess;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RunWindow frame = new RunWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public RunWindow() {
		setBackground(new Color(0, 0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage(RunWindow.class.getResource("/imgs/vaporwave_run_icon.png")));
		setResizable(false);
		BufferedImage img = null;
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("/font/Roboto-Medium.ttf").openStream());
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(font);
			font = font.deriveFont(14f);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			e2.printStackTrace();
		}

		setTitle("Run");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 496, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnWindow = new JPanel() {
			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0, new Color(148, 208, 255,0), getWidth(), getHeight(),
						new Color(255, 106, 213,0));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		pnWindow.setBounds(0, 0, 495, 194);
		contentPane.add(pnWindow);
		pnWindow.setLayout(null);

		JLabel lblRunIcon = new JLabel();
		lblRunIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblRunIcon.setBounds(10, 10, 55, 55);
		try {
			img = ImageIO.read(new File("./src/imgs/vaporwave_run_icon.png"));
			Image dimg = img.getScaledInstance(lblRunIcon.getWidth(), lblRunIcon.getHeight(), Image.SCALE_SMOOTH);
			lblRunIcon.setIcon(new ImageIcon(dimg));
		} catch (IOException e) {
			lblRunIcon.setIcon(new ImageIcon(RunWindow.class.getResource("/imgs/vaporwave_run_icon.png")));
		}
		pnWindow.add(lblRunIcon);

		JLabel lblAbrir = new JLabel("Abrir:");
		lblAbrir.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbrir.setFont(font);
		lblAbrir.setBounds(20, 92, 46, 27);
		pnWindow.add(lblAbrir);

		txtProcess = new JTextField();
		txtProcess.setBounds(68, 89, 417, 30);
		pnWindow.add(txtProcess);
		txtProcess.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(166, 147, 89, 23);
		btnOk.setFont(font);
		pnWindow.add(btnOk);

		JButton btnProcurar = new JButton("Procurar...");
		btnProcurar.setBounds(380, 147, 105, 23);
		btnProcurar.setFont(font);
		pnWindow.add(btnProcurar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(265, 147, 105, 23);
		btnCancelar.setFont(font);
		pnWindow.add(btnCancelar);

		JTextArea txtAreaTitle = new JTextArea();
		txtAreaTitle.setLineWrap(true);
		txtAreaTitle.setFont(font);
		txtAreaTitle.setBackground(new Color(0, 0, 0, 0));
		txtAreaTitle.setEditable(false);
		txtAreaTitle.setText(
				"Digite o nome do programa para ser executado, voc\u00EA tamb\u00E9m pode especificar o caminho da aplica\u00E7\u00E3o que deseja executar...");
		txtAreaTitle.setBounds(75, 20, 411, 45);
		pnWindow.add(txtAreaTitle);
	}
}
