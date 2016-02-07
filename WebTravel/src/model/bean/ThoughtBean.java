package model.bean;

import java.util.Arrays;
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
	
	@Column(name="thoughtPhoto")
	private byte[] thoughtPhoto;
	
	@ManyToOne
	@JoinColumn(
			name="MemberId",
			insertable=false,updatable=false
	)
	private MemberBean member;
	
	public MemberBean getMember() {
		return member;
	}
	public void setMember(MemberBean member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "ThoughtBean [thoughtId=" + thoughtId + ", thoughtName=" + thoughtName + ", thoughtContent="
				+ thoughtContent + ", thoughtSubtitle=" + thoughtSubtitle + ", thoughtTime=" + thoughtTime
				+ ", memberId=" + memberId + ", thoughtPhoto=" + Arrays.toString(thoughtPhoto) + ", member=" + member
				+ "]";
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
	public byte[] getThoughtPhoto() {
		return thoughtPhoto;
	}
	public void setThoughtPhoto(byte[] thoughtPhoto) {
		this.thoughtPhoto = thoughtPhoto;
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
