package com.example.spring.mapper;

import com.example.spring.domain.TodoVO;
import com.example.spring.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTests {

    @Autowired(required = false)
    private TodoMapper todoMapper;

    @Test
    public void testGetTime() {
        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert() {

        TodoVO todoVO = TodoVO.builder()
                .title("스프링테스트")
                .dueDate(LocalDate.of(2025,05,20))
                .writer("user00")
                .build();

        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll() {

        List<TodoVO> voList = todoMapper.selectAll();

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectOne() {

        TodoVO todoVO = todoMapper.selectOne(2L);

        log.info(todoVO);
    }

    @Test
    public void testSelectList() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));
    }

    @Test
    public void testSelectSearch() {

        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .types(new String[]{"t","w"})
                .keyword("스프링")
//                .finished(true)
                .from(LocalDate.of(2025,05,23))
                .to(LocalDate.of(2026,05,24))
                .build();

        List<TodoVO> voList = todoMapper.selectList(pageRequestDTO);

        voList.forEach(vo -> log.info(vo));

        log.info( todoMapper.getCount(pageRequestDTO));
    }

}
