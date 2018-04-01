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

	public boolean insertAfiliado(Afiliados afiliado) throws SQLException {
		LOGGER.info("Ejecutando insertAfiliado ");
		Connection dbConn = null;
		Statement insertStatement = null;

		String queryInsert = "INSERT INTO SOR.AFILIADO_COLP VALUES ((AFILIADO_SEQ.NEXTVAL),'"
				+ afiliado.getIdAfiliadoSystema() + "','" + afiliado.getSegmentoAfiliado() + "','"
				+ afiliado.getEstadoProcAfiliado() + "')";

		try {

			dbConn = OracleConn.getConnection();
			insertStatement = dbConn.createStatement();
			insertStatement.executeUpdate(queryInsert);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		} finally {

			if (insertStatement != null) {
				insertStatement.close();
			}

//			if (dbConn != null) {
//				dbConn.close();
//			}
		}

	}

}
