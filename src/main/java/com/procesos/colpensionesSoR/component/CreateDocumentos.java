package com.procesos.colpensionesSoR.component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Documentos;

public class CreateDocumentos {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateDocumentos.class);
	//private static final String FOMART_DATE_DB = "dd/MM/yyyy";

	public CreateDocumentos() {
		super();
	}

	public void create(Documentos documentos) throws SQLException {
		LOGGER.info("Ejecutando insertAfiliado ");
		Connection dbConn = null;
		Statement insertStatement = null;

		String queryInsert = "INSERT INTO SOR.DOC_AFILIADO VALUES ((DOC_SEQ.NEXTVAL),"
				+ "(SELECT ID_CASO FROM SOR.CASOS_INCAPACIDAD WHERE ID_AFILIADO = "
				+ "(SELECT ID_AFILIADO FORM SOR.AFILIADO_COLP WHERE ID_AFILIADO_SYSTEMA ='" +
				documentos.getNumeroAfiliado() + "')),'" + documentos.getDocumentName() + 
				"','" + documentos.getDocumentPath() + "','" + documentos.getDocumentStatus() +
				"','" + documentos.getStartDate() + "','" + documentos.getEndDate() + "')";

		try {

			dbConn = OracleConn.getConnection();
			insertStatement = dbConn.createStatement();
			insertStatement.executeUpdate(queryInsert);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			if (insertStatement != null) {
				insertStatement.close();
			}

			if (dbConn != null) {
				dbConn.close();
			}
		}

	}

}
