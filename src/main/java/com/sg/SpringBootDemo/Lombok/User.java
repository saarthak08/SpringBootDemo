package com.sg.SpringBootDemo.Lombok;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter
public class User {
    private String name;
    private Long salary;
    private Integer id;
}
