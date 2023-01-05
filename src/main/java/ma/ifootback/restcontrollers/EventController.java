package ma.ifootback.restcontrollers;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ma.ifootback.entities.Event;
import ma.ifootback.services.EventServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/events")
public class EventController {

	@Autowired
	private EventServiceImpl ES;
	
    @RequestMapping(method = RequestMethod.GET,path = "/test")
    public String hello() {   
    	return "Hello, world"; 
    }
    
    @GetMapping
    public List<Event> getAllEvents() {
        return ES.findAll();
    }
    
    @GetMapping("/myevents/{id}")
    public List<Event> getmyEvents(@PathVariable Long id){
    	return ES.findusersEvents(id);
    }
    
    @GetMapping("/myaddedevents/{id}")
    public List<Event> getmyAddedEvents(@PathVariable Long id){
    	return ES.findmyAddedEvents(id);
    }
    
    @GetMapping("/{id}")
    public Event getEventbyID(@PathVariable Long id){
    	return ES.findById(id);
    }
    
    @DeleteMapping("/{id}")
    public void deleteEvent (@PathVariable Long id) {
    	Event event = ES.findById(id);
    	ES.delete(event);
    }
    
    @PostMapping("/addevent")
    public ResponseEntity<Event> createEvent(@Valid @RequestBody Event event) {
        Event createdEvent = ES.save(event);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdEvent.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdEvent);
    }
    
    @PutMapping("/updateevent/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestParam(value = "userid", required = true) Long userid){
    	Event event = ES.findById(id);
    	List<Long>idplayers = event.getId_players();
    	idplayers.add(userid);
    	event.setId_players(idplayers);
    	ES.save(event);
    	return ResponseEntity.ok(event);
    }
    
	@GetMapping("/bypitch/{idpitch}")
	public List<Event> getPitchReservations(@RequestParam("idpitch")Long pitchid){
		return ES.findpitchReservation(pitchid);
	}
}
