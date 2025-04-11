package it.epicode.GestionePrenotazioni.services;

import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.postazioniAziendali.PostazioneRepository;
import it.epicode.GestionePrenotazioni.postazioniAziendali.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.prenotazioni.PrenotazioneRepository;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import it.epicode.GestionePrenotazioni.utenti.UtenteRepository;
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
    @Autowired
    private UtenteRepository utenteRepository;

    public Prenotazione prenotaPostazione(Long postazioneId, Long utenteId, LocalDate data) {
        //Verifica l'esistenza della postazione e dell' utente
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new RuntimeException("Postazione non trovata"));
        Utente utente = utenteRepository.findById(utenteId).orElseThrow(() -> new RuntimeException("Utente non trovato"));
        //Verifica se la postazione è già prenotata per la data specificata
        List<Prenotazione> prenotazioniPostazione = prenotazioneRepository.findByPostazioneAndData(postazione, data);
        if (!prenotazioniPostazione.isEmpty()) {
            throw new RuntimeException("La postazione e' gia' prenotata per la data specificata");
        }
        //Verifica se l'utente ha già una prenotazione per la data specificata
        List<Prenotazione> prenotazioniUtente = prenotazioneRepository.findByUtenteAndData(utente, data);
        if (!prenotazioniUtente.isEmpty()) {
            throw new RuntimeException("L'utente ha gia' una prenotazione per la data specificata");
        }
        //Crea la prenotazione
        Prenotazione prenotazioneNuova = new Prenotazione();
        prenotazioneNuova.setPostazione(postazione);
        prenotazioneNuova.setUtente(utente);
        prenotazioneNuova.setData(data);
        return prenotazioneRepository.save(prenotazioneNuova);
    }

    public List<Postazione> ricercaPostazioni(TipoPostazione tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

}
