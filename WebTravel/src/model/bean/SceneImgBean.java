package model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernate.HibernateUtil;

@Entity
@Table(name="SceneImg")
public class SceneImgBean implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sceneImgId;

	private byte[] img;
	
	private int sceneId;
	
	@ManyToOne
	@JoinColumn(
			name="sceneId",
			referencedColumnName="sceneId",
			insertable=false,updatable=false
			)
	private SceneBean scene;
	
	public String toString() {
		return  "["+sceneImgId + "," +img + "," + sceneId + "]";
	}

	public int getSceneImgId() {
		return sceneImgId;
	}

	public void setSceneImgId(int sceneImgId) {
		this.sceneImgId = sceneImgId;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public int getSceneId() {
		return sceneId;
	}

	public void setSceneId(int sceneId) {
		this.sceneId = sceneId;
	}
	
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();

//			Criteria criteria = session.createCriteria(DeptBean.class);
//			criteria.add(Restrictions.like("deptname", "%b%"));
//			List<DeptBean> depts = criteria.list();
//			System.out.println(depts);
			
			
			SceneImgBean select1 = (SceneImgBean) session.load(SceneImgBean.class, 1);
			System.out.println(select1);
//			Set<EmpBean> emps = select1.getEmps();
//			System.out.println(emps);
//			session.delete(select1);
			
//			DeptBean select2 = (DeptBean) session.get(DeptBean.class, 20);
//			System.out.println(select2);

//			List<DeptBean> beans = session.createQuery("from DeptBean").list();
//			System.out.println(beans);
		
//			DeptBean bean = new DeptBean();
//			bean.setDeptid(90);
//			bean.setDeptname("hohoho");
//			session.save(bean);

			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
