package goorm.todo.repository;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import goorm.todo.repository.mybatis.TodoMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
class TodoRepositoryImplTest {
    @Autowired
    TodoMapper todoMapper;

    @Test
    void save() {
        TodoItem item = new TodoItem();
        item.setTitle("test입니다2.");
        item.setContents("testContents입니다2.");

        todoMapper.save(item);
    }

    @Test
    void delete() {
        todoMapper.delete(9);
    }

    @Test
    void update() {
        TodoItemDto updateItem = new TodoItemDto();
        updateItem.setTitle("수정된 제목");
        updateItem.setContents("수정된 내용");

        todoMapper.update(9, updateItem);
    }
}