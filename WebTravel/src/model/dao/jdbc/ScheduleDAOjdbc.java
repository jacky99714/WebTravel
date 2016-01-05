package model.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.ScheduleBean;
import model.dao.ScheduleDAO;
import model.util.DataSourceConnection;
import model.util.JdbcConnection;

public class ScheduleDAOjdbc implements ScheduleDAO {
	
	private static final String SELECT_ID = "SELECT * FROM Schedule WHERE ScheduleID=?";
	private static final String SELECT = "SELECT * FROM Schedule";
	private static final String INSERT = "insert into Schedule(scheduleName,memberId) values(?,?)";
	private static final String UPDATE = "update Schedule set scheduleName=?,memberId=? where scheduleID=?";
	private static final String DELETE = "delete FROM Schedule where ScheduleID=?";
	private static final String SELECT_MEMBERID = "SELECT * FROM Schedule WHERE MEMBERID=?";
	
	private Connection conn= null;

	
	
	
	//對會員的行程做select
		public List<ScheduleBean> selectMember(int MemberId){
			try (
					Connection conn = JdbcConnection.getConnection();
					) {
//				conn = DataSourceConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(SELECT_MEMBERID);
				ps.setInt(1, MemberId);
				ResultSet rs = ps.executeQuery();
				List<ScheduleBean> list = new ArrayList<ScheduleBean>();
				while(rs.next()){
					ScheduleBean sBean =new ScheduleBean();
					sBean.setScheduleId(rs.getInt(1));
					sBean.setMemberId(rs.getInt(2));
					sBean.setScheduleName(rs.getString(3));
					list.add(sBean);
				}
				return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				JdbcConnection.closeConnection();
			}
			return null;
		}
	
	
	
	//查詢
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ScheduleDAO#select(int)
	 */
	@Override
	public ScheduleBean select(int scheduleId){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, scheduleId);
			ResultSet rs = ps.executeQuery();
			ScheduleBean sBean =new ScheduleBean();
			while(rs.next()){
				sBean.setScheduleId(rs.getInt(1));
				sBean.setMemberId(rs.getInt(2));
				sBean.setScheduleName(rs.getString(3));
			}
			return sBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ScheduleDAO#select()
	 */
	@Override
	public List<ScheduleBean> select(){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<ScheduleBean> list =new ArrayList<ScheduleBean>();
			while(rs.next()){
				ScheduleBean sBean =new ScheduleBean();
				sBean.setScheduleId(rs.getInt(1));
				sBean.setMemberId(rs.getInt(2));
				sBean.setScheduleName(rs.getString(3));
				list.add(sBean);
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
	 * @see model.dao.jdbc.ScheduleDAO#insert(model.ScheduleBean)
	 */
	@Override
	public boolean insert(ScheduleBean scheduleBean){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, scheduleBean.getScheduleName());
			ps.setInt(2, scheduleBean.getMemberId());
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
	
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ScheduleDAO#update(model.ScheduleBean)
	 */
	@Override
	public ScheduleBean update(ScheduleBean scheduleBean){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setInt(3, scheduleBean.getScheduleId());
			ps.setString(1, scheduleBean.getScheduleName());
			ps.setInt(2, scheduleBean.getMemberId());
			if(ps.executeUpdate()==1){
				return this.select(scheduleBean.getScheduleId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.ScheduleDAO#delete(int)
	 */
	@Override
	public boolean delete(int scheduleId){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setInt(1,scheduleId);
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
	public int getInsertId(ScheduleBean scheduleBean){
		try {
			conn = JdbcConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, scheduleBean.getScheduleName());
			ps.setInt(2, scheduleBean.getMemberId());
			
			if(ps.executeUpdate()==1){
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()){
					return rs.getInt(1);
				}else{
					return 0;
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return 0;
	}		
	
	public static void main(String[] args){
		ScheduleDAO s = new ScheduleDAOjdbc();
		ScheduleBean sb = new ScheduleBean();
		sb.setScheduleId(11);
		sb.setMemberId(1);
		sb.setScheduleName("知本泡湯旅行祕笈");
		System.out.println(s.selectMember(1));
//----------------------------------------------------------
//		for(ScheduleBean e : s.selectMember(1)){
//			System.out.println(e);
//		}
//----------------------------------------------------------
//		System.out.println(s.select(1));  //單筆select
//----------------------------------------------------------
//		System.out.println(s.insert(sb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(s.update(sb)); //修改
//----------------------------------------------------------
//		System.out.println(s.delete(1));//刪除
//----------------------------------------------------------
		
	}
}
