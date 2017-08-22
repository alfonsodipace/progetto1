package bean;

import java.sql.SQLException;
import java.util.Collection;

public interface PagamentoBeanDaoInterface {

	public void doSave(PagamentoBean data) throws SQLException;

	public void doDelete(PagamentoBean data) throws SQLException;
	
	public PagamentoBean doRetrieveByKey(String idpagamento) throws SQLException;
	
	
	public Collection<PagamentoBean> doRetrieveAll(String order) throws SQLException;
	
}
