package goorm.todo.repository.mybatis;

import goorm.todo.domain.TodoItem;
import goorm.todo.domain.TodoItemDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface TodoMapper {
    List<TodoItem> findAll();

    Optional<TodoItem> findById(int id);

    void save(TodoItem item);

    void delete(int id);

    void update(@Param("id") int id, @Param("updateItem") TodoItemDto updateItem);
}
