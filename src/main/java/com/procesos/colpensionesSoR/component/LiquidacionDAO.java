package com.procesos.colpensionesSoR.component;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;

public class LiquidacionDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(LiquidacionDAO.class);

	private static final String UPDATE_LIQ = "UPDATE SOR.LIQ_AFILIADO SET LIQ_PAY = ?, LIQ_MORA = ?, LIQ_STATUS = ?, LIQ_STATUS_MORA = ?, LIQ_TOTAL = ? , BASE_COT = ?, END_DATE = TRUNC(SYSDATE) WHERE ID_CASO = ?";
	private static final String INSERT_LIQ_INI = "INSERT INTO SOR.LIQ_AFILIADO VALUES((LIQ_SEQ.NEXTVAL), ?, ?, NULL, NULL, NULL, NULL, NULL, TRUNC(SYSDATE), NULL)";

	public LiquidacionDAO() {
		super();
	}

	public void crearLiquidacion(Integer idCaso, String baseCotizacion) {
		LOGGER.info("Insertando liquidacion");
		PreparedStatement preparedStatemenLiq = null;

		try {
			
			preparedStatemenLiq = OracleConn.getConnection().prepareStatement(INSERT_LIQ_INI);

			preparedStatemenLiq.setInt(1, idCaso);
			preparedStatemenLiq.setString(2, baseCotizacion);

			preparedStatemenLiq.executeQuery();

		} catch (Exception e) {
			LOGGER.error("Error actualizando el SOR", e);
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

	public void updateLiquidacion(CalcularLiquidacion liquidacion) {
		PreparedStatement preparedStatemenLiq = null;

		try {
			
			preparedStatemenLiq = OracleConn.getConnection().prepareStatement(UPDATE_LIQ);

			String base = liquidacion.getBaseCotizacion().replace(".", "");
			// Cotizacion*2.56%*diasMora/365
			double liqMora = Integer.parseInt(base) * 0.0256 * liquidacion.getDiasMora()
					/ 365;

			double liqPay = liquidacion.getDiasIncapacidad() * Integer.parseInt(base) * 0.5;
			String liqStatusMora = liqMora > 0 ? "TRUE" : "FALSE";

			double liqTotal = liqMora + liqPay;

			LOGGER.info(String.format("Info liquidacion base=%s diasMora=%s, liqMora=%.0f liqPay=%.0f liqtotal=%.0f", base, ""+liquidacion.getDiasMora(), liqMora, liqPay,liqTotal));
			
			preparedStatemenLiq.setString(1, String.format("%.0f", Math.abs(liqPay)));
			preparedStatemenLiq.setString(2, String.format("%.0f", Math.abs(liqMora)));
			preparedStatemenLiq.setString(3, "TRUE");
			preparedStatemenLiq.setString(4, liqStatusMora);
			preparedStatemenLiq.setString(5, String.format("%.0f", Math.abs(liqTotal)));
			preparedStatemenLiq.setString(6, base);
			preparedStatemenLiq.setInt(7, liquidacion.getIdCaso());

			preparedStatemenLiq.executeQuery();

		} catch (Exception e) {
			LOGGER.error("Error actualizando liquidacion", e);
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
