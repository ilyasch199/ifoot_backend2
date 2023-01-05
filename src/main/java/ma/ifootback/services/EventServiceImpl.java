package ma.ifootback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ifootback.entities.Event;
import ma.ifootback.repositories.EventRepository;

@Component
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public Event findById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}

	@Override
	public Event save(Event event) {
		return eventRepository.save(event);
	}

	@Override
	public void delete(Event event) {
		eventRepository.delete(event);
	}

	@Override
	public List<Event> findusersEvents(Long id_user) {
		return eventRepository.findByiduser(id_user);
	}

	@Override
	public List<Event> findmyAddedEvents(Long id_user) {
		return eventRepository.findByPlayer(id_user);
	}

	@Override
	public Event update(Event event) {
		Event existingevent = eventRepository.findById(event.getId()).orElse(null);
		if (existingevent == null) {
			return null;
		}
		existingevent.setId_players(event.getId_players());
		return eventRepository.save(existingevent);
	}

	@Override
	public List<Event> findpitchReservation(Long idpitch) {
		return eventRepository.findByPitch(idpitch);
	}

}
