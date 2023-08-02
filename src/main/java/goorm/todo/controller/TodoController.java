package goorm.todo.controller;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import goorm.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping
    public String home(Model model) {
        List<TodoItem> todoItems = todoService.findAll();
        model.addAttribute("todoItems", todoItems);

        return "todo/main";
    }

    @GetMapping("/{todoId}")
    public String todoDetail(@PathVariable int todoId, Model model) {
        TodoItem item = todoService.findById(todoId).get();
        model.addAttribute("item", item);

        return "todo/manageForm";
    }

    @GetMapping("/add")
    public String addForm() {
        return "todo/addForm";
    }

    @PostMapping("/add")
    public String addItem(@Validated @ModelAttribute TodoItemDto todoItemDto,
                          RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult.getFieldError());
            return "redirect:/todo/add";
        }

        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(todoItemDto.getTitle());
        todoItem.setContents(todoItemDto.getContents());

        TodoItem savedItem = todoService.save(todoItem);
        redirectAttributes.addAttribute("todoId", savedItem.getId());

        return "redirect:/todo/{todoId}";
    }

    @GetMapping("/delete/{todoId}")
    public String deleteItem(@PathVariable int todoId, RedirectAttributes redirectAttributes) {
        todoService.delete(todoId);

        return "redirect:/todo";
    }

    @PostMapping("/update/{todoId}")
    public String updateItem(@PathVariable int todoId, @Validated @ModelAttribute TodoItemDto todoItemDto,
                             RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error("errors={}", bindingResult.getFieldError());
            redirectAttributes.addAttribute("todoId", todoId);
            return "redirect:/todo/{todoId}";
        }

        todoService.update(todoId, todoItemDto);
        redirectAttributes.addAttribute("todoId", todoId);

        return "redirect:/todo/{todoId}";
    }
}