package goorm.todo.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
@Data
@Entity
@Table(name="todo")
public class TodoItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="contents")
    private String contents;

    public TodoItem() {

    }

    public TodoItem(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public TodoItem(int id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }
}