package it.epicode.GestionePrenotazioni.prenotazioni;

import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @ManyToOne
    private Postazione postazione;
    @ManyToOne
    private Utente utente;
    private LocalDate data;
}
