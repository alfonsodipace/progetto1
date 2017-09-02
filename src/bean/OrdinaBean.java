package bean;

import java.util.Date;

public class OrdinaBean {
 private String email;
 private int idProdotto;
 private Date dataOrdine;
	
	public OrdinaBean() { }

	public int getIdProdotto() {
		return idProdotto;
	}

	public void setIdProdotto(int idProdotto) {
		this.idProdotto = idProdotto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataOrdine() {
		return dataOrdine;
	}

	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
 
 
 
 
}
