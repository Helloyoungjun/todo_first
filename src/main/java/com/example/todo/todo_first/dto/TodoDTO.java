package com.example.todo.todo_first.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class TodoDTO {
    private Integer tno;
    private String title;
    private String memo;
    private boolean complete;
    private LocalDateTime regDate, modDate;
}
