package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.annagrammi.db.DizionarioDAO;

public class Dizionario {

	private DizionarioDAO d;

	public Dizionario() {
		this.d = new DizionarioDAO();
	}

	public List<String> getParole() {
		return this.d.getParole();
	}

}
