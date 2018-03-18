package com.procesos.colpensionesSoR.component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Liquidacion;

public class CreateLiquidacion {

	private static final Logger LOGGER = LoggerFactory.getLogger(CreateLiquidacion.class);
	//private static final String FOMART_DATE_DB = "dd/MM/yyyy";

	public CreateLiquidacion() {
		super();
	}

	public void create(Liquidacion liquidacion) throws SQLException {
		LOGGER.info("Ejecutando insertAfiliado ");
		Connection dbConn = null;
		Statement insertStatement = null;

		String queryInsert = "INSERT INTO SOR.CASOS_INCAPACIDAD VALUES ((LIQ_SEQ.NEXTVAL),"
				+ "(SELECT ID_CASO FROM SOR.CASOS_INCAPACIDAD WHERE ID_AFILIADO = "
				+ "(SELECT ID_AFILIADO FORM SOR.AFILIADO_COLP WHERE ID_AFILIADO_SYSTEMA ='" +
				liquidacion.getNumeroAfiliado() + "'),'" + liquidacion.getLiquidacionPago() + 
				"','" + liquidacion.getLiquidacionMora() + "','" + liquidacion.getLiquidacionStatus() +
				"','" + liquidacion.getLiquidacionStatusMora() + "','" + liquidacion.getStartDate() + 
				"','" + liquidacion.getEndDate() + "')";

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
