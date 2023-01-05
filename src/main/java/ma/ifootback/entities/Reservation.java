package ma.ifootback.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Reservation")
public class Reservation {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private LocalDate date;
	private String heure_debut;
	private Float cost;
	private Boolean ispaid;
	private Long id_pitch;
	private Long id_user;
	@ElementCollection
	@CollectionTable(name="reservation_id_players", joinColumns=@JoinColumn(name="reservation_id"))
    @Column(name="id_player")
	private List<Long> id_players;
	
	public Reservation() {}

	public Reservation(LocalDate date, String heure_debut, Float cost, Boolean ispaid, Long id_pitch, Long id_user,
			List<Long> id_players) {
		super();
		this.date = date;
		this.heure_debut = heure_debut;
		this.cost = cost;
		this.ispaid = ispaid;
		this.id_pitch = id_pitch;
		this.id_user = id_user;
		this.id_players = id_players;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getHeure_debut() {
		return heure_debut;
	}

	public void setHeure_debut(String heure_debut) {
		this.heure_debut = heure_debut;
	}

	public Float getCost() {
		return cost;
	}

	public void setCost(Float cost) {
		this.cost = cost;
	}

	public Boolean getIspaid() {
		return ispaid;
	}

	public void setIspaid(Boolean ispaid) {
		this.ispaid = ispaid;
	}

	public Long getId_pitch() {
		return id_pitch;
	}

	public void setId_pitch(Long id_pitch) {
		this.id_pitch = id_pitch;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public List<Long> getId_players() {
		return id_players;
	}

	public void setId_players(List<Long> id_players) {
		this.id_players = id_players;
	}
}
