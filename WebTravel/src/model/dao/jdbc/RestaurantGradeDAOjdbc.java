package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.RestaurantGradeBean;
import model.dao.RestaurantGradeDAO;
import model.util.JdbcConnection;


public class RestaurantGradeDAOjdbc implements RestaurantGradeDAO {

	
	private static final String SELECT_MEMBERID = "SELECT * FROM RestaurantGrade WHERE MemberID=?";
	private static final String SELECT_RESTAURANTID = "SELECT memberId,RestaurantID,Evaluate FROM RestaurantGrade WHERE RestaurantID=?";
	private static final String SELECT = "SELECT memberId,RestaurantID,Evaluate FROM RestaurantGrade";
	private static final String INSERT = "insert into RestaurantGrade(memberId,RestaurantID,Evaluate) values(?,?,?)";
	private static final String UPDATE = "update RestaurantGrade set Evaluate=? where MemberID=? and RestaurantID=?";
	private static final String DELETE = "delete FROM RestaurantGrade where memberId=? and RestaurantID=?";
	private Connection conn= null;
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantGradeDAO#select()
	 */
	@Override
	public List<RestaurantGradeBean> select(){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<RestaurantGradeBean> list = new ArrayList<RestaurantGradeBean>();
			while(rs.next()){
				RestaurantGradeBean cBean =new RestaurantGradeBean();
				cBean.setMemberId(rs.getInt(1));
				cBean.setRestaurantId(rs.getInt(2));
				cBean.setEvaluate(rs.getInt(3));
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
	 * @see model.dao.jdbc.RestaurantGradeDAO#select(int)
	 */
	@Override
	public List<RestaurantGradeBean> select(int restaurantId){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_RESTAURANTID);
			ps.setInt(1, restaurantId);
			ResultSet rs = ps.executeQuery();
			List<RestaurantGradeBean> list = new ArrayList<RestaurantGradeBean>();
			while(rs.next()){
				RestaurantGradeBean cBean =new RestaurantGradeBean();
				cBean.setRestaurantId(rs.getInt(2));
				cBean.setMemberId(rs.getInt(1));
				cBean.setEvaluate(rs.getInt(3));
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
	 * @see model.dao.jdbc.RestaurantGradeDAO#insert(model.RestaurantGradeBean)
	 */
	@Override
	public List<RestaurantGradeBean> insert(RestaurantGradeBean restaurantGradeBean){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setInt(1, restaurantGradeBean.getMemberId());
			ps.setInt(2, restaurantGradeBean.getRestaurantId());
			ps.setInt(3, restaurantGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(restaurantGradeBean.getRestaurantId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantGradeDAO#update(model.RestaurantGradeBean)
	 */
	@Override
	public List<RestaurantGradeBean> update(RestaurantGradeBean restaurantGradeBean){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(2, restaurantGradeBean.getMemberId());
			ps.setInt(3, restaurantGradeBean.getRestaurantId());
			ps.setInt(1, restaurantGradeBean.getEvaluate());

			if(ps.executeUpdate()==1){
				return this.select(restaurantGradeBean.getRestaurantId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantGradeDAO#delete(int, int)
	 */
	@Override
	public boolean delete(int memberId,int restaurantId){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,memberId);
			ps.setInt(2,restaurantId);
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
	public static void main(String[] args){
		RestaurantGradeDAO t = new RestaurantGradeDAOjdbc();
		
		RestaurantGradeBean cb = new RestaurantGradeBean();

		cb.setRestaurantId(1);
		cb.setMemberId(4);
		cb.setEvaluate(0);
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(cb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(t.update(cb)); //修改
//----------------------------------------------------------
		System.out.println(t.delete(2,2));//刪除
//----------------------------------------------------------
		for(RestaurantGradeBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
	}
}
