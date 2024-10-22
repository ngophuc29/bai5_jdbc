package dao;

import java.util.List;

import models.nhacungcap;

public interface nhaCungCapDao {

	public List<nhacungcap> listNCC();
	public boolean addNCC(nhacungcap ncc);
	public nhacungcap getidNCC(int id);
}
