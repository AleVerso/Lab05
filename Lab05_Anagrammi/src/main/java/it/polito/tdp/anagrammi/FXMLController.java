package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagramma;
import it.polito.tdp.anagrammi.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Anagramma model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button bntDoAnagram;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;
    
	@FXML
	void doAnagramma(ActionEvent event) {

		Dizionario d = new Dizionario();

		this.btnReset.setDisable(false);

		String parola = this.txtParola.getText();

		// controllo su input

		if (parola.isBlank()) {
			return;
		}

		if (!parola.matches("([a-z]*)")) {
			return;
		}

		List<String> anagrammi = this.model.anagrammi(parola);
		String outputCorretto = "";
		String outputErrato = "";
		List<String> dizionario = d.getParole();

		for (String p : anagrammi) {
			if (dizionario.contains(p)) {
				outputCorretto += p + "\n";
			} else {
				outputErrato += p + "\n";
			}

		}

		this.txtCorretti.setText(outputCorretto);
		this.txtErrati.setText(outputErrato);

	}

    @FXML
    void doReset(ActionEvent event) {
    	
    	this.txtParola.clear();
    	this.txtCorretti.clear();
    	this.txtErrati.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert bntDoAnagram != null : "fx:id=\"bntDoAnagram\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    void setModel(Anagramma model) {
    	this.model=model;
    }
}
