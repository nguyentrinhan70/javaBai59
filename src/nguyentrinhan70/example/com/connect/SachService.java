package nguyentrinhan70.example.com.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import nguyentrinhan70.example.com.model.NhaXuatBan;
import nguyentrinhan70.example.com.model.Sach;

public class SachService extends MySQLService {
	public ArrayList<Sach> timSachTheoNhaXuatBan(String maNxb){
		ArrayList<Sach> dsSach = new ArrayList<>();
		try{
			String sql = "select * from sach where maNxb like ?";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, maNxb);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				
				Sach s = new Sach();
				s.setMaSach(resultSet.getString(1));
				s.setTenSach(resultSet.getString(2));
				s.setMaNxb(resultSet.getString(3));
				s.setSoTrang(resultSet.getInt(4));
				dsSach.add(s);
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dsSach;
	}
}
