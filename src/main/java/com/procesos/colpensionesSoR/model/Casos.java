package com.procesos.colpensionesSoR.model;

public class Casos {

	private String numeroAfiliado;
	private String descripcion;
	
	public Casos() {
		super();
	}

	public Casos(String numeroAfiliado, String descripcion) {
		super();
		this.numeroAfiliado = numeroAfiliado;
		this.descripcion = descripcion;
	}

	public String getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(String numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
