package com.procesos.colpensionesservices.model;

public class Afiliado {

	private Integer edad;
	private Integer semanasCotizadas;
	private Integer tiempoCotizacion;
	private boolean aplicaPensionInvalidez;
	private boolean favorable;
	private Integer perdidaCapacidadLaboral;

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

	public boolean getAplicaPensionInvalidez() {
		return aplicaPensionInvalidez;
	}

	public void setAplicaPensionInvalidez(boolean aplicaPensionInvalidez) {
		this.aplicaPensionInvalidez = aplicaPensionInvalidez;
	}

	public boolean getFavorable() {
		return favorable;
	}

	public void setFavorable(boolean favorable) {
		this.favorable = favorable;
	}

	public Integer getPerdidaCapacidadLaboral() {
		return perdidaCapacidadLaboral;
	}

	public void setPerdidaCapacidadLaboral(Integer perdidaCapacidadLaboral) {
		this.perdidaCapacidadLaboral = perdidaCapacidadLaboral;
	}

	@Override
	public String toString() {
		return "Afiliado [edad=" + edad + ", semanasCotizadas=" + semanasCotizadas + ", tiempoCotizacion="
				+ tiempoCotizacion + ", aplicaPensionInvalidez=" + aplicaPensionInvalidez + ", favorable=" + favorable
				+ ", perdidaCapacidadLaboral=" + perdidaCapacidadLaboral + "]";
	}

}
