package bean;

import java.sql.SQLException;
import java.util.Collection;

public interface Riempie2BeanDaoInterface {
	
	public void doSave(Riempie2Bean data) throws SQLException;

	public void doDelete(Riempie2Bean data) throws SQLException;
	
	public Riempie2Bean doRetrieveByKey(String nome) throws SQLException;
	
	public Collection<Riempie2Bean> doRetrieveAll(String order) throws SQLException;
}
