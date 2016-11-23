package com.niit.shopping.service;



import java.util.List;

import com.niit.shopping.model.Userdetails;


public interface UsersDetailService {

    void addUser (Userdetails usersDetail);

    Userdetails getUserById (String userId);


    Userdetails getUserByUsername (String username);
}
