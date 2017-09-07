package bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public interface OrdinaBeanInterface {

	void doSave(OrdinaBean data) throws SQLException;

	void doDelete(OrdinaBean data) throws SQLException;


	ArrayList<OrdinaBean> doRetrieveByKey(String email) throws SQLException;

	ArrayList<OrdinaBean> doRetrieveAll() throws SQLException;

}
