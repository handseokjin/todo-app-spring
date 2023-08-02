package goorm.todo.repository;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import goorm.todo.repository.mybatis.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {
    private final TodoMapper todoMapper;

    @Override
    public Optional<TodoItem> findById(int id) {
        return todoMapper.findById(id);
    }

    @Override
    public List<TodoItem> findAll() {
        return todoMapper.findAll();
    }

    @Override
    public TodoItem save(TodoItem item) {
        todoMapper.save(item);

        return item;
    }

    @Override
    public void delete(int itemId) {
        todoMapper.delete(itemId);
    }

    @Override
    public void update(int itemId, TodoItemDto updateItem) {
        todoMapper.update(itemId, updateItem);
    }
}