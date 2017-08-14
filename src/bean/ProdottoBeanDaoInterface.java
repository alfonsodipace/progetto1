package bean;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoBeanDaoInterface {
	
	public void doSave(ProdottoBean data) throws SQLException;

	public void doDelete(ProdottoBean data) throws SQLException;
	
	public ProdottoBean doRetrieveByKey(String nome) throws SQLException;
	
	
	public Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException;
}
