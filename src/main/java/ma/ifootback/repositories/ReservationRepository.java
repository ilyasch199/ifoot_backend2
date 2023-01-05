package ma.ifootback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ifootback.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	@Query("SELECT r FROM Reservation r WHERE r.id_user =:user")
    public List<Reservation> findByiduser(@Param("user") Long user);
	
	@Query("SELECT r FROM Reservation r WHERE :id_player MEMBER OF r.id_players")
	public List<Reservation> findByPlayer(@Param("id_player") Long idPlayer);
	
	@Query("SELECT r FROM Reservation r WHERE r.id_pitch = :idpitch")
	public List<Reservation> findByPitch(@Param("idpitch") Long idpitch);
}
