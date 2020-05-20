package models;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class UserModel {

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("password")
	private String password;

	@SerializedName("userStatus")
	private int userStatus;

	@SerializedName("phone")
	private String phone;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String userName;

	public UserModel() {

	}

	public UserModel(String firstName, String lastName, String username, String password, String phone,
					 String email, int userStatus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.userStatus = userStatus;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserModel that = (UserModel) o;

		return Objects.equals(this.firstName, that.firstName) &&
				Objects.equals(this.lastName, that.lastName) &&
				Objects.equals(this.userName, that.userName) &&
				Objects.equals(this.password, that.password) &&
				Objects.equals(this.email, that.email) &&
				Objects.equals(this.userStatus, that.userStatus) &&
				Objects.equals(this.phone, that.phone);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("UserModel{");
		sb.append("id=").append(id);
		sb.append(", userName='").append(userName);
		sb.append(", firstName='").append(firstName).append('\'');
		sb.append(", lastName=").append(lastName);
		sb.append(", email=").append(email);
		sb.append(", password=").append(password);
		sb.append(", phone='").append(phone);
		sb.append(", userStatus='").append(userStatus).append('\'');
		sb.append('}');
		return sb.toString();
	}

}
