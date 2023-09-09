package goorm.todo.service;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import goorm.todo.repository.TodoSpringDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
    // private final TodoRepository todoRepository;
    private final TodoSpringDataJpaRepository todoSpringDataJpaRepository;

    @Override
    public Optional<TodoItem> findById(int itemId) {
        // return todoRepository.findById(itemId);

        return todoSpringDataJpaRepository.findById(itemId);
    }

    @Override
    public List<TodoItem> findAll() {
        // return todoRepository.findAll();

        return todoSpringDataJpaRepository.findAll();
    }

    @Override
    public TodoItem save(TodoItem item) {
        // return todoRepository.save(item);

        return todoSpringDataJpaRepository.save(item);
    }

    @Override
    public void delete(int itemId) {
        // todoRepository.delete(itemId);

        todoSpringDataJpaRepository.deleteById(itemId);
    }

    @Override
    public void update(int itemId, TodoItemDto updateItem) throws NoSuchElementException {
        // todoRepository.update(itemId, updateItem);

        TodoItem todoItem = todoSpringDataJpaRepository.findById(itemId).orElseThrow(() -> {
            throw new NoSuchElementException();
        });
        todoItem.setTitle(updateItem.getTitle());
        todoItem.setContents(updateItem.getContents());
    }
}