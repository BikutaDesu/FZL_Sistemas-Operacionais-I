/*
 * Fazer uma aplicação, em Java, que tenha, na tela, uma JProgressBar, um JLabel e um JButton. A aplicação deve ter duas
 * Threads. A primeira, fará com que a JProgressBar incremente, num intervalo de 20 mS. A segunda, enquanto a primeira
 * estiver viva, irá alternando 3 palavras em um tempo de exibição constante, de 100 mS. O Botão deve iniciar a chamada
 * das Threads e fazer com que ele próprio desapareça.
*/

package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import controller.ProgressBarController;

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
		contentPane.setLayout(null);
		setContentPane(contentPane);

		final JLabel lblPalavra = new JLabel(" ");
		lblPalavra.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPalavra.setBounds(10, 132, 98, 49);
		contentPane.add(lblPalavra);

		final JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(10, 35, 188, 42);
		contentPane.add(progressBar);
		
		JButton btnIniciar = new JButton("Início");
		btnIniciar.setBounds(10, 228, 89, 23);
		ProgressBarController progressBarController = new ProgressBarController(lblPalavra, progressBar, btnIniciar);
		btnIniciar.addActionListener(progressBarController);
		contentPane.add(btnIniciar);
	}

}
