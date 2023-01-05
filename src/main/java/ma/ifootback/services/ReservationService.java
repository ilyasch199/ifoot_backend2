package ma.ifootback.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ma.ifootback.entities.Reservation;

@Service
public interface ReservationService {

	public List<Reservation> findAll();
    public Reservation findById(Long id);
    public Reservation save(Reservation reservation);
    public void delete(Reservation reservation);
    public List<Reservation> findusersReservation(Long id_user);
    public List<Reservation> findmyaddedReservations(Long id_user);
    public List<Reservation> findpitchReservsation(Long idpitch);
}
