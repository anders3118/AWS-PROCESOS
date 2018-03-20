package com.procesos.colpensionesservices.model;

public class Afiliado {

	private Integer edad;
	private Integer semanasCotizadas;
	private Integer tiempoCotizacion;
	private Boolean aplicaPensionInvalidez;
	
	private long idAfiliadoSystema;
	private String segmentoAfiliado;
	private String estadoProcAfiliado;

	public Afiliado() {
		super();
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Integer getSemanasCotizadas() {
		return semanasCotizadas;
	}

	public void setSemanasCotizadas(Integer semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}

	public Integer getTiempoCotizacion() {
		return tiempoCotizacion;
	}

	public void setTiempoCotizacion(Integer tiempoCotizacion) {
		this.tiempoCotizacion = tiempoCotizacion;
	}

	public Boolean getAplicaPensionInvalidez() {
		return aplicaPensionInvalidez;
	}

	public void setAplicaPensionInvalidez(Boolean aplicaPensionInvalidez) {
		this.aplicaPensionInvalidez = aplicaPensionInvalidez;
	}

	public long getIdAfiliadoSystema() {
		return idAfiliadoSystema;
	}

	public void setIdAfiliadoSystema(long idAfiliadoSystema) {
		this.idAfiliadoSystema = idAfiliadoSystema;
	}

	public String getSegmentoAfiliado() {
		return segmentoAfiliado;
	}

	public void setSegmentoAfiliado(String segmentoAfiliado) {
		this.segmentoAfiliado = segmentoAfiliado;
	}

	public String getEstadoProcAfiliado() {
		return estadoProcAfiliado;
	}

	public void setEstadoProcAfiliado(String estadoProcAfiliado) {
		this.estadoProcAfiliado = estadoProcAfiliado;
	}

	@Override
	public String toString() {
		return "Afiliado [edad=" + edad + ", semanasCotizadas=" + semanasCotizadas + ", tiempoCotizacion="
				+ tiempoCotizacion + ", aplicaPensionInvalidez=" + aplicaPensionInvalidez + ", idAfiliadoSystema="
				+ idAfiliadoSystema + ", segmentoAfiliado=" + segmentoAfiliado + ", estadoProcAfiliado="
				+ estadoProcAfiliado + "]";
	}
	

	
	
}
