package com.procesos.colpensionesSoR.component;

public class CalcularLiquidacion {

	private Integer idCaso;
	private String baseCotizacion;
	private int diasIncapacidad;
	private int diasMora;

	public CalcularLiquidacion() {
		super(); 
	}

	public int getDiasMora() {
		return diasMora;
	}

	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}

	public Integer getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
	}

	public String getBaseCotizacion() {
		return baseCotizacion;
	}

	public void setBaseCotizacion(String baseCotizacion) {
		this.baseCotizacion = baseCotizacion;
	}

	public int getDiasIncapacidad() {
		return diasIncapacidad;
	}

	public void setDiasIncapacidad(int diasIncapacidad) {
		this.diasIncapacidad = diasIncapacidad;
	}

	@Override
	public String toString() {
		return "CalcularLiquidacion [idCaso=" + idCaso + ", baseCotizacion=" + baseCotizacion + ", diasIncapacidad="
				+ diasIncapacidad + ", diasMora=" + diasMora + "]";
	}
	
}
