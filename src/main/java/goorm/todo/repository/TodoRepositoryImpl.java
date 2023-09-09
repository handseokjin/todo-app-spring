package goorm.todo.repository;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import goorm.todo.repository.mybatis.TodoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
//@Repository
@RequiredArgsConstructor
public class TodoRepositoryImpl implements TodoRepository {
    private final TodoMapper todoMapper;
    private final EntityManager em;

    @Override
    public Optional<TodoItem> findById(int id) { // jpa 적용
        //return todoMapper.findById(id);

        TodoItem todoItem = em.find(TodoItem.class, id);
        return Optional.ofNullable(todoItem);
    }

    @Override
    public List<TodoItem> findAll() { // jpa 적용
        //return todoMapper.findAll();

        String jpql = "select i from TodoItem i";
        TypedQuery<TodoItem> query = em.createQuery(jpql, TodoItem.class);
        return query.getResultList();
    }

    @Override
    public TodoItem save(TodoItem item) { // jpa 적용
        //todoMapper.save(item);

        em.persist(item);
        return item;
    }

    @Override
    public void delete(int itemId) {
        todoMapper.delete(itemId);
    }

    @Override
    public void update(int itemId, TodoItemDto updateItem) { // jpa 적용
        TodoItem todoItem = em.find(TodoItem.class, itemId);
        todoItem.setTitle(updateItem.getTitle());
        todoItem.setContents(updateItem.getContents());

        // todoMapper.update(itemId, updateItem);
    }
}