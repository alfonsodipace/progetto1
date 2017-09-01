package bean;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdottoBeanDao implements ProdottoBeanDaoInterface {

	private static final String TABLE_NAME = "prodotto";

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
			preparedStatement.setInt(5, data.getVenduti());
			preparedStatement.setString(6, data.getImmagine());
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
				bean.setVenduti(rs.getInt(5));
				bean.setImmagine(rs.getString(6));
				bean.setIdProdotto(rs.getInt("idProdotto"));
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
	public ArrayList<ProdottoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProdottoBean> prod = new ArrayList<ProdottoBean>();

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
				bean.setVenduti(rs.getInt("venduti"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setIdProdotto(rs.getInt("idProdotto"));
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
	public ArrayList<ProdottoBean> doRetrieveAllByTipo(String tipo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProdottoBean> prod = new ArrayList<ProdottoBean>();

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
				bean.setVenduti(rs.getInt("venduti"));
				bean.setImmagine(rs.getString("immagine"));
				bean.setIdProdotto(rs.getInt("idProdotto"));
				prod.add(bean);
			}
			rs.close();
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
