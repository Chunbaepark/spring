package com.example.spring.mapper;

import com.example.spring.domain.TodoVO;
import com.example.spring.dto.PageRequestDTO;

import java.util.List;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);

    List<TodoVO> selectAll();

    TodoVO selectOne(Long tno);

    void delete(Long tno);

    void update(TodoVO todoVO);

    List<TodoVO> selectList(PageRequestDTO pageRequestDTO);

    int getCount(PageRequestDTO pageRequestDTO);
}
