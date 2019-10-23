package com.sg.SpringBootDemo.DataJPA.DAO;

import com.sg.SpringBootDemo.DataJPA.model.Alien;
import org.springframework.data.repository.CrudRepository;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
    Alien findAlienById(int id);
}
