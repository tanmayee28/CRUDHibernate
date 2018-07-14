package com.scp.servicesImplimentation;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.scp.entity.Users;
import com.scp.hibernateUtil.HibernateUtil;
import com.scp.services.UserServices;
public class ServicesImplementations implements UserServices {
	SessionFactory sf=HibernateUtil.getSessionFactory();
	public  void addUser(Users u1) {
		// TODO Auto-generated method stub
		/*Users u1=new Users(1,"Tanmayee","tanmayee123");
		Users u2=new Users(2,"Monali","monali123");
		//Users u1=new Users(1,"Tanmayee","tanmayee123");*/
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		se.save(u1);
		//se.save(u2);
		HibernateUtil.flushNCommit(se, tr);
	}

	public  List<Users> getUserbyName(String name) {
		// TODO Auto-generated method stub
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		Criteria cr=se.createCriteria(Users.class);
		cr.add(Restrictions.eq("username",name));
		List<Users>list=cr.list();
		HibernateUtil.flushNCommit(se, tr);
		return list;
	}

	public  void deleteUser(int id) {
		// TODO Auto-generated method stub
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		Users u1=se.get(Users.class,id);
		se.delete(u1);
		HibernateUtil.flushNCommit(se, tr);
		
	}

	public  void updateUSer(Users u1) {
		// TODO Auto-generated method stub
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		se.update(u1);
		HibernateUtil.flushNCommit(se, tr);
		
	}

	public  List<Users> getAllUsers() {
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		Criteria cr=se.createCriteria(Users.class);
		List<Users>list=cr.list();
		return list;
	}

	public Users getUserbyId(int id) {
		// TODO Auto-generated method stub
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		Users u=se.get(Users.class, id);
		////Criteria cr=se.createCriteria(Users.class);
		//cr.add(Restrictions.eq("id",id));
		//List<Users>list=cr.list();
		return u;
	}

}
