package ru.innotech.testdata;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Employee {
    private String name;
    private Integer age;
    private String employee;
}
