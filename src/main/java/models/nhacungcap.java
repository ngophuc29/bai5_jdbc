package models;

public class nhacungcap {

	private int mancc;
	private String tennhacc;
	private String diachi;
	private String sodiachi;
	public nhacungcap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public nhacungcap(int mancc, String tennhacc, String diachi, String sodiachi) {
		super();
		this.mancc = mancc;
		this.tennhacc = tennhacc;
		this.diachi = diachi;
		this.sodiachi = sodiachi;
	}
	public nhacungcap(String tennhacc, String diachi, String sodiachi) {
		super();
		this.tennhacc = tennhacc;
		this.diachi = diachi;
		this.sodiachi = sodiachi;
	}
	
	public nhacungcap(int mancc) {
		super();
		this.mancc = mancc;
	}
	public int getMancc() {
		return mancc;
	}
	public void setMancc(int mancc) {
		this.mancc = mancc;
	}
	public String getTennhacc() {
		return tennhacc;
	}
	public void setTennhacc(String tennhacc) {
		this.tennhacc = tennhacc;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getSodiachi() {
		return sodiachi;
	}
	public void setSodiachi(String sodiachi) {
		this.sodiachi = sodiachi;
	}
	@Override
	public String toString() {
		return "nhacungcap [mancc=" + mancc + ", tennhacc=" + tennhacc + ", diachi=" + diachi + ", sodiachi=" + sodiachi
				+ "]";
	}
	
}
