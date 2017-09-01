package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface Riempie1BeanDaoInterface {
	
	public void doSave(Riempie1Bean data) throws SQLException;

	public void doDelete(Riempie1Bean data) throws SQLException;
	
	public ArrayList<Riempie1Bean> doRetrieveByKey(String nome) throws SQLException;
	
	public Collection<Riempie1Bean> doRetrieveAll(String order) throws SQLException;
}
