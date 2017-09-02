package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class OrdinaBeanDao implements OrdinaBeanInterface{
private static final String TABLE_NAME = "ordina1";
	
	
	
	@Override
	public void doSave(OrdinaBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OrdinaBeanDao.TABLE_NAME
				+ " (email, idProdotto) VALUES (?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, data.getEmail());
			preparedStatement.setDouble(2, data.getIdProdotto());
		//	preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
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

		String selectSQL = "SELECT s.email, s.idProdotto, s.dataordine FROM ordina1 s join "
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

	@Override
	public Collection<OrdinaBean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
