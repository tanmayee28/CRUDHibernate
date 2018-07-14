package com.scp.hibernateUtil;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.scp.entity.Users;

public class VerifyUser {
	
	public static boolean authenticateUser(String username,String password)
	{
		boolean flg;
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session se=sf.openSession();
		Transaction tr=se.beginTransaction();
		Criteria cr=se.createCriteria(Users.class);
		cr.add(Restrictions.eq("username",username));
		cr.add(Restrictions.eq("password",password));
		Users u=(Users)cr.uniqueResult();
		if(u!=null)
		{
			System.out.println("Authentication Successfull..");
			flg=true;
		}
		else {
			System.out.println("Authentication Failed");
			flg=false;
		}
		return flg;
		
	}

}
