package com.credito.enums;

public enum SexoEnum {
	MASCULINO(1), 
	FEMININO(2);
	
	private Integer sexo;
	
	SexoEnum(Integer sexo){
		this.sexo = sexo;
	}
	
	public Integer getValue(){
		return sexo;
	}
}
