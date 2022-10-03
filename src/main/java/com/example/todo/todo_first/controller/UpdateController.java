package com.example.todo.todo_first.controller;

import com.example.todo.todo_first.dao.TodoDAO;
import com.example.todo.todo_first.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "UpdateController", value = "/todo/update")
public class UpdateController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int tno = Integer.parseInt(request.getParameter("tno"));
        System.out.println("update tno " + tno);

        // tno번호를 가져와서 DTO 생성후 뿌려주기
        TodoDTO DTO = TodoDTO.builder().tno(tno).build();

        TodoDTO TodoDTO = TodoDAO.INSTANCE.findByTno(DTO);

        // tno 출력
        log.info(String.valueOf(TodoDTO));

        request.setAttribute("TodoDTO", TodoDTO );


        request.getRequestDispatcher("/WEB-INF/views/contents/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String memo = request.getParameter("memo");

        
        // 박스가 체크되어있으면 파라미터가 있게 된다.
        String complete = (request.getParameter("complete"));


        System.out.println("complete 값 보기" + complete);

        int tno = Integer.parseInt(request.getParameter("tno"));

        TodoDTO todoDTO = TodoDTO.builder().tno(tno).title(title).memo(memo).complete(complete == null ? false : true).build();

        log.info(String.valueOf(todoDTO));


        int result = TodoDAO.INSTANCE.updateTodo(todoDTO);

        System.out.println("update 출력 결과   + "+  result);

        response.sendRedirect("detail?tno="+tno);

    }
}
