package com.credito.calculador;

import java.math.BigDecimal;

import com.credito.domain.Cliente;

public class AnaliseRendaBaixa implements Analise {
	private Analise proximaAnalise;
	
	@Override
	public Cliente analisarLimite(Cliente cliente) {
		if(cliente.getRenda().compareTo(new BigDecimal("1000")) == -1) {
			cliente.setLimite("renda baixa");
			cliente.setResultadoAnalise(false);
			return new AnaliseFinalizadora().analisarLimite(cliente);		
		}
		return proximaAnalise.analisarLimite(cliente);
	}

	@Override
	public void setProximaAnalise(Analise analise) {
		this.proximaAnalise = analise;
	}

}
