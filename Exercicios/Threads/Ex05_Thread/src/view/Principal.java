package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnIniciarController;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	private JTextField[] txtNumeros = new JTextField[3];
	
	private JButton btnIniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		for (int i = 0; i < txtNumeros.length; i++) {
			txtNumeros[i] = new JTextField();
			txtNumeros[i].setHorizontalAlignment(SwingConstants.CENTER);
			txtNumeros[i].setFont(new Font("Century Gothic", Font.BOLD, 24));
			txtNumeros[i].setText("7");
			txtNumeros[i].setEditable(false);
			txtNumeros[i].setBounds(110 + (i * 70), 85, 60, 50);
			contentPane.add(txtNumeros[i]);
			txtNumeros[i].setColumns(10);
		}
		
		btnIniciar = new JButton("Iniciar");
		btnIniciar.setHorizontalAlignment(SwingConstants.CENTER);
		btnIniciar.setFont(new Font("Century Gothic", Font.BOLD, 24));
		btnIniciar.setBounds(110, 180, 200, 50);
		BtnIniciarController btnIniciarController = new BtnIniciarController(txtNumeros, btnIniciar);
		btnIniciar.addActionListener(btnIniciarController);
		contentPane.add(btnIniciar);
	}
}
