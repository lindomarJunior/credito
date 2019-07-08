package com.credito.calculador;

import com.credito.domain.Cliente;

public interface Analise {
	
	public Cliente analisarLimite(Cliente cliente);
	
	public void setProximaAnalise(Analise analise);
}
