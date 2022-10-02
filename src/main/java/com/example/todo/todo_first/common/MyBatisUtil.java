package com.example.todo.todo_first.common;

import lombok.Getter;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

@Getter
public enum MyBatisUtil{
    INSTANCE;


    private SqlSessionFactory sqlSessionFactory;

    MyBatisUtil() {
        try {
            /**
             * import 할 때, ibatis 패키지를 가져와야 한다.
             * 버전업 되면서 이름 바뀜.,.
             */
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}