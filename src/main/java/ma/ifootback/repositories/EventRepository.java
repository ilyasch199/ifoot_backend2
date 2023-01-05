package ma.ifootback.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.ifootback.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

	@Query("SELECT e FROM Event e WHERE e.id_user =:user")
    public List<Event> findByiduser(@Param("user") Long user);
	
	@Query("SELECT e FROM Event e WHERE :id_player MEMBER OF e.id_players")
	List<Event> findByPlayer(@Param("id_player") Long idPlayer);
	
	@Query("SELECT e FROM Event e WHERE e.id_pitch = :idpitch")
	public List<Event> findByPitch(@Param("idpitch") Long idpitch);
}
