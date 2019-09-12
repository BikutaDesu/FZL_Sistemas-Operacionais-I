package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BolinhaController;

import javax.swing.JLabel;

public class Principal extends JFrame {

	private JPanel contentPane;

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

	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblBolinha1 = new JLabel(".");
		lblBolinha1.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblBolinha1.setBounds(58, 64, 68, 74);
		contentPane.add(lblBolinha1);
		
		JLabel lblBolinha2 = new JLabel(".");
		lblBolinha2.setFont(new Font("Tahoma", Font.BOLD, 70));
		lblBolinha2.setBounds(313, 64, 68, 74);
		contentPane.add(lblBolinha2);
		
		
		JButton btnIniciar = new JButton("Iniciar");
		BolinhaController bolinhaController = new BolinhaController(lblBolinha1, lblBolinha2, btnIniciar);
		btnIniciar.setBounds(0,0,89,23);
		btnIniciar.addActionListener(bolinhaController);
		contentPane.add(btnIniciar);
		
		
		
		
	}
}
