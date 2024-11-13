package com.example.gestionevent.Repositories;

import com.example.gestionevent.Entities.Categorieevent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieeventRepository extends JpaRepository<Categorieevent, Long> {
}
