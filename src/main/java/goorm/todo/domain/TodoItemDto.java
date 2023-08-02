package goorm.todo.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Slf4j
@Getter
@Setter
public class TodoItemDto {
    @NotBlank(message = "{required.todoitem.title}")
    private String title;

    private String contents;

    public TodoItemDto() {

    }

    public TodoItemDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}