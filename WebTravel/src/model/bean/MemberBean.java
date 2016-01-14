package model.bean;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;

import model.hibernate.HibernateUtil;


@Entity
@Table(name="Member")
public class MemberBean implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="memberId")
	private int memberId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private byte[] password;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="nickName")
	private String nickName;
	
	@Column(name="birthDay")
	private java.util.Date birthDay;
	
	@Column(name="address")
	private String address;
	
	@Column(name="cellphone")
	private String cellphone;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="photo")
	private byte[] photo;
	
	@OneToMany(
			cascade={CascadeType.REMOVE},
			mappedBy="memberBean"
			)
	
	
	private Set<MemberMessageBean> MemberMessageBeans;
	
	
	public static void main(String[] args) throws ParseException, IOException{
		
		File f = new File("C:/Users/Student/Desktop/Member2.jpg");
		byte[] poto = new byte[(int)f.length()];
		FileInputStream fi = new FileInputStream(f);
		fi.read(poto);
		fi.close();
		
//--------------------------假資料--------------------------------
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		MemberBean mbean = new MemberBean();
		mbean.setMemberId(23);
		mbean.setUserName("jack21111");
		mbean.setPassword("B".getBytes());
		mbean.setFirstName("王");
		mbean.setLastName("翔");
		mbean.setNickName("mousssse");
		mbean.setBirthDay(sdf.parse("1991-11-22"));
		mbean.setAddress("台北市");
		mbean.setCellphone("0919929sss9393");
		mbean.setTelephone("02222sss22222");
		mbean.setEmail("jsuusssssse@gmail.com");
		mbean.setPhoto(poto);
		
		try {
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			//select 
			MemberBean mb =(MemberBean)session.load(MemberBean.class,1);
			System.out.println(mb);
			Set<MemberMessageBean> mmb = mb.getMemberMessageBeans();
			System.out.println(mmb);
			
			//insert
//			session.save(mbean);
			
			//delete
//			session.delete(mbean);
			
			session.getTransaction().commit();
		} finally{
			HibernateUtil.closeSessionFactory();
		}
	}
	
	
	
	
	public MemberBean(){
		
	}
	
	public Set<MemberMessageBean> getMemberMessageBeans() {
		return MemberMessageBeans;
	}




	public void setMemberMessageBeans(Set<MemberMessageBean> memberMessageBeans) {
		MemberMessageBeans = memberMessageBeans;
	}

	private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	
	public static java.util.Date converDate(String date){
		java.util.Date rs =null;
		try {
			rs=sf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	@Override
	public String toString() {
		return  "["+memberId + "," + userName + "," + password + ","
				+ firstName + "," + lastName + "," + nickName + "," + birthDay
				+ "," + address + "," + cellphone + "," + telephone + "," + email
				+ "," + photo +"]";
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public byte[] getPassword() {
		return password;
	}
	public void setPassword(byte[] password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public java.util.Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(java.util.Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
}
