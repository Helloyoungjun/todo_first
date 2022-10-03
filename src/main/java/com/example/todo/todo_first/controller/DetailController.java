package com.example.todo.todo_first.controller;

import com.example.todo.todo_first.dao.TodoDAO;
import com.example.todo.todo_first.dto.TodoDTO;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Slf4j
@WebServlet(name = "DetailServlet", value = "/todo/detail")
public class DetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");


        int tno = Integer.parseInt(request.getParameter("tno"));

        // tno번호를 가져와서 DTO 생성후 뿌려주기
        TodoDTO DTO = TodoDTO.builder().tno(tno).build();

        TodoDTO TodoDTO = TodoDAO.INSTANCE.findByTno(DTO);

        // tno 출력
        log.info(String.valueOf(TodoDTO));

        request.setAttribute("TodoDTO", TodoDTO );


        request.getRequestDispatcher("/WEB-INF/views/contents/detail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
