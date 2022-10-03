package com.example.todo.todo_first.controller;

import com.example.todo.todo_first.dao.TodoDAO;
import com.example.todo.todo_first.dto.TodoDTO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteController", value = "/todo/delete")
public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int tno = Integer.parseInt(request.getParameter("tno"));

        TodoDTO DTO = TodoDTO.builder().tno(tno).build();

        int result = TodoDAO.INSTANCE.deleteTodo(DTO);

        response.sendRedirect("/todo/list?page=1");




    }
}
