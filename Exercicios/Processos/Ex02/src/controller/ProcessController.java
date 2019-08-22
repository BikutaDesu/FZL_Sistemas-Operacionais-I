package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcessController {
	
	public String getOS() {
		String OS = System.getProperty("os.name");
		return OS;
	}
	
	public void getProcesses(String osName) {
		try {
			Process process;
			if (osName.contains("Windows")) {
				process = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
			}else{
				process = Runtime.getRuntime().exec("");
			}
			InputStream flow = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(flow);
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
	
	public void killProcess(String param, String osName) {
		String cmdPid; 
		String cmdName;
		
		if (osName.contains("Windows")) {
			cmdPid = "TASKKILL /PID ";
			cmdName = "TASKKILL /IM ";
		}else {
			cmdPid = "TASKKILL /PID ";
			cmdName = "TASKKILL /IM ";
		}
		
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
					e1.printStackTrace();
				}
			}else {
				e.printStackTrace();
			}
			
		}
	}
}
