package com.example.spring.controller;

import com.example.spring.dto.PageRequestDTO;
import com.example.spring.dto.TodoDTO;
import com.example.spring.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/list")
    public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult
            bindingResult, Model model) {

        log.info(pageRequestDTO);

        if(bindingResult.hasErrors()) {
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
    }

    @GetMapping("/register")
    public void registerGET() {
        log.info("GET todo register.......");
    }

    @PostMapping("/register")
    public String registerPost(@Valid TodoDTO todoDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        log.info("POST todo register.......");

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            return "redirect:/todo/register";
        }

        log.info(todoDTO);

        return "redirect:/todo/list";
    }

    @GetMapping({"/read", "/modify"})
    public void read(@RequestParam("tno") Long tno, PageRequestDTO pageRequestDTO, Model model) {
        TodoDTO todoDTO = todoService.getOne(tno);
        log.info(todoDTO);

        model.addAttribute("dto", todoDTO);
    }

    @PostMapping("/remove")
    public String remove(@RequestParam("tno") Long tno, PageRequestDTO pageRequestDTO, RedirectAttributes redirectAttributes) {

        log.info("------------------remove------------------");
        log.info("tno: " + tno);

        todoService.remove(tno);

        return "redirect:/todo/list?" + pageRequestDTO.getLink();
    }

    @PostMapping("/modify")
    public String modify(PageRequestDTO pageRequestDTO,
                         @Valid TodoDTO todoDTO,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if(bindingResult.hasErrors()) {
            log.info("has errors.......");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());

            redirectAttributes.addFlashAttribute("tno", todoDTO.getTno());
            return "redirect:/todo/modify";
        }

        log.info(todoDTO);

        todoService.modify(todoDTO);

        redirectAttributes.addAttribute("tno", todoDTO.getTno());

        return "redirect:/todo/read";
    }
}