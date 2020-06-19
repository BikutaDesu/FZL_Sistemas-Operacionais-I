package controller;

public class ThreadConversaoController extends Thread{

	private int cod;
	private float temperatura;
	private int indice;
	private String siglaTemperatura;
	
	public ThreadConversaoController(int cod, float temperatura, int indice) {
		this.cod = cod;
		this.temperatura = temperatura;
		this.indice = indice;
	}
	
	@Override
	public void run() {
		System.out.printf("%d -> %.2f°C -> %.2f°%s \n", indice, temperatura, realizarConversao(), siglaTemperatura);
	}
	
	private float realizarConversao() {
		float temperaturaConvertida = 0;
		switch (cod) {
		case 1: {
			temperaturaConvertida = converterParaKelvin();
			siglaTemperatura = "K";
			break;
		}
		case 2: {
			temperaturaConvertida = converterParaFahrenheit();
			siglaTemperatura = "F";
			break;
		}
		default:
			temperaturaConvertida = temperatura;
			siglaTemperatura = "C";
		}
		return temperaturaConvertida;
	}
	
	private float converterParaKelvin() {
		float conversao = temperatura + 273;
		return conversao;
	}
	
	private float converterParaFahrenheit() {
		float conversao = (1.8f * temperatura) + 32;
		return conversao;
	}
}

