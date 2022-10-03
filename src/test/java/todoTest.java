import com.example.todo.todo_first.dao.TodoDAO;
import com.example.todo.todo_first.dto.TodoDTO;
import com.sun.tools.javac.comp.Todo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
@Slf4j
public class todoTest {





    @Test
    void findAllList(){
        List<TodoDTO> todoDTOList = TodoDAO.INSTANCE.findAllList();

        todoDTOList.forEach((list) -> {log.info(String.valueOf(list));});
        }

    @Test
    void findByTno(){

        TodoDTO DTO = TodoDTO.builder().tno(1).build();

        TodoDTO todoDTO = TodoDAO.INSTANCE.findByTno(DTO);

        log.info(String.valueOf(todoDTO));
    }

    @Test
    void insertTodo(){

        TodoDTO DTO = TodoDTO.builder().title("b4abc").memo("ccc").build();
        int insertResult = TodoDAO.INSTANCE.insertTodo(DTO);

    System.out.println("insert 결과 출력     : " + insertResult );
    }

    // tno를 기준으로 title과 memo를 바꾼다.
    @Test
    void updateTodo(){
        TodoDTO DTO = TodoDTO.builder().tno(2).title("hi").memo("change").build();

        int updateTodo = TodoDAO.INSTANCE.updateTodo(DTO);
        System.out.println("update 결과 출력  :  " + updateTodo);
    }

    @Test
    void deleteTodo(){

        TodoDTO DTO = TodoDTO.builder().tno(5).build();
        int deleteTodo = TodoDAO.INSTANCE.deleteTodo(DTO);

        System.out.println("delete 결과출력 :   " + deleteTodo);
    }




}
