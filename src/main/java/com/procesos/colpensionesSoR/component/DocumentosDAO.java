package com.procesos.colpensionesSoR.component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Documentos;

public class DocumentosDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(DocumentosDAO.class);

	private static final String INSERT_DOC = "INSERT INTO SOR.DOC_AFILIADO VALUES ((DOC_SEQ.NEXTVAL), ?, ?, ?, ?, TRUNC(SYSDATE), NULL)";

	public DocumentosDAO() {
		super();
	}

	public void create(Documentos documentos) throws SQLException {
		LOGGER.info("Ejecutando insert documento ");
		PreparedStatement preparedStatemenLiq = null;

		try {
			preparedStatemenLiq = OracleConn.getConnection().prepareStatement(INSERT_DOC);

			preparedStatemenLiq.setInt(1, documentos.getIdCaso());
			preparedStatemenLiq.setString(2, documentos.getDocumentName());
			preparedStatemenLiq.setString(3, documentos.getDocumentPath());
			preparedStatemenLiq.setString(4, documentos.getDocumentStatus());

			preparedStatemenLiq.executeQuery();
		} catch (Exception e) {
			LOGGER.error("Error insertando documento", e);
		} finally {

			if (preparedStatemenLiq != null) {
				try {
					preparedStatemenLiq.close();
				} catch (SQLException e) {
				}
			}

//			if (OracleConn.getConnection() != null) {
//				try {
//					OracleConn.getConnection().close();
//				} catch (SQLException e) {
//				}
//			}
		}

	}

}
