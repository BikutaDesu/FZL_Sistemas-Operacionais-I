package view;

import java.io.IOException;

import controller.FileController;

public class Mian {
	
	/*
	 *  Pegar o arquivo relatório.txt, colocar em um diretório que o permita ser lido, 
	 *  fazer a leitura e colocar seu conteúdo em um arquivo CSV, 
	 *  para que seja lido pelo Excel.
	*/
	
	public static void main(String[] args) {
		
		final String filePath = "./src/files/";
		final String fileInName = "relatorio.txt";
		final String fileOutName = "relatorio.csv";
		
		FileController fileController = new FileController();
		
		try {
			fileController.convertToCsv(filePath, fileInName, fileOutName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
