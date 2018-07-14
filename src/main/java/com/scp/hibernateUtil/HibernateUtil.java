package com.scp.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
static SessionFactory sf=null;
public static SessionFactory getSessionFactory()
{
	if(sf==null)
	{
		sf=new Configuration().configure().buildSessionFactory();
	}
	return sf;
}

public static void flushNCommit(Session se,Transaction tr)
{
	if(se!=null)
	{
		se.flush();
	}
	if(tr!=null)
	{
		tr.commit();
	}
		
}
}
