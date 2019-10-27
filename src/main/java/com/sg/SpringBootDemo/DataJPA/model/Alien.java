package com.sg.SpringBootDemo.DataJPA.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ApiModel(value = "Alien Class",description = "Details of the Alien")
public class Alien {

    @Id
    @ApiModelProperty(value = "Unique id for alien")
    private int id;

    @ApiModelProperty(value = "Alien name")
    private String name;

    @ApiModelProperty(value = "Alien tech")
    private String tech;
}
