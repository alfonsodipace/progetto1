package bean;

import java.sql.SQLException;
import java.util.Collection;

public interface CarrelloBeanDaoInterface {
	
	public void doSave(CarrelloBean data) throws SQLException;

	public void doDelete(CarrelloBean data) throws SQLException;
	
	public CarrelloBean doRetrieveByKey(String nome) throws SQLException;
	
	
	public Collection<CarrelloBean> doRetrieveAll(String order) throws SQLException;
}
