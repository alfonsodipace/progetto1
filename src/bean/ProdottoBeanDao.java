package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class ProdottoBeanDao implements ProdottoBeanDaoInterface {

	private static final String TABLE_NAME = "Prodotto";

	@Override
	public void doSave(ProdottoBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProdottoBeanDao.TABLE_NAME
				+ " (nome, Tipo, Desc, Prezzo, Disp, Venduti) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, data.getNome());
			preparedStatement.setString(2, data.getTipo());
			preparedStatement.setString(3, data.getDesc());
			preparedStatement.setDouble(4, data.getPrezzo());
			preparedStatement.setInt(5, data.getDisp());
			preparedStatement.setInt(6, data.getVenduti());
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
	public ProdottoBean doRetrieveByKey(String nome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProdottoBean bean = new ProdottoBean();

		String selectSQL = "SELECT * FROM " + ProdottoBeanDao.TABLE_NAME + " WHERE nomeprodotto = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNome(rs.getString(1));
				bean.setTipo(rs.getString(2));
				bean.setDesc(rs.getString(3));
				bean.setPrezzo(rs.getDouble(4));
				bean.setDisp(rs.getInt(5));
				bean.setVenduti(rs.getInt(6));
			}
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
	public Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProdottoBean> prod = new LinkedList<ProdottoBean>();

		String selectSQL = "SELECT * FROM " + ProdottoBeanDao.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean bean = new ProdottoBean();

				bean.setNome(rs.getString("nomeprodotto"));
				bean.setTipo(rs.getString("tipo"));
				bean.setDesc(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisp(rs.getInt("disponiilita"));
				bean.setVenduti(rs.getInt("venduti"));
				prod.add(bean);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prod;
	}

	
	
	@Override
	public void doDelete(ProdottoBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "DELETE FROM " + ProdottoBeanDao.TABLE_NAME + " WHERE nomeprodotto= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, data.getNome());
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
	public Collection<ProdottoBean> doRetrieveAllByTipo(String tipo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProdottoBean> prod = new LinkedList<ProdottoBean>();

		String selectSQL = "SELECT * FROM " + ProdottoBeanDao.TABLE_NAME + " WHERE tipo ='"+ tipo +"'";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProdottoBean bean = new ProdottoBean();

				bean.setNome(rs.getString("nomeprodotto"));
				bean.setTipo(rs.getString("tipo"));
				bean.setDesc(rs.getString("descrizione"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDisp(rs.getInt("disponibilita"));
				bean.setVenduti(rs.getInt("venduti"));
				prod.add(bean);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prod;
	}


}
