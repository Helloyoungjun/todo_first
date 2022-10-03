package com.example.todo.todo_first.controller;

import com.example.todo.todo_first.dao.TodoDAO;
import com.example.todo.todo_first.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddController", value = "/todo/add")
public class AddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/contents/add.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // input 태그의 name 이름으로 불러옴
        String title = request.getParameter("title");
        String memo = request.getParameter("memo");

        TodoDTO DTO = TodoDTO.builder().title(title).memo(memo).build();

        int result = TodoDAO.INSTANCE.insertTodo(DTO);

        System.out.println("insert 성공여부 "  + result);

        response.sendRedirect("/todo/list");







    }
}
