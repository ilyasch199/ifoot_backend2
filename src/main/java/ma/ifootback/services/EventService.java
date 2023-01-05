package ma.ifootback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ifootback.entities.Event;

@Service
public interface EventService {

    public List<Event> findAll();
    public Event findById(Long id);
    public Event save(Event event);
    public Event update(Event event);
    public void delete(Event event);
    public List<Event> findusersEvents(Long id_user);
    public List<Event> findmyAddedEvents(Long id_user);
    public List<Event> findpitchReservation(Long idpitch);
}
