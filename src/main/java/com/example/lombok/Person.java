package com.example.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j
@Builder
public class Person {
    private String id;
    private String name;
    private String identity;

    public void printSelf() {
        log.debug(this);
    }
}
