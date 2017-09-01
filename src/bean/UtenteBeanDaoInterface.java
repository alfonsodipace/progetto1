package bean;

import java.sql.SQLException;
import java.util.Collection;

public interface UtenteBeanDaoInterface {
	
	public void doSave(UtenteBean data) throws SQLException;

	public UtenteBean doRetrieveByKey(String email) throws SQLException;
	
	public void doUpdate (UtenteBean data) throws SQLException;
	
	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException;

	
}
