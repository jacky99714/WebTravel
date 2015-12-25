package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.bean.SceneBean;
import model.dao.jndi.SceneDAOjndi;
import model.util.DataSourceConnection;
import model.util.TypeConveter;

public class SceneData {
	private static String SQL = "update scene set ScenePhoto = ? where sceneid = ?";
	public void insert(){
		SceneDAOjndi s = new SceneDAOjndi();
		SceneBean bean = new SceneBean();
		bean.setScenePhoto(TypeConveter.parseByteArray("E:/image/firen.png"));
		System.out.println(bean.getScenePhoto());
		System.out.println("AAAA");
		try (
				Connection conn = DataSourceConnection.getConnection();
				){
			PreparedStatement ps = conn.prepareStatement(SQL);
			if(bean != null){
				ps.setBytes(1, bean.getScenePhoto());
				ps.setString(2, "1");
				int rs = ps.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
