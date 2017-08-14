package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

public class PagamentoBeanDao implements PagamentoBeanDaoInterface {

	private static final String TABLE_NAME = "pagamento";
	
	@Override
	public void doSave(PagamentoBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + PagamentoBeanDao.TABLE_NAME+ " (idpagamento, idcarrello, dataacquisto) VALUES (?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, data.getIdPagamento());
			preparedStatement.setInt(2, data.getIdCarrello());
			preparedStatement.setString(3, data.getDataAcquisto());
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
				bean.setDataAcquisto(rs.getString(3));
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
