package com.sg.SpringBootDemo.DataJPA.DAO;

import com.sg.SpringBootDemo.DataJPA.model.Alien;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlienRepo extends CrudRepository<Alien, Integer> {
    Alien findAlienById(int id);

    @Query("from Alien where tech=?1 order by name")
    List<Alien> findByTechSorted(String tech);
}
