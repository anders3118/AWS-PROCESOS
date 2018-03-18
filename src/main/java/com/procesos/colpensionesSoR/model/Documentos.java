package com.procesos.colpensionesSoR.model;

import java.sql.Date;

public class Documentos {

	private String numeroAfiliado;
	private String documentName;
	private String documentPath;
	private String documentStatus;
	private Date startDate;
	private Date endDate;
	
	public Documentos() {
		super();
	}

	public Documentos(String numeroAfiliado, String documentName, String documentPath, String documentStatus,
			Date startDate, Date endDate) {
		super();
		this.numeroAfiliado = numeroAfiliado;
		this.documentName = documentName;
		this.documentPath = documentPath;
		this.documentStatus = documentStatus;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getNumeroAfiliado() {
		return numeroAfiliado;
	}

	public void setNumeroAfiliado(String numeroAfiliado) {
		this.numeroAfiliado = numeroAfiliado;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentPath() {
		return documentPath;
	}

	public void setDocumentPath(String documentPath) {
		this.documentPath = documentPath;
	}

	public String getDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(String documentStatus) {
		this.documentStatus = documentStatus;
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

}
