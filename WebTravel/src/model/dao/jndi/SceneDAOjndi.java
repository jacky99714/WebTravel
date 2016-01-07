package model.dao.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.SceneBean;
import model.dao.SceneDAO;
import model.util.DataSourceConnection;
import model.util.TypeConveter;
import other.bean.FavoriteBean;

public class SceneDAOjndi implements SceneDAO {
	
	//select
	private static final String SELECT_ALL = "select * from scene";//把sql語法塞進java程式
	private static final String SELECT_BY_LOCATION = "select * from scene where location = ?";	
	private static final String SELECT_BY_ID = "select * from scene where sceneID = ?";	
	//insert
	private static final String INSERT = 
			"insert into scene"
		  + " (location,city,sceneName,scenePhoto,sceneContent,timeStart,timeEnd,MemberId) "
		  + "values(?, ?, ?, ?, ?, ?,?,?)";
	//update
	private static final String UPDATE = "update scene set location=?, city=?,"
		  + "sceneName=?,scenePhoto=?, sceneContent=?, timeStart=?, timeEnd=?, MemberId=?";	
	//delete
	private static final String DELETE_NAME = "delete from scene where sceneName=?";
	private static final String DELETE_ID  = "delete from scene where sceneid=?";
	
	
	private Connection conn = null;
	
	@Override
	public  List<SceneBean> select() {
		List<SceneBean> list = null;
		SceneBean sbean =null;
		try (
			//AutoCloseable
			Connection conn = DataSourceConnection.getConnection();
			 ){
			
			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);//把sql動態指令丟進來
			ResultSet rs = ps.executeQuery();// 結果集
			list = new ArrayList<SceneBean>();
			while(rs.next()){
				sbean = new SceneBean();				
				sbean.setSceneId(rs.getInt(1));//set欄位、get取得欄位資料
				sbean.setLocation(rs.getString(2));
				sbean.setCity(rs.getString(3));
				sbean.setSceneName(rs.getString(4));
				sbean.setScenePhoto(rs.getBytes(5));
				sbean.setSceneContent(rs.getString(6));
				sbean.setTimeStart(rs.getString(7));
				sbean.setTimeEnd(rs.getString(8));
				sbean.setMemberId(rs.getInt(9));
				list.add(sbean);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	//查詢SELECT_BY_LOCATION
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneDAO#select(java.lang.String)
	 */
	@Override
	public  List<FavoriteBean> select(String location) {
		try (
				Connection conn = DataSourceConnection.getConnection();
			 ){
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_LOCATION);
			ps.setString(1,location);
			ResultSet rs = ps.executeQuery();
			
			List<FavoriteBean> li = new ArrayList<>();
			FavoriteBean bean;
			while(rs.next()){
				bean = new FavoriteBean();
				bean.setSceneId(rs.getInt(1));
				bean.setLocation(rs.getString(2));
				bean.setCity(rs.getString(3));
				bean.setSceneName(rs.getString(4));
				bean.setScenePhoto(TypeConveter.EncodeBase64(rs.getBytes(5)));	
				bean.setSceneContent(rs.getString(6));
				bean.setTimeStart(rs.getString(7));
				bean.setTimeEnd(rs.getString(8));
				li.add(bean);		
			}
			return li;
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return null;
	}
	
	public  SceneBean select(int sceneId) {
		SceneBean sbean =null;
		try (
				Connection conn = DataSourceConnection.getConnection();
			 ){
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				sbean = new SceneBean();				
				sbean.setSceneId(rs.getInt(1));
				sbean.setLocation(rs.getString(2));
				sbean.setCity(rs.getString(3));
				sbean.setSceneName(rs.getString(4));
				sbean.setScenePhoto(rs.getBytes(5));
				sbean.setSceneContent(rs.getString(6));
				sbean.setTimeStart(rs.getString(7));
				sbean.setTimeEnd(rs.getString(8));
				sbean.setMemberId(rs.getInt(9));	
			}		
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	
		return sbean;
	}
	
	//新增INSERT
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneDAO#insert(model.SceneBean)
	 */
	@Override
	public SceneBean insert(SceneBean bean) {
		SceneBean result = null;
		try (
				Connection conn = DataSourceConnection.getConnection();
				){
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if(bean != null){
				ps.setString(1, bean.getLocation());
				ps.setString(2, bean.getCity());
				ps.setString(3, bean.getSceneName());
				ps.setBytes(4, bean.getScenePhoto());
				ps.setString(5, bean.getSceneContent());
				ps.setString(6, bean.getTimeStart());
				ps.setString(7, bean.getTimeEnd());
				ps.setInt(8, bean.getMemberId());
						
				int rs = ps.executeUpdate();
				if (rs == 1){
					result = bean;
			  }
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改UPDATE
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneDAO#update(model.SceneBean)
	 */
	@Override
	public SceneBean update(SceneBean bean){
		SceneBean result = null;
		try (
				Connection conn = DataSourceConnection.getConnection();	
				){
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if(bean != null){
				ps.setString(1, bean.getLocation());
				ps.setString(2, bean.getCity());
				ps.setString(3, bean.getSceneName());
				ps.setBytes(4, bean.getScenePhoto());
				ps.setString(5, bean.getSceneContent());
				ps.setString(6, bean.getTimeStart());
				ps.setString(7, bean.getTimeEnd());
				ps.setInt(8, bean.getMemberId());
						
				int rs = ps.executeUpdate();
				if (rs == 1){
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//刪除DELETE
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String sceneName) {
		try (
				Connection conn = DataSourceConnection.getConnection(); 	
					){
				PreparedStatement ps = conn.prepareStatement(DELETE_NAME);
				ps.setString(1, sceneName);							
				int rs = ps.executeUpdate();
				if (rs == 1){
					return true;
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	@Override
	public boolean delete(int sceneId) {
		try (
				Connection conn = DataSourceConnection.getConnection(); 	
					){
				PreparedStatement ps = conn.prepareStatement(DELETE_ID);
				ps.setInt(1, sceneId);							
				int rs = ps.executeUpdate();
				if (rs == 1){
					return true;
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	public static void main(String[] args){
		SceneDAO test = new SceneDAOjndi();
//----------------------------------------------------------
//		List<SceneBean> li= test.select();  //全部select
//		for(SceneBean e:li){
//			System.out.println(e);
//		}
//----------------------------------------------------------
//		System.out.println(test.select("北區"));  //單筆select
//----------------------------------------------------------
		SceneBean sbean = new SceneBean();
		sbean.setLocation("南區");
		sbean.setCity("台南市xxx");
		sbean.setSceneName("安平古堡");
		sbean.setSceneContent("安平古堡XXXXXXX");
		sbean.setTimeStart("09:00");
		sbean.setTimeEnd("21:00");
//    	sbean.setMemberId(1);
//		  
		System.out.println(test.insert(sbean)); // 新增資料
//----------------------------------------------------------
//		System.out.println(test.select("text123")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(test.update(sbean)); //修改
//----------------------------------------------------------
//		System.out.println(test.delete("安平古堡"));//刪除
//----------------------------------------------------------
//		FileOutputStream fo = new FileOutputStream("/Users/mouse/Desktop/4.jpg");   //把圖片取出來放桌面 
//		fo.write(m.select(2).getPhoto(), 0, t);
//		fo.close();
//----------------------------------------------------------
		
	}
}//class
