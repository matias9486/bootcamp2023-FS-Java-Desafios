package ar.com.educacionit.domain;

public class Placeholder extends Entity{
	
	private Integer userId;
	private String name;
	private String username;
	private String email;
	private String phone;
	private String website;
	
	public Placeholder(Integer userId, String name, String username, String email, String phone, String website) {		
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}
	
	public Placeholder(Long id, Integer userId, String name, String username, String email, String phone, String website) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.website = website;
	}
		
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	@Override
	public String toString() {
		return "Placeholder [userId=" + userId + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", phone=" + phone + ", website=" + website + "]";
	}
	
	
	
	
}
