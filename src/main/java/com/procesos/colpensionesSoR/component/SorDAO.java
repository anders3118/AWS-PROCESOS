package com.procesos.colpensionesSoR.component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.ActualizaSor;
import com.procesos.colpensionesSoR.model.ReabrirCaso;

public class SorDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(SorDAO.class);

	private static final String UPDATE_FECHA_FIN_DOC = "UPDATE SOR.DOC_AFILIADO SET END_DATE = TRUNC(SYSDATE), DOC_STATUS='OK' WHERE ID_CASO = ?";

	private static final String INSERT_LIQ_CERO = "INSERT INTO SOR.LIQ_AFILIADO VALUES((LIQ_SEQ.NEXTVAL), ?, ?, '0', '0', 'TRUE', 'FALSE', '0', TRUNC(SYSDATE), TRUNC(SYSDATE))";

	private static final String INSERT_LIQ_INI = "INSERT INTO SOR.LIQ_AFILIADO VALUES((LIQ_SEQ.NEXTVAL), ?, ?, NULL, NULL, NULL, NULL, NULL, TRUNC(SYSDATE), NULL)";

	public SorDAO() {
		super();
	}

	public void actualizarSor(ActualizaSor actualizaSor) {
		LOGGER.info("Actualizando fecha fin del documento ");

		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatemenLiq = null;

		try {
			
			preparedStatement = OracleConn.getConnection().prepareStatement(UPDATE_FECHA_FIN_DOC);
			preparedStatement.setInt(1, actualizaSor.getIdCaso());

			preparedStatement.executeUpdate();

			if (actualizaSor.isFavorable()) {
				preparedStatemenLiq = OracleConn.getConnection().prepareStatement(INSERT_LIQ_INI);
			} else {
				preparedStatemenLiq = OracleConn.getConnection().prepareStatement(INSERT_LIQ_CERO);
			}

			preparedStatemenLiq.setInt(1, actualizaSor.getIdCaso());
			preparedStatemenLiq.setString(2, actualizaSor.getBaseCotizacion());
			
			preparedStatemenLiq.executeQuery();

		} catch (Exception e) {
			LOGGER.error("Error actualizando el SOR", e);
		} finally {

			if (preparedStatement != null) {
				try {
					preparedStatement.close();
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

	public int reabrirCaso(ReabrirCaso reabrirCaso) {
		LOGGER.info("Reabriendo caso");
		CasosDAO casosDao = new CasosDAO();
		DocumentosDAO documentosDao = new DocumentosDAO();
		LiquidacionDAO liquidacionDao = new LiquidacionDAO();

		try {

			int idCaso = casosDao.create(reabrirCaso.getCaso());
			reabrirCaso.getDocumento().setIdCaso(idCaso);
			
			documentosDao.create(reabrirCaso.getDocumento());
			liquidacionDao.crearLiquidacion(idCaso, reabrirCaso.getBaseCotizacion());
			return idCaso;
		} catch (Exception e) {
			LOGGER.error("Error reabriendo caso en el SOR", e);
			return 0;
		} finally {

		}
	}
}
