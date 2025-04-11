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
        System.out.println("Benvenuto nel sistema di gestione delle prenotazioni!");

        System.out.println("Inserisci l'ID della postazione:");
        Long postazioneId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Inserisci l'ID dell'utente:");
        Long utenteId = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        System.out.println("Inserisci la data della prenotazione (yyyy-MM-dd):");
        String dataInput = scanner.nextLine();
        LocalDate data = LocalDate.parse(dataInput);

        Prenotazione prenotazione = prenotazioneController.prenotaPostazione(postazioneId, utenteId, data);
        System.out.println("Prenotazione effettuata : " + prenotazione);

        System.out.println("Inserisci il tipo di postazione (PRIVATO, OPENSPACE, SALA_RIUNIONI):");
        TipoPostazione tipo = TipoPostazione.valueOf(scanner.nextLine().toUpperCase());

        System.out.println("Inserisci la citta:");
        String citta = scanner.nextLine();

        List<Postazione> postazioni = prenotazioneController.ricercaPostazioni(tipo, citta);
        System.out.println("Postazioni trovate: " + postazioni);

        scanner.close();
    }
}
