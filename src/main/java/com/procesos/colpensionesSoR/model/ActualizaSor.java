package com.procesos.colpensionesSoR.model;

public class ActualizaSor {

	private Integer idCaso;
	private boolean favorable;
	private String baseCotizacion;

	public ActualizaSor() {
		super();
	}

	public Integer getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
	}

	public boolean isFavorable() {
		return favorable;
	}

	public void setFavorable(boolean favorable) {
		this.favorable = favorable;
	}

	public String getBaseCotizacion() {
		return baseCotizacion;
	}

	public void setBaseCotizacion(String baseCotizacion) {
		this.baseCotizacion = baseCotizacion;
	}

}
