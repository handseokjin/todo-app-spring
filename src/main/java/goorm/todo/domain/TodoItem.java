package goorm.todo.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class TodoItem {
    private int id;
    private String title;
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