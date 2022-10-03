import com.example.todo.todo_first.common.MyBatisUtil;
import com.example.todo.todo_first.dto.PageRequestDTO;
import com.example.todo.todo_first.dto.TodoDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Slf4j
public class pageTest {
    @Test

    public void selectAllPage() {
        SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(); // true 넣으면 auto commit

        // 페이징 해야할 테이블이 많기 떄문에, 재사용을 하고싶다.
        // Map 을 사용하는 방식
        Map<String, Object> param = new HashMap<>();
        param.put("skip", 10);
        param.put("size", 10);

        PageRequestDTO dto = PageRequestDTO.builder().page(2).size(10).build();

        // skip, page를 던지고 싶은데 두번째 파라미터로 객체 하나밖에 못던진다.
        List<TodoDTO> list = session.selectList("mapper.selectPageMapper.selectPage", dto);
        session.close();

//        log.info(list);

        list.forEach((a) -> log.info(String.valueOf(a)));

    }
}
//    @Test
//    public void selectAllPage2() {
//        SqlSession session = MyBatisUtil.INSTANCE.getSqlSessionFactory().openSession(); // true 넣으면 auto commit
//
//        // 페이징 해야할 테이블이 많기 떄문에, 재사용을 하고싶다.
//        // 전용 DTO 을 사용하는 방식
//        org.zero.w0929.dto.PageRequestDTO dto = org.zero.w0929.dto.PageRequestDTO.builder().page(1).size(50).build();
//
//        // skip, page를 던지고 싶은데 두번째 파라미터로 객체 하나밖에 못던진다.
//        List<TodoDTO> list = session.selectList("org.zero.w0929.dao.TodoMapper.selectPage", dto);
//        session.close();
//
////        log.info(list);
//
//        list.forEach(todoDTO -> log.info(todoDTO));
//
//
//    }
//}