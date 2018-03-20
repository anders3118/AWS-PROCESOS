package com.procesos.colpensionesSoR.model;

public class Casos {

	private String numeroAfiliado;
	private String descripcion;
	private int casoAnterior;
	
	public Casos() {
		super();
	}

	public Casos(String numeroAfiliado, String descripcion, int casoAnterior) {
		super();
		this.numeroAfiliado = numeroAfiliado;
		this.descripcion = descripcion;
		this.casoAnterior = casoAnterior;
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

	public int getCasoAnterior() {
		return casoAnterior;
	}

	public void setCasoAnterior(int casoAnterior) {
		this.casoAnterior = casoAnterior;
	}
	
}
