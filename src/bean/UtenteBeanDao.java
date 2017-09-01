package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class UtenteBeanDao implements UtenteBeanDaoInterface {
	
	private static final String TABLE_NAME = "utente";
	
	@Override
	public void doSave(UtenteBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UtenteBeanDao.TABLE_NAME
				+ " (email, pass, nome, cognome, indirizzo, tipo, telefono) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, data.getEmail());
			preparedStatement.setString(2, data.getPass());
			preparedStatement.setString(3, data.getNome());
			preparedStatement.setString(4, data.getCognome());
			preparedStatement.setString(5, data.getIndirizzo());
			preparedStatement.setString(6, data.getTipo());
			preparedStatement.setString(7, data.getTelefono());
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
		connection.close();
	}

	@Override
	public UtenteBean doRetrieveByKey(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UtenteBean bean = new UtenteBean();

		String selectSQL = "SELECT * FROM " + UtenteBeanDao.TABLE_NAME + " WHERE email = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			rs.first();
			if(rs.wasNull()){
				return null;
			}
			else{rs.beforeFirst();
			while (rs.next()) {
				bean.setEmail(rs.getString(1));
				bean.setPass(rs.getString(2));
				bean.setNome(rs.getString(3));
				bean.setCognome(rs.getString(4));
				bean.setIndirizzo(rs.getString(5));
				bean.setTipo(rs.getString(6));
				bean.setTelefono(rs.getString(7));
			}}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	@Override
	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doUpdate (UtenteBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + UtenteBeanDao.TABLE_NAME + " SET  nome = ?, cognome = ?, indirizzo = ?, telefono = ? WHERE email = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, data.getNome());
			preparedStatement.setString(2, data.getCognome());
			preparedStatement.setString(3, data.getIndirizzo());
			preparedStatement.setString(4, data.getTelefono());
			preparedStatement.setString(5, data.getEmail());
			preparedStatement.executeUpdate();
			connection.commit();
		} 
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		connection.close();
	}

}
