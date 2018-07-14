package com.scp.services;
import java.util.ArrayList;
import java.util.List;

import com.scp.entity.Users;
public interface UserServices {
	
	static List<Users>list=new ArrayList<Users>();
	public void addUser(Users u);
	public List<Users> getUserbyName(String name);
	public Users getUserbyId(int id);
	public void  deleteUser(int id);
	public void updateUSer(Users u1);
	public List<Users> getAllUsers();

}
