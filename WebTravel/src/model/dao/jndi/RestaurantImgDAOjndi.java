package model.dao.jndi;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.RestaurantImgBean;
import model.dao.RestaurantImgDAO;
import model.dao.RestaurantMessageDAO;

public class RestaurantImgDAOjndi implements RestaurantImgDAO {


	// select
	private static final String SELECT_ALL = "select * from RestaurantImg";
	private static final String SELECT_BY_RESTAURANTID = "select * from RestaurantImg where restaurantId = ?";
	// insert
	private static final String INSERT = "insert into RestaurantImg" + " (img,restaurantId) "
			+ "values(?, ?)";
	// update
	private static final String UPDATE = "update RestaurantImg set img=?,restaurantId=?";
	// delete
	private static final String DELETE = "delete from RestaurantImg where restaurantImgId=?";
	private Connection conn = null;

	DataSource ds =null;
	public RestaurantImgDAOjndi(){
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/xxx");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<RestaurantImgBean> select() {
		List<RestaurantImgBean> list = null;
		RestaurantImgBean ribean = null;
		try (// AutoCloseable
				Connection conn = ds.getConnection();) {

			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<RestaurantImgBean>();
			while (rs.next()) {
				ribean = new RestaurantImgBean();
				ribean.setRestaurantImgId(rs.getInt(1));
				ribean.setImg(rs.getBytes(2));
				ribean.setRestaurantId(rs.getInt(3));
				
				list.add(ribean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查詢SELECT_BY_RESTAURANTID
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantImgDAO#select(int)
	 */
	@Override
	public RestaurantImgBean select(int RestaurantId) {
		RestaurantImgBean ribean = null;
		try (Connection conn = ds.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_RESTAURANTID);
			ps.setInt(1, RestaurantId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ribean = new RestaurantImgBean();
				ribean.setRestaurantImgId(rs.getInt(1));
				ribean.setImg(rs.getBytes(2));
				ribean.setRestaurantId(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ribean;
	}

	// 新增INSERT
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantImgDAO#insert(model.RestaurantImgBean)
	 */
	@Override
	public RestaurantImgBean insert(RestaurantImgBean bean) {
		RestaurantImgBean result = null;
		try (Connection conn = ds.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if (bean != null) {
				ps.setBytes(1, bean.getImg());
				ps.setInt(2, bean.getRestaurantId());
				
				int rs = ps.executeUpdate();
				if (rs == 1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 修改UPDATE
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantImgDAO#update(model.RestaurantImgBean)
	 */
	@Override
	public RestaurantImgBean update(RestaurantImgBean bean) {
		RestaurantImgBean result = null;
		try (Connection conn = ds.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if (bean != null) {
				ps.setBytes(1, bean.getImg());
				ps.setInt(2, bean.getRestaurantId());

				int rs = ps.executeUpdate();
				if (rs == 1) {
					result = bean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 刪除DELETE
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantImgDAO#delete(int)
	 */
	@Override
	public boolean delete(int RestaurantImgId) {
		try (Connection conn = ds.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(DELETE);

			ps.setInt(1, RestaurantImgId);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		RestaurantMessageDAO test = new RestaurantMessageDAOjndi();
		
		//-----------------------圖片匯入-----------------------------------
		
//				File f = new File("/Users/mouse/Desktop/001.jpg");
//				byte[] poto = new byte[(int)f.length()];
//				FileInputStream fi = new FileInputStream(f);
//				System.out.println(fi);
//				fi.read(poto);
//				fi.close();
		
		
		// ----------------------------------------------------------
		// List<RestaurantImgBean> li= test.select(); //全部select
		// for(RestaurantImgBean e:li){
		// System.out.println(e);
		// }
		// ----------------------------------------------------------
		// System.out.println(test.select(2)); // 單筆select
		// ----------------------------------------------------------
//		RestaurantImgBean ribean = new RestaurantImgBean();
//		
//		ribean.setRestaurantId(3);
//		ribean.setMemberId(1);

		//
//		 System.out.println(test.insert(ribean)); // 新增資料
		// ----------------------------------------------------------
		// System.out.println(test.select("text123")); //單筆select （帳號）
		// ----------------------------------------------------------
		// System.out.println(test.update(ribean)); //修改
		// ----------------------------------------------------------
		// System.out.println(test.delete(3));//刪除
		// ----------------------------------------------------------
		// FileOutputStream fo = new
		// FileOutputStream("/Users/mouse/Desktop/4.jpg"); //把圖片取出來放桌面
		// fo.write(m.select(2).getPhoto(), 0, t);
		// fo.close();
		// ----------------------------------------------------------

	}
}
