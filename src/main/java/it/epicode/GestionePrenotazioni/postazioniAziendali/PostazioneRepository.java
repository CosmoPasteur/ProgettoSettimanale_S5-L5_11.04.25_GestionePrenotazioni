package it.epicode.GestionePrenotazioni.postazioniAziendali;

import it.epicode.GestionePrenotazioni.edifici.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
    List<Postazione> findByEdificio_Citta(String citta);
    List<Postazione> findByTipo(TipoPostazione tipo);
    List<Postazione> findByTipoAndEdificio_Citta(TipoPostazione tipo, String citta);

}
