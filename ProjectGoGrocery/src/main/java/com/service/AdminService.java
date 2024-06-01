package com.service;

import java.util.List;
import java.util.Map;

import com.model.Admin;

public interface AdminService {

	Admin addAdmin(Admin ad);

	Admin getAdminById(int id);

	List<Admin> getAllAdmin();

	Admin updateAdmin(Admin admin);

	Map<String, Object> deleteAdmin(int id);

	String sendRegistrationMail(long id);

	

	

}
