package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Riempie1BeanDao implements Riempie1BeanDaoInterface {
																	///	MAYBE WE NEED AUTOINCREMENT VALUE IN DB for store more item
	private static final String TABLE_NAME = "riempie1";
	
	
	
	@Override
	public void doSave(Riempie1Bean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + Riempie1BeanDao.TABLE_NAME
				+ " (nome, tipo, idcarrello, email, prezzo, idProdotto) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, data.getNome());
			preparedStatement.setString(2, data.getTipo());
			preparedStatement.setInt(3, data.getIdCarrello());
			preparedStatement.setString(4, data.getEmail());
			preparedStatement.setDouble(5, data.getPrezzo());
			preparedStatement.setDouble(6, data.getIdProdotto());
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
	 
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "DELETE FROM " + Riempie1BeanDao.TABLE_NAME + " WHERE idProdotto= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, data.getIdProdotto());
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
	public ArrayList<Riempie1Bean> doRetrieveByKey(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<Riempie1Bean> array = new ArrayList<>();

		String selectSQL = "SELECT * FROM " + Riempie1BeanDao.TABLE_NAME + " WHERE email = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			while(rs.next()) {
				Riempie1Bean bean = new Riempie1Bean();
				bean.setNome(rs.getString(1));
				bean.setTipo(rs.getString(2));
				bean.setIdCarrello(rs.getInt(3));
				bean.setEmail(rs.getString(4));
				bean.setPrezzo(rs.getDouble(5));
				bean.setIdProdotto(rs.getInt("idProdotto"));
				array.add(bean);
				System.out.println(bean.getNome());
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
	
	public boolean doRetrieveById(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;


		String selectSQL = "SELECT * FROM " + Riempie1BeanDao.TABLE_NAME + " WHERE idProdotto = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();
			if(rs.wasNull())
				return false;
			else 
				return true;
		}
		
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public Collection<Riempie1Bean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
