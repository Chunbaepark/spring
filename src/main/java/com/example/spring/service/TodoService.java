package com.example.spring.service;

import com.example.spring.dto.PageRequestDTO;
import com.example.spring.dto.PageResponseDTO;
import com.example.spring.dto.TodoDTO;

import java.util.List;

public interface TodoService {

    void register(TodoDTO todoDTO);

//    List<TodoDTO> getAll();
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);

    TodoDTO getOne(Long tno);

    void remove(Long tno);

    void modify(TodoDTO todoDTO);
}
