package goorm.todo.repository;

import goorm.todo.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoSpringDataJpaRepository extends JpaRepository<TodoItem, Integer> {
//    @Query("select i from TodoItem")
//    List<TodoItem> findTodoList();
}
