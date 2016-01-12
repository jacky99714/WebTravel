package model.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;

import model.hibernate.HibernateUtil;



@Entity
@Table(name="thought")
public class ThoughtBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="thoughtId")
	private int thoughtId;
	
	@Column(name="thoughtName")
	private String thoughtName;
	
	@Column(name="thoughtContent")
	private String thoughtContent;
	
	@Column(name="thoughtSubtitle")
	private String thoughtSubtitle;
	
	@Column(name="thoughtTime")
	private java.sql.Timestamp thoughtTime;
	
	@Column(name="memberId")
	private int memberId;
	
	@ManyToOne
	@JoinColumn(
			name="ThoughtId",
			referencedColumnName="Thought",
			insertable=false,updatable=false
	)
	
	
	@Override
	public String toString() {
		return "[" + thoughtId + "," + thoughtName + "," + thoughtContent + "," 
				+ thoughtSubtitle + "," + thoughtTime + "," + memberId + "]";
	}
	public int getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(int thoughtId) {
		this.thoughtId = thoughtId;
	}
	public String getThoughtName() {
		return thoughtName;
	}
	public void setThoughtName(String thoughtName) {
		this.thoughtName = thoughtName;
	}
	public String getThoughtContent() {
		return thoughtContent;
	}
	public void setThoughtContent(String thoughtContent) {
		this.thoughtContent = thoughtContent;
	}
	public String getThoughtSubtitle() {
		return thoughtSubtitle;
	}
	public void setThoughtSubtitle(String thoughtSubtitle) {
		this.thoughtSubtitle = thoughtSubtitle;
	}
	public java.sql.Timestamp getThoughtTime() {
		return thoughtTime;
	}
	public void setThoughtTime(java.sql.Timestamp thoughtTime) {
		this.thoughtTime = thoughtTime;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public static void main(String[] args) {
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
//			ThoughtBean bean = (ThoughtBean) session.load(ThoughtBean.class, "Alex");
//			System.out.println(bean);
			
			Query query = session.createQuery("from ThoughtBean");
			List list = query.list();
			System.out.println(list);
			
			session.getTransaction().commit();
		} finally {
			HibernateUtil.closeSessionFactory();
		}
	}

}
