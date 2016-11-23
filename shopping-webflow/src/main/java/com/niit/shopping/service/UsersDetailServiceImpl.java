package com.niit.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopping.dao.UserdetailsDAO;
import com.niit.shopping.model.Userdetails;

import java.util.List;



@Service
public class UsersDetailServiceImpl implements UsersDetailService{

    @Autowired
    private UserdetailsDAO usersDetailDao;

    public void addUser (Userdetails usersDetail) {
    	usersDetailDao.save(usersDetail);
    }

    public Userdetails getUserById(String userId) {
        return usersDetailDao.get(userId);
    }

    

    public Userdetails getUserByUsername (String username) {
        return usersDetailDao.getUserByUsername(username);
    }

	}
