package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {

		OperacoesController operacoes = new OperacoesController();

//		operacoes.concatenaString();
//		System.out.print('\n');
//		operacoes.concatenaBuffer();

		String frase = "Hoje a noite esta escura e fria... Tomei um Dolly agora pouco";

		operacoes.operacaoString(frase);

	}

}
