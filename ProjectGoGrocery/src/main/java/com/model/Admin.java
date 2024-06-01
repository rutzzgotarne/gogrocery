package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="admins")
public class Admin {
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator="admin_seq")
	@SequenceGenerator(name="admin_seq",sequenceName="admin_sequence")
	private int adminId;
	private String adminName;
	private String passward;
	public Admin() {
		super();
	}
	public Admin(int adminId, String adminName, String passward) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.passward = passward;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	
	
	
}
