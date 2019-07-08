package com.credito.calculador;

import java.math.BigDecimal;

import com.credito.domain.Cliente;

public class AnaliseMaisDeSessentaAnos implements Analise {
	private Analise proximaAnalise;
	
	@Override
	public Cliente analisarLimite(Cliente cliente) {
		if(cliente.getIdade() >= 60) {
			cliente.setRendaAnalisada(
					cliente.getRendaAnalisada()
					.subtract(BigDecimal.valueOf(500)));			
		}
		return proximaAnalise.analisarLimite(cliente);
	}

	@Override
	public void setProximaAnalise(Analise analise) {
		this.proximaAnalise = analise;
	}

}
