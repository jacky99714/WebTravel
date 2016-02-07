package model.bean;

import javax.persistence.Table;

import org.hibernate.Session;

import model.hibernate.HibernateUtil;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="MemberMessage")
public class MemberMessageBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int memberMessageID;
	
	private String memberMessageContent;
	
	private String messaageTime;
	
	private int memberId;
	@ManyToOne()
	@JoinColumn(
			name="memberId",
			referencedColumnName="memberId",
			insertable=false,
			updatable=false
			)
	private MemberBean memberBean;
	
	public MemberBean getMemberBean() {
		return memberBean;
	}



	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}



	public static void main(String[] args){
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//select 
			MemberMessageBean mmb =(MemberMessageBean)session.load(MemberMessageBean.class,2);
			System.out.println(mmb);
			
			
			//insert
//			session.save(mbean);
			
			//delete

			
			session.getTransaction().commit();
		} finally{
			HibernateUtil.closeSessionFactory();
		}
	}
	
	

	@Override
	public String toString() {
		return "[MemberMessageID=" + memberMessageID + ", MemberMessageContent="
				+ memberMessageContent + ", MessaageTime=" + messaageTime + ", memberId=" + memberId + "]";
	}

	public int getMemberMessageID() {
		return memberMessageID;
	}

	public void setMemberMessageID(int memberMessageID) {
		this.memberMessageID = memberMessageID;
	}

	public String getMemberMessageContent() {
		return memberMessageContent;
	}

	public void setMemberMessageContent(String memberMessageContent) {
		this.memberMessageContent = memberMessageContent;
	}

	public String getMessaageTime() {
		return messaageTime;
	}

	public void setMessaageTime(String messaageTime) {
		this.messaageTime = messaageTime;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	
}
