package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class RunController implements ActionListener{

	private JFrame frame;
	private JTextField txtProcess;
	
	public RunController(JFrame frame, JTextField txtProcess) {
		this.frame = frame;
		this.txtProcess = txtProcess;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		callProcess(txtProcess.getText());
	}

	private void closeWindow() {
		frame.dispose();
	}
	
	private void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
			frame.dispose();
		} catch (IOException e) {
			if (e.getMessage().contains("740")) {
//				cmd /c process - /c -> credenciais
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
					frame.dispose();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Não foi possível executar o processo!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Não foi possível executar o processo, verifique o nome e tente novamente!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}
	
}
