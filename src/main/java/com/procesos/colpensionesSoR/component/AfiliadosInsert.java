package com.procesos.colpensionesSoR.component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.procesos.colpensionesSoR.DAO.OracleConn;
import com.procesos.colpensionesSoR.model.Afiliados;


@Component
public class AfiliadosInsert {
	
	private final Afiliados afiliado;
	

	public AfiliadosInsert(Afiliados afiliado) {
		super();
		this.afiliado = afiliado;
	}

	@PostConstruct
	public void insertAfiliado(Afiliados afiliado) throws SQLException {
		Connection dbConn = null;
		Statement insertStatement = null;
		
		String queryInsert = "INSERT INTO AFILIADO_COLP VALUES ((SELECT AFILIADO_SEQ.NEXTVAL FROM DUAL)," +
				getAfiliado().getIdAfiliadoSystema() + "," + getAfiliado().getSegmentoAfiliado() + "," + 
				getAfiliado().getEstadoProcAfiliado() + ",";
		
		try {
			
			dbConn = OracleConn.getConnection();
			insertStatement = dbConn.createStatement();
			insertStatement.executeUpdate(queryInsert);

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {

			if (insertStatement != null) {
				insertStatement.close();
			}

			if (dbConn != null) {
				dbConn.close();
			}
		}
		
	}

	public Afiliados getAfiliado() {
		return afiliado;
	}
	
}
