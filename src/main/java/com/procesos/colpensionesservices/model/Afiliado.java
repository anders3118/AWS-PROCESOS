package com.procesos.colpensionesservices.model;

public class Afiliado {

	private Integer diasIncapacidad;
	private Integer semanasCotizadas;
	private Integer perdidaCapacidadLaboral;
	private Integer porcentajeLiquidacion;

	public Afiliado() {
		super();
	}

	public Integer getDiasIncapacidad() {
		return diasIncapacidad;
	}

	public void setDiasIncapacidad(Integer diasIncapacidad) {
		this.diasIncapacidad = diasIncapacidad;
	}

	public Integer getSemanasCotizadas() {
		return semanasCotizadas;
	}

	public void setSemanasCotizadas(Integer semanasCotizadas) {
		this.semanasCotizadas = semanasCotizadas;
	}

	public Integer getPerdidaCapacidadLaboral() {
		return perdidaCapacidadLaboral;
	}

	public void setPerdidaCapacidadLaboral(Integer perdidaCapacidadLaboral) {
		this.perdidaCapacidadLaboral = perdidaCapacidadLaboral;
	}

	public Integer getPorcentajeLiquidacion() {
		return porcentajeLiquidacion;
	}

	public void setPorcentajeLiquidacion(Integer porcentajeLiquidacion) {
		this.porcentajeLiquidacion = porcentajeLiquidacion;
	}

	@Override
	public String toString() {
		return "Afiliado [diasIncapacidad=" + diasIncapacidad + ", semanasCotizadas=" + semanasCotizadas
				+ ", perdidaCapacidadLaboral=" + perdidaCapacidadLaboral + ", porcentajeLiquidacion="
				+ porcentajeLiquidacion + "]";
	}

	
	
}
