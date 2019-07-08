package com.credito.calculador;

import java.math.BigDecimal;

import com.credito.domain.Cliente;

public class AnaliseFinalizadora implements Analise {

	@Override
	public Cliente analisarLimite(Cliente cliente) {
		BigDecimal rendaMinima = new BigDecimal("1000");
		
		if(cliente.getResultadoAnalise() != null) {
			return cliente;
		}else if(cliente.getRendaAnalisada().compareTo(rendaMinima) == 0 
				|| cliente.getRendaAnalisada().compareTo(rendaMinima) == 1) {
			
			Double rendaAnalisada = Math.floor(cliente.getRendaAnalisada().divide(new BigDecimal("1000")).doubleValue());
			
			BigDecimal rendaAnalisadaArredondada = new BigDecimal(rendaAnalisada.toString()).multiply(new BigDecimal("1000"));
			BigDecimal limiteFinal = rendaAnalisadaArredondada.divide(new BigDecimal("2"));
			BigDecimal limiteInicial = limiteFinal.subtract(new BigDecimal("500"));
			
			if(limiteInicial.compareTo(new BigDecimal("2000")) == 1) {
				cliente.setLimite("superior 2000");
				cliente.setResultadoAnalise(true);
				return cliente;
			}
			
			if(limiteInicial.compareTo(new BigDecimal("0")) == 0) {
				limiteInicial = new BigDecimal("100");
			}
			
			cliente.setLimite("entre " + limiteInicial.setScale(0) + " - " + limiteFinal.setScale(0));
			cliente.setResultadoAnalise(true);
		}else {
			cliente.setLimite("reprovado pela política de crédito");
			cliente.setResultadoAnalise(false);
		}
		return cliente;
	}

	@Override
	public void setProximaAnalise(Analise analise) {
	}

}
