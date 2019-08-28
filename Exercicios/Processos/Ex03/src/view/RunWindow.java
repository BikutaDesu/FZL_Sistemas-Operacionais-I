package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.Utils;
public class RunWindow extends JFrame {

	private JPanel contentPane;
	private JTextField txtProcess;
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(RunWindow.class.getResource("/imgs/vaporwave_run_icon.png")));
		setResizable(false);
		
		Font font = Utils.getCustomFont("src/font/Roboto-Medium.ttf", 14f);
		

		setTitle("Run");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setUndecorated(true);
		setBackground(new Color(1.0f,1.0f,1.0f,0));
		
		JPanel pnControl = new JPanel();
		pnControl.setBounds(0, 0, 495, 28);
		pnControl.setBackground(new Color(30,30,30));
		contentPane.add(pnControl);
		pnControl.setLayout(null);
		
		JLabel lblClose = new JLabel("close");
		lblClose.setBounds(467, 0, 28, 28);
		Utils.getCustomIconForLabel(lblClose, "/imgs/vaporwave_close_icon.png");
		pnControl.add(lblClose);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setBounds(429, 0, 28, 28);
		Utils.getCustomIconForLabel(lblMin, "/imgs/vaporwave_min_icon.png");
		pnControl.add(lblMin);

		JPanel pnWindow = new JPanel() {
			@Override
			public void setBackground(Color bg) {
				super.setBackground(new Color(0,0,0,0));
			}
			
			@Override
			protected void paintComponent(Graphics grphcs) {
				super.paintComponent(grphcs);
				Graphics2D g2d = (Graphics2D) grphcs;
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				GradientPaint gp = new GradientPaint(0, 0, new Color(148, 208, 255, 230), getWidth(), getHeight(),
						new Color(255, 106, 213, 230));
				g2d.setPaint(gp);
				g2d.fillRect(0, 0, getWidth(), getHeight());

			}
		};
		
		pnWindow.setBounds(0, 28, 495, 194);
		contentPane.add(pnWindow);
		pnWindow.setLayout(null);

		JLabel lblRunIcon = new JLabel();
		lblRunIcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblRunIcon.setBounds(10, 10, 55, 55);
		Utils.getCustomIconForLabel(lblRunIcon, "/imgs/vaporwave_run_icon.png");
		
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
