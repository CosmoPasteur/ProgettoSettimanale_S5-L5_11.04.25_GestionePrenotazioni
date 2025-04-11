package it.epicode.GestionePrenotazioni.postazioniAziendali;

import it.epicode.GestionePrenotazioni.edifici.Edificio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
