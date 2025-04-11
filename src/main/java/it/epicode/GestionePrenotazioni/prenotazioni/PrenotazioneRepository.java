package it.epicode.GestionePrenotazioni.prenotazioni;

import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);

    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
}
