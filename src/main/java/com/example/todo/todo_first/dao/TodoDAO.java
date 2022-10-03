package com.example.todo.todo_first.dao;

import com.example.todo.todo_first.common.MyBatisUtil;
import com.example.todo.todo_first.dto.PageRequestDTO;
import com.example.todo.todo_first.dto.TodoDTO;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public enum TodoDAO {

    INSTANCE;

    TodoDAO() {
    }

    public List<TodoDTO> findAllList() {
        @Cleanup SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession();


        List<TodoDTO> todoDTOList = session.selectList("mapper.todoMapper.findAllList");
        return todoDTOList;
    }

    public TodoDTO findByTno(TodoDTO DTO) {
        @Cleanup SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession();

        TodoDTO todoDTO = session.selectOne("mapper.todoMapper.findByTno" , DTO);
        return todoDTO;


    }

    public Integer insertTodo(TodoDTO DTO){
        @Cleanup SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        int insertResult = session.insert("mapper.todoMapper.insert",DTO);


        return  insertResult;
        }

    public int updateTodo(TodoDTO DTO) {
        @Cleanup SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);


        int updateResult = session.update("mapper.todoMapper.update", DTO);

        return updateResult;




    }


    /*tno 하나 받아서 실행*/
    public int deleteTodo(TodoDTO DTO) {
        @Cleanup SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(true);

        int deleteResult = session.delete("mapper.todoMapper.delete", DTO);

        return deleteResult;
    }

    // 페이지네이션

    public List<TodoDTO> pagination (PageRequestDTO DTO){
        @Cleanup SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession();


        List<TodoDTO> todoDTOList = session.selectList("mapper.selectPageMapper.selectPage", DTO);

        return todoDTOList;

    }
}