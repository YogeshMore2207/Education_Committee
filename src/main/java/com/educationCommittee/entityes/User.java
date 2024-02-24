package com.educationCommittee.entityes;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String Username;
	private String number;
	
	@Column(unique = true)
	private String email;
	private String Password;
	private String Role;
	
	
	private String name;
	private String Address;
	private String Phoneno;
	private String parentNo;
	private String Qualification;
	private String AadharNo;
	
	private String AadharPhoto;
	private String MarksheetPhoto;
	
	private String paymentStatus;
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneno() {
		return Phoneno;
	}
	public void setPhoneno(String phoneno) {
		Phoneno = phoneno;
	}
	public String getParentNo() {
		return parentNo;
	}
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String getAadharNo() {
		return AadharNo;
	}
	public void setAadharNo(String aadharNo) {
		AadharNo = aadharNo;
	}
	public String getAadharPhoto() {
		return AadharPhoto;
	}
	public void setAadharPhoto(String aadharPhoto) {
		AadharPhoto = aadharPhoto;
	}
	public String getMarksheetPhoto() {
		return MarksheetPhoto;
	}
	public void setMarksheetPhoto(String marksheetPhoto) {
		MarksheetPhoto = marksheetPhoto;
	}
	
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", Username=" + Username + ", number=" + number + ", email=" + email + ", Password="
				+ Password + ", Role=" + Role + ", name=" + name + ", Address=" + Address + ", Phoneno=" + Phoneno
				+ ", parentNo=" + parentNo + ", Qualification=" + Qualification + ", AadharNo=" + AadharNo
				+ ", AadharPhoto=" + AadharPhoto + ", MarksheetPhoto=" + MarksheetPhoto + "]";
	}
	
	
	


}
