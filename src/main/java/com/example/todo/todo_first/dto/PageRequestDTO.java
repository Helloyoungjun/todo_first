package com.example.todo.todo_first.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data   // getter setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    private int page = 1;
    @Builder.Default
    private int size = 10;

    public int getSkip(){
        page = page <= 1? 1  : page;
        size = size <= 10?  10 : (size >= 100? 100 : size);   // 삼항연산자 두 개

        return (page - 1) * size;
    }
}

//    PageRequestDTO 코드