package ar.com.educacionit.connectors.placeholders.dto;

import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "username", "email", "address", "phone", "website", "company" })
@Generated("jsonschema2pojo")
@JsonIgnoreProperties(value = { "address", "company" })	//agregado para que no tenga en cuenta a la hora de generar el json, ni el objeto
public class UserDTO {

	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("username")
	private String username;
	@JsonProperty("email")
	private String email;
//	@JsonProperty("address")
//	private Address address;
	@JsonProperty("phone")
	private String phone;
	@JsonProperty("website")
	private String website;
//	@JsonProperty("company")
//	private Company company;

	@JsonProperty("id")
	public Integer getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(Integer id) {
		this.id = id;
	}

	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("username")
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("email")
	public String getEmail() {
		return email;
	}

	@JsonProperty("email")
	public void setEmail(String email) {
		this.email = email;
	}

//	@JsonProperty("address")
//	public Address getAddress() {
//		return address;
//	}
//
//	@JsonProperty("address")
//	public void setAddress(Address address) {
//		this.address = address;
//	}

	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	@JsonProperty("phone")
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@JsonProperty("website")
	public String getWebsite() {
		return website;
	}

	@JsonProperty("website")
	public void setWebsite(String website) {
		this.website = website;
	}

//	@JsonProperty("company")
//	public Company getCompany() {
//		return company;
//	}
//
//	@JsonProperty("company")
//	public void setCompany(Company company) {
//		this.company = company;
//	}

}