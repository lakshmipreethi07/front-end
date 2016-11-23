package com.niit.shopping.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.model.Cart;
import com.niit.shopping.model.Userdetails;



@EnableTransactionManagement
@Repository("userdetailsDAO")
public class UserdetailsDAOImpl implements UserdetailsDAO {
private static final Logger log = LoggerFactory.getLogger(UserdetailsDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	public UserdetailsDAOImpl(SessionFactory sessionFactory)
	{
	this.sessionFactory = sessionFactory;

	}
@Transactional
	public boolean save(Userdetails userdetails)
	{
	try {
		log.debug("starting of save method");
		
	Session session=sessionFactory.getCurrentSession();
		
			userdetails.setRole("ROLE_USER");
		userdetails.setEnabled(true);
		log.debug("Ending of save method");
		
		Cart newCart = new Cart();
        newCart.setUsersDetail(userdetails);
        userdetails.setCart(newCart);
        session.saveOrUpdate(userdetails);
        session.saveOrUpdate(newCart);

		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in save" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean update(Userdetails userdetails)
	{
	try {
		log.debug("starting of update method");
		sessionFactory.getCurrentSession().update(userdetails);
		log.debug("starting of update method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in update" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
	public boolean delete(Userdetails userdetails)
	{
	try {
		log.debug("starting of delete method");
		sessionFactory.getCurrentSession().delete(userdetails);
		log.debug("starting of delete method");
		return true;
	}
	catch(Exception e)
	{
		log.error("Exception occured in delete" +e.getMessage());
		e.printStackTrace();
		return false;
	}
	}
@Transactional
public Userdetails get(String id)
{
	String hql = "from Userdetails where id= "+" '" +id+ "'";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	List<Userdetails> list = query.list();
	if(list == null || list.isEmpty())
	{
		return null;
	}
	else
	{
		return list.get(0);
	}
}

@Transactional
public Userdetails isValidUser(String name,String password)
{
	String hql = "from Userdetails where name = '" + name +"' and password= '" +password +"'";
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	List<Userdetails> list = query.list();
	if(list == null)
	{
		return null;
	}
	else
	{
		return list.get(0);
	}
}


@Transactional
public List<Userdetails> list()
{
	String hql = "from Userdetails";
	Query query =sessionFactory.getCurrentSession().createQuery(hql);
	return query.list();
}
@Transactional
public Userdetails getUserByUsername (String username) {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("from Userdetails where username = ?");
    query.setString(0, username);

    return (Userdetails) query.uniqueResult();
}
}
