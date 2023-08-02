package goorm.todo.service;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import goorm.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;

    @Override
    public Optional<TodoItem> findById(int itemId) {
        return todoRepository.findById(itemId);
    }

    @Override
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public TodoItem save(TodoItem item) {
        return todoRepository.save(item);
    }

    @Override
    public void delete(int itemId) {
        todoRepository.delete(itemId);
    }

    @Override
    public void update(int itemId, TodoItemDto updateItem) {
        todoRepository.update(itemId, updateItem);
    }
}