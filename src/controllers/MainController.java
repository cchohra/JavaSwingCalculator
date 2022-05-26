package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import views.MainUI;

// Ce controlleur � pour but de traduire le clique sur le bouton
// � un affichage sur l'�cran de la calculatrice
public class MainController implements ActionListener {

	private MainUI ui;

	// Constructeur
	public MainController(MainUI ui) {
		this.ui = ui;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// La source de l'�v�nement
		JButton source = (JButton) e.getSource();
		// Copier le text du bouton source sur l'�cran de la calculatrice
		ui.input.setText(ui.input.getText() + source.getText());
	}

}
