package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class Riempie1BeanDao implements Riempie1BeanDaoInterface {
																	///	MAYBE WE NEED AUTOINCREMENT VALUE IN DB for store more item
	private static final String TABLE_NAME = "Riempie1";
	
	@Override
	public void doSave(Riempie1Bean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + Riempie1BeanDao.TABLE_NAME
				+ " (nome, tipo, idcarrello, email) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, data.getNome());
			preparedStatement.setString(2, data.getTipo());
			preparedStatement.setInt(3, data.getIdCarrello());
			preparedStatement.setString(4, data.getEmail());
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
	public void doDelete(Riempie1Bean data) throws SQLException {
	 
		
	}

	@Override
	public Riempie1Bean doRetrieveByKey(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Riempie1Bean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
