package goorm.todo.repository;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {
    Optional<TodoItem> findById(int itemId);

    List<TodoItem> findAll();

    TodoItem save(TodoItem item);

    void delete(int itemId);

    void update(int itemId, TodoItemDto updateItem);
}