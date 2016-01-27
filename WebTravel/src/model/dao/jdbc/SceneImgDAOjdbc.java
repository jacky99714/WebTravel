package model.dao.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.SceneImgBean;
import model.dao.RestaurantMessageDAO;
import model.dao.SceneImgDAO;
import model.dao.jndi.SceneImgDAOjndi;
import model.util.JdbcConnection;

public class SceneImgDAOjdbc implements SceneImgDAO {

	// select
	private static final String SELECT_ALL = "select * from SceneImg";
	private static final String SELECT_BY_SCENEID = "select * from SceneImg where sceneId = ?";
	// insert
	private static final String INSERT = "insert into SceneImg" + " (img,sceneId) "
			+ "values(?, ?)";
	// update
	private static final String UPDATE = "update SceneImg set img=?,sceneId=?";
	// delete
	private static final String DELETE = "delete from SceneImg where sceneImgId=?";
	private Connection conn = null;

	// 查詢 SELECT_ALL
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneImgDAO#select()
	 */
	@Override
	public List<SceneImgBean> select() {
		List<SceneImgBean> list = null;
		SceneImgBean rmbean = null;
		try (// AutoCloseable
				Connection conn = JdbcConnection.getConnection();) {

			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<SceneImgBean>();
			while (rs.next()) {
				rmbean = new SceneImgBean();
				rmbean.setSceneImgId(rs.getInt(1));
				rmbean.setImg(rs.getBytes(2));
				rmbean.setSceneId(rs.getInt(3));
				
				list.add(rmbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查詢SELECT_BY_SCENEID
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneImgDAO#select(int)
	 */
	@Override
	public List<SceneImgBean> select(int sceneId) {
		List<SceneImgBean> list = null;
		SceneImgBean rmbean = null;
		try (Connection conn = JdbcConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_SCENEID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<SceneImgBean>();
			while (rs.next()) {
				rmbean = new SceneImgBean();
				rmbean.setSceneImgId(rs.getInt(1));
				rmbean.setImg(rs.getBytes(2));
				rmbean.setSceneId(rs.getInt(3));
				
				list.add(rmbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 新增INSERT
	/* (non-Javadoc)
	 * @see model.dao.jdbc.SceneImgDAO#insert(model.SceneImgBean)
	 */
	@Override
	public SceneImgBean insert(SceneImgBean bean) {
		SceneImgBean result = null;
		try (Connection conn = JdbcConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if (bean != null) {
				ps.setBytes(1, bean.getImg());
				ps.setInt(2, bean.getSceneId());
				
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
	 * @see model.dao.jdbc.SceneImgDAO#update(model.SceneImgBean)
	 */
	@Override
	public SceneImgBean update(SceneImgBean bean) {
		SceneImgBean result = null;
		try (Connection conn = JdbcConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if (bean != null) {
				ps.setBytes(1, bean.getImg());
				ps.setInt(2, bean.getSceneId());

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
	 * @see model.dao.jdbc.SceneImgDAO#delete(int)
	 */
	@Override
	public boolean delete(int sceneImgId) {
		try (Connection conn = JdbcConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(DELETE);

			ps.setInt(1, sceneImgId);

			int rs = ps.executeUpdate();
			if (rs == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		SceneImgDAO test = new SceneImgDAOjdbc();
		
		//-----------------------圖片匯入-----------------------------------
		
		File f = new File("C:/Users/Student/Desktop/scene/schange/128_03.JPG");
		byte[] poto = new byte[(int)f.length()];
		FileInputStream fi = new FileInputStream(f);
		System.out.println(fi);
		fi.read(poto);
		fi.close();
		
		
		// ----------------------------------------------------------
		// List<SceneImgBean> li= test.select(); //全部select
		// for(SceneImgBean e:li){
		// System.out.println(e);
		// }
		// ----------------------------------------------------------
		// System.out.println(test.select(2)); // 單筆select
		// ----------------------------------------------------------
		SceneImgBean rmbean = new SceneImgBean();
//		
		rmbean.setSceneId(128);
		rmbean.setImg(poto);

		//
		 System.out.println(test.insert(rmbean)); // 新增資料
		// ----------------------------------------------------------
		// System.out.println(test.select("text123")); //單筆select （帳號）
		// ----------------------------------------------------------
		// System.out.println(test.update(rmbean)); //修改
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
