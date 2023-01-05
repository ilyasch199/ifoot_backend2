package ma.ifootback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ma.ifootback.entities.Reservation;
import ma.ifootback.repositories.ReservationRepository;

@Component
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findById(Long id) {
		return reservationRepository.findById(id).orElse(null);
	}

	@Override
	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public void delete(Reservation reservation) {
		reservationRepository.delete(reservation);
	}

	@Override
	public List<Reservation> findusersReservation(Long id_user) {
		return reservationRepository.findByiduser(id_user);
	}

	@Override
	public List<Reservation> findmyaddedReservations(Long id_user) {
		return reservationRepository.findByPlayer(id_user);
	}

	@Override
	public List<Reservation> findpitchReservsation(Long idpitch) {
		return reservationRepository.findByPitch(idpitch);
	}

}
