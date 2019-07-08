package com.credito.calculador;

import com.credito.domain.Cliente;

public class Calculador {
	
	Cliente cliente;
	
	public Calculador(Cliente cliente){
		this.cliente = cliente;
		prepararCalculo();
	}
	
	private void prepararCalculo() {
		cliente.setRendaAnalisada(cliente.getRenda());
	}
	
	public Cliente calcularAnalise() {
		Analise analise1 = new AnaliseRendaBaixa();
		Analise analise2 = new AnaliseDependenteMasculino();
		Analise analise3 = new AnaliseDependenteFeminino();
		Analise analise4 = new AnaliseMaisDeSessentaAnos();
		Analise analise5 = new AnaliseDivorciado();
		
		analise1.setProximaAnalise(analise2);
		analise2.setProximaAnalise(analise3);
		analise3.setProximaAnalise(analise4);
		analise4.setProximaAnalise(analise5);
		analise5.setProximaAnalise(new AnaliseFinalizadora());
		
		return analise1.analisarLimite(cliente);
	}
}
