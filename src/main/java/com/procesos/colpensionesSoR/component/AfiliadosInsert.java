package com.procesos.colpensionesSoR.component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Afiliados;

public class AfiliadosInsert {

	private static final Logger LOGGER = LoggerFactory.getLogger(AfiliadosInsert.class);

	public AfiliadosInsert() {
		super();
	}

	public void insertAfiliado(Afiliados afiliado) throws SQLException {
		LOGGER.info("Ejecutando insertAfiliado ");
		Connection dbConn = null;
		Statement insertStatement = null;

		String queryInsert = "INSERT INTO AFILIADO_COLP VALUES ((SELECT AFILIADO_SEQ.NEXTVAL FROM DUAL),"
				+ afiliado.getIdAfiliadoSystema() + "," + afiliado.getSegmentoAfiliado() + ","
				+ afiliado.getEstadoProcAfiliado() + ",";

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
