package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class Riempie2BeanDao implements Riempie2BeanDaoInterface {
	
	private static final String TABLE_NAME = "Riempie2";

	@Override
	public void doSave(Riempie2Bean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + Riempie2BeanDao.TABLE_NAME
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
	public void doDelete(Riempie2Bean data) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Riempie2Bean doRetrieveByKey(String nome) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Riempie2Bean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
