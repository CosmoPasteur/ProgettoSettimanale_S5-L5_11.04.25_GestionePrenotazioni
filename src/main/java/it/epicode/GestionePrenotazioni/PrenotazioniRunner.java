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

        Scanner scanner = new Scanner(System.in);
        System.out.println("Cerca postazioni per: ");
        System.out.println("1. Città");
        System.out.println("2. Tipo");
        System.out.println("3. Id");

        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                System.out.println("Inserisci la città:");
                String citta = scanner.next();
                List<Postazione> postazioniPerCitta = postazioneRepository.findByEdificio_Citta(citta);

                System.out.println("Postazioni trovate: " + postazioniPerCitta.size());
                break;
            case 2:
                System.out.println("Inserisci il tipo di postazione (PRIVATO, OPENSPACE, SALA_RIUNIONE):");
                TipoPostazione tipo = TipoPostazione.valueOf(scanner.next().toUpperCase());
                List<Postazione> postazioniPerTipo = postazioneRepository.findByTipo(tipo);

                System.out.println("Postazioni trovate: " + postazioniPerTipo.size());
                for (Postazione p : postazioniPerTipo) {
                    System.out.println(p);
                }
                break;
            case 3:
                //ricerca per id
                System.out.println("Inserisci l'id della postazione:");
                Long id = scanner.nextLong();
                Postazione postazione = postazioneRepository.findById(id).orElse(null);
                if (postazione != null) {
                    System.out.println("Postazione trovata: " + postazione);
                } else {
                    System.out.println("Postazione non trovata.");
                }
                break;
            default:
                System.out.println("Scelta non valida.");
                break;
        }

        scanner.close();

    }
}
