package model;
import java.io.Serializable;
import java.util.Date;

public class UserBeans implements Serializable{
	private int id;
	private String loginId;
	private String password;
	private String name;
	private Date birthDate;
	private String createDate;
	private String updateDate;

	public UserBeans() {
	}

	public UserBeans(String LoginId, String name) {
		this.loginId = LoginId;
		this.name = name;
	}

	public UserBeans(int id,String LoginId,String password,String name, Date birthDate,
			String createDate,String updateDate) {
		this.id = id;
		this.loginId = LoginId;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public UserBeans(String LoginId, String name, Date birthDate,
			String createDate,String updateDate,String password) {

		this.loginId = LoginId;
		this.name = name;
		this.birthDate = birthDate;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.password = password;
	}

	public UserBeans(String LoginId, String name, Date birthdate) {
		this.loginId = LoginId;
		this.name = name;
		this.birthDate = birthdate;
	}


	public int getId() {
		return id;
	}

	public void setId(int Id) {
		this.id = Id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String LoginId) {
		this.loginId = LoginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


}