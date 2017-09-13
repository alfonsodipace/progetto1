package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrdinaBeanDao implements OrdinaBeanInterface{
private static final String TABLE_NAME = "ordina1";
	
	
	
	@Override
	public void doSave(OrdinaBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OrdinaBeanDao.TABLE_NAME
				+ " (email, idProdotto, dataacquisto, oraconsegna) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, data.getEmail());
			preparedStatement.setDouble(2, data.getIdProdotto());
			preparedStatement.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
			preparedStatement.setString(4, data.getOraConsegna());
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public void doDelete(OrdinaBean data) throws SQLException {
	 
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "DELETE FROM " + OrdinaBeanDao.TABLE_NAME + " WHERE email= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, data.getEmail());
			preparedStatement.executeUpdate(); 
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public ArrayList<OrdinaBean> doRetrieveByKey(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<OrdinaBean> array = new ArrayList<>();

		String selectSQL = "SELECT s.email, s.idProdotto, s.dataacquisto, s.oraconsegna FROM ordina1 s join "
				+ "prodotto t WHERE s.idProdotto=t.idProdotto and s.email= ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while(rs.next()) {
				OrdinaBean bean = new OrdinaBean();
				bean.setEmail(rs.getString(1));
				bean.setIdProdotto(rs.getInt(2));
				bean.setDataOrdine(rs.getDate(3));
				bean.setOraConsegna(rs.getString(4));
				array.add(bean);
			}
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return array;
	}
	
	public OrdinaBean doRetrieveByeId(int id){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		OrdinaBean bean = new OrdinaBean();

		String selectSQL = "SELECT * FROM ordina1 "
				+ " WHERE id= ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setEmail(rs.getString(1));
				bean.setIdProdotto(rs.getInt(2));
				bean.setIdOrdine(rs.getInt(3));
				bean.setDataOrdine(rs.getDate(4));
				bean.setOraConsegna(rs.getString(5));
				bean.setStato(rs.getString(6));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		System.out.println(bean.getDataOrdine());
		return bean;
	}
	
	public void evadiOrdine(int id){
	
		String updateSQL = "UPDATE  "+OrdinaBeanDao.TABLE_NAME+" SET  stato = ? WHERE id = ? ";
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(updateSQL);
			preparedStatement.setString(1,"evaso");
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		
	}

	@Override
	public ArrayList<OrdinaBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<OrdinaBean> array = new ArrayList<>();

		String selectSQL = "SELECT * FROM ordina1 ";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
 
			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while(rs.next()) {
				OrdinaBean bean = new OrdinaBean();
				bean.setEmail(rs.getString(1));
				bean.setIdProdotto(rs.getInt(2));
				bean.setIdOrdine(rs.getInt(3));
				bean.setDataOrdine(rs.getDate(4));
				bean.setOraConsegna(rs.getString(5));
				bean.setStato(rs.getString(6));
				array.add(bean);
			}
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return array;
	}
	
	public ArrayList<OrdinaBean> doRetrieveNonEvasi() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<OrdinaBean> array = new ArrayList<>();

		String selectSQL = "SELECT * FROM ordina1 where stato='non evaso'";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
 
			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while(rs.next()) {
				OrdinaBean bean = new OrdinaBean();
				bean.setEmail(rs.getString(1));
				bean.setIdProdotto(rs.getInt(2));
				bean.setIdOrdine(rs.getInt(3));
				bean.setDataOrdine(rs.getDate(4));
				bean.setOraConsegna(rs.getString(5));
				bean.setStato(rs.getString(6));
				array.add(bean);
			}
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return array;
	}

}
