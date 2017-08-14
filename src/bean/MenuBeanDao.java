package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class MenuBeanDao implements MenuBeanDaoInterface {
	
	private static final String TABLE_NAME = "menu";

	@Override
	public void doSave(MenuBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + MenuBeanDao.TABLE_NAME+ " (idmenu, nome, prezzo, datainizio, datafine) VALUES (?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, data.getIdmenu());
			preparedStatement.setString(2, data.getNome());
			preparedStatement.setDouble(3, data.getPrezzo());
			preparedStatement.setString(4, data.getDataInizio());
			preparedStatement.setString(5, data.getDataFine());
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
	public void doDelete(MenuBean data) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "DELETE FROM " + MenuBeanDao.TABLE_NAME + " WHERE idmenu= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, data.getIdmenu());
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
	public MenuBean doRetrieveByKey(String idmenu) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		MenuBean bean = new MenuBean();

		String selectSQL = "SELECT * FROM " + MenuBeanDao.TABLE_NAME + " WHERE idmenu = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, idmenu);

			ResultSet rs = (ResultSet) preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdmenu(rs.getInt(1));
				bean.setNome(rs.getString(2));
				bean.setPrezzo(rs.getDouble(3));
				bean.setDataInizio(rs.getString(4));
				bean.setDataFine(rs.getString(5));
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
	public Collection<MenuBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<MenuBean> menu = new LinkedList<MenuBean>();

		String selectSQL = "SELECT * FROM " + MenuBeanDao.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				MenuBean bean = new MenuBean();

				bean.setIdmenu(rs.getInt("idmenu"));
				bean.setNome(rs.getString("nome"));
				bean.setPrezzo(rs.getDouble("prezzo"));
				bean.setDataInizio(rs.getString("datainizio"));
				bean.setDataFine(rs.getString("datafine"));
				menu.add(bean);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return menu;
	}

}
