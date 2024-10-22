package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.dienthoaiDao;
import models.dienthoai;
import models.nhacungcap;

public class dienthoaiDaoImpl implements dienthoaiDao {

	private DataSource dataSource;

	public dienthoaiDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<dienthoai> getAll() {
		List<dienthoai> listDt = new ArrayList<>();
		String sql = "select * from dienthoai";

		try (Connection conn = dataSource.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();) {

			while (rs.next()) {
				dienthoai dt = new dienthoai();
				dt.setMaDT(rs.getInt("maDT"));
				dt.setTenDT(rs.getString("tendt"));
				dt.setNamsx(rs.getInt("namsx"));
				dt.setCauhinh(rs.getString("cauhinh"));
				dt.setNhacungcap(new nhacungcap(rs.getInt("mancc")));

				listDt.add(dt);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return listDt;
	}

	@Override
	public boolean addDienThoai(dienthoai dt) {
		// TODO Auto-generated method stub
		String sql = "insert into dienthoai (tendt,namsx,cauhinh,mancc) values(?,?,?,?)";
		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql);) {

			stmt.setString(1, dt.getTenDT());
			stmt.setInt(2, dt.getNamsx());
			stmt.setString(3, dt.getCauhinh());
			stmt.setInt(4, dt.getNhacungcap().getMancc());
			
			int rowChange=stmt.executeUpdate();
			return rowChange>0;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateDienThoai(dienthoai dt) {
		// TODO Auto-generated method stub
		
		String sql="update dienthoai set tendt=?,namsx=? , cauhinh=? where maDT=?";
		
		try (
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			stmt.setString(1, dt.getTenDT());
			stmt.setInt(2, dt.getNamsx());
			stmt.setString(3, dt.getCauhinh());
			stmt.setInt(4, dt.getMaDT());
			
			int rowChange=stmt.executeUpdate();
			return rowChange>0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDienThoai(int id) {
		// TODO Auto-generated method stub
		String sql="delete from dienthoai where maDT=?";
		try (
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			stmt.setInt(1, id);
			
			int rowchange=stmt.executeUpdate();
			return rowchange>0;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public dienthoai dt(int id) {
		// TODO Auto-generated method stub
		
		String sql="select * from dienthoai where maDT=?";
		try (
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				dienthoai dt= new dienthoai();
				dt.setMaDT(rs.getInt("maDT"));
				dt.setTenDT(rs.getString("tendt"));
				dt.setNamsx(rs.getInt("namsx"));
				dt.setCauhinh(rs.getString("cauhinh"));
				dt.setNhacungcap(new nhacungcap(rs.getInt("mancc")));
				
				return dt;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
