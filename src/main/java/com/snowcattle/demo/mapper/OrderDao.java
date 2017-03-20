package com.snowcattle.demo.mapper;

import com.snowcattle.demo.entity.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by wangchangye on 2017/3/20.
 *
 * @Author wangchangye
 */
@Repository
public class OrderDao {

    @Autowired
    private SqlSession sqlSession;

    public int insert(Order order) {
        return sqlSession.insert("insertOrder", order);
    }
    public void deleteByUserId(Order order){
         sqlSession.delete("deleteByUserId",order);
    }

    public void updateOrder(Order order) {
        sqlSession.update("updateOrder", order);
    }

    public Order getOrder(Order order) {
        return sqlSession.selectOne("getOrder", order);
    }
}//end of class
