package dao;

import java.util.List;

import models.dienthoai;

public interface dienthoaiDao {

	public List<dienthoai>getAll();
	public boolean addDienThoai(dienthoai dt);
	public boolean updateDienThoai(dienthoai dt);
	public boolean deleteDienThoai(int id);
	public dienthoai dt(int id);
	
}
