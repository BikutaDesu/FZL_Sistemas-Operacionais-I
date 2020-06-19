package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		String path = "/home/bikuta/";
		String name = "teste.csv";
		try {
//			arqCont.readDir(path);
//			arqCont.createFile(path, name);
//			arqCont.readFile(path, name);
			arqCont.openFile(path, name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
