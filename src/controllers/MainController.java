package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import views.MainUI;

// Ce controlleur à pour but de traduire le clique sur le bouton
// à un affichage sur l'écran de la calculatrice
public class MainController implements ActionListener {

	private MainUI ui;

	// Constructeur
	public MainController(MainUI ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// La source de l'événement
		JButton source = (JButton) e.getSource();
		// Copier le text du bouton source sur l'écran de la calculatrice
		ui.input.setText(ui.input.getText() + source.getText());
	}

}
