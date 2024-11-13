package com.example.gestionevent.Repositories;

import com.example.gestionevent.Entities.ClientUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientUserRepository extends JpaRepository<ClientUser, Long> {
    ClientUser findByEmailUser(String email);
}
