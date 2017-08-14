package bean;

import java.sql.SQLException;
import java.util.Collection;

public interface MenuBeanDaoInterface {

	public void doSave(MenuBean data) throws SQLException;

	public void doDelete(MenuBean data) throws SQLException;
	
	public MenuBean doRetrieveByKey(String idmenu) throws SQLException;
	
	
	public Collection<MenuBean> doRetrieveAll(String order) throws SQLException;
	
}
