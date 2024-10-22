package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.nhaCungCapDao;
import models.dienthoai;
import models.nhacungcap;

public class nhaCungcapDaoImpl implements nhaCungCapDao{

	
	private DataSource dataSource;
	public nhaCungcapDaoImpl(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}

	@Override
	public List<nhacungcap> listNCC() {
		// TODO Auto-generated method stub
				String sql="select * from nhacungcap";
				List<nhacungcap> listncc= new ArrayList<>();
				
				try (
						Connection conn=dataSource.getConnection();
						PreparedStatement stmt=conn.prepareStatement(sql);
						ResultSet rs=stmt.executeQuery();
						){
					while(rs.next()) {
					nhacungcap ncc= new nhacungcap();
					ncc.setMancc(rs.getInt("mancc"));
					ncc.setDiachi(rs.getString("diachi"));
					ncc.setTennhacc(rs.getString("tenncc"));
					ncc.setSodiachi(rs.getString("sodienthoai"));
					
					listncc.add(ncc);
					
					
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				return listncc;
	}

	@Override
	public boolean addNCC(nhacungcap ncc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public nhacungcap getidNCC(int id) {
		String sql="select * from nhacungcap where mancc=?";
		try (
				Connection conn=dataSource.getConnection();
				PreparedStatement stmt=conn.prepareStatement(sql);
				){
			
			stmt.setInt(1, id);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) {
				nhacungcap dt= new nhacungcap();
				dt.setMancc(rs.getInt("mancc"));
				dt.setTennhacc(rs.getString("tenncc"));
				dt.setDiachi(rs.getString("diachi"));
				dt.setSodiachi(rs.getString("sodienthoai"));
				
				return dt;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
