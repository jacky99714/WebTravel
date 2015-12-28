package model.dao.jndi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.RestaurantMessageBean;
import model.dao.RestaurantMessageDAO;
import model.util.DataSourceConnection;

public class RestaurantMessageDAOjndi implements RestaurantMessageDAO {

	// select
	private static final String SELECT_ALL = "select * from RestaurantMessage";
	private static final String SELECT_BY_RESTAURANTID = "select * from RestaurantMessage where restaurantId = ?";
	// insert
	private static final String INSERT = "insert into RestaurantMessage" + " (messageContent,restaurantId,memberId) "
			+ "values(?, ?, ?)";
	// update
	private static final String UPDATE = "update RestaurantMessage set messageContent=?,restaurantId=?,memberId=?";
	// delete
	private static final String DELETE = "delete from RestaurantMessage where restaurantMessageId=?";
	private Connection conn = null;


	@Override
	public List<RestaurantMessageBean> select() {
		List<RestaurantMessageBean> list = null;
		RestaurantMessageBean rmbean = null;
		try (// AutoCloseable
			Connection conn = DataSourceConnection.getConnection();) {

			PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			list = new ArrayList<RestaurantMessageBean>();
			while (rs.next()) {
				rmbean = new RestaurantMessageBean();
				rmbean.setRestaurantMessageId(rs.getInt(1));
				rmbean.setMessageContent(rs.getString(2));
				rmbean.setRestaurantId(rs.getInt(3));
				rmbean.setMemberId(rs.getInt(4));

				list.add(rmbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 查詢SELECT_BY_RESTAURANTID
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantMessageDAO#select(int)
	 */
	@Override
	public RestaurantMessageBean select(int sceneId) {
		RestaurantMessageBean rmbean = null;
		try (Connection conn = DataSourceConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(SELECT_BY_RESTAURANTID);
			ps.setInt(1, sceneId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				rmbean = new RestaurantMessageBean();
				rmbean.setRestaurantMessageId(rs.getInt(1));
				rmbean.setMessageContent(rs.getString(2));
				rmbean.setRestaurantId(rs.getInt(3));
				rmbean.setMemberId(rs.getInt(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rmbean;
	}

	// 新增INSERT
	/* (non-Javadoc)
	 * @see model.dao.jdbc.RestaurantMessageDAO#insert(model.RestaurantMessageBean)
	 */
	@Override
	public RestaurantMessageBean insert(RestaurantMessageBean bean) {
		RestaurantMessageBean result = null;
		try (Connection conn = DataSourceConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(INSERT);
			if (bean != null) {
				ps.setString(1, bean.getMessageContent());
				ps.setInt(2, bean.getRestaurantId());
				ps.setInt(3, bean.getMemberId());

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
	 * @see model.dao.jdbc.RestaurantMessageDAO#update(model.RestaurantMessageBean)
	 */
	@Override
	public RestaurantMessageBean update(RestaurantMessageBean bean) {
		RestaurantMessageBean result = null;
		try (Connection conn = DataSourceConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(UPDATE);
			if (bean != null) {
				ps.setString(1, bean.getMessageContent());
				ps.setInt(2, bean.getRestaurantId());
				ps.setInt(3, bean.getMemberId());

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
	 * @see model.dao.jdbc.RestaurantMessageDAO#delete(int)
	 */
	@Override
	public boolean delete(int RestaurantMessageId) {
		try (Connection conn = DataSourceConnection.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(DELETE);

			ps.setInt(1, RestaurantMessageId);

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
		// ----------------------------------------------------------
		// List<RestaurantMessageBean> li= test.select(); //全部select
		// for(RestaurantMessageBean e:li){
		// System.out.println(e);
		// }
		// ----------------------------------------------------------
		// System.out.println(test.select(2)); // 單筆select
		// ----------------------------------------------------------
		RestaurantMessageBean rmbean = new RestaurantMessageBean();
		rmbean.setMessageContent("好吃");
		rmbean.setRestaurantId(3);
		rmbean.setMemberId(1);

		//
//		 System.out.println(test.insert(rmbean)); // 新增資料
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
