package nguyentrinhan70.example.com.connect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import nguyentrinhan70.example.com.model.NhaXuatBan;

public class NhaXuatBanService extends MySQLService {

	public ArrayList<NhaXuatBan> layToanBoNhaXuatBan(){
		ArrayList<NhaXuatBan> dsNxb = new ArrayList<>();
		try{
			String sql = "select * from nhaxuatban";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				
				NhaXuatBan nxb = new NhaXuatBan();
				nxb.setMaNxb(resultSet.getString(1));
				nxb.setTenNxb(resultSet.getString(2));
				nxb.setDiaChi(resultSet.getString(3));
				nxb.setSoPhone(resultSet.getString(4));
				dsNxb.add(nxb);
				
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return dsNxb;
	}
}
