package com.procesos.colpensionesSoR.model;

import java.sql.Date;

public class Documentos {

	private Integer idCaso;
	private String documentName;
	private String documentPath;
	private String documentStatus;
	private Date startDate;
	private Date endDate;

	public Documentos() {
		super();
	}

	public Integer getIdCaso() {
		return idCaso;
	}

	public void setIdCaso(Integer idCaso) {
		this.idCaso = idCaso;
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

	@Override
	public String toString() {
		return "Documentos [idCaso=" + idCaso + ", documentName=" + documentName + ", documentPath=" + documentPath
				+ ", documentStatus=" + documentStatus + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}	
}
