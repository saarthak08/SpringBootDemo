package com.sg.SpringBootDemo.DataJPA.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Alien {

    @Id
    private int id;

    private String name;

    private String tech;
}
