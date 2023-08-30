package com.ouvidoria1.spring.Ouvidoria1.services;

import java.util.Scanner;

public class TratamentoDeErro {
	
static Scanner sc = new Scanner(System.in);
	
	public   int inteiro () {
		int validacao = 0;
		int inteiro = 0;
		do {
			try {				
				inteiro = Integer.parseInt(sc.nextLine());
				validacao = 0;
				
			} catch (Exception e) {
				System.out.println("valor informado errado, digite um numero inteiro novamente:");
				validacao = 1;
			}
		} while (validacao == 1);
		return inteiro;
	}
	
	public   double ldouble() {
		int validacao = 0;
		double flutuante = 0;
		do {
			try {				
				flutuante = Double.parseDouble(sc.nextLine());
				validacao = 0;
				
			} catch (Exception e) {
				System.out.println("valor informado errado, digite um numero inteiro novamente");
				validacao = 1;
			}
		} while (validacao == 1);
		return flutuante ;
		
	}
	
	public  String lerString() {
		return sc.nextLine();
		
	}

}
