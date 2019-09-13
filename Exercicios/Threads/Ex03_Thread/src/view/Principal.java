package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.BtnIniciarCorridaController;
import utils.ImageUtils;

public class Principal extends JFrame {

	private JPanel contentPane;
	
	private JLabel lblBackground;
	private JButton btnIniciarCorrida;
	private JLabel lblTempoCorrida, lblClassificacao;
	private JLabel[] lblListaColocados = new JLabel[5];
	private JLabel[] lblSapos = new JLabel[5];
	
	private int windowWidth = 1000;
	private int windowHeight = 600;
	
	private Image[] sapoImageList = new Image[6];
	
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
		setTitle("Corrida de Sapos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, windowWidth, windowHeight);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		for (int i = 0; i < sapoImageList.length; i++) {
			sapoImageList[i] = ImageUtils.resizeImage("src/imgs/sapo"+(i+1)+".png", 50, 50);
		}
		
		Random random = new Random();
		
		for (int i = lblSapos.length-1; i >= 0; i--) {
			int imageI = random.nextInt(6);
			lblSapos[i] = new JLabel(new ImageIcon(sapoImageList[imageI]));
			lblSapos[i].setBounds(20, 420 + (i * 30), 50, 50);
			contentPane.add(lblSapos[i]);
			
			lblListaColocados[i] = new JLabel();
			lblListaColocados[i].setBounds(900, 420 + (i * 30), 50, 50);
			lblListaColocados[i].setFont(new Font("Montserrat", Font.BOLD, 16));
			contentPane.add(lblListaColocados[i]);
		}

		lblTempoCorrida = new JLabel("Tempo: ");
		lblTempoCorrida.setBounds(150, 10, 200, 25);
		lblTempoCorrida.setFont(new Font("Montserrat", Font.BOLD, 18));
		contentPane.add(lblTempoCorrida);

		lblClassificacao = new JLabel("Classificação");
		lblClassificacao.setBounds(860, 380, 140, 25);
		lblClassificacao.setFont(new Font("Montserrat", Font.BOLD, 18));
		contentPane.add(lblClassificacao);

		btnIniciarCorrida = new JButton("Iniciar Corrida");
		BtnIniciarCorridaController btnIniciarCorridaController = new BtnIniciarCorridaController(lblTempoCorrida,
				lblListaColocados, lblSapos, btnIniciarCorrida);
		btnIniciarCorrida.setBounds(10, 10, 120, 25);
		btnIniciarCorrida.addActionListener(btnIniciarCorridaController);
		contentPane.add(btnIniciarCorrida);
		
		lblBackground = new JLabel(new ImageIcon(ImageUtils.resizeImage("src/imgs/cenario-sapos.png", windowWidth,windowHeight)));
		lblBackground.setBounds(0,0,windowWidth,windowHeight);
		contentPane.add(lblBackground);
		
	}
	
	

}
