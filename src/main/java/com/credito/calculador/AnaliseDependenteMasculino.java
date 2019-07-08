package com.credito.calculador;

import java.math.BigDecimal;

import com.credito.domain.Cliente;
import com.credito.enums.SexoEnum;

public class AnaliseDependenteMasculino implements Analise {
	
	private Analise proximaAnalise;

	@Override
	public Cliente analisarLimite(Cliente cliente) {
		if(cliente.getDependentes() > 0) {
			if(cliente.getSexo().equals(SexoEnum.MASCULINO.getValue())) {
				cliente.setRendaAnalisada(
						cliente.getRendaAnalisada()
						.subtract(BigDecimal.valueOf(cliente.getDependentes() * 1000)));
			}
		}
		return proximaAnalise.analisarLimite(cliente);
	}

	@Override
	public void setProximaAnalise(Analise analise) {
		this.proximaAnalise = analise;
	}	
	
}
