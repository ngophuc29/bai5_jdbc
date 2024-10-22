package models;

public class dienthoai {
	
	private int maDT;
	private String tenDT;
	private int namsx;
	private String cauhinh;
	private nhacungcap nhacungcap;
	
	
	public dienthoai() {
		super();
		// TODO Auto-generated constructor stub
	}


	public dienthoai(int maDT, String tenDT, int namsx, String cauhinh,  nhacungcap nhacungcap) {
		super();
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.namsx = namsx;
		this.cauhinh = cauhinh;
		this.nhacungcap = nhacungcap;
	}


	public dienthoai(String tenDT, int namsx, String cauhinh,  nhacungcap nhacungcap) {
		super();
		this.tenDT = tenDT;
		this.namsx = namsx;
		this.cauhinh = cauhinh;
		this.nhacungcap = nhacungcap;
	}


	public int getMaDT() {
		return maDT;
	}


	public void setMaDT(int maDT) {
		this.maDT = maDT;
	}


	public String getTenDT() {
		return tenDT;
	}


	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}


	public int getNamsx() {
		return namsx;
	}


	public void setNamsx(int namsx) {
		this.namsx = namsx;
	}


	public String getCauhinh() {
		return cauhinh;
	}


	public void setCauhinh(String cauhinh) {
		this.cauhinh = cauhinh;
	}


	public nhacungcap getNhacungcap() {
		return nhacungcap;
	}


	public void setNhacungcap(nhacungcap nhacungcap) {
		this.nhacungcap = nhacungcap;
	}


	@Override
	public String toString() {
		return "dienthoai [maDT=" + maDT + ", tenDT=" + tenDT + ", namsx=" + namsx + ", cauhinh=" + cauhinh
				+ ", nhacungcap=" + nhacungcap + "]";
	}
	
	
}
