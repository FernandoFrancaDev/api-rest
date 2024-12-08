package br.com.celular.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.celular.factory.ConnectionFactory;
import br.com.celular.modal.Celular;

public class CelularDao {
	
	public void save (Celular celular) {
		
		String sql = "INSERT INTO celularcrud(nome, ano, preco) VALUES(?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setNString(1, celular.getNome());
			pstm.setInt(2, celular.getAno());
			pstm.setDouble(3, celular.getPreco());
			pstm.execute();			
			System.out.println("Celular salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
