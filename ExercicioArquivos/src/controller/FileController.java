package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileController {

	private void createFile(String path, String name, String content) throws IOException {
		File dir = new File(path);
		File arq = new File(path, name);
		if (dir.exists() && dir.isDirectory()) {
			boolean exists = arq.exists();
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

	private String readFile(String path, String name) throws IOException {
		File file = new File(path, name);
		String fileContent = "";
		if (file.exists() && file.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			int i = 0;
			StringBuffer stringBuffer = new StringBuffer();
			String row = bufferedReader.readLine();

			while (row != null) {
				row = bufferedReader.readLine();
				if (row != null) {
					if (i > 0) {
						row = row.replace(" ", ";");
					}
					stringBuffer.append(row + "\r\n");
				}
				i++;
			}
			fileContent = stringBuffer.toString();
			bufferedReader.close();
			inputStreamReader.close();
			fileInputStream.close();
		} else {
			throw new IOException("Arquivo inválido!");
		}
		return fileContent;
	}

	private void openFile(String path, String name) throws IOException {
		File arq = new File(path, name);
		if (arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arq);
		} else {
			throw new IOException("Arquivo inválido!");
		}
	}

	public void convertToCsv(String filePath, String fileInName, String fileOutName) throws IOException {
		String fileContennt = readFile(filePath, fileInName);
		createFile(filePath, fileOutName, fileContennt);
		openFile(filePath, fileOutName);
	}

}
