package com.niit.shopping.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.shopping.dao.CardDetailDao;
import com.niit.shopping.model.CardDetail;




@Service
public class CardDetailServiceImpl implements CardDetailService{

    @Autowired
    private CardDetailDao cardDetailDao;

    public void addCardDetail (CardDetail cardDetail) {
    	cardDetailDao.addCardDetail(cardDetail);
    }

 
}
