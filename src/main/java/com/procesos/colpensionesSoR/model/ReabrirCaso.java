package com.procesos.colpensionesSoR.model;

public class ReabrirCaso {

	private Casos caso;
	private Documentos documento;
	private String baseCotizacion;

	public ReabrirCaso() {
		super();
	}

	public String getBaseCotizacion() {
		return baseCotizacion;
	}

	public void setBaseCotizacion(String baseCotizacion) {
		this.baseCotizacion = baseCotizacion;
	}

	public Casos getCaso() {
		return caso;
	}

	public void setCaso(Casos caso) {
		this.caso = caso;
	}

	public Documentos getDocumento() {
		return documento;
	}

	public void setDocumento(Documentos documento) {
		this.documento = documento;
	}

}
