package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SearchController implements ActionListener {
	
	private String processPath;
	private JTextField txtProcess;
	
	public SearchController(JTextField txtProcess) {
		this.txtProcess = txtProcess;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		searchProcess();
	}
	
	private void searchProcess() {
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Executáveis (.exe)", "exe");
		
		String systemPath = System.getProperty("user.home") + "/Desktop";
		File dir = new File(systemPath);
		
		JFileChooser chooseWindow = new JFileChooser();
		chooseWindow.setCurrentDirectory(dir);
		chooseWindow.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooseWindow.setAcceptAllFileFilterUsed(false);
		chooseWindow.addChoosableFileFilter(filter);
		
		String processPath = "";
		
		int chooseWindowReturn = chooseWindow.showOpenDialog(null);
		if (chooseWindowReturn == JFileChooser.APPROVE_OPTION) {
			processPath = chooseWindow.getSelectedFile().getAbsolutePath();
			txtProcess.setText(processPath);
		}
	}
}
