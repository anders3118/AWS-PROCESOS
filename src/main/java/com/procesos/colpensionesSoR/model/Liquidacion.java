package com.procesos.colpensionesSoR.model;

import java.sql.Date;

public class Liquidacion {

	private String numeroAfiliado;
	private String baseCotizacion;
	private String liquidacionPago;
	private String liquidacionMora;
	private String liquidacionStatus;
	private String liquidacionStatusMora;
	private String liquidacionTotal;
	private Date startDate;
	private Date endDate;
	
	public Liquidacion() {
		super();
	}

	public Liquidacion(String numeroAfiliado, String baseCotizacion, String liquidacionPago, String liquidacionMora, String liquidacionStatus,
			String liquidacionStatusMora, String liquidacionTotal, Date startDate, Date endDate) {
		super();
		this.numeroAfiliado = numeroAfiliado;
		this.liquidacionPago = liquidacionPago;
		this.liquidacionMora = liquidacionMora;
		this.liquidacionStatus = liquidacionStatus;
		this.liquidacionStatusMora = liquidacionStatusMora;
		this.liquidacionTotal = liquidacionTotal;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(String numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	public String getLiquidacionPago() {
		return liquidacionPago;
	}

	public void setLiquidacionPago(String liquidacionPago) {
		this.liquidacionPago = liquidacionPago;
	}

	public String getLiquidacionMora() {
		return liquidacionMora;
	}

	public void setLiquidacionMora(String liquidacionMora) {
		this.liquidacionMora = liquidacionMora;
	}

	public String getLiquidacionStatus() {
		return liquidacionStatus;
	}

	public void setLiquidacionStatus(String liquidacionStatus) {
		this.liquidacionStatus = liquidacionStatus;
	}

	public String getLiquidacionStatusMora() {
		return liquidacionStatusMora;
	}

	public void setLiquidacionStatusMora(String liquidacionStatusMora) {
		this.liquidacionStatusMora = liquidacionStatusMora;
	}

	public String getLiquidacionTotal() {
		return liquidacionTotal;
	}

	public void setLiquidacionTotal(String liquidacionTotal) {
		this.liquidacionTotal = liquidacionTotal;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getBaseCotizacion() {
		return baseCotizacion;
	}

	public void setBaseCotizacion(String baseCotizacion) {
		this.baseCotizacion = baseCotizacion;
	}

}
