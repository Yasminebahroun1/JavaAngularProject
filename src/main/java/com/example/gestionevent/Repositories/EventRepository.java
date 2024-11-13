package com.example.gestionevent.Repositories;

import com.example.gestionevent.Entities.ClientUser;
import com.example.gestionevent.Entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByClientUsersContaining(ClientUser user);
}
