package com.procesos.colpensionesSoR.model;

public class Casos {

	private Integer idCaso;
	private String numeroAfiliado;
	private String descripcion;
	private Integer idCasoAnterior;

	public Casos() {
		super();
	}

	public Casos(Integer idCaso, String numeroAfiliado, String descripcion, int idCasoAnterior) {
		super();
		this.idCaso = idCaso;
		this.numeroAfiliado = numeroAfiliado;
		this.descripcion = descripcion;
		this.idCasoAnterior = idCasoAnterior;
	}

	public Integer getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
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

	public Integer getIdCasoAnterior() {
		return idCasoAnterior;
	}

	public void setIdCasoAnterior(Integer idCasoAnterior) {
		this.idCasoAnterior = idCasoAnterior;
	}

	@Override
	public String toString() {
		return "Casos [idCaso=" + idCaso + ", numeroAfiliado=" + numeroAfiliado + ", descripcion=" + descripcion
				+ ", idCasoAnterior=" + idCasoAnterior + "]";
	}

}
