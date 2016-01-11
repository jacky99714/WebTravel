package model.dao.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.bean.ThoughtBean;
import model.dao.ThoughtDAO;
import model.util.DataSourceConnection;
import model.util.TypeConveter;

public class ThoughtDAOjndi implements ThoughtDAO {
	
	
	private static final String SELECT_ID = "SELECT * FROM Thought WHERE ThoughtID=?";
	private static final String SELECT_NAME = "SELECT * FROM Thought WHERE thoughtName=?";
	private static final String SELECT = "SELECT * FROM Thought";
	private static final String INSERT = "insert into Thought(thoughtName,thoughtContent,thoughtSubtitle,memberId) values(?,?,?,?)";
	private static final String UPDATE = "update Thought set thoughtName=?,thoughtContent=?,thoughtSubtitle=?,memberId=? where ThoughtID=?";
	private static final String DELETE = "delete FROM Thought where ThoughtID=?";


	
	@Override
	public List<ThoughtBean> select(){
		try(
				Connection conn = DataSourceConnection.getConnection();
				)  {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<ThoughtBean> list = new ArrayList<ThoughtBean>();
			while(rs.next()){
				ThoughtBean tBean =new ThoughtBean();
				tBean.setThoughtId(rs.getInt(1));
				tBean.setThoughtName(rs.getString(2));
				tBean.setThoughtContent(rs.getString(3));
				tBean.setThoughtSubtitle(rs.getString(4));
				tBean.setThoughtTime(TypeConveter.parseTimestamp(rs.getString(5)));
				tBean.setMemberId(rs.getInt(6));
				list.add(tBean);
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
	 * @see model.dao.jdbc.ThoughtDAO#select(java.lang.String)
	 */
	@Override

	public List<ThoughtBean> select(String thoughtName){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
//			SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			PreparedStatement ps = conn.prepareStatement(SELECT_NAME);
			ps.setString(1, thoughtName);
			ResultSet rs = ps.executeQuery();
			ThoughtBean tBean= null;
			List<ThoughtBean> list = new ArrayList<ThoughtBean>();
			while(rs.next()){
				tBean = new ThoughtBean();
				tBean.setThoughtId(rs.getInt(1));
				tBean.setThoughtName(rs.getString(2));
				tBean.setThoughtContent(rs.getString(3));
				tBean.setThoughtSubtitle(rs.getString(4));
				tBean.setThoughtTime(TypeConveter.parseTimestamp(rs.getString(5)));
				tBean.setMemberId(rs.getInt(6));
				list.add(tBean);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ThoughtDAO#select(int)
	 */
	@Override
	public ThoughtBean select(int thoughtId){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, thoughtId);
			ResultSet rs = ps.executeQuery();
			ThoughtBean tBean = null;
			while(rs.next()){
				tBean = new ThoughtBean();
				tBean.setThoughtId(rs.getInt(1));
				tBean.setThoughtName(rs.getString(2));
				tBean.setThoughtContent(rs.getString(3));
				tBean.setThoughtSubtitle(rs.getString(4));
				tBean.setThoughtTime(TypeConveter.parseTimestamp(rs.getString(5)));
				tBean.setMemberId(rs.getInt(6));
			}
			return tBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ThoughtDAO#update(model.ThoughtBean)
	 */
	@Override
	public ThoughtBean update(ThoughtBean thoughtBean){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(5, thoughtBean.getThoughtId());
			ps.setString(1, thoughtBean.getThoughtName());
			ps.setString(2, thoughtBean.getThoughtContent());
			ps.setString(3, thoughtBean.getThoughtSubtitle());
//			ps.setTimestamp(4, TypeConveter.parseTimestamp(thoughtBean.getThoughtTime()));
			ps.setInt(4, thoughtBean.getMemberId());
			if(ps.executeUpdate()==1){
				return this.select(thoughtBean.getThoughtId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ThoughtDAO#insert(model.ThoughtBean)
	 */
	@Override
	public ThoughtBean insert(ThoughtBean thoughtBean){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, thoughtBean.getThoughtName());
			ps.setString(2, thoughtBean.getThoughtContent());
			ps.setString(3, thoughtBean.getThoughtSubtitle());
//			ps.setTimestamp(4, TypeConveter.parseTimestamp(thoughtBean.getThoughtTime()));
			ps.setInt(4, thoughtBean.getMemberId());
			if(ps.executeUpdate()==1){
				return this.select(thoughtBean.getThoughtId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ThoughtDAO#delete(int)
	 */
	@Override
	public boolean delete(int thoughtId){
		try (
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,thoughtId);
			if(ps.executeUpdate()==1){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static void main(String[] args){
		ThoughtDAO t = new ThoughtDAOjndi();
		
		ThoughtBean tb = new ThoughtBean();
		tb.setThoughtId(1);
		tb.setThoughtName("台中花海節");
		tb.setThoughtSubtitle("景點");
		tb.setThoughtContent("去台中玩還可以吃東東芋圓 非常不錯得景點");
		tb.setMemberId(1);
		
//		tb.setThoughtId(1);
//		tb.setThoughtName("台東熱氣球");
//		tb.setThoughtSubtitle("景點");
//		tb.setThoughtContent("泡溫泉 又可以看風景 還可以熱氣球唷");
//		tb.setMemberId(3);
//----------------------------------------------------------
		for(ThoughtBean e : t.select()){
			System.out.println(e);
		}
//----------------------------------------------------------
//		System.out.println(t.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(t.insert(tb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(t.select("花蓮一日遊")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(t.update(tb)); //修改
//----------------------------------------------------------
//		System.out.println(t.delete(1));//刪除
//----------------------------------------------------------
		
	}
}
