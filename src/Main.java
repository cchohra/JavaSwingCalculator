import javax.swing.UIManager;

import views.MainUI;

public class Main {

	public static void main(String[] args) {

		// Choisir un look & feel
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Créer une instance de la classe de l'interface utilisateur
		new MainUI();

	}

}
