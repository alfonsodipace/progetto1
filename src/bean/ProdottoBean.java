package bean;

public class ProdottoBean {
	private String nome;
	private String tipo;
	private String desc;
	private double prezzo;
	private int disp;
	private int venduti;
	private String immagine;
	
	public String getImmagine() {
		return immagine;
	}
	public void setImmagine(String immagine) {
		this.immagine = immagine;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	public int getDisp() {
		return disp;
	}
	public void setDisp(int disp) {
		this.disp = disp;
	}
	public int getVenduti() {
		return venduti;
	}
	public void setVenduti(int venduti) {
		this.venduti = venduti;
	}
}
