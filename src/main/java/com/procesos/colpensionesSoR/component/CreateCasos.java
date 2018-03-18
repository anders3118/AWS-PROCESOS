package com.procesos.colpensionesSoR.component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Casos;

public class CreateCasos {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateCasos.class);

	public CreateCasos() {
		super();
	}

	public void create(Casos caso) throws SQLException {
		LOGGER.info("Ejecutando insertAfiliado ");
		Connection dbConn = null;
		Statement insertStatement = null;

		String queryInsert = "INSERT INTO SOR.CASOS_INCAPACIDAD VALUES ((CASO_SEQ.NEXTVAL),"
				+ "(SELECT ID_AFILIADO FORM SOR.AFILIADO_COLP WHERE ID_AFILIADO_SYSTEMA ='" +
				caso.getNumeroAfiliado() + "'),'" + caso.getDescripcion() + "')";

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
