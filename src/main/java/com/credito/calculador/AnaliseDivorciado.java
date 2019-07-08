package com.credito.calculador;

import java.math.BigDecimal;

import com.credito.domain.Cliente;
import com.credito.enums.EstadoCivilEnum;

public class AnaliseDivorciado implements Analise {
	private Analise proximaAnalise;
	
	@Override
	public Cliente analisarLimite(Cliente cliente) {
		if(cliente.getEstadoCivil().equals(EstadoCivilEnum.DIVORCIADO.name())) {
			cliente.setRendaAnalisada(
					cliente.getRendaAnalisada()
					.divide(new BigDecimal("2")));			
		}
		return proximaAnalise.analisarLimite(cliente);
	}

	@Override
	public void setProximaAnalise(Analise analise) {
		this.proximaAnalise = analise;
	}

}
