package it.epicode.GestionePrenotazioni.postazioneAziendale;

import it.epicode.GestionePrenotazioni.edificio.Edificio;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String codiceUnivoco;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private int numeroMassimoOccupanti;
    @ManyToOne
    private Edificio edificio;
}
