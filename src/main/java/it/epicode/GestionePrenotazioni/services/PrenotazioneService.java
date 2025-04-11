package it.epicode.GestionePrenotazioni.services;

import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.postazioniAziendali.PostazioneRepository;
import it.epicode.GestionePrenotazioni.postazioniAziendali.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.prenotazioni.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;
    @Autowired
    private PostazioneRepository postazioneRepository;

    public Prenotazione prenotaPostazione(Long postazioneId, Long utenteId, LocalDate data) {
        //Postazione postazione = postazioneRepository.findById(postazioneId).orElse(null);
        //if (postazione == null) {
        //    throw new IllegalArgumentException("Postazione non trovata.");
        //}
        //Prenotazione prenotazione = new Prenotazione();
        //prenotazione.setPostazione(postazione);
        //prenotazione.setUtente(utenteId);
        //prenotazione.setData(data);
        //return prenotazioneRepository.save(prenotazione);
    }

    public List<Postazione> ricercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

}
