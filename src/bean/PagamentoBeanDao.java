package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

public class PagamentoBeanDao implements PagamentoBeanDaoInterface {

	private static final String TABLE_NAME = "pagamento";
	
	@Override
	public void doSave(PagamentoBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + PagamentoBeanDao.TABLE_NAME+ " (idcarrello, dataacquisto, email) VALUES (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, data.getIdCarrello());
			preparedStatement.setDate(2, new java.sql.Date(data.getDataAcquisto().getTime()));
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
	public void doDelete(PagamentoBean data) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PagamentoBean doRetrieveByKey(String idpagamento) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		PagamentoBean bean = new PagamentoBean();

		String selectSQL = "SELECT * FROM " + PagamentoBeanDao.TABLE_NAME + " WHERE idacquisto = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, idpagamento);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdPagamento(rs.getInt(1));
				bean.setIdCarrello(rs.getInt(2));
				bean.setDataAcquisto(rs.getDate(3));
				bean.setEmail(rs.getString(4));
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
	public Collection<PagamentoBean> doRetrieveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
