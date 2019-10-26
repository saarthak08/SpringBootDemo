package com.sg.SpringBootDemo.DataJPA.DAO;

import com.sg.SpringBootDemo.DataJPA.model.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestResource(collectionResourceRel = "restaliens",path = "restaliens")
public interface AlienRestRepo extends JpaRepository<Alien,Integer> {
}
