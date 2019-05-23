package com.rxjy;


import com.rxjy.modules.air.dao.AirPeopleConsultDao;
import com.rxjy.modules.air.dao.AirPeopleRsglDiquDao;
import com.rxjy.modules.air.entity.AirPeopleEntity;
import com.rxjy.modules.air.entity.AirPeopleRsglDiquEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JoinApplication.class)
public class TestqhbCurd {

    @Autowired
     public AirPeopleConsultDao airPeopleConsultDao;

    @Autowired
    public AirPeopleRsglDiquDao  airPeopleRsglDiquDao;




    @Test
    public void select(){
        Map<String, Object> peopleConsult = airPeopleConsultDao.getPeopleConsult(52);


        System.out.println(peopleConsult.get("wxadd"));
    }

    @Test
    public void  selectone(){
        AirPeopleEntity peopleInfoById = airPeopleRsglDiquDao.getPeopleInfoById(12);

        System.out.println(peopleInfoById.getDqName());
    }


    @Test
    public void  selecttwo(){
        AirPeopleRsglDiquEntity peopleRsglDiquById = airPeopleRsglDiquDao.getPeopleRsglDiquById(55);

        System.out.println(peopleRsglDiquById.getAirPeopleName());

        System.out.println(peopleRsglDiquById.getRsglDiquEntity().getDqName());
    }

}
