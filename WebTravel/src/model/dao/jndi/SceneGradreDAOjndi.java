package model.dao.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.SceneGradeBean;
import model.dao.SceneGradreDAO;
import model.util.DataSourceConnection;


public class SceneGradreDAOjndi implements SceneGradreDAO {

	
	private static final String SELECT_MEMBERID = "SELECT * FROM SceneGrade WHERE MemberID=?";
	private static final String SELECT_SCENEID = "SELECT memberId,SceneID,Evaluate FROM SceneGrade WHERE SceneID=?";
	private static final String SELECT = "SELECT memberId,SceneID,Evaluate FROM SceneGrade";
	private static final String INSERT = "insert into SceneGrade(memberId,SceneID,Evaluate) values(?,?,?)";
	private static final String UPDATE = "update SceneGrade set Evaluate=? where MemberID=? and SceneID=?";
	private static final String DELETE = "delete FROM SceneGrade where memberId=? and SceneID=?";
	private Connection conn= null;
	
	@Override
	public List<SceneGradeBean> select(){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<SceneGradeBean> list = new ArrayList<SceneGradeBean>();
			while(rs.next()){
				SceneGradeBean cBean =new SceneGradeBean();
				cBean.setMemberId(rs.getInt(1));
				cBean.setSceneId(rs.getInt(2));
				cBean.setEvaluate(rs.getInt(3));
				list.add(cBean);
			}
		return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneGradreDAO#select(int)
	 */
	@Override
	public List<SceneGradeBean> select(int sceneId){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_SCENEID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			List<SceneGradeBean> list = new ArrayList<SceneGradeBean>();
			while(rs.next()){
				SceneGradeBean cBean =new SceneGradeBean();
				cBean.setSceneId(rs.getInt(2));
				cBean.setMemberId(rs.getInt(1));
				cBean.setEvaluate(rs.getInt(3));
				list.add(cBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneGradreDAO#insert(model.SceneGradeBean)
	 */
	@Override
	public List<SceneGradeBean> insert(SceneGradeBean sceneGradeBean){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setInt(1, sceneGradeBean.getMemberId());
			ps.setInt(2, sceneGradeBean.getSceneId());
			ps.setInt(3, sceneGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(sceneGradeBean.getSceneId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneGradreDAO#update(model.SceneGradeBean)
	 */
	@Override
	public List<SceneGradeBean> update(SceneGradeBean sceneGradeBean){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(2, sceneGradeBean.getMemberId());
			ps.setInt(3, sceneGradeBean.getSceneId());
			ps.setInt(1, sceneGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(sceneGradeBean.getSceneId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneGradreDAO#delete(int, int)
	 */
	@Override
	public boolean delete(int memberId,int sceneId){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,memberId);
			ps.setInt(2,sceneId);
			if(ps.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return false;
	}
	public static void main(String[] args){
		SceneGradreDAO t = new SceneGradreDAOjndi();
		
		SceneGradeBean cb = new SceneGradeBean();

		cb.setSceneId(1);
		cb.setMemberId(5);
		cb.setEvaluate(11);
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(cb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.update(cb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(2,2));//刪除
//----------------------------------------------------------
		for(SceneGradeBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
	}
}
