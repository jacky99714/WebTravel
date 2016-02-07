package model.dao.jndi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.bean.MemberBean;
import model.dao.MemberDAO;
import model.util.DataSourceConnection;

public class MemberDAOjndi implements MemberDAO {
	
	private static final String SELECT_ID = "SELECT * FROM Member WHERE memberID=?";
	private static final String SELECT_UESRNAME = "SELECT * FROM Member WHERE userName=?";
	private static final String SELECT = "SELECT * FROM Member";
	private static final String DELETE = "delete FROM Member where userName=?";
	private static final String INSERT = "insert into Member(userName,password,firstName,lastName,nickName,birthDay,address,cellphone,telephone,email,photo) values(?,?,?,?,?,?,?,?,?,?,?)";
//	private static final String INSERT = "insert into Member(userName,password,firstName,lastName,nickName,birthDay,address,cellphone,telephone,email) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE = "update Member set password=?,firstName=?,lastName=?,nickName=?,birthDay=?,address=?,cellphone=?,telephone=?,email=?,photo=? where userName=?";
	private static final String UPDATE_PASS = "update Member set password=?,firstName=?,lastName=?,nickName=?,birthDay=?,address=?,cellphone=?,telephone=?,email=? where userName=?";
	private static final String UPDATE_IMG = "update Member set password=?,firstName=?,lastName=?,nickName=?,birthDay=?,address=?,cellphone=?,telephone=?,email=? where userName=?";
	private static final String UPDATE_CONTEXT = "update Member set firstName=?,lastName=?,nickName=?,address=?,cellphone=?,telephone=?,email=? where userName=?";
	
	
	private Connection conn= null;
	
