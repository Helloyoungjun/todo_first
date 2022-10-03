package com.example.todo.todo_first.controller;

import com.example.todo.todo_first.dao.TodoDAO;
import com.example.todo.todo_first.dto.TodoDTO;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Slf4j
@WebServlet(name = "PrintListController", value = "/todo/list")
public class PrintListController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // db에서 전체 list를 다 뽑아오는 로직
        List<TodoDTO> AllList = TodoDAO.INSTANCE.findAllList();

        // list 잘들고 왔는지 확인하기
        AllList.forEach((list)->{log.info(String.valueOf(list));
        });


        // 화면에 전달을 해줘야 한다. - request 사용

        request.setAttribute("list" , AllList);

        // jsp 화면을 띄어준다.
        request.getRequestDispatcher("/WEB-INF/views/contents/list.jsp").forward(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
