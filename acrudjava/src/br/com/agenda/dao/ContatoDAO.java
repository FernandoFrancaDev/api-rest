package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {	
	//CRUD CREATE READ UPDATE DELETE
	
	public void save(Contato contato) {

		
		String sql = "INSERT INTO contatos(nome, idade, datacadastro) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// criar conexão como banco de dados
			conn  = ConnectionFactory.createConnectionToMySQL();
			
			//criamos uma PreparedStatement para executar uma query
			pstm = conn.prepareStatement(sql);
			
			// adicionar os valores que são esperados pela query
			pstm.setNString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			// executar a query
			pstm.execute();
			
			System.out.println("Contato salvo com sucesso");
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			// fechar conexões
			try {
				// fechar as conexões
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		
	}

	public void update (Contato contato) {
		
		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ?" + "WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));			
			pstm.setInt(4, contato.getId());
			
			pstm.execute();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();					
				}				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
	
	public void deleteById(int id) {
		
		String sql = "DELETE FROM contatos WHERE id = ?";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm != null) {
					pstm.close();				
				}
				if(conn != null) {
					conn.close();
				}				
			} catch (Exception e2) {
				e2.printStackTrace();
			}				
		}			
	}
	
	public List<Contato> getContatos(){
		
		String sql = "SELECT * FROM contatos";		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;		
		ResultSet rset = null; // classe que vai recuperar os dados do banco (select)
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				
				contato.setId(rset.getInt("id")); // recuperar id
				contato.setNome(rset.getString("nome")); // recuperar nome
				contato.setIdade(rset.getInt("idade")); // recuperar idade
				contato.setDataCadastro(rset.getDate("dataCadastro")); // recuperar idade
				
				contatos.add(contato);			
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(rset != null) {
				rset.close();
			}
			if(pstm !=null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}
		return contatos;

}
}
