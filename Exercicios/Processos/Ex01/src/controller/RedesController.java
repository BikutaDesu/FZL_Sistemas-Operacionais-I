package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import model.Adapter;

public class RedesController {

	private String OS;

	public RedesController() {
		this.OS = System.getProperty("os.name");
	}

	public String getIP() {
		String adapters = "";
		if (OS.contains("Windows")) {
			adapters = getAdapters(getProcess("ipconfig"));
		} else {
			adapters = getAdapters(getProcess("ifconfig"));
		}

		return adapters;
	}

	public String getPing(String address) {
		String pingReturn = "";
		int totalMs = 0;
		for (int i = 0; i < 10; i++) {
			if (OS.contains("Windows")) {
				totalMs += getMs(getProcess("ping " + address));
			} else {
				getAdapters(getProcess(""));
			}
		}
		pingReturn = "Média de ms: " + (int) totalMs/10;
		return pingReturn;
	}

	private int getMs(BufferedReader buffer) {
		int ms = 0;
		try {
			String row = buffer.readLine();
			while (row != null) {
				if (row.contains("Reply")) {
					String time = row;
					row = row.substring(row.indexOf("="));
					row = row.replace("=", "");
					System.out.println(row);
					row = row.replace("ms", "");
					row = row.replace(" ", "");
					ms += Integer.parseInt(row);
					break;
				}
				row = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ms;
	}

	private Process callProcess(String processName) {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec(processName);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return process;
	}

	public BufferedReader getProcess(String processName) {
		InputStream flow = callProcess(processName).getInputStream();
		InputStreamReader reader = new InputStreamReader(flow);
		BufferedReader buffer = new BufferedReader(reader);
		return buffer;
	}

	private String getAdapters(BufferedReader buffer) {
		String adapterReturn = "";
		Adapter adapter = new Adapter();
		try {
			String row = buffer.readLine();
			while (row != null) {
				if (row.contains("adapter")) {
					adapter.setName(row);
				} else if (row.contains("IPv4")) {
					adapter.setAddress(row);
					adapterReturn += adapter.getName() + "\n" + adapter.getAddress() + "\n\n";
				}
				row = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return adapterReturn;
	}
}
