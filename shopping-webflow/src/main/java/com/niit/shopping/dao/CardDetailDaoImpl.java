package com.niit.shopping.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shopping.model.CardDetail;



@Repository
@Transactional
public class CardDetailDaoImpl implements CardDetailDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCardDetail(CardDetail cardDetail) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(cardDetail);

        session.flush();
    }

}
