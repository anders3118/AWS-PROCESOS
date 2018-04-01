package com.procesos.colpensionesSoR.component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Casos;

public class CasosDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(CasosDAO.class);

	private static final String INSERT_CASO = "INSERT INTO SOR.CASOS_INCAPACIDAD VALUES ((CASO_SEQ.NEXTVAL), (SELECT ID_AFILIADO FROM SOR.AFILIADO_COLP WHERE ID_AFILIADO_SYSTEMA = ?), ?, ?)";
	private static final String SELECT_MAX = "SELECT MAX(ID_CASO) FROM SOR.CASOS_INCAPACIDAD";

	public CasosDAO() {
		super();
	}

	public Integer create(Casos caso) throws SQLException {
		
		LOGGER.info("Ejecutando caso ");
		
		PreparedStatement preparedStatement = null;
		PreparedStatement statemenMax = null;
		Integer idCaso = null;
		try {

			preparedStatement = OracleConn.getConnection().prepareStatement(INSERT_CASO);
			preparedStatement.setString(1, caso.getNumeroAfiliado());
			preparedStatement.setString(2, caso.getDescripcion());
			preparedStatement.setInt(3, caso.getIdCasoAnterior()); 
			
			preparedStatement.executeUpdate();

			statemenMax = OracleConn.getConnection().prepareStatement(SELECT_MAX);
			ResultSet rs = statemenMax.executeQuery();

			if (rs.next()) {
				idCaso = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			OracleConn.getConnection().rollback();
		} finally {

			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (statemenMax != null) {
				statemenMax.close();
			}

//			if (OracleConn.getConnection() != null) {
//				OracleConn.getConnection().close();
//			}
		}
		return idCaso;

	}

}
