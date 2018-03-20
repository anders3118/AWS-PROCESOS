package com.procesos.colpensionesSoR.model;

public class Afiliados {

	private long idAfiliadoSystema;
	private String segmentoAfiliado;
	private String estadoProcAfiliado;
	
	public Afiliados(long idAafiliado, long idAfiliadoSystema, String segmentoAfiliado, String estadoProcAfiliado) {
		super();
		this.idAfiliadoSystema = idAfiliadoSystema;
		this.segmentoAfiliado = segmentoAfiliado;
		this.estadoProcAfiliado = estadoProcAfiliado;
	}


	public long getIdAfiliadoSystema() {
		return idAfiliadoSystema;
	}

	public String getSegmentoAfiliado() {
		return segmentoAfiliado;
	}

	public String getEstadoProcAfiliado() {
		return estadoProcAfiliado;
	}


	public void setIdAfiliadoSystema(long idAfiliadoSystema) {
		this.idAfiliadoSystema = idAfiliadoSystema;
	}


	public void setSegmentoAfiliado(String segmentoAfiliado) {
		this.segmentoAfiliado = segmentoAfiliado;
	}


	public void setEstadoProcAfiliado(String estadoProcAfiliado) {
		this.estadoProcAfiliado = estadoProcAfiliado;
	}

}
