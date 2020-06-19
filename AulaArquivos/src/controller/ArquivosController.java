package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController{

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for (File file : files) {
				if (file.isFile()) {
					System.out.println("     \t" + file.getName());
				} else {
					System.out.println("<DIR>\t" + file.getName());
				}
			}
		} else {
			throw new IOException("Diretório inválido!");
		}
	}

	@Override
	public void createFile(String path, String name) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name);
		if (dir.exists() && dir.isDirectory()) {
			boolean exists = arq.exists();
			String content = generateText();
			FileWriter fileWriter = new FileWriter(arq, exists);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			printWriter.write(content);
			printWriter.flush();
			printWriter.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório inválido");
		}
	}

	private String generateText() {
		StringBuffer buffer = new StringBuffer();
		String row = "";
		while (!row.equalsIgnoreCase("end")) {
			row = JOptionPane.showInputDialog(null, "Type something", 
					"Text input",JOptionPane.INFORMATION_MESSAGE);
			if (!row.equalsIgnoreCase("end")) {
				buffer.append(row + "\r\n");
			}
		}
		return buffer.toString();
	}

	@Override
	public void readFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(arq);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String row = bufferedReader.readLine();
			while (row!= null) {
				System.out.println(row);
				row = bufferedReader.readLine();
			}
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		} else {
			throw new IOException("Arquivo inválido!");
		}
	}

	@Override
	public void openFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			Desktop  desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo inválido!");
		}
	}

}
