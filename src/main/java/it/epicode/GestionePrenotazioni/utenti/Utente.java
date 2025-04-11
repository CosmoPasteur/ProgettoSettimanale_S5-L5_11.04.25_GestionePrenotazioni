package it.epicode.GestionePrenotazioni.utenti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String username;
    private String nomeCompleto;
    private String email;
}
