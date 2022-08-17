package com.chaossnow.ms.service.impl;

import com.chaossnow.ms.dao.GoodDao;
import com.chaossnow.ms.pojo.Good;
import com.chaossnow.ms.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chaos
 * @ClassName GoodDaoImpl
 * @date 2022年07月31日 15:44
 * @Version 1.0
 */

@Service
@Transactional
public class GoodServiceImpl implements GoodService {


    @Autowired
    public GoodDao goodDao;

    @Override
    public List<Good> getGoodList() {
        List<Good> goodList = goodDao.getGoodList();
        return goodList;
    }
}
