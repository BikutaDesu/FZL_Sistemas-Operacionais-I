package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcController {

	public ProcController() {
		super();
	}
	
	public String getOS() {
		return System.getProperty("os.name");
	}
	
	public String getOsVersion() {
		return System.getProperty("os.version");
	}
	
	public String getOsArch() {
		return System.getProperty("os.arch");
	}
	
	
	public void callProcess(String process) {
		try {
			Runtime.getRuntime().exec(process);
		} catch (IOException e) {
			if (e.getMessage().contains("740")) {
//				cmd /c process - /c -> credenciais
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (IOException e1) {
					System.err.println("Erro ao abrir o processo, verifique o nome e tente novamente...\n");
					e1.printStackTrace();
				}
			}else {
				System.err.println("Erro ao abrir o processo, verifique o nome e tente novamente...");
				e.printStackTrace();
			}
			
		}
	}
	
	public void getProcess(String processName) {
		try {
			Process process = Runtime.getRuntime().exec(processName);
//			bits do processo
			InputStream flow = process.getInputStream();
//			string dos bits
			InputStreamReader reader = new InputStreamReader(flow);
//			buffer de leitura de string
			BufferedReader buffer = new BufferedReader(reader);
			String row = buffer.readLine();
			
			while(row != null) {
				System.out.println(row);
				row = buffer.readLine();
			}
			buffer.close();
			reader.close();
			flow.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void killProcess(String param) {
		String cmdPid = "TASKKILL /PID "; 
		String cmdName = "TASKKILL /IM ";
		
		int pid = 0;
		StringBuffer buffer = new StringBuffer();
		
		try {
			pid = Integer.parseInt(param);
			buffer.append(cmdPid);
			buffer.append(pid);
		} catch (NumberFormatException e) {
			buffer.append(cmdName);
			buffer.append(param);
		}
		
		callProcess(buffer.toString());
		
	}
	
	public void readProcess(String processName) {
		try {
			Process process = Runtime.getRuntime().exec(processName);
			InputStream inputStream = process.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String row = bufferedReader.readLine();
			
			while (row != null) {
				System.out.println(row);
				row = bufferedReader.readLine();
			}
			
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
		
		} catch (IOException e) {
			System.err.println("Erro ao abrir o processo, verifique o nome e tente novamente...");
			e.printStackTrace();
		}
	}

}
