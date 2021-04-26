package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

public class Anagramma {
	
	public Anagramma() {

	}

	public List<String> anagrammi(String parola) {

		List<String> risultato = new ArrayList<>();

		permuta("", parola, 0, risultato); // lancia la ricorsione
		return risultato;

	}

	// livello = lunghezza della soluzione parziale;
	// livello iniziale = 0;
	// parziale = stringa che contiene l'anagramma incompleto in fase di costruzione
	// lettere = le lettere della parola iniziale che ancora non abbiamo utilizzato

	private void permuta(String parziale, String lettere, int livello, List<String> risultato) {

		if (lettere.length() == 0) {
			risultato.add(parziale);
		} else {
			// ricorsione
			for (int pos = 0; pos < lettere.length(); pos++) {
				char tentativo = lettere.charAt(pos);

				String nuovaParziale = parziale + tentativo;

				String nuovaLettere = lettere.substring(0, pos) + lettere.substring(pos + 1); // togli il carattere pos
																								// da lettere
				permuta(nuovaParziale, nuovaLettere, (livello + 1), risultato);

			}
		}

	}

}
