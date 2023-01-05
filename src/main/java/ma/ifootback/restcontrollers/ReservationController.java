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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ma.ifootback.entities.Reservation;
import ma.ifootback.services.ReservationServiceImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/reservations")
public class ReservationController {

	@Autowired
	private ReservationServiceImpl RS;
	
	@GetMapping
	public List<Reservation> getALLReservations(){
		return RS.findAll();
	}
	
	@GetMapping("/myreservations/{id_user}")
	public List<Reservation> getMyReservations(@PathVariable Long id_user){
		return RS.findusersReservation(id_user);
	}
	
	@GetMapping("/bypitch/{idpitch}")
	public List<Reservation> getPitchReservations(@PathVariable Long idpitch){
		return RS.findpitchReservsation(idpitch);
	}
	
	@GetMapping("/myaddedreservations/{id_user}")
	public List<Reservation> getMyAddedReservations(@PathVariable Long id_user){
		return RS.findmyaddedReservations(id_user);
	}
	
	@GetMapping("/{id}")
	public Reservation getReservation(@PathVariable Long id){
		return RS.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteReservation(@PathVariable Long id) {
		Reservation reservation = RS.findById(id);
		RS.delete(reservation);
	}
	
    @PostMapping("/addreservation")
    public ResponseEntity<Reservation> createEvent(@Valid @RequestBody Reservation reservation) {
    	Reservation createdReservation = RS.save(reservation);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdReservation.getId())
                .toUri();
        return ResponseEntity.created(location).body(createdReservation);
    }
}
