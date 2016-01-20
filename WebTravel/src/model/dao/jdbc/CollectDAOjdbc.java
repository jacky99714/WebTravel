package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.CollectBean;
import model.dao.CollectDAO;
import model.util.DataSourceConnection;
import model.util.JdbcConnection;
import model.util.TypeConveter;
import other.bean.FavoriteBean;




public class CollectDAOjdbc implements CollectDAO {

	
	private static final String SELECT_MEMBERID = "SELECT * FROM Collect WHERE MemberID=?";
	private static final String SELECT_SCENEID = "SELECT * FROM Collect WHERE SceneID=?";
	private static final String SELECT = "SELECT memberId,sceneId,collectId FROM Collect";
	private static final String INSERT = "insert into Collect(memberId,sceneId,collectId) values(?,?,?)";
	private static final String UPDATE = "update Collect set collectId=? where MemberID=? and sceneId=?";
	private static final String DELETE = "delete FROM Collect where memberId=? and sceneId=?";
	private static final String SELECT_SCENE =
			"select s.SceneID, s.Location,s.City,s.SceneName,s.Scenephoto,s.SceneContent,s.TimeStart,s.TimeEnd from Collect as c join Scene as s  on c.SceneID = s.SceneID where c.MemberID=? ";  
	private Connection conn= null;
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.CollectDAO#select()
	 */
	@Override
	public List<CollectBean> select(){
		try {
			conn =  JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<CollectBean> list = new ArrayList<CollectBean>();
			while(rs.next()){
				CollectBean cBean =new CollectBean();
				cBean.setCollectId(rs.getInt(3));
				cBean.setMemberId(rs.getInt(1));
				cBean.setSceneId(rs.getInt(2));
				list.add(cBean);
			}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	//會員對景點做收藏 把一個會員收藏的景點查詢出來
	/* (non-Javadoc)
	 * @see model.dao.jdbc.CollectDAO#select(int)
	 */
	@Override
	public List<CollectBean> select(int memberId){
		try {
			conn =  JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_MEMBERID);
			ps.setInt(1, memberId);
			ResultSet rs = ps.executeQuery();
			List<CollectBean> list = new ArrayList<CollectBean>();
			while(rs.next()){
				CollectBean cBean =new CollectBean();
				cBean.setMemberId(rs.getInt(1));
				cBean.setSceneId(rs.getInt(2));
				cBean.setCollectId(rs.getInt(3));
				list.add(cBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.CollectDAO#insert(model.CollectBean)
	 */
	@Override
	public List<CollectBean> insert(CollectBean collectBean){
		try {
			conn =  JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setInt(1, collectBean.getMemberId());
			ps.setInt(2, collectBean.getSceneId());
			ps.setInt(3, collectBean.getCollectId());
		
			if(ps.executeUpdate()==1){
				return this.select(collectBean.getMemberId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.CollectDAO#update(model.CollectBean)
	 */
	@Override
	public List<CollectBean> update(CollectBean collectBean){
		try {
			conn =  JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(2, collectBean.getMemberId());
			ps.setInt(3, collectBean.getSceneId());
			ps.setInt(1, collectBean.getCollectId());

			if(ps.executeUpdate()==1){
				return this.select(collectBean.getMemberId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.CollectDAO#delete(int, int)
	 */
	@Override
	public boolean delete(int memberId,int sceneId){
		try {
			conn =  JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,memberId);
			ps.setInt(2,sceneId);
			if(ps.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return false;
	}
	
	@Override
	public List<FavoriteBean> selectScene(int memberId) {
		try {
			//s.SceneID,s.Location,s.City,s.SceneName,s.Scenephoto,s.SceneContent,s.TimeStart,s.TimeEnd
			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_SCENE);
			ps.setInt(1, memberId);
			ResultSet rs = ps.executeQuery();
			List<FavoriteBean> li = new ArrayList<>();
			FavoriteBean bean;
			String temp;
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
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}	
	
	public static void main(String[] args){
		CollectDAO t = new CollectDAOjdbc();
		
		CollectBean cb = new CollectBean();

		
		cb.setCollectId(10); //對此景點收藏為 0 永久收藏為 1
		cb.setMemberId(3); //哪一個會員
		cb.setSceneId(4); //對哪一個景點

//----------------------------------------------------------
//		for(CollectBean e : t.select()){
//			System.out.println(e);
//		}
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
		System.out.println(t.insert(cb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(t.update(cb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(1,1));//刪除
//----------------------------------------------------------
	}

}
