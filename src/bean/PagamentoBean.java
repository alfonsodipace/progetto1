package bean;

import java.util.Date;

public class PagamentoBean {

	private int idPagamento;
	private int idCarrello;
	private Date dataAcquisto;
	private String email;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdPagamento() {
		return idPagamento;
	}
	public void setIdPagamento(int idPagamento) {
		this.idPagamento = idPagamento;
	}
	public int getIdCarrello() {
		return idCarrello;
	}
	public void setIdCarrello(int idCarrello) {
		this.idCarrello = idCarrello;
	}
	public Date getDataAcquisto() {
		return dataAcquisto;
	}
	public void setDataAcquisto(Date dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}	
}
