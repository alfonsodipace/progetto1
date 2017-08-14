package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class CarrelloBeanDao implements CarrelloBeanDaoInterface {

	private static final String TABLE_NAME = "carrello";
	
	@Override
	public void doSave(CarrelloBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + CarrelloBeanDao.TABLE_NAME
				+ " (idmenu, idcarrello, email) VALUES (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, data.getIdMenu());
			preparedStatement.setInt(2, data.getIdCarrello());
			preparedStatement.setString(3, data.getEmail());
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
	public void doDelete(CarrelloBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "DELETE FROM " + CarrelloBeanDao.TABLE_NAME + " WHERE idcarrello= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, data.getIdCarrello());
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
	public CarrelloBean doRetrieveByKey(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CarrelloBean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
