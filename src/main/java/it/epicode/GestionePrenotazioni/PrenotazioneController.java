package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.postazioniAziendali.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.services.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    public Prenotazione prenotaPostazione(Long postazioneId, Long utenteId, LocalDate data) {
        return prenotazioneService.prenotaPostazione(postazioneId, utenteId, data);
    }

    public List<Postazione> ricercaPostazioni(TipoPostazione tipo, String citta) {
        return prenotazioneService.ricercaPostazioni(tipo, citta);
    }
}
