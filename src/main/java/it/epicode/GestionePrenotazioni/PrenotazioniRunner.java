package it.epicode.GestionePrenotazioni;

import it.epicode.GestionePrenotazioni.postazioniAziendali.Postazione;
import it.epicode.GestionePrenotazioni.postazioniAziendali.TipoPostazione;
import it.epicode.GestionePrenotazioni.prenotazioni.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@Component
public class PrenotazioniRunner implements CommandLineRunner {

    @Autowired
    private PrenotazioneController prenotazioneController;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PrenotazioneController prenotazioneController = new PrenotazioneController(); // Assicurati che sia inizializzato

        System.out.println("Benvenuto nel sistema di gestione delle prenotazioni!");
        System.out.println("Scegli un'opzione:");
        System.out.println("1. Aggiungi una prenotazione");
        System.out.println("2. Ricerca postazioni disponibili");

        int scelta = scanner.nextInt();
        scanner.nextLine(); // Consuma il newline

        switch (scelta) {
            case 1:
                System.out.println("Aggiunta di una prenotazione");

                System.out.print("Inserisci l'ID della postazione: ");
                Long postazioneId = scanner.nextLong();

                System.out.print("Inserisci l'ID dell'utente: ");
                Long utenteId = scanner.nextLong();

                System.out.print("Inserisci la data della prenotazione (yyyy-MM-dd): ");
                LocalDate data = LocalDate.parse(scanner.next());

                Prenotazione prenotazione = prenotazioneController.prenotaPostazione(postazioneId, utenteId, data);
                System.out.println("Prenotazione effettuata: " + prenotazione);
                break;

            case 2:
                System.out.println("Ricerca postazioni disponibili");

                System.out.print("Inserisci il tipo di postazione (PRIVATO, OPENSPACE, SALA_RIUNIONI): ");
                TipoPostazione tipo = TipoPostazione.valueOf(scanner.nextLine().toUpperCase());

                System.out.print("Inserisci la città: ");
                String citta = scanner.nextLine();

                List<Postazione> postazioni = prenotazioneController.ricercaPostazioni(tipo, citta);
                System.out.println("Postazioni trovate: " + postazioni);
                break;

            default:
                System.out.println("Scelta non valida. Riprova.");
        }

        scanner.close();
    }
}