	public MemberBean updateContext(MemberBean memberBean){
		PreparedStatement ps=null;
		try (
				Connection conn = DataSourceConnection.getConnection();
				){
//			conn = DataSourceConnection.getConnection();
			ps = conn.prepareStatement(UPDATE_CONTEXT);
			ps.setString(1, memberBean.getFirstName());
			ps.setString(2, memberBean.getLastName());
			ps.setString(3, memberBean.getNickName());
			ps.setString(4, memberBean.getAddress());
			ps.setString(5, memberBean.getCellphone());
			ps.setString(6, memberBean.getTelephone());
			ps.setString(7, memberBean.getEmail());
			ps.setString(8, memberBean.getUserName());
			if(ps.executeUpdate()==1){
				return this.select(memberBean.getUserName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}

	@Override
	public List<MemberBean> select(){  //查詢
		try (
				Connection conn = DataSourceConnection.getConnection();
				){
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(SELECT);
			ResultSet rs = ps.executeQuery();
			List<MemberBean> list = new ArrayList<MemberBean>();
			while(rs.next()){
				MemberBean mBean =new MemberBean();
				mBean.setMemberId(rs.getInt(1));
				mBean.setUserName(rs.getString(2));
				mBean.setPassword(rs.getBytes(3));
				mBean.setFirstName(rs.getString(4));
				mBean.setLastName(rs.getString(5));
				mBean.setNickName(rs.getString(6));
				mBean.setBirthDay(rs.getDate(7));
				mBean.setAddress(rs.getString(8));
				mBean.setCellphone(rs.getString(9));
				mBean.setTelephone(rs.getString(10));
				mBean.setEmail(rs.getString(11));
//				mBean.setPhoto(rs.getBlob(12).getBytes(0,(int)rs.getBlob(12).length()));//b.getBytes(0,(int)rs.getBlob(12).length())
				mBean.setPhoto(rs.getBytes(12));
				list.add(mBean);
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
	 * @see model.dao.jdbc.MemberDAO#select(int)
	 */
	@Override
	public MemberBean select(int memberId){
		PreparedStatement ps=null;
		ResultSet rs =null;
		try (
				Connection conn = DataSourceConnection.getConnection();	
				){
//			conn = DataSourceConnection.getConnection();
			ps = conn.prepareStatement(SELECT_ID);
			ps.setInt(1, memberId);
			rs = ps.executeQuery();
			while(rs.next()){
				MemberBean mBean =new MemberBean();
				mBean.setMemberId(rs.getInt(1));
				mBean.setUserName(rs.getString(2));
				mBean.setPassword(rs.getBytes(3));
				mBean.setFirstName(rs.getString(4));
				mBean.setLastName(rs.getString(5));
				mBean.setNickName(rs.getString(6));
				mBean.setBirthDay(rs.getDate(7));
				mBean.setAddress(rs.getString(8));
				mBean.setCellphone(rs.getString(9));
				mBean.setTelephone(rs.getString(10));
				mBean.setEmail(rs.getString(11));
//				Blob b = rs.getBlob(12);
//				mBean.setPhoto(rs.getBlob(12));
				mBean.setPhoto(rs.getBytes(12));
				return mBean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.MemberDAO#select(java.lang.String)
	 */
	@Override
	public MemberBean select(String userName){
		PreparedStatement ps=null;
		ResultSet rs=null;
		try (
				Connection conn = DataSourceConnection.getConnection();
				){
//			conn = DataSourceConnection.getConnection();
			ps = conn.prepareStatement(SELECT_UESRNAME);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			while(rs.next()){
				MemberBean mBean =new MemberBean();
				mBean.setMemberId(rs.getInt(1));
				mBean.setUserName(rs.getString(2));
				mBean.setPassword(rs.getBytes(3));
				mBean.setFirstName(rs.getString(4));
				mBean.setLastName(rs.getString(5));
				mBean.setNickName(rs.getString(6));
				mBean.setBirthDay(rs.getDate(7));
				mBean.setAddress(rs.getString(8));
				mBean.setCellphone(rs.getString(9));
				mBean.setTelephone(rs.getString(10));
				mBean.setEmail(rs.getString(11));
//				mBean.setPhoto(rs.getBlob(12).getBytes(0,(int)rs.getBlob(12).length()));
				mBean.setPhoto(rs.getBytes(12));
				return mBean;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		
		return null;
	}
	//新增
	/* (non-Javadoc)
	 * @see model.dao.jdbc.MemberDAO#insert(model.MemberBean)
	 */
	@Override
	public MemberBean insert(MemberBean memberBean) {  //新增
		try(
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(INSERT);
			ps.setString(1, memberBean.getUserName());
			ps.setBytes(2, memberBean.getPassword());
			ps.setString(3, memberBean.getFirstName());
			ps.setString(4, memberBean.getLastName());
			ps.setString(5, memberBean.getNickName());
			ps.setDate(6, new java.sql.Date(memberBean.getBirthDay().getTime()));
			ps.setString(7, memberBean.getAddress());
			ps.setString(8, memberBean.getCellphone());
			ps.setString(9, memberBean.getTelephone());
			ps.setString(10, memberBean.getEmail());
			ps.setBytes(11, memberBean.getPhoto());
//			InputStream in = new FileInputStream(memberBean.getPhoto());//jdbc Blob 取圖片至fileinputstream
//			ps.setBinaryStream(11,in,memberBean.getPhoto().length());
			if(ps.executeUpdate()==1){
				return this.select(memberBean.getUserName());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.MemberDAO#update(model.MemberBean)
	 */
	@Override
	public MemberBean update(MemberBean memberBean){
		try(
				Connection conn = DataSourceConnection.getConnection();
				) {
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			ps.setString(11, memberBean.getUserName());
			ps.setBytes(1, memberBean.getPassword());
			ps.setString(2, memberBean.getFirstName());
			ps.setString(3, memberBean.getLastName());
			ps.setString(4, memberBean.getNickName());
			ps.setDate(5, new java.sql.Date(memberBean.getBirthDay().getTime()));
			ps.setString(6, memberBean.getAddress());
			ps.setString(7, memberBean.getCellphone());
			ps.setString(8, memberBean.getTelephone());
			ps.setString(9, memberBean.getEmail());
//			InputStream in = new FileInputStream(new String(memberBean.getPhoto()));
//			InputStream in = new FileInputStream(memberBean.getPhoto());//jdbc Blob 取圖片至fileinputstream
//			ps.setBinaryStream(10,in);
			ps.setBytes(10, memberBean.getPhoto());
			
			if(ps.executeUpdate()==1){
				return this.select(memberBean.getUserName());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceConnection.closeConnection();
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see model.dao.jdbc.MemberDAO#delete(java.lang.String)
	 */
	@Override
	public boolean delete(String userName){
		try (
				Connection conn = DataSourceConnection.getConnection();
				)
		{
//			conn = DataSourceConnection.getConnection();
			PreparedStatement ps = conn.prepareStatement(DELETE);
			ps.setString(1,userName);
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
	public static void main(String[] args) throws ParseException, IOException{
		MemberDAO m =new MemberDAOjndi();
		
//-----------------------圖片匯入-----------------------------------
		
		File f = new File("C:/Users/Student/Desktop/02.jpg");
		byte[] poto = new byte[(int)f.length()];
		FileInputStream fi = new FileInputStream(f);
		fi.read(poto);
		fi.close();
		
//--------------------------假資料--------------------------------
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MemberBean mb = new MemberBean();
		mb.setUserName("jack21");
		mb.setPassword("B".getBytes());
		mb.setFirstName("王");
		mb.setLastName("翔");
		mb.setNickName("mousssse");
		mb.setBirthDay(sdf.parse("1991-11-22"));
		mb.setAddress("台北市");
		mb.setCellphone("0919929sss9393");
		mb.setTelephone("02222sss22222");
		mb.setEmail("jsuusssssse@gmail.com");
		mb.setPhoto(poto);
		
//----------------------------------------------------------
		List<MemberBean> li= m.select();  //全部select
		for(MemberBean e:li){
			System.out.println(e);
		}
//----------------------------------------------------------
//		System.out.println(m.select(2));  //單筆select
//----------------------------------------------------------
//		System.out.println(m.insert(mb)); // 新增資料
//----------------------------------------------------------
//		System.out.println(m.select("text123")); //單筆select （帳號）
//----------------------------------------------------------
//		System.out.println(m.update(mb)); //修改
//----------------------------------------------------------
//		System.out.println(m.delete("jack1"));//刪除
//----------------------------------------------------------
//		FileOutputStream fo = new FileOutputStream("/Users/mouse/Desktop/7.jpg");   //把圖片取出來放桌面 
//		fo.write(m.select(6).getPhoto());
//		fo.close();
//----------------------------------------------------------
		
	}
}
