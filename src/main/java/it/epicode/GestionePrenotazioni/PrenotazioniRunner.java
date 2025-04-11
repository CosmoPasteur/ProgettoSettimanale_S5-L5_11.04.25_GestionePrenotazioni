package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.edifici.Edificio;
import it.epicode.GestionePrenotazioni.edifici.EdificioRepository;
import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.postazioniAziendali.PostazioneRepository;
import it.epicode.GestionePrenotazioni.postazioniAziendali.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import it.epicode.GestionePrenotazioni.utenti.Utente;
import it.epicode.GestionePrenotazioni.utenti.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class PrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Override
    public void run(String... args) throws Exception {
        Edificio edificio1 = new Edificio(null, "Edificio 1", "Via Roma 1", "Roma");
        edificioRepository.save(edificio1);

        Postazione postazione1 = new Postazione(
                null,                         // id
                "POST-SALA-01",               // codice univoco
                "Postazione Sala Riunioni",  // descrizione
                TipoPostazione.SALA_RIUNIONE,
                2,
                edificio1
        );


        postazioneRepository.save(postazione1);

        Utente utente1 = new Utente(null, "utente1", "Mario Rossi", "mario@example.com");
        utenteRepository.save(utente1);



        System.out.println("Dati iniziali inseriti nel database.");
    }
}
